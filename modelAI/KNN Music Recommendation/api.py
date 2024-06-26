import requests
import access_Database as acsdb
from flask import Flask
from flask_restful import Resource, Api
from knn_recommender import Recommender

app = Flask(__name__)
api = Api(app)

#xu li du lieu
class Process(Resource):
    def get(self, music_id):
        model = Recommender(metric='cosine', algorithm='brute', data=acsdb.viewcnt_data, table=acsdb.viewcnt_table)
        recommend_list = model.make_recommendation(song_id = music_id, n_recommendations=5)
        return recommend_list

api.add_resource(Process, '/recommend/<int:music_id>')

if __name__ == '__main__':
    app.run(debug = True, host = '0.0.0.0', port = 8000)


