
# 2.1类:类是一类事物的抽象，对象是类创建的一个具体事物，具有状态和行为，能做具体的事情,类可以创建多个对象,
# 类由类名、属性和方法构成

class Dog:
    def __init__(self):
        print("初始化方法")
    def eat(self):
        print("正在啃骨头...")
    def drink(self):
        print("正在喝水...")
    def run(self):
        print("正在跑....")
# 2.2对象
# id()函数可以获取对象在内存中的地址,一个类可以创建多个对象，但是对象在内存中的地址是不一样的
print("hello wangcai")
wangcai = Dog()   # 创建了一个对象
wangcai.run()
print("hello tuofu")
tuofu = Dog()
tuofu.run()
print("wangcai position is ", id(wangcai))
print("tuofu position is ", id(tuofu))

# 2.3 __init__ 构造方法  作用是创建一个类的对象时进行初始化操作
# 通过init方法构造小狗的基本属性(品种和性别)
class Dog1:
    def __init__(self, variety, sex):
        print("开始初始化")
        self.variety = variety  # self.属性名=属性值
        self.sex = sex
        self.__age = 1   # __代表私有属性，具有私有属性访问权限的属性和方法只能在内部访问，外部不能访问
        def __set_age(self,age):
            self.__age = age
        print("初始化结束")
wc = Dog1("金毛","雌性")
wc.name = "旺财"   # 属于动态添加，不推荐
# print("wc的品种为{}".format(wc.variety))
# print("wc的性别为{}".format(wc.sex))
# print("wc的名字为{}".format(wc.name))

# 2.4访问权限  ,私有属性和方法只能在类的内部访问，外部是访问不了的，在属性和方法前面加上 __就代表私有的
class Dog2:
    def __init__(self, name):
        self.name = name
        self.__age = 1 # 私有属性
    def __set_age(self, age):   # 私有方法，用于设置年龄
        self.__age = age
    # 设置名字和年龄属性
    def set_info(self, name, age):
        # 如果传入的名字不是空字符串，则给对象设置新的名字
        if name != '':
            self.name = name
        # 合法年龄是1岁到20岁
        if age > 0 and age <= 20:
            self.__set_age(age)
        else:
            print("年龄设置失败，非法年龄！")
    def get_info(self):
        print("我的名字是{},我现在{}岁".format(self.name, self.__age))
wc = Dog2("旺财")
# wc.get_info()
# 给旺财设置新的年龄
wc.set_info("", 20)
# wc.get_info()

# 2.5继承 :可以很好的实现代码重用
# 2.5.1 单继承：在定义子类时，子类类名后面加一个小括号，小括号中填写父类的类名
# 并且子类只能调用父类的非私有属性和非私有方法
# 当子类在查找调用的方法时，顺序是先在子类中查找，然后再从父类中查找,如果父类还有父类，则继续往父类的父类中查找，如果最后找不到就会报错
class Animal:   # 定义动物类
    # 定义动物类的一些行为
    def eat(self):
        print("---吃吃吃----")
    def drink(self):
        print("---喝喝喝---")
    # 定义私有属性和方法
    def __init__(self):
        self.name = "动物"
        self.__age = "未知"
        print("---Animal初始化---")
    def __la(self):
        print("---啦啦啦---")
class Pig(Animal):  #定义一个猪，继承动物类
    def run(self):
        print("---跑跑跑----")
    def __init__(self):
        print("---Dog初始化---")
pig = Pig()
pig.run()
pig.eat()
# 写一个猪的子类
class Sow(Pig):
    def born(self):
        print("--看我可以生崽---")
sow = Sow()
sow.eat()
sow.run()
sow.born()
# 备注：如果子类没有定义构造方法，那么会调用父类的构造方法，如果子类有调用方法，则会调用自己的构造方法，则不会在调用父类的构造方法

# 2.5.2 super函数
# 如果在子类中需要调用父类的方法，有两种方法可以实现
# 通过 父类名.方法名(self[,参数列表])  注意 self是子类的实例对象，不是父类的实例对象
# 或者通过 super().方法名 的方式，不需要指定调用哪个父类的方法，super函数会自动找到调用的父类方法
class Cat(Animal):
    def __init__(self):
        print("---Cat初始化---")
    def hand(self):
        print("---握手---")
class MuCat(Cat):
    def guide(self):
        print("---我能导航---")
        print("---请先跟我握手---")
        # Cat.hand(self)
        super().hand()
mucat = MuCat()
mucat.guide()

# 2.5.3 重写：就是子类中定义和父类中同名的方法，当子类对象调用该方法时，只会调用子类的方法
class SmallCat(Cat):
    def guide(self):
        print("---我能导航---")
        print("---请先跟我握手---")
    def hand(self):
        print("--我还小，只能伸手---")
smallcat = SmallCat()
smallcat.hand()

# 2.5.4多继承，就是一个类可以继承多个父类并调用他们的非私有属性和非私有方法，多个父类之间用都好隔开
# 如果多个父类中有同名的方法，则取最括号中最左边父类的方法，可以通过内置的 __mro__方法解析搜索顺序
class AI:
    def face_recognition(self):
        print("---AI人脸识别---")
    def data_handle(self):
        print("---AI数据处理---")
class BigData:
    def data_analysis(self):
        print("---大数据分析---")
    def data_handle(self):
        print("---大数据处理---")
class PythonLan(AI, BigData):
    def operation(self):
        print("---语言操作----")
pylan = PythonLan()
# 通过内置的  __mro__方法查看解析搜索顺序
print("---------多继承开始---------")
print(PythonLan.__mro__)
pylan.operation()
pylan.face_recognition()
pylan.data_analysis()
pylan.data_handle()