# -*- coding:utf-8 -*-


def createtable(start_path, end_path):
    with open(start_path,'r',encoding='utf8') as f:
        lines = f.readlines()
    with open(end_path, 'w', encoding='utf8') as w:
        for line in lines:
            word1 = line.strip().split('--')[0]
            word2 = line.strip().split('--')[1]
            # paltform string COMMENT '平台'
            result = word1 + " bigint comment '" + word2 + "'\n,"
            w.write(result)


if __name__ == '__main__':
    start_path = 'F:\\阅文\\需求\\需求99-内容-大转盘干活\\建表字段.txt'
    end_path = 'F:\\阅文\\需求\\需求99-内容-大转盘干活\\生成建表语句.sql'

    createtable(start_path, end_path)