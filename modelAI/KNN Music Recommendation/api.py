import requests
import access_Database as acsdb
from flask import Flask
from flask_restful import Resource, Api
from knn_recommender import Recommender

app = Flask(__name__)
api = Api(app)

#xu li du lieu
#return recommend_list la mot list int
class Process(Resource):
    def get(self, music_id):
        model = Recommender(metric='cosine', algorithm='brute', data=acsdb.viewcnt_data, table=acsdb.viewcnt_table)
        recommend_list = model.make_recommendation(song_id = music_id, n_recommendations=10)
        return recommend_list

#nhan id bai nhac dang nghe
api.add_resource(Process, '/recommend/<int:music_id>')

if __name__ == '__main__':
    app.run(debug = True)


