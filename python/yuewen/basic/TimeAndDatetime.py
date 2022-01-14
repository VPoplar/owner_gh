# -*- coding: UTF-8 -*-
import datetime
import time

# datetime.strptime(date_string, format) 将字符串转化为时间
# time.strftime(format, time.localtime())  将日期转化为字符串
#1 time函数的用法
#获取系统当前时间并且格式化
print(time.strftime('%Y-%m-%d %H:%M:%S ', time.localtime())) # 2020-11-24 15:19:46   将日期转化为字符串
print(time.strftime('%Y%m%d ', time.localtime())) # 2020-11-24 15:19:46
print(datetime.datetime(2019, 2, 20, 13))   # 2019-02-20 13:00:00

print(time.strptime('20210620', '%Y-%m-%d'))
date = '20210620'
# now = datetime.datetime.now()  --获取当前时间
mid = datetime.datetime.strptime(date, '%Y%m%d')
res = mid + datetime.timedelta(days=2)  # 2天后的时间

print(res)

#2 datetime的用法
print(datetime.datetime.now())  #  格式化当前的时间 2020-06-18 08:19:13.357307
print(datetime.datetime.fromtimestamp(1111111)) # 将一个时间戳转化为格式化的时间  1970-01-14 04:38:31

#对时间进行加减
print(datetime.datetime.now()+datetime.timedelta(days=1)) # 2020-06-21 08:19:13.357307
print(datetime.datetime.now()+datetime.timedelta(hours=3)) # 2020-06-18 11:19:13.357307
print(datetime.datetime.now()+datetime.timedelta(minutes=5)) # 2020-06-18 08:24:13.357307
print(datetime.datetime.now()+datetime.timedelta(seconds=14)) # 2020-06-18 08:19:27.357307
#替换时间
print(datetime.datetime.now().replace(year=2222)) # 2222-06-18 08:19:13.357307
print(datetime.datetime.now().replace(month=7)) # 2020-07-18 08:19:13.357307




