

# 需求：读取指定目录下的所有文件，并把这些所有的文件数据合并到一个新文件里面
# 注意：每个文件在追加的时候要换行

import os

dirs = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\1 全平台都不活跃的用户'
files = os.listdir(dirs)   # 获取目录信息
resultFile = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\全平台都不活跃的用户.txt'

for file in files:
    filePath = os.path.join(dirs, file)
    # 读取文件并追加写入到一个新的文件里面
    with open(filePath, "r") as f:
        lines = f.readlines()
        lines1 = lines[1:]  # 跳过第一行数据
        with open(resultFile, 'a') as w:
            for line in lines1:
                line.strip("\n")
                w.write(line)
            w.write("\n")





