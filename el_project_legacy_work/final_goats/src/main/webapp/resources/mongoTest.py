# -*- coding: utf-8 -*-
from pymongo import MongoClient
from datetime import date
import matplotlib.pyplot as plt
import pandas as pd

plt.rcParams['font.family'] = 'Malgun Gothic'

client = MongoClient("192.168.0.59", 27017)
db = client['goats']
col = db["spend"]

today = date.today()
date_ = today.strftime("%Y-%m-%d")
print(type(date_))
res = col.find()
print(res)
sum_ = 0
for idx in res:
    print(idx)
    if date_ in idx:
        so = idx[date_][0]["소모품"]
        bok = idx[date_][1]["복리후생"]
        gyo = idx[date_][2]["교통비"]
        un = idx[date_][3]["운반비"]
        bo = idx[date_][4]["보험료"]
        joep = idx[date_][5]["접대비"]
        do = idx[date_][6]["도서비"]
        su = idx[date_][7]["수수료"]
        gyo_ = idx[date_][8]["교육훈련비"]
        ki = idx[date_][9]["기타"]
        sik = idx[date_][10]["식비"]
        suk = idx[date_][11]["숙박비"]
        je = idx[date_][12]["제경비"]
        sum_ = int(so)+int(bok)+int(gyo)+int(un)+int(bo)+int(bok)+int(joep)+int(do)+int(su)
        +int(gyo_)+int(ki)+int(sik)+int(suk)+int(je)
        print(sum_/10000)
    else:
        print("오늘 날짜데이터가 없다.")


df = pd.read_csv("C:/Users/kosmo/Desktop/Legacy/el_project_legacy_work/final_goats/src/main/webapp/resources/csvData/data.csv", index_col=False)

new_data = {'Date': [date_],
            'data': [sum_/10000]}
new_df = pd.DataFrame(new_data)
df = pd.concat([df, new_df], ignore_index=True)

# CSV 파일로 저장
df.to_csv('csvData/data.csv', index=False)

filepath = "C:/Users/kosmo/Desktop/Legacy/el_project_legacy_work/final_goats/src/main/webapp/resources/csvData/data.csv"

df = pd.read_csv(filepath, index_col=False)
print(df)
dates = df['Date']
datas = df['data']

plt.plot(dates, datas)

plt.title("금액 변동 그래프")
plt.xlabel("날짜")
plt.ylabel("금액(만원)")

def on_mouse_move(event):
    if event.xdata is not None and event.ydata is not None:
        plt.gca().format_coord = lambda x, y: f'{x:.2f}, {y:.2f}'

# 마우스 이벤트 핸들러 등록
plt.gcf().canvas.mpl_connect('motion_notify_event', on_mouse_move)
savepath = "C:/Users/kosmo/Desktop/Legacy/el_project_legacy_work/final_goats/src/main/webapp/resources/Spendgraph/"+date_
plt.xticks(rotation=45)
plt.tight_layout()
plt.savefig(savepath, dpi=400)
print(savepath+"에 저장 되었습니다.")