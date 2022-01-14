import xlrd
import xlwt

for i in range(1, 5):  # 根据想要爬的页数而改动
        url = 'https://www.52bqg.net/top/allvisit/{}.html'.format(i+1)
list_all = list()
path = 'D:/笔趣阁目录.xls'
workbook = xlwt.Workbook(encoding='utf-8', style_compression=0)
worksheet = workbook.add_sheet('小说目录', cell_overwrite_ok=True)  # 可覆盖  # 设置工作表名
col = ('小说类型', '小说名', '最新章节', '作者', '最新更新时间')
for i in range(0, 5):
   worksheet.write(0, i, col[i])  # 设置列名
for i in range(1, 5):  # 根据想要爬的页数而改动，这里爬的是第一页到第四页
   url = 'https://www.qidian.com/rank/yuepiao?month=04&style=2&page='.format(i)
   data_list = get_content(url)
   list_all.append([data_list])
for i in range(len(list_all)):  # i=0~1
   sleep(0.5)  # 延迟0.5秒)
   print('正在下载第{}页目录=====>  请稍后'.format(i+1))
   data_s = list_all[i]
   for j in range(len(data_s)):  # j=0
       data = data_s[j]
       for k in range(len(data)):  # k=0~49
           data_simple = data[k]
           for m in range(0, 5):  # m=0~4
               worksheet.write(1 + i * 50 + k, m, data_simple[m])
workbook.save(path)