
# I 网络编程基础
# HTTP:超文本传输协议
# URL 统一资源定位符
# HTTP请求的方式；get-提交数据长度有限并且安全性低；post-通过表单的方式提交，长度无限制并且安全性高

# II urllib库
# 2.1 urllib.request.urlopen函数
# 发送get请求
import urllib.request
import urllib.parse

import main

res = urllib.request.urlopen("http://www.baidu.com", timeout=0.1)   # 0.1s
print("status:", res.status)  # 获取响应状态码
print("headers:", res.getheaders())  # 获取响应头
print("headers:", res.getheader("Date"))  # 获取响应头信息中的日期

# print(res.read().decode("utf8"))   # 得到的就是百度首页的前端代码
# 发送post请求
# http://httpbin.org/post 是一个用于测试HTTP请求的网站
# 与HTTP请求一起发送的数据
param_dict = {"key": "hello"}
# 调用urlencode函数将字典类型数据转换为字符串
param_str = urllib.parse.urlencode(param_dict)
# 将传输的数据封装成bytes对象
param_datas = bytes(param_str, encoding="utf8")
# 传入data值
response = urllib.request.urlopen("http://httpbin.org/post", data=param_datas)
# print(response.read())

#2.2 urllib.request.Request类
# 示例：编写一个简单得爬虫程序，爬取京东商城中搜索关键字“手机”得内容
import requests

def spider_jd(keyword):
    # 请求参数
    params = {
        "keyword":keyword,
        "enc":"utf-8",
        "pvid":"5e5401f31001413183d985095aa3937d"
    }
    # 请求头信息
    headers = {
        "user-agent":"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.131 Mobile Safari/537.36",
        "referer": "https://www.jd.com/",
        "host": "search.jd.com",
        "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
        "accept-language":"zh-CN,zh;q=0.9"
    }
    url = "https://search.jd.com/Search"
    response = requests.get(url, headers=headers, params=params)
    # 通过状态码判断是否获取成功
    if response.status_code == 200:
        # 回去响应内容编码格式
        print("encoding:{}".format(response.encoding))
        response.encoding = "utf-8"
        print(response.text)
if __name__ == '__main__':
        spider_jd("手机")

