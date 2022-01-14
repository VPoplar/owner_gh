#!/usr/bin/env python3.7
# -*- coding:utf-8 -*-
import json
import requests
import hashlib
import time
import random
import os
import sys


# reload(sys)
# sys.setdefaultencoding("UTF-8")

# 游可赢平台腾讯游戏收入信息

secure_key = 'ec6fd29661d90072cc653dfd884d6846'
start_date = sys.argv[1]
end_date = start_date
account_id = '1016'
userurl = 'https://api.yky.qq.com/api/v1/datareport/position'
data = start_date.replace('-', '')
file_name = 'E:\\33.txt'


# 获取数据
def get_data(sign, timestamp, nonce, end_date, start_date, account_id, realurl):
    headers = {'content-type': 'application/json'}
    url = realurl + '?account_id=' + account_id + '&sign=' + \
          sign + '&nonce=' + nonce + '&timestamp=' + timestamp + '&start_date=' + start_date + '&end_date=' + end_date  + '&page_size=500&page_num=1'
    print(url)
    res = requests.get(url, headers)
    user_data = json.loads(res.text)
    file_dir = os.path.dirname(file_name)
    if os.path.exists(file_name):
        os.remove(file_name)
    if not os.path.exists(file_dir):
        os.makedirs(file_dir)
    print("user_data" + str(user_data))
    if user_data.get('data') is not None:
        for line in user_data['data']:
            stat_datetime = str(line['stat_datetime'])
            account_id = str(line['account_id'])
            media_app_id = str(line['media_app_id'])
            media_app_name = str(line['media_app_name'])
            position_id = str(line['position_id'])
            position_name = str(line['position_name'])
            ad_type_name = str(line['ad_type_name'])
            platform = str(line['platform'])
            request_num = str(line['request_num'])
            response_num = str(line['response_num'])
            impression_num = str(line['impression_num'])
            click_num = str(line['click_num'])
            if line.get('cpm') is not None:  # 处理空值缺失
                cpm = str(line['cpm'])
            else:
                cpm = '0'
            if line.get('cpm') is not None:  # 处理空值缺失
                cost = str(line['cost'])
            else:
                cost = '0'
            mess = [stat_datetime, account_id, media_app_id, media_app_name, position_id, position_name, ad_type_name,
                    platform, request_num, response_num, impression_num, click_num, cpm, cost]
            print(mess)
            text = '|'.join(mess)
            with open(file_name, 'a+') as f:
                f.write(text + '\n')


def signature_gen(secure_key, timestamp, nonce):
    keys = [secure_key, timestamp, nonce]
    keys.sort()
    keyStr = ''.join(keys)
    signature = hashlib.sha1(keyStr.encode('utf8')).hexdigest()
    return signature


nonce = str(random.randint(1000000000, 9999999999))
# nonce = str(random.randint(10000000000000000000, 99999999999999999999))
timestamp = str(int(time.time()))
sign = signature_gen(secure_key, timestamp, nonce)
print(sign)
print(nonce)
print(timestamp)
print(end_date)
print(start_date)
print(account_id)
print(userurl)
get_data(sign, timestamp, nonce, end_date, start_date, account_id, userurl)