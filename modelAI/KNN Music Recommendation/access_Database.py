import mysql.connector
import pandas as pd
from scipy.sparse import csr_matrix

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

viewcnt_table = viewcnt_df.pivot(index='music_id', columns='user_id', values='view_count').fillna(0)

viewcnt_data = csr_matrix(viewcnt_table.values)
