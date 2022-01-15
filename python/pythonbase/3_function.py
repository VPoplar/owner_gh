
# 函数
import time


def func(name):
    print("name is %s" % name)
    print("name is {}".format(name))
    print("name is " + name)
    print("name is", name)
# func("lily")

def quefun(x, y=20):   # y表示缺省参数，如果不传则默认值为20；并且缺省参数一定要位于普通形参之后，否则会报错
    z = x + y
    print("{}+{}={}".format(x, y, z))
# quefun(4, 10)
# quefun(4)
# quefun(y=3, x=5)   # 命名参数，直接给参数赋予指定的值并且可以不按照

# 2.4不定长参数
# 带有一个*不定长的参数和一个普通参数
def bdcfun(*args, y):
    print("args参数值{}，y的值为：{}".format(args, y))
    print("args参数类型：", type(args))
    re = 0
    if len(args) > 0:
        for i in args:
            re += i
        re += y
        print("所有参数之和为：", re)
# bdcfun(1, 2, 3, y=5)
# bdcfun(4, 6, y=4)
# 带有两个*的不定长参数,kv键值对并存入字典中
def kvfunc(basis, **kwargs):
    print("kwargs的值为{}".format(kwargs))
    print("kwargs的数据类型为{}".format(type(kwargs)))
    tax = kwargs.get("tax")
    social = kwargs.get("social")
    income = basis - tax - social
    print("小明的工资收入为{}".format(income))
# kvfunc(8000, tax=500, social=700)

# 拆包方法,如果要把列表，元组和字典传入不定长参数中，则需要进行拆包，列表和元组在实参之前加*,字典则在实参之前加**
# 调用之前不定长参数累加
list1 = [1, 2, 3]
# bdcfun(*list1, y=4)
# print("----------")
dict1 = {"tax": 500, "social": 700}
# kvfunc(8000, **dict1)

# 4.3函数返回值return
# 实现一个简单的每月工资计算器，通过税前工资，五险一金缴纳比例，扣除住房公积金和税
def insuranceAndFund(basic, **kvargs):
    social = kvargs.get("socail")
    fund = kvargs.get("fund")
    return round(basic*(social+fund), 2)
def tax(balance):
    if balance <= 5000:
        return 0
    elif balance > 5000 and balance <= 10000:
        return balance * 0.05
    elif balance > 10000 and balance < 30000:
        return balance * 0.1
    else:
        return balance * 0.2
def pay(basic):
    dict2 = {"socail": 0.105, "fund": 0.07}
    cost = insuranceAndFund(basic, **dict2)
    cost1 = basic - cost
    tax1 = tax(cost1)
    income = basic - cost - tax1
    print("lily的税前月收入{}，五险一金扣除{}，税扣除{}，最后总收入为{}".format(basic, cost, tax1, income))
# pay(11400)

# 4.4全局变量和局部变量：全局变量定义函数体外，局部变量定义在函数体内，如果要在函数体内修改全局变量，则需要用到 global关键字
basic_value = 1000
# print("修改前basic的值为",basic_value)
def vars(a):
    global basic_value
    basic_value = 15000
    print("修改后basic_value的值为",basic_value)
# vars(basic_value)
# print(basic_value)
# 4.5递归函数
# 计算5的阶乘
def recursiona(num):
    if num > 1:
        print(num, end="*")
        return num * recursiona(num - 1)
    else:
        print(num, end="=")
        return num
# print(recursiona(12))
# 4.6匿名函数 lambda
sum = lambda x,y:x+y
# print(sum(1, 4))

def x_y_cacl(x,y,func):  # func是匿名函数
    print("x={},y={}".format(x, y))
    result = func(x, y)
    print("result={}".format(result))
# x_y_cacl(10,5,lambda x,y:x*y)

# 4.7闭包：当一个嵌套函数的内部函数引用了外部函数的变量，外部函数的返回值是内部函数的引用，这种函数的表达方式称之为闭包
# 通过闭包实现求和
def sum_closer(x):
    def sum_inner(y):
        return x+y
    return sum_inner
rs1 = sum_closer(10)
rs2 = rs1(5)
# print(rs1)
# print(type(rs1))
# print(rs2)
# print(type(rs2))
# 使用普通函数实现计数器
def count_func(base=0,step=1):
    return base+step
c1 = count_func()
c2 = count_func(c1)
c3 = count_func(c2)
# print(c1)
# print(c2)
# print(c3)
# 使用闭包函数实现计数器
def bi_count(base=0):
    list1 = [base]
    def bi_in_count(step=1):
        list1[0] += step
        return list1[0]
    return bi_in_count
a = bi_count()
# print(a())
# print(a())
# print(a())

# 4.8装饰器:其实就是闭包功能的动态使用，使用 @
# 电商客服标准的回复话术
def robot(func):
    def say():
        print("亲，请问有什么可以帮助您吗？")
        func()
        print("亲，请评价我们的服务！")
        print("1 非常满意，2 满意，3 一般，4 差")
        score = input("请输入您的评价:")
        scores = int(score)
        bb = ""
        while scores != '' :
            if scores == 1:
                bb = "非常满意"
                break
            elif scores == 2:
                bb = "满意"
                break
            elif scores == 3:
                bb = "一般"
                break
            elif scores == 4:
                bb = "差"
                break
            else:
                a = input("输入错误，请重新输入您的评价:")
                b = int(a)
                scores = b
        print("感谢您的评价!--{}".format(bb))
    return say
# 正常使用
def concat():
    q = input("请问：")
    print("答：对不起，暂时无法解答您的问题：{}".format(q))
# mid = robot(concat)
# result = mid()

# 1 使用装饰器(无参函数)
@robot
def concat2():
    q = input("请问：")
    print("答：对不起，暂时无法解答您的问题：{}".format(q))
# concat2()

# 2 带参函数使用装饰器:计数两个数字的和
# 计算程序执行耗时
def time_counter(func):
    def counter(x, y):
        start_time = time.time()
        print("start_time:", start_time)
        func(x,y)
        end_time = time.time()
        print("end_time:",end_time)
        print("run_time:",end_time - start_time)
    return counter
# 计算两个数字的和
@time_counter
def sum(x, y):
    time.sleep(2)
    print("{}+{}={}".format(x, y, x+y))
# sum(4, 5)

# 3给装饰器添加不定长参数
# 计算程序执行耗时
def time_counter(func):
    def counter(*args):
        start_time = time.time()
        print("start_time:", start_time)
        func(*args)
        end_time = time.time()
        print("end_time:", end_time)
        print("run_time:", end_time - start_time)
    return counter
# 计算两个数字的和
@time_counter
def sum(x, y, z):
    time.sleep(1)
    print("{}+{}+{}={}".format(x, y, z, x+y+z))
# sum(4, 5, 6)

# 4带参装饰器的使用:只有管理员权限才可以添加和修改学生成绩
# 定义一个字典存储学生考试成绩
stuscore = {}
def if_admin(admin):
    def check(func):
        def inner(t_name, s_name, score):
            print("正在进行权限检查")
            if t_name != admin:
                raise Exception("权限不够！禁止操作！")
            func(t_name, s_name, score)
            print("操作成功!")
        return inner
    return check
# 添加学生考试成绩
@if_admin("admin")
def add_stu_score(t_name, s_name, score):
    stuscore[s_name] = score
add_stu_score("amin","tom","80")
print(stuscore)
