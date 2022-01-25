

# i matplotlib绘图
import pandas as pd
from matplotlib import pyplot as plt
import numpy as np

# 1 绘制散点图 scatter函数
# x = np.random.randn(1000)
# y = np.random.randn(1000)
# plt.scatter(x, y, color = 'g', marker = '*', alpha = 0.5)
# plt.title('scatter plot for 1000 random data from normal distribution')
# plt.xlim(-5,5)
# plt.ylim(-5,5)
# plt.show()
# 2 绘制折线图
# grouth = pd.read_table('e:\\pycharm_repo\\datas\\growth.txt', sep=' ')
# plt.plot(grouth['year'], grouth['sweden'], color='r', label='sweden', linestyle='--')
# plt.plot(grouth['year'], grouth['norway'], color='pink', label='norway')
# plt.plot(grouth['year'], grouth['new zealand'], color='purple', label='new zealand', marker='+')
# plt.title('real gdp growth for three countries between 1946 and 2009')
# plt.xlabel('year')
# plt.ylabel('real gdp growth')
# plt.legend()
# plt.show()

# 3 绘制柱状图 用bar函数
# index = np.arange(5)
# value = [20, 30, 45, 35, 50]
# plt.bar(index, value, width=0.5, label='population', facecolor='#ff0000')
# plt.title('Grouping Allocation')
# plt.xticks(index, ('Group1', 'Group2', 'Group3', 'Group4', 'Group5'))
# plt.yticks(np.arange(0, 60, 10))
# plt.legend(loc='upper left')
# a = zip(index, value)
# for x, y in a:
#     plt.text(x, y, y, ha='center', va='bottom')
# plt.show()

# 4 绘制箱状图
# goals = pd.read_csv('e:\\pycharm_repo\\datas\\WorldCupMatches.csv')
# home_team_goals = goals['Home Team Goals']

# away_team_goals = goals['Away Team Goals']

# plt.boxplot((home_team_goals,away_team_goals), labels = ['Home Teams','Away Teams'])
# plt.title('Goals for Home Teams and Away Teams in all FIFA World Cups')
# plt.show()

# II Pandas绘图
# 1 绘制Series序列图：默认情况下，plot方法绘制Series图生成的都是线型图
# s1 = pd.Series(np.random.randn(100))
#s1.plot(style='ko--', alpha=0.5, grid=True, label='s1',
#        title='Plot for 100 Random Data from Standard Normal Distribution')
#plt.show()
# 2 在同一张图中绘制两个Series折现图
# s2 = pd.Series(np.random.randn(100))
# s3 = pd.Series(np.random.randn(100))
# s2.plot(label='s1')
# s3.plot(label='s2', style='--')
# plt.legend()
# plt.show()
# 3 绘制DataFrame图表:默认每一个列会生成一个图例，默认生成折现图
# df = pd.DataFrame(np.random.randn(10, 3).cumsum(0), columns=['one', 'two', 'three'])
# print(df)
# df.plot(kind='bar', stacked=True)
# kind的枚举值 直方图-hist,箱线图-box，饼图-pie,散点图-scatter,密度图-density,
# plt.show()

# 4 Seaborn 绘图：是一种基于matplotlib的可视化库，提供了更高级的API封装
import seaborn as sns
tips = sns.load_dataset('tips')
print(tips.head())
#
# 单变量条形图
# sns.stripplot(x = 'day', y = 'total_bill', data = tips)
# plt.show()
#
# 单变量条形图非重叠
# sns.stripplot(x = 'day', y = 'total_bill', data = tips, jitter = True)
# plt.show()
#
# 横向单变量条形散点图
# sns.stripplot(x = 'total_bill', y = 'size', data = tips, jitter = True, orient= 'h')
# plt.show()
#
# 双变量条形散点图
# sns.swarmplot(x = 'day', y = 'total_bill', data = tips, hue = 'sex')
# plt.show()

# 箱线图
# sns.boxplot(x = 'day', y = 'total_bill', hue = 'smoker',data = tips, palette = 'Reds')
# plt.show()

# 琴形图
# sns.violinplot(x = 'day', y = 'total_bill', data = tips)
# plt.show()

# 分类琴形图
# sns.violinplot(x = 'day', y = 'total_bill', hue = 'smoker', palette= 'coolwarm', inner = 'quartile', split= True, data = tips)
# plt.show()

# 小提琴图结合散点图
# sns.violinplot(x = 'day', y = 'total_bill', data = tips, palette = 'hls', inner = None)
# sns.swarmplot(x = 'day',  y = 'total_bill', data = tips, color = 'w', alpha = 0.5)
# plt.show()

# factorplot
# 点图
# sns.factorplot(x='day', y='total_bill', hue='smoker', data=tips)
# plt.show()

# 柱形图
# sns.factorplot(x='day', y='total_bill', hue= 'smoker', kind = 'bar', data=tips)
# plt.show()

# 条形散点图
# sns.factorplot(x='day', y='total_bill', hue='smoker',
#                col='time', kind = 'swarm', data=tips)
# plt.show()

# 箱线图
# sns.factorplot(x='day', y='total_bill', hue='smoker',
#                col='time', kind = 'box', data=tips)
# plt.show()

# 多变量琴形图
g = sns.PairGrid(tips,
                 x_vars=['smoker', 'time', 'sex'],
                 y_vars=['total_bill', 'tip'],
                 aspect=.75, size=3.5)
g.map(sns.violinplot, palette="hls")
plt.show()