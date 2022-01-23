
def list1():
    lista = ["lisa", "women", "23"]
    for i in range(0, len(lista)):
        print(lista[i])
    print("------------------------")
    for j in lista:
        print(j, end=" ")
        print("")
    for i in range(0, len(lista)):
        if i < len(lista) - 1:
            print(lista[i] + ",", end="")
        else:
            print(lista[i], end="")
    print()
    print(",".join(lista))
def list2():
    lista1 = [1, 2]
    lista2 = [3, 4]
    lista3 = [5, 6]
    lista2[1] = 'a'
    print(lista2 + lista3)
    lista1.append(lista2)
    print(lista1)
    lista4 = [5, 6, 7, 8]
    del lista4[1]
    lista4.remove(5)
    lista4.pop()
    print(lista4)
    lista5 = ['a', 'b', 'c', 'd', 'e', 'f']
    lista6 = ['a', 'b', 'c', 'd', 'f', 'e']
    print(lista5[:3])  # 前3位
    print(lista5[:4])  # 最后两位位
    print(lista5[0::2])  # 第1，3，5位
    print(lista5[0]+lista5[5])  # 第1位和最后一位
    lista6.sort(reverse=True)
    print(lista6)
def tuple1():
    tuplea1 = (1, 4)
    a = tuplea1[0]
    b = tuplea1[1]
    print("a:{},b:{}".format(str(a), str(b)))
def dic1():
    dica1 = {"name": "lisa", "age": "13", "sex": "men"}
    print(dica1["name"])
    print(dica1.get("name"))
    print("---------")
    for key in dica1.keys():
        print("{}:{}".format(key, dica1[key]), end=",")
    print("\n-----------------")
    print("-".join(str(value) for value in dica1.values()))
    print("----------------")
    dica2 = {"name": "lisa", "age": "13", "sex": "men"}
    for item in dica2.items():
        print(item[0])   # 打印所有的key
        print(item[1])   # 打印所有的value
    print("------------------")
    for key, value in dica2.items():
        print("key:{}, value:{}".format(key, value))
def seta():
    set1 = {1, 2, 2, 3, 4}
    print(set1)
    list1 = [1, 2, 2, 3, 4]
    print(set(list1))
    set2 = set("hello")
    set2.add("f")  # 向集合中添加元素
    set2.discard("a")
    set2.pop()
    print(set2)
    set3 = {1, 2, 3, 4}
    set4 = {5, 6, 3, 4}
    print(set3 & set4)   # 两个集合的交集
    print(set3.intersection(set4))  # 两个集合的交集
    print(set3.union(set4))   # 两个集合的并集
    print(set3 | set4)  # 两个集合的并集
    print(set3 - set4)    # 两个集合的差集
    print(set4.difference(set3))  # 两个集合的差集
if __name__ == '__main__':
#   list1()
#   list2()
#   tuple1()
#   dic1()i
    seta()
