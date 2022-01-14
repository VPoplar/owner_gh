# -*- coding: UTF-8 -*-

# 1python读取txt文件并按逗号切割文件
fp = "F:\\python\\input\\1.txt"
with open(fp, "r", encoding="utf-8") as f:
    lines1 = f.readlines()
for line1 in lines1:
    world = line1.strip().split(",", 1)  # 参数1表示只切割1次
    # print(world)

# 2python读取奇数和偶数行示例
file_path = "F:\\python\\test\\855886287_12377326404583803.txt"
with open(file_path, "r", encoding="utf-8") as f: # r是一个标识符，表示读取文件
    lines = f.readlines()
data_1 = open("F:\\python\\input\\奇数行.txt", 'w', encoding='utf-8')  # w是一个标识符，表示写文件
data_2 = open("F:\\python\\input\\偶数行.txt", 'w', encoding='utf-8')

num = 0  # 行数-1
for line in lines:
    if (num % 2) == 0:  # num为偶数说明是奇数行
        print(line.strip(), file=data_1)  # .strip用来删除\n
    else:  # # num为奇数说明是偶数行
        print(line.strip(), file=data_2)
    num += 1
data_1.close()
data_2.close()

# 3python讲txt文本中的偶数行拼接到奇数行上去
fp1 = "F:\\python\\input\\2.txt"
fp2 = "F:\\python\\output\\2w.txt"
with open(fp1, "r", encoding="utf-8") as f:
    lines2 = f.readlines()
    with open(fp2, "w", encoding="utf-8") as w:
        for j in range(0, len(lines2), 2):
            w.write(lines2[j][:-1]+","+lines2[j+1])
            print(lines2[j][:-1]+","+lines2[j+1])







