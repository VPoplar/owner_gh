# -*- coding: UTF-8 -*-


import datetime
import time

date = '20210620'
# now = datetime.datetime.now()  --获取当前时间
mid = datetime.datetime.strptime(date, '%Y%m%d')  # 将字符串转化为日期
mid2 = mid + datetime.timedelta(days=2)  # 2天后的时间
res = mid2.strftime('%Y%m%d')
# print(res)

list1 = [1, 2, 3, 4]
print(str(i) for i in list1)

