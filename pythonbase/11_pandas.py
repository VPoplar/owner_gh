# python常用扩展库 numpy和pandas
import numpy as np
import pandas as pd

# 1 Pandas数据结构-Series
# 主要的数据结构为Series(存储)和DataFrame(分析)
# 1.1 Series-由索引和值组成，索引在左侧，值在右侧
s1 = pd.Series([1, 2, 3, 4, 5])
print('s1= ', s1)
# 还可以设置索引
s2 = pd.Series([1, 2, 3, 4, 5], index=['第一', '第二', '第三', '第四', '第五'])
print('s2= ', s2)
# 通过values和index获取索引和数值,它的切片是左闭右闭的
print('s2.index= ', s2.index)
print('s2.values= ', s2.values)
# 索引是不可以被修改的，但是数据可以被修改
print('s2中第二对应的数据：{}'.format(s2['第二']))
s2['第二'] = 10
print('s2中第二对应的数据：{}'.format(s2['第二']))
print('s2中对应的数据：{}'.format(s2[['第一', '第二', '第三']]))
print('s2中对应的数据：{}'.format(s2['第二': '第三']))
# 1.3 字典类型数据创建Series
s_dic = {'First': 1, 'Two': 2, 'Three': 3, 'Third': 4, 'Four': 5 }
s3 = pd.Series(s_dic)
print('s3= {}'.format(s3))
# 安照指定的顺序排列
s4 = pd.Series(s_dic, index=['First', 'Third', 'Four', 'Two'])
print('s4= {}'.format(s4))
# 还可以用字典中的 in 和 not in
print('s4 中含有six', 'six' in s4)
print('s4 中是不含有six', 'six' not in s4)
# 看字典中是否存在缺失值,如果索引对应的数据为空那么会用NaN表示
s5 = pd.Series(s_dic, index=['First', 'Third', 'Four', 'Six'])
print('s5= {}'.format(s5))
print('s5数据缺失 {}'.format(s5.isnull()))
print('s5数据不缺失 {}'.format(s5.notnull()))
# 1.4 Series的算术运算 不同索引对应的数据会自动对齐
print('s4= ', s4)
print('s5= ', s5)
print('s5+s4= ', s5 + s4)

# 2 DataFrame数据结构
# 它是一种二维表型数据结构，即有行索引也有列索引
df_dic = {'color': ['red', 'yellow', 'blue', 'purple', 'pink'],
        'size': ['meidum', 'small', 'big', 'medium', 'small'],
        'taste': ['sweet', 'sour', 'salty', 'sweet', 'spicy']}
df = pd.DataFrame(df_dic, columns=['size', 'taste', 'color', 'category'])
# 可以指定列的顺序;如果传入的列不存在，则那一列的值都为Nan
print('df= {}'.format(df))
# 可以设置列的标题和行索引的名称
df.index.name = 'sample'
df.columns.name = 'feature'
print('df=\n{}'.format(df))
# 使用values可以获得所有的数据，并以二维数组的形式返回
print('df.values=\n', df.values)
# 获取列索引的两种方式
print('df中的color列\n{}'.format(df.color))
print('df中的color列\n{}'.format(df['color']))
# 如果要获取某一行，可以用行索引 loc
print('df中的第2行\n{}'.format(df.loc[1]))
# 对应空的列，可以进行数据填充
df['category'] = np.arange(5)
print('df=\n{}'.format(df))  # 填充全部值
df['category'] = pd.Series([2, 3, 4], index=[0, 2, 4])
print('df=\n{}'.format(df))  # 填充部分值
# 如果为不存在的列赋值，则会创建一个新的列
df['country'] = pd.Series(['China', 'UK', 'Japan', 'USA', 'Frank'])
print('df=\n{}'.format(df))  # 增加新的列并赋值
# 可以使用布尔数组选行
print('df 中category小于等于3得数据\n{}'.format(df[df['category'] <= 3]))

# 3 数学统计与计算:可以求和、平均数、分位数等
# mean-均值；median-中位数；count-非缺失值数量；min-最小值；max-最大值
# describe-汇总统计；var-方差;std-标准差；skew-偏度；kurt-峰度；diff-一阶差分；
# cumin-累计最小值；cumax-累计最大值;cumsum-累计和；cumprod-累计积；cov-协方差；corr-相关系数；
df1 = pd.DataFrame([[3, 2, 3, 1], [2, 5, 3, 6], [3, 4, 5, 2], [9, 5, 3, 1]]
                   , index=['a', 'b', 'c', 'd'], columns=['one', 'two', 'three', 'four'])
