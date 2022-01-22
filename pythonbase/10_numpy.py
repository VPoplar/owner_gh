# python常用扩展库 numpy和pandas

import numpy as np
# 1 创建naarray数组
# 1.1 创建一维数组

a = [1.1, 2.2, 3.3, 4.4]
arr = np.array(a)
print('a:{}'.format(a))
print('arr：{}'.format(arr))
# 1.2 创建多维数组
b = [[1, 2, 3], [5, 6, 7]]
arr1 = np.array(b)
print('arr1:{}'.format(arr1))
# 1.3 shape函数得使用
# shape函数可以查看每个数组各个维度得大小，返回得是一个元组得对象，arr.shape[0]输出第一个维度得长度
print('arr shape:{}'.format(arr.shape))   # arr shape:(4,)
print('arr1 shape:{}'.format(arr1.shape))  #  arr1 shape:(2, 3)
# 1.4 reshape函数：可以更改数组得结构
arr1_reshape = arr1.reshape(3, 2)
print('arr1_reshape:{}'.format(arr1_reshape))
arr1[0, 0] = 10 # arr1中第一个元素
print('arr1:{}'.format(arr1))
print('arr1_reshape:{}'.format(arr1_reshape))
# 1.4 创建特殊数组
print('zero_array1', np.zeros(3))  # 创建都为0得一维数组
print('zero_array2', np.zeros((2, 1)))  # 创建都为0得多维数组
print('one_array', np.ones((2, 3)))  # 创建都为1得多维数组
print('empty_array', np.empty((2, 2, 4)))  # 创建没有具体数值得多维数组
print('arange_array', np.arange((19)))    # 创建指定序列数组
print('eye_array', np.eye(2, 3))  # 创建单位数组

# 2 数组得数据类型：可以使用 dtype函数查看,  astype可以转换数据类型
print('arr type', arr.dtype)
print('arr1 type', arr1.dtype)
arr2 = np.array([1, 2, 3], dtype=np.int32)
arr3 = np.array([1, 2, 3], dtype=np.float64)
print('arr2:{},arr2_dtype:{}'.format(arr2, arr2.dtype))
print('arr3:{},arr3_dtype:{}'.format(arr3, arr3.dtype))
arr2_float = arr2.astype(np.float32)
print('arr2_float:{},arr2_float:{}'.format(arr2_float, arr2_float.dtype))

# 3 数组的索引与切片
# 一维数组索引
arr5 = np.arange(15)
print('arr5: ', arr5)
print('arr5[8]: ', arr5[8])
print('arr5[8,12]: ', arr5[8:12])   # 左闭右开
# copy函数
arr5_copy = arr5.copy()
print('arr5_copy: ', arr5_copy)
# 二维数组索引
arr_2d = np.array([[1, 1, 1], [2, 2, 3], [3, 3, 3]])
print('arr_2d[1]: ', arr_2d[1, 2])
# 多维数组索引
arr_3d = np.arange(16).reshape(2, 2, 4)
print('arr_3d: ', arr_3d)
print('arr_3d[0,1,2]: ', arr_3d[0, 1, 2])
# 切片索引：只需要将数组中的每一行每一列都分别看作一个列表参照列表切片索引的方法，最终返回数组类型的数据
arr6 = np.arange(25).reshape(5, 5)
print('arr6: ', arr6)
print('arr6[1,2:4]: ', arr6[1, 2:4])
print('arr6[1:3,2:4]: ', arr6[1:3, 2:4])
print('arr6[:,2:]: ', arr6[:, 2:])  # 取出所有第三列之后的二维数组
print('arr6[::2,2:]: ', arr6[::2, 2:])  # 行方向隔行取数,列方向取第三列之后的数据

# 5 布尔类型   != 表示不等于，  ~ 表示对条件的否定  logical_not  用于设置反向条件 ；布尔运算符 可用于设置多个条件，多条件选择需要的数组
print('arr6: ', arr6)

# 6 数学与统计函数的调用
# 6.1 统计运算
print('arr6.sum():', arr6.sum())  # 对所有元素求和
print('arr6.mean():', arr6.mean())  # 对所有元素求平均值
print('arr6.max()', arr6.max())  # 对所有元素求最大值
print('arr6:min()', arr6.min())  # 对所有元素求最小值
print('arr6:std()', arr6.std())  # 对所有元素求标准差
print('arr6:var()', arr6.var())  # 对所有元素求方差
print('arr6:cumsum()', arr6.cumsum())  # 对所有元素求累计和  类似于迭代计算
print('arr6:cumprod()', arr6.cumprod())  # 对所有元素求累计积
print('arr6:argmin()', arr6.argmin())  # 求最小元素的索引
print('arr6:argmax()', arr6.argmax())  # 对最大元素的索引

# 6.2 矩阵运算
arr7 = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print('arr7: ', arr7)
print('arr7.T: ', arr7.T)   # 对矩阵进行转置
print('arr7的逆: ', np.linalg.inv(arr7))   # 对矩阵进行转置
arr8 = np.array([[4, 5, 6], [7, 8, 9], [1, 2, 3]])
print('arr7+arr8: ', arr7 + arr8)   # 矩阵的加法
print('arr7-arr8: ', arr7 - arr8)   # 矩阵的减法
# 备注：矩阵A和矩阵B相乘的条件是A的列数等于B的行数
print('矩阵arr7 点乘 arr8= ', arr7 * arr8)  # 矩阵的点乘
print('矩阵arr7 乘以 arr8的转置= ', arr7.dot(arr8.T))  # 矩阵的乘法arr8转置
print('矩阵arr7 乘以 arr8= ', arr7.dot(arr8))  # 矩阵的乘法
print('arr7的迹： ', np.trace(arr7))  # 矩阵的迹：主对角线上各个元素的总和
eigvalue, eigvector = np.linalg.eig(arr7)
print("arr7的特征值为：", eigvalue)
print("arr7的特征向量为：", eigvector)

# 6.3 数据处理  比如 排序sort和去重unique,默认从小到大(从左到右)
# 排序sort,当参数中的axis=0时，每一列上的元素按照行的方向排序；当参数中的axis=1时，每一行的元素按照列的方向排序
arr9 = np.array([[2, 4, 3], [5, 4, 2], [9, 0, 3]])
print('arr9：', arr9)
print('arr9.sort_axis=0:', np.sort(arr9, axis=0))
print('arr9.sort_axis=1:', np.sort(arr9, axis=1))
arr11 = np.array([3, 4, 5, 1, 2, 7, 88, 4])
print('arr11去重：', np.unique(arr11))

# 6.4 文件写入(savetxt)和读取(loadtxt)
arr12 = np.arange(9).reshape(3, 3)
np.savetxt('E:\\pycharm_repo\\datas\\numpy_arr12.txt', arr12, fmt='%d')
np.savetxt('E:\\pycharm_repo\\datas\\numpy_arr12.csv', arr12, delimiter=',', fmt='%d')

a = np.loadtxt('E:\\pycharm_repo\\datas\\numpy_arr12.txt')
print('文件内容：', a.astype(np.int32))




