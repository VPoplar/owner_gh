# -*- coding:utf-8 -*-
from datetime import date, timedelta

# 打印一个月的每一天
# 删除oracle表的分区 alter table t_md_qidian_hx_seo truncate partition p_20201220
# 给hive的range分区加分区  alter table t_md_qidian_member_exchange add partition p_20200220 values less than (20200221);

def add_range_partiton():
    CURRENTMONTH = "2020-03"
    traverseDay = date(int(CURRENTMONTH[0:4]), int(CURRENTMONTH[5:7]), 1)
    intMonth = int(CURRENTMONTH[5:7])
    while True:
        if intMonth == traverseDay.month:
           # print ('alter table t_md_qidian_hx_seo truncate partition p_'+traverseDay.strftime('%Y%m%d'))
           print('alter table t_rd_qqbook_bp_freebook add partition p_'+ traverseDay.strftime('%Y%m%d') +' values less than ('+(traverseDay+timedelta(days=1)).strftime('%Y%m%d')+')')
           traverseDay = traverseDay + timedelta(days=1)
        else:
           break

def add_list_partiton():
    CURRENTMONTH = "2020-07"
    traverseDay = date(int(CURRENTMONTH[0:4]), int(CURRENTMONTH[5:7]), 1)
    intMonth = int(CURRENTMONTH[5:7])
    while True:
        if intMonth == traverseDay.month:
           # print ('alter table t_md_qidian_hx_seo truncate partition p_'+traverseDay.strftime('%Y%m%d'))
           print('alter table t_md_qidian_author_avgbuy_work add partition p_'+ traverseDay.strftime('%Y%m%d') + ' values(' + traverseDay.strftime('%Y%m%d')+');')
           traverseDay = traverseDay + timedelta(days=1)
        else:
           break

def truncate_partiton():
    CURRENTMONTH = "2021-03"
    traverseDay = date(int(CURRENTMONTH[0:4]), int(CURRENTMONTH[5:7]), 1)
    intMonth = int(CURRENTMONTH[5:7])
    while True:
        if intMonth == traverseDay.month:
           print ('alter table t_md_qidian_author_work truncate partition (p_'+traverseDay.strftime('%Y%m%d')+');')
           traverseDay = traverseDay + timedelta(days=1)
        else:
           break

if __name__ == '__main__':


#   add_range_partiton()
    add_list_partiton()

#   truncate_partiton()