import time
import datetime

# 1 time模块
# 1.1time函数  打印time会返回以秒为单位的时间戳(浮点数)
print(time.time())
print(round(time.time()))

# 2 localtime([seconds]) 函数,默认获取本地时间，括号中可以传入一个以秒为单位的时间戳
print("-------localtime([seconds])---------")
print(time.localtime())
times = time.localtime()
print(str(times.tm_year) + str(times.tm_mon) + str(times.tm_mday))
ts = time.time()
datetimea = time.localtime(ts)
print(datetimea)

# 3 strftime(fmt[,struct_time]) 函数：自定义格式化时间，默认格式化当前时间
print(time.strftime('%Y{y}%m{m}%d{d}').format(y='年', m='月', d='日'))
print(time.strftime('%Y-%m-%d %H:%M:%S'))

# 4 strptime(sring,format)函数
time_tuple = time.strptime("2021-11-04 04:50:09","%Y-%m-%d %H:%M:%S")
print(time_tuple)

# 5 mktime(p_tuple) 函数,将一个时间元组转换成一个浮点型时间戳
localtimes = time.mktime(time.localtime())
print(localtimes)

# 6 sleep(seconds)函数:可以让程序在运行的过程中让程序暂停运行，睡眠等待几秒
# for t in range(3, -1, -1):
   # print("倒计时：", t)
   # if t != 0:
   #     time.sleep(1)
   # else:
   #     print("gogogo")

## datetime 模块：它提供了更加丰富的日期和时间处理函数，相比time模块功能更加高级
print("----datetime模块-------")
# 1 now() 方法：获取程序运行的当前时间和日期
time1 = datetime.datetime.now()
print("当前时间为：{}".format(time1))
print(time1.year)
print(time1.month)
print(time1.day)
# 还可以计算时间差值
# time.sleep(2)
time2=datetime.datetime.now()
time_diff = time2.second - time1.second
print("time2-time=", time_diff)
# 2 strftime(fmt)方法：对日期进行格式化
format_time = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
print(format_time)
# 3 fromtimestamp(timestamp)方法：对传入的时间戳进行日期类型的格式化，默认是 “YYYY-MM-DD HH:MM:SS.mmmmmm”,
# 还可以调用strftime()将返回值以自定义的格式进行格式化
ts = time.time()
print("ts", ts)
print("默认格式化ts=", datetime.datetime.fromtimestamp(ts))
print("自定义格式化ts=", datetime.datetime.fromtimestamp(ts).strftime("%Y%m%d"))
# 4 timedelta类 ：内置的时间间隔类
# 计算昨天的日期
today = datetime.datetime.today()
print('今天的日期为 {}'.format(today.strftime("%Y-%m-%d")))
days = datetime.timedelta(days=1)  # 1天的时间间隔
yesterday = today - days
print("days=", days)
print("昨天的日期为：", yesterday.strftime("%Y-%m-%d"))
