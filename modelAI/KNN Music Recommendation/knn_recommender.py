from sklearn.neighbors import NearestNeighbors
import numpy as np

class Recommender:
    def __init__(self, metric, algorithm, data, table):
        self.metric = metric
        self.algorithm = algorithm
        self.data = data
        self.table = table
        self.model = self._recommender().fit(data)

    def _recommender(self):
        return NearestNeighbors(metric=self.metric, algorithm=self.algorithm)

    def make_recommendation(self, song_id, n_recommendations):
        recommend = []
        song_index = self.table.index.get_loc(song_id)
        distances, indices = self.model.kneighbors(self.table.iloc[song_index,:].values.reshape(1, -1), n_neighbors = n_recommendations + 1)
        for i in range(1, len(indices.flatten())):
            recommend.append(int(self.table.index[indices[0][i]]))
        print("... Done")
        return recommend
