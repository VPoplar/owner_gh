import pymysql


def conn_mysql():
    # 1 连接数据库
    db = pymysql.connect(host='localhost', port=3306, user='root', password='0000000')
    # 2 使用cursor方法创建一个游标对象
    cur = db.cursor()
    # 3 使用execute方法执行sql查询
    sql = 'select * from test.useTest limit 1'
    cur.execute(sql)
    # 4 fetachall是获取所有的数据，fetachone是获取单条数据
    # result = cur.fetchall()
    result1 = cur.fetchone()
    print(result1)
    # for i in result:
    #    print(i)
    db.close()


if __name__ == '__main__':
    conn_mysql()

