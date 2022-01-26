import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
import matplotlib.pyplot as plt
from sklearn.metrics import accuracy_score
from numpy import *

def autoNorm(data_df):
    min_value = data_df.min(0)
    max_value = data_df.max(0)
    ranges = max_value - min_value
    norm_data_set = zeros(shape(data_df))
    m = data_df.shape[0]
    norm_data_set = data_df - tile(min_value,(m,1))
    norm_data_set = norm_data_set / tile(ranges,(m,1))
    return norm_data_set,ranges,min_value

# 1.加载数据集
winequality_red_df = pd.read_csv("winequality-red.csv")

# 查看diabetes_df类型是DataFrame
print(type(winequality_red_df))

# 通过DataFrame的shape属性查看数据集结构
print("样本行数:{},列数:{}".format(winequality_red_df.shape[0],winequality_red_df.shape[1]))

# 查看数据集部分数据内容，默认打印前5行数据
print(winequality_red_df.head())

# 划分数据集
#提取具有11个特征的样本集
X = winequality_red_df[["fixed acidity","volatile acidity","citric acid","residual sugar",
                        "chlorides","free sulfur dioxide","total sulfur dioxide","density",
                        "pH","sulphates","alcohol"]]
# X = winequality_red_df[["citric acid","residual sugar","pH","sulphates","alcohol"]]
#提取样本目标变量
y = winequality_red_df["quality"]

X,ranges,min_value = autoNorm(X)
# print(X)
# print("--------------")
# print(range)
# print("--------------")
# print(min_value)
#进行预测
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)
print("数据集样本数：{}，训练集样本数：{}，测试集样本数：{}".format(len(X), len(X_train), len(X_test)))

# 2.选择模型
# 使用sklearn内置的KNeighborsClassifier类创建一个knn算法模型
k = 1
knn = KNeighborsClassifier(n_neighbors=k)

# 3.训练模型
knn.fit(X_train, y_train)

# 4.测试模型
y_pred = knn.predict(X_test)
print(y_pred)

# 计算准确率
acc = accuracy_score(y_test, y_pred)
print("准确率：", acc)


#查看k值对结果的影响
k_range = range(1, 51) #k值选择1到50个不同的值
acc_scores = [] #存储每次预测之后的打分
for k in k_range:
    knn = KNeighborsClassifier(n_neighbors=k)
    knn.fit(X_train, y_train)
    score = knn.score(X_test, y_test)
    acc_scores.append(score)

#使用matplotlib画图
plt.figure()
plt.rcParams["figure.figsize"] = (15.0, 8.0) #设置图片大小
plt.xlabel("k") #设置x轴显示的标签名是k
plt.ylabel("accuracy") #设置y轴显示的标签名是accuracy
#使用plot函数绘制图形，x轴坐标值表示不同的k值，y轴坐标值表示准确率，marker参数设置数据点标识符
plt.plot(k_range, acc_scores, marker='o')
#x轴上的点分布
plt.xticks([0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 51])
plt.show()
