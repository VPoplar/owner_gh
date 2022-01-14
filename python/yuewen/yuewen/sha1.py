# -*- coding:UTF-8 -*-
import hashlib
import sys

# 小米数据对目录为日期的进行sha1加密
def sign(param, salt="65S16ZBHSTH5C2WTTGHTSR0BV9DY"):
    sign_args = []
    sign_args.append(param)
    if salt:
        sign_args.append(salt)
    joined = '&'.join(sign_args).encode('utf-8')
    return hashlib.sha1(joined).hexdigest()

if __name__ == '__main__':
    statis_day = None
    if len(sys.argv) >= 1:
        statis_day = sys.argv[1]
    else:
        exit("Check the params!")
    print(sign(statis_day))