print('df1=\n{}'.format(df1))
print('df1.sum_lie=\n{}'.format(df1.sum()))  # 按列求和
print('df1.sum_line=\n{}'.format(df1.sum(axis=1)))  # 按行求和
print('df1.cumsum=\n{}'.format(df1.cumsum()))  # 从上到下累计求和
print('df1.cumsum=\n{}'.format(df1.cumsum(axis=1)))  # 从左到右累计求和

# 4 DataFrame的文件操作
# 4.1 读取文件;可以读取csv,txt,excel,sql,json,html,dict
# read_csv = pd.read_csv('E:\\pycharm_repo\\datas\\numpy_arr12.csv', encoding='utf-8')
# print('read_csv=\n', read_csv)
# 4.2 写入文件：csv,txt,excel,sql,json,html,dict
# df.to_csv('datas\\pandas1.csv', sep=',', header=True, index=True, encoding='utf-8')
# 5 数据处理（数据清洗）：缺失值,重复值等等
# 5.1 缺失值一般会被记作 numpy.nan
df4 = pd.DataFrame([[3, np.nan, 3, 1], [2, 5, np.nan, 3], [3, 4, 5, np.nan], [5, 3, 1, 3]],
                   index=['a', 'b', 'c', 'd'], columns=['one', 'two', 'three', 'four'])
print(df4.isnull())  # 判断df4中每个位置是否为缺失值-返回的是布尔类型
print(df4[df4.isnull().any(axis=1)])  # 返回有True的那一行

arr = pd.Series([1, 2, 3, np.nan, 5, 6])
print('arr:{}'.format(arr))
# 过滤缺失值  并不会改变原来的数组
print('过滤缺失值：{}'.format(arr.dropna()))
arr = arr.dropna()   # arr.dropna(inplace=True)  结果是一样的
print('过滤缺失值之后的arr:{}'.format(arr))
df4['fifth'] = np.NAN
print('df4:{}'.format(df4))
# fillna 填充函数
# 用0替换缺失值的null
print('df4.fillna(0)\n{}'.format(df4.fillna(0)))
# 用中位数填补缺失值
print('df4_fillna_median\n{}'.format(df4.fillna(df4.median())))
# 向上填充 ffill,向下填充 bfill
print('df4.ffill()\n{}'.format(df4.ffill()))
print('df4.bfill()\n{}'.format(df4.bfill()))
# 5.2 重复值处理
df5 = pd.DataFrame([[3, 5, 3, 1], [2, 5, 5, 6], [3, 4, 5, 3]
                    , [5, 3, 1, 3], [3, 4, 5, 3], [3, 4, 6, 8]]
                    , index=['a', 'b', 'c', 'd', 'e', 'f']
                    , columns=['one', 'two', 'three', 'four'])
print('df5\n', df5)
# 查看是否存在重复行
print('查看df5是否存在重复行\n', df4[df4.duplicated()])
# 查看前两列是否存在重复行
print('查看df5前两列是否存在重复行\n', df4[df4.duplicated(['one', 'two'])])
# 删除重复列，只保存第一次出现的重复行
print('删除重复列，只保存第一次出现的重复行\n', df5.drop_duplicates(subset=['one', 'two'], keep='first'))
# 5.3 数据记录合并与分组
# append合并两个列索引完全相同的 DataFrame
df6 = pd.DataFrame([[1, 7, 3, 1], [3, 5, 5, 6]], index=['g', 'h'], columns=['one', 'two', 'three', 'four'])
print('df5.append(df6)合并\n', df5.append(df6))
# concat合并，可以行合并，也可以列合并(axis=1)
print('df5和df6行合并', pd.concat([df5, df6]))
print('df5和df6列合并', pd.concat([df5, df6], axis=1))    # join参数，可以取并集也可以取交集
# merge合并  这个类似于表的join,可以左连接，右连接，全连接
df7 = pd.DataFrame([[1, 'lily'], [2, 'joke'], [3, 'andy']], index=['a', 'b', 'c'], columns=['id', 'name'])
print('df7:\n', df7)
df8 = pd.DataFrame([[1, 22], [2, 33], [4, 44]], index=['a', 'b', 'c'], columns=['id', 'age'])
print('df8:\n', df8)
print('df7 inner join df8:\n', pd.merge(df7, df8, left_on='id', right_on='id', how='inner'))  # 默认inner
print('df7 left join df8:\n', pd.merge(df7, df8, left_on='id', right_on='id', how='left'))
print('df7 right join df8:\n', pd.merge(df7, df8, left_on='id', right_on='id', how='right'))
print('df7 outer join df8:\n', pd.merge(df7, df8, left_on='id', right_on='id', how='outer'))
