# 文件和文件夹的操作，json文件操作和csv文件操作
# I 文件操作相关
# 1 读写文件
import os
import time

f1 = open("E:\\test\\one.txt", "r", encoding="utf-8")  # 读

w = open("E:\\test\\one.txt", "w") # 写-覆盖
w.write("tom\n")
w2 = open("E:\\test\\one.txt", "a") # 写-追加
# w2.write("nina")
w2.writelines(["mac\n", "cissie"])   # writelines方法可以将一个序列的数据添加到文件中
w2.close()
# 备注：使用with能够安全的打开和关闭文件，当操作完文件之后会自动调用close方法
with open("E:\\test\\one.txt", "w", encoding="utf-8") as w:
    w.writelines(["mac\n", "cissie"])
# 读文件 read方法可以一次性从文件中读取所有的内容
with open("E:\\test\\one.txt", "r", encoding="utf-8") as f:
    data = f.read()
    print(data)
# readlines()方法可以按照行的方式把整个文件中的内容一次性全部读取出来，返回的是一个列表
with open("E:\\test\\one.txt", "r", encoding="utf-8") as f:
    data = f.readlines()
    print(data)
    for i in data:
        print(i)  # 有多余一个空行的原因是print()函数打印的时候默认会产生一个空格
    for j in range(0, len(data)):
        print(data[j], end="")
print("\n---------")
# II 文件管理相关  os包
# 1 rename  对文件重新命名
import os
# os.rename("E:\\test\\three.txt", "E:\\test\\two.txt")
# 2 remove  删除指定文件
# os.remove("E:\\test\\two.txt")
# 3 mkdir 创建文件夹
# os.mkdir("E:\\test\\output")
# 4 getcwd 获取程序运行的绝对路径
print(os.getcwd())
# 5 listdir(path) 获取指定路径下的所有文件夹和文件名称，函数的返回值是一个列表（不递归）
print(os.listdir("./"))
# 6 rmdir() 删除一个空文件夹
# os.rmdir("E:\\test\\output")
# 7 删除一个非空文件夹  shutil模块中的rmtree(path)函数
import shutil
# shutil.rmtree("E:\\test\\output")

# III josn文件操作 python中的None类型在转换为json数据类型的时候会变成null
# dumps(python_dict):将python数据转换成json编码的字符串
# loads(json_str):将json数据转换成python编码的字符串
# dump(python_dict,file):将python数据转换为json编码的字符串，并写入json文件
# load(json_file): 从json文件中读取数据，并将json编码的字符串转换为python的数据结构
import json
print("--------------------json-------------------")
dict = {
"name": "nina",
"age": "13",
"interest": ["basketball", "badminton"],
"language": {"ai": "python", "bigdata": "flink"},
"if_vip": "TRUE",
"others": None
}
json_str = json.dumps(dict)
print(json_str)  # 打印出json格式
print(json.loads(json_str))  # 打印出python格式
with open("E:\\test\\json_load.txt", "w") as w:
    json.dump(dict, w)
with open("E:\\test\\json_load.txt", "r") as f:
    user = json.load(f)
    print(user)

# IV CSV文件操作  CSV文件的默认分隔符是逗号，并且所有数据都是字符串
# 写入和读取csv文件数据
# writerow([rowdata])  一次写入一行数据
# writerows([[rowdata],[rowdata2]])  一次写入多行数据
# reader() 方法，读取文件，返回一个可迭代的对象
# 备注：如果是excle文件，那么可以用 xlrd和xlwt 模块，非常丰富,不过这两个模块需要单独安装
import csv
import xlrd
import xlwt
datas = [[1, 2, 3, 4], ["nina", "lily"]]
with open("E:\\test\\one.csv", "w") as w:
    writea = csv.writer(w)
    for row in datas:   # 一行一行循环写入
        writea.writerow(row)
with open("E:\\test\\two.csv", "w") as w:
    writea = csv.writer(w)
    writea.writerows(datas)
with open("E:\\test\\three.csv", "r", encoding="utf-8") as f:
    reader = csv.reader(f)  # 返回一个可迭代对象
    for row in reader:
        print(row)  # 是一个列表
        print(row[0])
