# -*- coding: UTF-8 -*-

"""
1、读取指定目录下的所有文件
2、读取指定文件，输出文件内容
"""
import os

dirs = "F:\\阅文\\需求\\需求1-华语言情活动用户粉丝数\\2020前四季的入围的书籍的用户排序带分值"
files = os.listdir(dirs)

for fileName in files:
    filePath = os.path.join(dirs, fileName)
    # -*- coding: utf=8 -*-
    # 需求：读取文本文件并把偶数行数字按照逗号拼接，并且把书籍信息也拼接到一起
    out_path = "F:\\阅文\\需求\\需求1-华语言情活动用户粉丝数\\output\\华语言情大赛guid带分值数据1"
    # 1根据文件名筛选出赛季名和书籍名称
    seasons = filePath.split("\\")[-1].split("_")[0]
    season_name = ""
    books = filePath.split("\\")[-1].split("_")[1].split(".")[0]
    book_name = ""
    # 对赛季名进行判断
    if seasons == "855886287":
        season_name = "第一赛季"
    elif seasons == "857058295":
        season_name = "第二赛季"
    elif seasons == "858239769":
        season_name = "第三赛季"
    elif seasons == "859797991":
        season_name = "第四赛季"
    else:
        season_name = "未知"
    # 对书籍名进行判断
    if books == "13899265303683904":
        book_name = "《暖婚甜入骨》"
    elif books == "12998186103746803":
        book_name = "《娱乐圈bug》"
    elif books == "12377326404583803":
        book_name = "《总统宠妻太高调》"
    elif books == "14026253005575904":
        book_name = "《今天娶到云小姐了吗》"
    elif books == "14891494305031604":
        book_name = "《快穿之谁还不是个妖精了》"
    elif books == "14433859204078004":
        book_name = "《摄政王的小闲妻》"
    elif books == "14009336103004604":
        book_name = "《男神投喂指南》"
    elif books == "14460695405261204":
        book_name = "《快穿之男主上位计划》"
    elif books == "13925608405513904":
        book_name = "《锦娇》"
    elif books == "13587870903455604":
        book_name = "《我家夫君惹不起》"
    elif books == "13849059803811204":
        book_name = "《王爷，王妃又去打劫啦》"
    elif books == "14192888703148404":
        book_name = "《电竞大佬的佛系追妻路》"
    elif books == "14615427305384304":
        book_name = "《或许只有你懂得我》"
    elif books == "13992296405132004":
        book_name = "《笛上春行录》"
    elif books == "14001230105665804":
        book_name = "《衔枚忘春归》"
    elif books == "14496119904552404":
        book_name = "《影帝每天都在撒糖》"
    elif books == "15681022404496404":
        book_name = "《这个二世祖归我了》"
    elif books == "14501616305679204":
        book_name = "《我家醋神被惯坏了》"
    elif books == "15076818104231804":
        book_name = "《你是蜂蜜口味的》"
    elif books == "14280927405539904":
        book_name = "《影帝老公他喜当爹》"
    elif books == "15073263904604404":
        book_name = "《求沈医生假扮男友的日子》"
    elif books == "14450034905560004":
        book_name = "《跟大佬恋爱你怂了吗》"
    elif books == "14695842205593904":
        book_name = "《天宫红颜传》"
    elif books == "15359668804009804":
        book_name = "《重生之皇上你被休了》"
    elif books == "15414277905202304":
        book_name = "《糟了是心肌梗塞的感觉》"
    elif books == "15300107605621604":
        book_name = "《初恋是颗夹心糖》"
    elif books == "15462345905036104":
        book_name = "《恃婚而骄》"
    elif books == "14368226904230604":
        book_name = "《隔壁大佬又帅又苏》"
    elif books == "15267048304869504":
        book_name = "《染唇》"
    elif books == "15731533704053704":
        book_name = "《惟愿余生不相逢》"
    elif books == "16129361004247204":
        book_name = "《我有五个大佬爸爸》"
    elif books == "16424641704976204":
        book_name = "《他太太才是真大佬》"
    elif books == "16304108905962604":
        book_name = "《满级大佬在女尊》"
    elif books == "13641088905154304 ":
        book_name = "《女配表示很无辜》"
    elif books == "15303408704764304":
        book_name = "《墨染相思江南远》"
    elif books == "15508766905199604":
        book_name = "《穿书之我在豪门当咸鱼》"
    elif books == "15047320705759804":
        book_name = "《我的马甲按不住了》"
    elif books == "15664481904509904":
        book_name = "《学神又忘记写名字了》"
    elif books == "16188070904133904":
        book_name = "《我把神君当灵兽》"
    elif books == "15133952304655604":
        book_name = "《王妃是个交换生》"
    elif books == "15615963605534504":
        book_name = "《成亲后王爷暴富了》"
    elif books == "15615802705488204":
        book_name = "《他以时间为名》"
    elif books == "16385051004001704":
        book_name = "《听说大神喜欢我》"
    elif books == "15756095104883004":
        book_name = "《甜甜恋爱轮到我》"
    elif books == "16203590704781504":
        book_name = "《他的春风和煦》"
    elif books == "16803381505903504":
        book_name = "《穿书后每天都在被迫撒娇》"
    elif books == "16912769405036504":
        book_name = "《太子爷的鬼迷心窍》"
    elif books == "16939644904579404":
        book_name = "《在偏执云爷怀里撒个娇》"
    elif books == "16440072105352904":
        book_name = "《我的世界圈你入怀》"
    elif books == "16471477904911304":
        book_name = "《傅医生是醋缸》"
    elif books == "16750964504955204":
        book_name = "《丧系大佬他背着我长歪了》"
    elif books == "16335268905813304":
        book_name = "《同桌她又A又飒》"
    elif books == "16559720904944404":
        book_name = "《霍小姐是个蜜罐子精》"
    elif books == "15611160504331204":
        book_name = "《两位大佬别冲动》"
    elif books == "17115073904331904":
        book_name = "《原来学神暗恋我》"
    elif books == "16403940604080904":
        book_name = "《所以追到了娱乐圈顶流》"
    elif books == "17155104204051104":
        book_name = "《夜寒深深醉思量》"
    elif books == "17328216204637404":
        book_name = "《一吻情注定》"
    elif books == "16640733904639504":
        book_name = "《她甜不可攀》"
    elif books == "17037639705370004":
        book_name = "《团宠反派被病娇缠上了》"
    else:
        book_name = "未知"

    with open(filePath, "r") as f:
        lines = f.readlines()
        with open(out_path, "a", encoding="utf-8") as w:
            for i in range(0, len(lines), 2):
                line = season_name + "," + books + "," + lines[i][:-1] + "," + book_name + "," + lines[
                    i + 1]  # print(lines[i].strip()+","+lines[i+1])  # strip() 表示去掉换行
                w.write(line)
                print(line)

    # 拼接if else 的语句 可忽略
    union = ""
    result = ""
    with open("F:\\python\\input\\书籍信息.txt", "r", encoding="utf-8") as t:
        lines1 = t.readlines()
        with open("F:\\python\\output\\333.txt", "w", encoding="utf-8") as v:
            for line1 in lines1:
                union = line1.strip().split("\t")
                result = 'elif books == "' + union[0] + '":\n' + '    book_name = "' + union[1] + '"\n'
                v.write(result)







