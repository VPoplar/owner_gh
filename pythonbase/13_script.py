
# 爬虫开发
# 爬虫工作流程
# 爬虫开发环境搭建
# 项目实战：爬取电商网站信息
# 1 爬虫工作流程
# 1） 客户端向URL发送请求；2）网站处理客户端请求并返回所需的资源；3）返回响应内容；4）解析响应内容并提取有用的数据;5)数据持久化（数据库或者文件等）

# 2 爬虫开发环境搭建
# 2.1 安装 Selenium 库-是一个Web自动化测试工具，能够驱动浏览器模拟输入、单击、下拉等操作；
# 2.2 安装Phantom.JS-是一个可编程的无界面浏览器引擎；需要下载安装到指定目录，并添加到系统环境变量
# 2.3 安装 pyquery 库-是一款非常强大的网页解析库

# 3 项目实战：爬取电商网站信息-京东商城手机商品的信息
import csv
import re
from urllib.parse import quote

from pyquery import PyQuery
from selenium import webdriver
import pyquery


# 构建一个无界面的浏览器对象
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By

#构建一个无界面的浏览器对象
browser = webdriver.PhantomJS()
# 3.1 根据关键获取搜索结果总页数与响应内容
def search_by_keyword(keyword, file_path, mode):
    print("正在搜索{}".format(keyword))
    try:
        # 拼接访问的url
        url = "https://search.jd.com/Search?keyword=" + quote("手机") + "&enc=utf-8"
        # 浏览器对象发送get请求
        browser.get(url)
        # 等待浏览器对象加载完成，直到到达超时时间10秒后抛出异常
        # WebDriverWait(browser, 10).until(...)
        # 等待网页内容加载加载完成
        WebDriverWait(browser, 10).until(
            EC.presence_of_element_located(By.CSS_SELECTOR, ".gl-item")
        )
        # 等待总页数元素加载完成
        pages = WebDriverWait(browser, 10).until(
            EC.presence_of_element_located(By.CSS_SELECTOR, "#J_bottomPage > span.p-skip > em:nth-child(1) > b")
        )
        print(pages.text)
        # 返回数字类型的总页数
        return int(pages.text)
    # 捕捉超时异常
    except TimeoutException as e:
        print("请求超时：", e)
        search_by_keyword(keyword)  # 请求超时，重试
# 3.2 解析数据，获取商品信息
def get_item_info():
    # 获取网页源代码
    html = browser.page_source
    # 使用 PyQuery 解析网页源代码
    pq = PyQuery(html)
    # 获取所有的商品列表项,一对<li class="gl-item">...</li>
    items = pq(".gl-item").items()
    datas = []
    # 表头
    head = ["p-name", "herf", "p-price", "p-commit", "p-shop", "p-icons"]
    datas.append(head)
    for item in items:
        p_name = re.sub("\\n", "", item.find(".p-name em").text())#商品名称，使用正则表达式将商品名称中的换行符\n替换掉
        href = item.find(".p-name a").attr("href") #商品链接
        p_price = item.find(".p-price").text() #商品价钱
        p_commit = item.find(".p-commit").text() #商品评价
        p_shop = item.find(".p-shop").text() #店铺名称
        p_icons = item.find(".p-icons").text()
        info = []
        info.append(p_name)
        info.append(href)
        info.append(p_price)
        info.append(p_commit)
        info.append(p_shop)
        info.append(p_icons)
        print(info)
        datas.append(info)
    return datas
'''
功能：跳转到指定页码的网页，解析网页数据，将数据保存到CSV文件中
参数：
    page：页码
    file_path：CSV文件路径
    mode：写入模式
'''
def skip_page(page, file_path, mode):
    print("跳转到第{}页".format(page))
    try:
        # 获取跳转到第几页的输入框
        input_text = WebDriverWait(browser, 10).until(
            EC.presence_of_element_located((By.CSS_SELECTOR, "#J_bottomPage > span.p-skip > input"))
        )
        # 获取跳转到第几页的确定按钮
        submit = WebDriverWait(browser, 10).until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, "#J_bottomPage > span.p-skip > a"))
        )
        print(type(input_text))
        print(type(submit))
        input_text.clear() #清空输入框
        input_text.send_keys(page) #在输入框中填入要跳转的页码
        submit.click() #点击确定按钮

        #等待网页加载完成，直到页面下方被选中并且高亮显示的页码，与页码输入框中的页码相等
        WebDriverWait(browser, 10).until(
            EC.text_to_be_present_in_element((By.CSS_SELECTOR, "#J_bottomPage > span.p-num > a.curr"), str(page))
        )

        datas = get_item_info()
        if len(datas) > 0:
            save_csv(file_path, mode, datas)

    except TimeoutException as e:
        print("请求超时：", e)
        skip_page(page, file_path, mode) #请求超时，重试

def save_csv(file_path, mode, datas):
    with open(file_path, mode) as f:
        writer = csv.writer(f)
        writer.writerows(datas)

def main():
    try:
        keyword = "手机" #搜索关键词
        file_path = "./jd_mobile_phone_page1"
        write_mode = "w"
        pages = search_by_keyword(keyword, file_path, write_mode)
        print("搜索结果共{}页".format(pages))
        #按照顺序循环跳转到下一页
        for page in range(2, pages + 1):
            file_path = "./jd_mobile_phone_page" + str(page)
            skip_page(page, file_path, write_mode)
    except Exception as err:
        print("产生异常：", err)
    finally:
        browser.close()
if __name__ == '__main__':
    main()









