
import os


file_path = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\全平台都不活跃的用户.txt'

with open(file_path, "r") as f:
    lines = f.readlines()
    # lines1 = lines[1:]   跳过第一行数据
    for i in range(10):
        print(lines[i]+'\n')

