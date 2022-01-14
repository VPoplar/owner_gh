import hashlib
# 生成MD5对象 并加盐
md5 = hashlib.md5(b'20211011')
# 要加密的密码
password = '20211011'
# 对数据加密
md5.update(password.encode('utf-8'))
# 获取密文
pwd = md5.hexdigest()

print(pwd)