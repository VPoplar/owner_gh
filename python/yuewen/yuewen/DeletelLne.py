# -*- coding:utf-8 -*-

# 需求是删除文本中含有hx所在的所有行
file_path = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\1 全平台都不活跃的用户\\尾号为6.txt'
result_path = 'F:\\阅文\\需求\\需求17-用户信息审核数据导出\\1 全平台都不活跃的用户\\尾号为6new.txt'
with open(file_path, 'r') as f:
    lines = f.readlines()
    with open(result_path, 'w') as w:
        for line in lines:
            if ( line.split('|')[1] != 'hx' ):
                w.write(line)
