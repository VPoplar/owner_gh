import requests
from bs4 import BeautifulSoup
import os


# 要下载的网页
url = 'https://www.biqubao.com/quanben/'
# 网站根网址
root_url = 'https://www.biqubao.com'
# 保存本地的路径
outputFile = 'F:\\python\\books'
# 解析网址
req = requests.get(url)
# 设置编码，浏览器查看网站编码：F12，控制栏输入document.characterSet回车即可查看
req.encoding = 'gbk'
# 获取网页所有的内容
soup = BeautifulSoup(req.text, 'html.parser')
# 查找网页中div的id等于main的标签
listTag = soup.div(id='main')
# 查看div内所有里的标签
lis = listTag[0](['li'])
# 去掉第一个没用的标签
del lis[0]
# 循环遍历
# 获取到a标签间的内容---小说类型
book_type = lis[1].a.string
# 获取a标签的href地址值---小说网址
book_url = (lis[1](['a'])[1].get('href'))
# 获取小说的书名
book_name = lis[1](['span'])[1].string
# 获取作者的信息
book_author = lis[1](['span'])[3].string
# 获取具体书籍的网页并设置网页编码
reqs = requests.get(root_url+book_url)
reqs.encoding = 'gbk'
# 解析书籍的网页
soups = BeautifulSoup(reqs.text, 'html.parser')
category = soups.div(id='list')
# 也可以获取小说名-不推荐使用
name = category[0].dt.string
# 打印书籍的信息
print("类型：{} 短址：{} 书名：{} 作者：{}".format(book_type, root_url+book_url, book_name,book_author))
# 创建同名文件夹 path = path + '\\' + book_name
if not os.path.exists(outputFile):
    os.mkdir(outputFile)
# 循环所有的dd标签，即所有章节的url信息并获取内容
for dd_tag in category[0].find_all('dd'):
    # 获取章节名
    chapter_name = dd_tag.string
    # 获取章节地址
    chapter_url = root_url + dd_tag.a.get('href')
    # 访问章节的网址并爬取章节的内容
    req2 = requests.get(chapter_url)
    req2.encoding = 'gbk'
    soup2 = BeautifulSoup(req2.text, 'html.parser')
    content = soup2.div.find(id='content')
    # 把空格内容全部换成行
    text = str(content.text.replace('\xa0', '\n'))
    # text.replace('\ufffd', '\n')
    # 写入文件操作,用追加的方式
    with open(outputFile + '\\' + book_name + '.txt', 'a') as w:
        w.write('\n' + chapter_name)
        w.write('\n' + text + '\n')
    print(text)











