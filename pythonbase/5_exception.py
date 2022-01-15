

# 1捕获单个异常
print("准备打开一个文件")
try:
    file = open("test.txt")
    print("文件打开成功")
    file.close()
except FileNotFoundError as err:
    print("捕获到了异常，文件不存在！！", err)
print("程序即将结束")

# 2捕获多个异常：只需要把捕获到的异常的类名存储到except的元组中就行
try:
    # 打印一个不存在的变量，将产生NameError异常
    print(num)
    # 读取一个不存在的文件，将产生FileNotFoundError异常
    print(open("test.txt"))
except (NameError, FileNotFoundError) as err:
    print("捕获到了异常！！", err)
print("程序即将结束")

# 3捕获全部异常:通过异常类Exception可以将没有预测到的异常全部捕获,Exception是所有异常的超集
print("3 捕获全部异常开始")
try:
    # 读取一个不存在的文件，将产生FileNotFoundError异常
    print(open("test.txt"))
    # 打印一个不存在的变量，将产生NameError异常
    print(num)
except Exception as err_all:
    print("捕获到了异常", err_all)

# 4异常中的finally语句：如果一段代码无论是否异常都必须执行，那么此时就需要用到finally：比如在数据库操作过程中发生异常需要把数据库连接返回连接池
# 4.1 产生并且捕获了异常
print("4 异常中的finally语句")
try:
    # 读取一个不存在的文件，将产生FileNotFoundError异常
    print(open("test.txt"))
except Exception as err_all:
    print("捕获到了异常", err_all)
finally:
    print("关闭连接")

# 4.2产生但是没有捕获异常
print("4.2产生但是没有捕获异常")
# try:
#    print(open("test.txt"))
# finally:
#    print("关闭连接")
# print("------------")   # 不会执行,因为报错了程序中断

# 4.3 没有异常执行finally语句
print("4.3 没有异常执行finally语句")
try:
    print("没有异常")
finally:
    print("关闭连接")
# print("------------")   # 会执行，因为没有报错程序不会中断

# 5异常传递：如果函数内部调用的函数产生了异常，需要在外部函数中捕获并且处理，需要从内部调用的函数把异常传递给了外部函数的过程
# fun1函数打印了一个不存在的变量，但是没有处理，后面函数func2调用了func1，在函数func2中处理
print("5异常传递")
def func1():
    print(num)
def func2():
    try:
        print("----func2-----")
        func1()
    except Exception as err:
        print("捕获到了异常", err)
func2()

# 6抛出异常 raise
print("-----6抛出异常------")
def div(a, b):
    if b == 0:
        raise ZeroDivisionError("异常原因，除法运算，除数不能为0")
    else:
        print(round(a/b, 2))
div(20, 3)