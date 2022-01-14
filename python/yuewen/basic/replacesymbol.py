


# 需求：读取文件并把里面的逗号替换成竖线
# 注意：每个文件在追加的时候要换行

import os

file_path = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\1 全平台都不活跃的用户\\尾号为2.txt'
resultFile = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\1 全平台都不活跃的用户\\尾号为2new.txt'
with open(file_path, "r") as f:
        lines = f.readlines()
        # lines1 = lines[1:]   跳过第一行数据
        with open(resultFile, 'w', encoding='utf-8') as w:
            for line in lines:
                 print(line.strip("\n").replace(',', '|'))
                 w.write(line.strip("\n").replace(',', '|')+"\n")








