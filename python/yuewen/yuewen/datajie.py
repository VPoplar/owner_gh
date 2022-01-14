# -*- coding:utf-8 -*-

import time
import hashlib
import requests
import datetime
import random


def signature_gen(token, timestamp, nonce): #所有参数应该转化为string
    keys = [token, timestamp, nonce]
    keys.sort()
    keyStr = ''.join(keys)
    signatub = hashlib.sha1(keyStr.encode("utf-8"))
    signature = signatub.hexdigest()
    return signature

def getdata():
    token = 'ec6fd29661d90072cc653dfd884d6846'
    t = time.time()  # 浮点时间
    timestamp = int(t)  # 10位时间戳
    account_id  = 1016   # 公司id
    random = lambda: int(round(time.time() * 1000 * 10000000))
    nonce = random()  # 20位随机数
    sign = signature_gen(token, str(timestamp), str(nonce))
    curr_time = datetime.datetime.now()
    end_date = datetime.datetime.strftime(curr_time, '%Y-%m-%d')
    delta = datetime.timedelta(days = 3)
    middate = curr_time - delta
    start_date = datetime.datetime.strftime(middate, '%Y-%m-%d')
    url = "https://api.yky.qq.com/api/v1/datareport/position"
    # 拼接url
    real_url = url + "?account_id=1016&sign=" + sign + "&nonce=" + str(nonce) + "&timestamp=" + str(timestamp) + "&start_date=" + \
               start_date + "&end_date=" + end_date
    # print(real_url)
    #发送get请求
    r = requests.get(real_url)
    print(r.json())


if __name__ == '__main__':

   getdata()