# python常用扩展库 numpy和pandas

import pandas as pd

# 1 Pandas数据结构
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

# DataFrame数据结构


