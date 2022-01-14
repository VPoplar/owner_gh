# -*- coding:utf-8 -*-
# 1 条件判断 if else

a = 10
if a > 5:
    print('a大于5')
elif a == 5:
    print('a等于5')
else:
    print('a小于5')

# 通过打印来进行
'''s = input('birth: ')
birth = int(s)
if birth < 2000:
    print('00前')
else:
    print('00后')'''
# 3 循环判断

for i in range(2):
    print(i)
print('-------------------')
n = 1
while n <= 5:
    if n >= 3:
        break
    print(n)
    n += 1
print('-------------------')
m = 1
while m <= 5:
    if m == 3:
        continue
    print(m)
    m = m + 1










