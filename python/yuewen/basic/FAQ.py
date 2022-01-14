# 常见的一些脚本
# 1获取当前路径
import os
print(os.path.abspath('.'))
# 2获取当前模块的文件名
print(__file__)
# 3获取命令行参数:注意第一个参数永远都是命令执行的.py文件
import sys
print(sys.argv)
# 4获取当前python命令的可执行文件
print(sys.executable)