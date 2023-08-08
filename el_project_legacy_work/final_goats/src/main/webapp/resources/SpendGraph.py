import cx_Oracle
import os

# 한글 지원
os.putenv('NLS_LANG', '.UTF8')

# 연결에 필요한 정보(유저, 비밀번호, 데이터베이스주소)
dsn = cx_Oracle.makedsn('192.168.0.35', 1521, 'orclLSB00')
conn = cx_Oracle.connect('goats', 'goats00')

curser = conn.cursor()
curser.execute( """ select * from GOAT_EMPLOYEE """)

row = curser.fetchall()
colname = curser.description
col = []

for i in row:
     print(i)

print('###############################')

for i in colname:
     print(i)


