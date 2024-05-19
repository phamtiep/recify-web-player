INSERT INTO mydb.user (username, password, role)  values ('admin', 'admin', 'ADMIN');


INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('ChacAiDoSeVe-SonTungMTP-3597661.mp3', 274, '../MusicUpload/chill-music/ChacAiDoSeVe-SonTungMTP-3597661.mp3','chill');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('good-night-160166.mp3', 147, '../MusicUpload/chill-music/good-night-160166.mp3', 'chill');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('lofi-chill-medium-version-159456.mp3', 67, '../MusicUpload/chill-music/lofi-chill-medium-version-159456.mp3', 'chill');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('ethereal-vistas-191254.mp3', 241, '../MusicUpload/study-music/ethereal-vistas-191254.mp3', 'study');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('Komiku - Friends, 2018.mp33', 64, '../MusicUpload/study-music/Komiku - Friends, 2018.mp3', 'study');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('good-night-160166.mp3', 147, '../MusicUpload/chill-music/good-night-160166.mp3', 'chill');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('lofi-chill-medium-version-159456.mp3', 67, '../MusicUpload/chill-music/lofi-chill-medium-version-159456.mp3', 'chill');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('ethereal-vistas-191254.mp3', 241, '../MusicUpload/study-music/ethereal-vistas-191254.mp3', 'study');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('Komiku - Friends, 2018.mp33', 64, '../MusicUpload/study-music/Komiku - Friends, 2018.mp3', 'study');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('lofi-study-112191.mp3', 147, '../MusicUpload/study-music/lofi-study-112191.mp3', 'study');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('blues-rock-energetic-203364.mp3', 72, '../MusicUpload/workout-music/blues-rock-energetic-203364.mp3', 'workout');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('funny-punk-rock-203366.mp3', 70, '../MusicUpload/workout-music/funny-punk-rock-203366.mp3', 'workout');
INSERT INTO mydb.music (music_name, length_by_seconds, path_to_file, category) values ('sports-music-rock-opening-puncher-155346.mp3', 53, '../MusicUpload/workout-music/sports-music-rock-opening-puncher-155346.mp3', 'workout');





-- Insert data into user table

INSERT INTO mydb.user (username, password, role) VALUES ('user1', 'password1', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user2', 'password2', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user3', 'password3', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user4', 'password4', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user5', 'password5', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user6', 'password6', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user7', 'password7', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user8', 'password8', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user9', 'password9', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user10', 'password10', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user11', 'password11', 'USER');
INSERT INTO mydb.user (username, password, role) VALUES ('user12', 'password12', 'USER');


-- Insert data into playlist table
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (1, 'Playlist1');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (1, 'Playlist2');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (2, 'Playlist2');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (3, 'Playlist3');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (4, 'Playlist4');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (5, 'Playlist5');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (6, 'Playlist6');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (7, 'Playlist7');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (8, 'Playlist8');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (9, 'Playlist9');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (10, 'Playlist10');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (11, 'Playlist11');
INSERT INTO mydb.playlist (user_id, playlist_name) VALUES (12, 'Playlist12');

-- Insert data into playlist_has_music table
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (1, 1);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (1, 2);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (1, 3);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (2, 4);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (2, 5);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (2, 6);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (3, 7);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (3, 8);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (3, 9);

INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (5, 1);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (5, 4);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (5, 7);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (6, 2);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (6, 5);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (6, 8);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (7, 3);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (7, 6);

INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (8, 1);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (8, 5);

INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (9, 3);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (9, 7);

INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (10, 2);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (10, 6);

INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (11, 4);
INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (11, 8);

INSERT INTO mydb.playlist_has_music (playlist_id, music_id) VALUES (12, 1);


-- Insert data into view_manager table
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (10, 1, 1);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (20, 2, 2);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (30, 3, 3);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (40, 4, 4);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (50, 5, 5);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (60, 6, 6);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (70, 7, 7);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (80, 8, 8);
INSERT INTO mydb.view_manager (view_count, music_id, user_id) VALUES (90, 9, 9);




