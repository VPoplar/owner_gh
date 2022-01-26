
# 数据分析的五个步骤:
# 提出问题，数据处理，探索数据，得出结论，结果报告
# 探索数据的常用分析方法：对比分析，相关分析，因子分析，交叉分析，回归分析，分组分析等

# 项目实战，房屋售价数据分析
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

price = pd.read_csv('kc_house_data.csv')
print(type(price))
# 查看price的行数和列数
print('price的行列数分别为：{}'.format(price.shape))
'''
    variables:
    price : 每个房子的售价
    date : 房子售出的日期
    bedrooms : 卧室的数量
    bathrooms : 洗手间的数量，小数点表示有卫生间无浴室
    sqft_living : 公寓内部居住空间（平方英尺）
    sqft_lot : 土地面积（平方英尺）
    floors : 楼层数
    waterfront : 是否可以俯瞰海滨（虚拟变量）
    view : 视野优良评分（0到4）
    condition : 公寓条件评分（1到5）
    grade : 建筑施工设计评分（1到13）
            1-3 建筑施工设计不足
            7 建筑施工设计的平均水平
            11-13 建筑施工设计高质量水平
    sqft_above : 地面以上的室内居住空间（平方英尺）
    sqft_basement : 地面以下的室内居住空间（平方英尺）
    yr_built : 房子最初建成年份
    yr_renovated : 房子最近一次更新的年份
    zipcode : 邮编
    lat : 纬度
    long : 经度 
    sqft_living15 : 最近的15个邻居的室内居住空间
    sqft_lot15 : 最近的15个邻居的土地面积

'''

# ####### 数据清洗
# # 处理重复值
# price_dup = price.duplicated()
# print(price[price_dup])
# price = price.drop_duplicates()
#
# # 处理缺失值
# isNA_price = price.isnull()
# print(price[isNA_price.any(axis = 1)])
#
# plt.scatter(x= list(range(1,len(price['bedrooms'])+1)), y = price['bedrooms'])
# plt.title('Scatter plot for numbers of bedrooms')
# plt.xlabel('samples')
# plt.ylabel('bedrooms')
# plt.show()

# 去除异常值
outlier = [i for i in range(len(price['bedrooms'])) if price['bedrooms'][i] > 10]
print(outlier)
price.drop(outlier, inplace=True)
# outlier = [i for i in range(len(price['bedrooms'])) if price['bedrooms'][i] > 10]
outlier1 = [i for i in price['bedrooms'] if i > 10]
print(outlier)

# 变量处理
## grade
price['grade'] = [1 if i <= 3 else 2 if i< 7 else 3 if i== 7 else 4 if i <11 else 5
                 for i in price['grade']]
print(price['grade'].head(10))

# # col_name = price.columns.tolist()
# # price.insert(loc = col_name.index('grade')+1, column='grade_category', value = grade_category)
#
## price
per_price = price['price']/price['sqft_living']
price.insert(loc = 1, column='per_price', value = per_price)
print(price.iloc[:2,:3])
print('#############')
print(price[price['grade']==1]['per_price'])
print('#############')
## age

print(price[['yr_built', 'date']][:3])
year = [eval(i[:4]) for i in price['date']]
price['age'] = year - price['yr_built']
print(price['age'][:3])
print(min(price['age']), max(price['age']))
bins = [min(price['age'])-1, 10, 20, 30,40, 50, 60, 70, 80, 90,100, max(price['age'])+1]
cut = pd.cut(price['age'], bins, right=False)
col_name = price.columns.tolist()
price.insert(loc = col_name.index('age')+1, column = 'age_category', value = cut)
print(price.iloc[:5, [col_name.index('age'), col_name.index('age')+1]])

# sale_month
price['sale_month'] = [eval(i[4:6]) if i[4]!= '0' else eval(i[5:6]) for i in price['date']]
print(price['sale_month'].head())

## yr_renovated
# 1 if the house has been renovated
price['yr_renovated'] = price['yr_renovated'].apply(lambda x: 1 if x>0 else 0)

## sqft_basement
price['if_basement'] = price['sqft_basement'].apply(lambda x: 1 if x>0 else 0)

print(price[['yr_renovated', 'if_basement']].head())
# print(price.head())

####### 房屋单位居住面积价格与房屋得分关系分析
# 视野优良得分
# data = pd.concat([price['per_price'],price['view'],price['condition'],price['grade']],axis=1)
# sns.boxplot(x = 'view', y = 'per_price', data = price, palette = 'hls')
# plt.show()
# sns.boxplot(x = 'condition', y = 'per_price', data = price , palette = 'hls')
# plt.show()
# sns.boxplot(x = 'grade', y = 'per_price', data = price, palette = 'hls')
# plt.show()
# print(price[price['grade']==1]['per_price'])

### 相关性分析
# 房屋价格与房屋面积及配置关系分析
# 各变量相关系数热力图
# corrmat = price.corr()
# f, ax = plt.subplots(figsize=(9, 8))
# sns.heatmap(corrmat, square= True, annot= True,center = None, fmt='.2f', robust = True,
#             linewidths=0.05, annot_kws={'size':6})
# plt.xticks(rotation=90)
# plt.yticks(rotation=360)
# plt.show()


# 相关性较大的变量
# 多变量散点图
# sns.set()
# col = ['price','bedrooms','bathrooms','sqft_living','grade','sqft_above','sqft_living15']
# sns.pairplot(price[col], size = 1.5)
# plt.show()

# # sqft_living居住面积与房价
# sns.jointplot(x='sqft_living', y = 'price', data = price, kind='reg', size = 5)
# plt.show()
# # sqft_above地上居住面积与房价
# sns.jointplot(x='sqft_above', y = 'price', data = price, kind='reg', size = 5)
# plt.show()
# # 周围15个邻居居住面积与房价
# sns.jointplot(x='sqft_living15', y = 'price', data = price, kind='reg', size = 5)
# plt.show()
#
# # bedroom卧室个数与房价
# data = pd.concat([price['price'],price['bedrooms']],axis=1)
# fig = sns.boxplot(x = 'bedrooms', y = 'price', data = data)
# fig.axis(ymin = 0, ymax = 4000000)
# plt.show()
#
# # bathroom浴室个数与房价
# data = pd.concat([price['price'],price['bathrooms']],axis=1)
# fig = sns.boxplot(x = 'bathrooms', y = 'price', data = data)
# fig.axis(ymin = 0, ymax = 4000000)
# plt.show()



# 房屋面积单价与成交年份及房屋建成年限分析
# sns.distplot(price['age'], bins, hist_kws=dict(edgecolor='k'))
# plt.ylabel('Percentage')
# plt.show()

# 销售时间段统计
month_count = [list(price['sale_month']).count(i) for i in range(1,13)]
dic = {'month': range(1,13),
       'count': month_count}
df = pd.DataFrame(dic)
print(df)
sns.barplot(x = 'month', y = 'count', data = df)
plt.show()

