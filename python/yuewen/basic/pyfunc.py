# -*- coding:utf-8 -*-
import random

# 1 查询文本中的数据
def query_data(start_path):
    with open(start_path, "r") as f:
        lines = f.readlines()
        # lines1 = lines[1:]   跳过第一行数据
        for i in range(10):
            print(lines[i])

# 2 统计文本中行的个数
def countline(start_path):
    with open(start_path, 'r') as f:
        cnt = 0
        for line in f:
            cnt += 1
        f.flush()
        print(cnt)

# 3 读取文本输出新的文件
def writetxt(start_path, end_path):
    with open(start_path, 'r') as f:
        lines = f.readlines()
        with open(end_path, 'w') as w:
            for i in range(10000):
                w.write(lines[i])
                #print(lines[i])

# 4 读取文本输出新的文件,并将文件中的gbk编码转化为utf-8编码
def writetxt_utf8(start_path, end_path):
    with open(start_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()
        with open(end_path, 'w') as w:
             for line in lines:
                # print(line)
                 w.write(line)
# 5 按照逗号切割文件，并取出第一列写到新的txt文件中
def splitwrite(start_path, end_path):
    with open(start_path, 'r') as f:
        lines = f.readlines()
        with open(end_path, 'w', encoding='utf-8') as w:
            for line in lines:
                word = line.strip().split(',')[0]
                w.write(word+'\n')

# 6 读取文本文件，并拼接新的字段数据，按照|进行分隔
def createNewFile(start_path, end_path):
    with open(start_path, 'r') as f:
        lines = f.readlines()[1:]   # 表示跳过第一行数据
        with open(end_path, 'w', encoding='utf-8') as w:
            for line in lines:
                words = '10140' + '|' + '41' + '|' + line.strip() + '|20210407' + '|1617778837299'
                w.write(words+'\n')


# 7 读取存在A文本中的数据但是不在B文本中的数据
def text_diff(a_file, b_file, new_file):
    with open(a_file, 'r') as f1:
        set1 = set(f1.readlines())    # 把打开的文件转换为集合，集合中必须是不同的元素，去除相同行
    with open(b_file, 'r') as f2:
        set2 = set(f2.readlines())
    diff = set1 - set2    # python中可以通过集合‘-’去除相同数据
    print(diff)
    with open(new_file, 'w') as w:
        w.writelines(diff)     #把多行数据写入新的文件中


# 8 读取文件中的文件，按照字段中平台不同输出到不同的文件中
def parse_fields(start_path, end_path):
    with open(start_path, 'r', encoding='utf-8') as f:
        #line_one = f.readlines()[0]  # 最后要拼接第一行数据
        lines = f.readlines()[1:]   # 表示跳过第一行数据
    with open(end_path, 'w', encoding='utf-8') as w:
        w.write('platform|guid|is_active|is_fufei|is_pinglun|is_balance|is_author|is_book\n')
        for line in lines:
            if(line.strip().split('|')[0] == 'qq'):
                #print(line)
                w.write(line)


def GenPassword():
    re = random(2)
    print(re)


if __name__ == '__main__':
    test_start_path = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\全平台不活跃细分数据1.3\\起点不活跃且头像未审核.txt'
    test_end_path = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\测试\\2utf8.txt'

    start_path = 'F:\\阅文\\需求\\需求77-审核-境外用户数据信息沟通\\境外用户新新新.txt'
    end_path = 'F:\\阅文\\需求\\需求77-审核-境外用户数据信息沟通\\境外用户qq.txt'
    test_path1 = 'F:\\测试\\文本1.txt'
    test_path2 = 'F:\\测试\\文本2.txt'
    new_path = 'F:\\测试\\文本3.txt'
#    print(test_start_path)
#   countline(test_start_path)  # 统计文本中有多少行数据
#    print('-------------------------------------------------')
#    query_data(test_start_path)
#   writetxt_utf8(start_path, end_path)  # 把文本中的编码格式转化为utf-8
#   splitwrite(start_path, end_path)
#   createNewFile(start_path,end_path)
#   parse_fields(start_path, end_path)
    GenPassword()
#text_diff(test_path1, test_path2, new_path)




