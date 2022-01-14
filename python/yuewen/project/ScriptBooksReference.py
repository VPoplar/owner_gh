import requests
from bs4 import BeautifulSoup
import os

if __name__ == '__main__':
    # 要下载的网页
    url = 'https://www.biqubao.com/quanben/'
    # 网站根网址
    root_url = 'https://www.biqubao.com'
    # 保存本地路径
    path = 'F:\\python\\txt'

    # 解析网址
    req = requests.get(url)
    # 设置编码，浏览器查看网站编码：F12，控制栏输入document.characterSet回车即可查看
    req.encoding = 'gbk'

    # 获取网页所有内容
    soup = BeautifulSoup(req.text, 'html.parser')

    # 查找网页中div的id为main的标签
    list_tag = soup.div(id="main")
    # 查看div内所有里标签
    li = list_tag[0](['li'])
    # 删除第一个没用的标签
    del li[0]
    # 循环遍历
    for i in li:
        # 获取到a标签间的内容---小说类型
        txt_type = i.a.string
        # 获取a标签的href地址值---小说网址
        short_url = (i(['a'])[1].get('href'))
        # 获取第三个span标签的值---作者
        author = i(['span'])[3].string

        # 获取网页设置网页编码
        req = requests.get(root_url + short_url)
        req.encoding = 'gbk'

        # 解析网页
        soup = BeautifulSoup(req.text, "html.parser")
        list_tag = soup.div(id="list")

        # 获取小说名
        name = list_tag[0].dl.dt.string

        print("类型：{}    短址：{}   作者：{}   小说名：{}".format(txt_type, short_url, author, name))

        # 创建同名文件夹
        # paths = path + '\\' + name
        if not os.path.exists(path):
            # 获取当前目录并组合新目录
            # os.path.join(path, name)
            os.mkdir(path)

        # 循环所有的dd标签
        for dd_tag in list_tag[0].dl.find_all('dd'):
            # 章节名
            zjName = dd_tag.string
            # 章节地址
            zjUrl = root_url + dd_tag.a.get('href')

            # 访问网址爬取章节内容
            req2 = requests.get(zjUrl)
            req2.encoding = 'gbk'

            zj_soup = BeautifulSoup(req2.text, "html.parser")
            content_tag = zj_soup.div.find(id="content")

            # 把空格内容替换成换行
            text = str(content_tag.text.replace('\xa0', '\n'))
            text.replace('\ufffd', '\n')

            # 写入文件操作'a'追加
            with open(path + "\\" + name + ".txt", 'a') as f:
                f.write('\n' + '\n' + zjName)
                f.write(text)
                print("{}------->写入完毕".format(zjName))