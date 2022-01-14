# -*- coding:UTF-8 -*-
import hashlib
import sys
import os
import os.path
import requests
import csv
from contextlib import closing

# 小米数据对目录为日期的进行sha1加密并获取网页的数据
def getdata(statis_day, salt="65S16ZBHSTH5C2WTTGHTSR0BV9DY"):
    sign_args = []
    sign_args.append(statis_day)
    if salt:
        sign_args.append(salt)
    joined = '&'.join(sign_args).encode('utf-8')
    date = hashlib.sha1(joined).hexdigest()
    if not os.path.exists('d:\\%s' %statis_day):
        os.mkdir('d:\\%s' %statis_day)
    filename = 'd:\\%s\\t_sd_xiaomi_ad.log' %statis_day
    # 以下为获取网页的数据并写入到指定的文件夹中
    url = 'http://cdn.cnbj1.fds.api.mi-img.com/dkfe/yuewen/free_fiction_stats/%s/ad.csv' %date
    # 读取数据
    with closing(requests.get(url, stream=True)) as r:
        f = (line.decode('utf-8') for line in r.iter_lines())
        reader = csv.reader(f, delimiter=',', quotechar='"')
        with open(filename, 'w', encoding='utf-8') as w:
            for row in reader:
                line = "|".join(str(i) for i in row)    # 让列表中的数字用|分隔
                w.write(line+"\n")
if __name__ == '__main__':
    statis_day = None
    if len(sys.argv) >= 1:
        statis_day = sys.argv[1]
    else:
        exit("Check the params!")
    getdata(statis_day)