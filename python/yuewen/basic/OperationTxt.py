# -*- coding: UTF-8 -*-

"""
1、读取指定目录下的所有文件
2、循环读取目录中的文件并操作并且最后把所有的文件输出到一个文件夹里面
"""
import os

dirs = "F:\\阅文\\需求\\需求1-华语言情活动用户粉丝数\\2020前四季的入围的书籍的用户排序带分值"
files = os.listdir(dirs)

for fileName in files:
    filePath = os.path.join(dirs, fileName)   # 获取该目录下所有文件的绝对路径
    # -*- coding: utf=8 -*-
    # 需求：读取文本文件并把偶数行数字按照逗号拼接，并且把书籍信息也拼接到一起
    out_path = "F:\\阅文\\需求\\需求1-华语言情活动用户粉丝数\\output\\华语言情大赛guid带分值数据1"
    # 1根据文件名筛选出赛季名和书籍名称
    seasons = filePath.split("\\")[-1].split("_")[0]
    season_name = ""
    books = filePath.split("\\")[-1].split("_")[1].split(".")[0]
    book_name = ""

    # 针对所有的文件进行操作，主要是把后面一行的数据拼接到前面一行
    with open(filePath, "r") as f:
        lines = f.readlines()
        with open(out_path, "a", encoding="utf-8") as w:
            for i in range(0, len(lines), 2):
                line = season_name + "," + books + "," + lines[i][:-1] + "," + book_name + "," + lines[
                    i + 1]  # print(lines[i].strip()+","+lines[i+1])  # strip() 表示去掉换行
                w.write(line)
                print(line)

    # 拼接if else 的语句 可忽略
    union = ""
    result = ""
    with open("F:\\python\\input\\书籍信息.txt", "r", encoding="utf-8") as t:
        lines1 = t.readlines()
        with open("F:\\python\\output\\333.txt", "w", encoding="utf-8") as v:
            for line1 in lines1:
                union = line1.strip().split("\t")
                result = 'elif books == "' + union[0] + '":\n' + '    book_name = "' + union[1] + '"\n'
                v.write(result)







