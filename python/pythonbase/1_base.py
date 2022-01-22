
# 1 字符串中的内置方法
#line = 'hello world hello python'
# print(line.find("223"))
# print(line.replace("hello", "hi", 1))

#content = input("提示信息，取款成功，yes继续，no直接退出： ")
# print("您输入的信息：", content)
#if content.lower() == "yes":
#    print("欢迎继续使用！")
#lse:
#    print("退出成功，请取卡！")
def while1():
    # 2 while 循环
    i = 1   # 用于控制行号
    n = 4   # 正三角形共打印多少行
    while i <= n:
        print(" "*(n-i), end="")  # 打印第一个星号距离左侧的空格数
        j = 1
        while j <= 2*i - 1:  # 每行打印星星的个数
            print("*", end="")
            j += 1
        print("")  # i每变一次，就进行换行
        i += 1
def while2():
    print("----------start----------")
    i = 1
    n = 20
    while i <= n:
        if i % 2 == 0:
            if i % 10 == 0:
                break
            print(i)
        i += 1
    print("-------end-------")

def while3():
    print("----------start----------")
    i = 1
    n = 20
    while i <= n:
        i += 1
        if i % 2 == 0:
            if i % 10 == 0:
                continue
            print(i)
    print("-------end-------")
def for1():
    for i in range(1, 21, 1):
        if i % 2 == 0:
            if i % 10 == 0:
                break
            print(i)
if __name__ == '__main__':
#    while1()   # 打印正三角行
#    while2()
#    while3()
    for1()
