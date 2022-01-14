import xlrd
import xlwt

workBook = xlrd.open_workbook('F:\\python\\input\\数据记录.xlsx')
# print(workBook)
# 1.获取sheet的名字
# 1.1 获取所有sheet的名字(list类型)
allSheetNames = workBook.sheet_names()
print(allSheetNames)
# 1.2 按索引号获取sheet的名字（string类型）
sheetName = workBook.sheet_names()[0]   # 获取第一个sheet
print(sheetName)
# 2. 获取sheet内容
# 2.1 法1：按索引号获取sheet内容
sheet1_content1 = workBook.sheet_by_index(0)   # sheet索引从0开始
# 2.2 法2：按sheet名字获取sheet内容
sheet1_content2 = workBook.sheet_by_name('表信息')
print(sheet1_content1)
print(sheet1_content2)
# 3. sheet的名称，行数，列数
print(sheet1_content1.name, sheet1_content1.nrows, sheet1_content1.ncols)
# 4. 获取整行和整列的值（数组）
print(sheet1_content1.row_values(1))  # 获取第二行内容
print(sheet1_content1.col_values(1))  # 获取第二列内容
# 5. 获取单元格内容(三种方式)
print(sheet1_content1.cell_value(0, 0))   # 表示第一行第一列
# 6. 获取单元格内容的数据类型
# Tips: python读取excel中单元格的内容返回的有5种类型 [0 empty,1 string, 2 number, 3 date, 4 boolean, 5 error]
print(sheet1_content1.cell(0, 0).ctype)
# 7. 保存内容为xlsx
workBook2 = xlwt.Workbook(encoding="utf-8")
workSheet2 = workBook2.add_sheet("我的excel", cell_overwrite_ok=True)
# 把数字38存到第一行第一列中
workSheet2.write(0, 0, 38)
# 存一行数据
rowData = [12, 23]
for i in range(len(rowData)):
    print(i)
    workSheet2.write(2, i, rowData[i])
workBook2.save('F:\\python\\output\\out1.xlsx')


