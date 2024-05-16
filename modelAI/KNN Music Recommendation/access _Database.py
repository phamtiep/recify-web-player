import mysql.connector
import pandas as pd

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="root",
  database="mydb"
)

mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM view_manager")

myresult = mycursor.fetchall()

viewcnt_df = pd.DataFrame(myresult, columns=['view_count', 'music_id', 'user_id'])