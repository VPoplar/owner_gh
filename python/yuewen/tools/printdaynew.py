import datetime
def dateRange(beginDate, endDate):
    dates = []
    dt = datetime.datetime.strptime(beginDate, "%Y-%m-%d")
    date = beginDate[:]
    while date <= endDate:
        dates.append(date)
        dt = dt + datetime.timedelta(1)
        date = dt.strftime("%Y-%m-%d")
    return dates

def addListPartition(beginDate, endDate):
    dates = []
    dt = datetime.datetime.strptime(beginDate, "%Y%m%d")
    date = beginDate[:]
    while date <= endDate:
        dates.append(date)
        dt = dt + datetime.timedelta(1)
        date = dt.strftime("%Y%m%d")
    for i in dates:
        print('alter table t_md_qidian_author_avgbuy_work add partition p_' + i + ' values(' + i + ');')

def addRangPartition(beginDate, endDate):
    dates = []
    dt = datetime.datetime.strptime(beginDate, "%Y%m%d")
    date = beginDate[:]
    while date <= endDate:
        dates.append(date)
        dt = dt + datetime.timedelta(1)
        date = dt.strftime("%Y%m%d")
    for i in dates:
       # print(i)
        mid_date = datetime.datetime.strptime(i, '%Y%m%d')  # 将日期转化为时间
        cen_date = mid_date + datetime.timedelta(days=1)
        res_date = cen_date.strftime('%Y%m%d')  # 将时间转化为字符串
        print('alter table t_ed_qidian_sna_view_v2 add partition p_' + i + ' values less than (' + res_date + ');')

def print_day(beginDate, endDate):
    dates = []
    dt = datetime.datetime.strptime(beginDate, "%Y%m%d")
    date = beginDate[:]
    while date <= endDate:
        dates.append(date)
        dt = dt + datetime.timedelta(1)
        date = dt.strftime("%Y%m%d")
    for i in dates:
       # print(i)
        mid_date = datetime.datetime.strptime(i, '%Y%m%d')  # 将日期转化为时间
        cen_date = mid_date + datetime.timedelta(days=1)
        res_date = cen_date.strftime('%Y%m%d')  # 将时间转化为字符串
        print(i)


if __name__ == '__main__':
    curr_time = datetime.datetime.now()
    end_date = datetime.datetime.strftime(curr_time, '%Y-%m-%d')
    delta = datetime.timedelta(days = 3)
    middate = curr_time - delta

#   print(middate)
#   addListPartition("20210526", "20210531")
#   addRangPartition("20210101", "20210726")
    print_day("20210101", "20210726")

