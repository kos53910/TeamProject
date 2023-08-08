import matplotlib as plt
import pandas as pd


df = pd.read_csv("csvData/data.csv", index_col=False)
"""print(df)
dates = df['Date']
datas = df['data']

plt.plot(dates, datas)

plt.title("날짜별 금액 변동 그래프")
plt.xlabel("날짜")
plt.ylabel("금액")

plt.xticks(rotation=45)
plt.tight_layout()
plt.show"""