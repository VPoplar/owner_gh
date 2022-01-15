import re

str = "python java ruby python"
rs = re.match("python", str)
print(type(rs))   # <class '_sre.SRE_Match'>
print(rs)  # <_sre.SRE_Match object; span=(0, 6), match='python'>
print(rs.group())  # python

# 1 单字符匹配
# . 匹配除 \n 之外的任意单个字符
# \d 匹配0到9之间的一个数字，等价于[0-9]
# \D 匹配一个非数字字符等价于[^0-9]
# \s 匹配任意空白字符，如空格，制表符，换行等
# \S 匹配任意非空白字符
# \w 匹配单词字符，包括字母，数字和下划线
# \W 匹配非单词字符
# [] 匹配[]列举中的字字符 字符之间是或的关系

print("-----------1 .号的使用 --------------")
rs1 = re.match(".", "1")
print(rs1.group())   # 1
rs2 = re.match(".", "123")
print(rs2.group())  # 1
rs3 = re.match("...", "123")
print(rs3.group())  # 123
rs4 = re.match(".", "\n")
print(rs4)  # None  备注 None不属于group方法
print("-----------2 []号的使用 --------------")
# 匹配h或者H的字符串
rs = re.match("[Hh]", "Hello")
print(rs.group())  # H
rs = re.match("[Hh]", "hello")
print(rs.group())  # h
# 匹配0-9任意一个数字
rs = re.match("[0123456789]", "123")
print(rs.group())   # 1
rs = re.match("[0-9]", "123")    # 推荐使用
print(rs.group())  # 1

# 2 数量表示：对字符串出现的次数进行匹配
# * 表示一个字符出现0次或者多次
# + 表示一个字符至少出现一次，等价表示{1,}
# ? 表示一个字符至多出现一次，也就是出现0次或者1次
# {m} 表示一个字符出现m次
# {m,} 表示一个字符至少出现m次
# {m,n} 表示一个字符出现m次到n次

# 3 边界
# ^ 表示匹配字符串开头
# & 表示匹配字符串结尾
# 示例；检查用户信息是否完整,用户信息包含三个字段；姓名，手机号，年龄
# 手机号第一位是1，第二位是3578其中1个数字，第3-9位位0-9任何一个数字


users = {"Tom,15600930792,32", "David,,30", "leilei,33747388900,22", "lisa,15747388900a,22"}
for user in users:
    rs9 = re.match("\w+,1[3578]\d{9}$,\d+", user)
    if rs9 != None:
        print("用户信息", rs9.group())
    else:
        print("用户信息不完整")

phones = {"15600930792", "5", "133747388900", "15747388900abccc"}
for phone in phones:
    rs9 = re.match("1[3578]\d{9}$", phone)
    if rs9 != None:
        print("用户", rs9.group())
    else:
        print("用户不完整")

# 4 转义字符 \ 如果转义的字符比较多，则可以用python的原生字符串解决这个问题 就是在字符串前面加个 r

str = "abc\\def"
print(str)   # abc\def

str = r"abc\\def"
print(str)   # abc\\def

# 5 匹配分组
# ! 连接多个表达式，表达式之间是"或"的关系，匹配”|“连接的任何一个表达式
# () 将括号中字符作为一个分组
# \NUM 综合”（）“分组使用，引用分组NUM（NUM表示分组的编号）对应的匹配规则
# (?P<name>) 给分组起别名
# (?P=name) 根据组名使用分组的表达式

# 示例1：匹配多种类型的邮箱
rs = re.match(r"\w{4,10}@(163|qq|outlook).com$", "python2018@163.com")
print(rs.group())

# 示例2：提取网页的标签;可以匹配之前使用的规则
html_data = "<head><title>python</title></head>"
rs = re.match(r"<(.+)><(.+)>.+<(/\2)><(/\1)>", html_data)   # \2表示匹配第2个规则，、1表示匹配第一个规则
print(rs.group())
rs = re.match(r"<(?P<g1>.+)><(?P<g2>.+)>.+</(?P=g2)></(?P=g1)>", html_data)
print(rs.group())

# 6 内置函数
# 1） compile函数，compile函数返回一个正则表达式的对象，从而对之前用过的正则表达式可以进行复用
pattern = re.compile(r"\w{4,10}@(163|qq|outlook).com$")
rs = re.match(pattern, "python2018@qq.com")
print(rs.group())
# 2) search 函数：从左到右在字符串的任意位置搜索第一个被正则表达式匹配的子字符串
rs = re.search("python", "i python 33 python")
print(rs)
# 3) findall函数将所有匹配所有符合正则表达式的子字符串
# 4) finditer 函数 匹配所有符合正则表达式的子字符串，不过返回的结果是一个可迭代对象 Iterator
# 5） sub函数 将正则表达式匹配到的子字符串使用新的字符串替换掉

# 7 贪婪与非贪婪模式
# 贪婪模式：python中的正则表达式解析器默认采用贪婪模式去匹配，也即是锦可能多地匹配字符串
# 非贪婪模式：与贪婪模式相反，是尽可能少地去匹配字符串