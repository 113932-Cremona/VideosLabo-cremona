INSERT INTO players (id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES (100000, 'APP', null, null, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),(1,'jaja','Pass#123','jaja@outlook.com',null,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO players (id, user_name, password, email, avatar, last_login, created_at, updated_at)
values (100,'juanupla', 'Password03#','juanupla@email.com',null,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO games (id,code,name,description,rules)
VALUES (100000,'RPS','Rock paper scissors', 'descripcionejhgujf','reglas');

--insert into matches(id,game_id,player_id,created_at,updated_at,status)
--values (100000,100000,100,current_timestamp,current_timestamp,'STARTED');
--
--insert into matches(id,game_id,player_id,created_at,updated_at,status)
--values (100001,100000,100,current_timestamp,current_timestamp,'FINISHED');
--
--insert into matches(id,game_id,player_id,created_at,updated_at,status)
--values (100002,100000,100,current_timestamp,current_timestamp,'CANCELED');
--
--
--
--
--
--
--
--
--
--INSERT INTO matches_rps(id,number_of_plays,remainder_plays,player1Score,player2Score)
--VALUES (100000,10,5,3,2);
--INSERT INTO matches_rps(id,number_of_plays,remainder_plays,player1Score,player2Score,winner_id)
--VALUES (100001,10,0,6,4,100);
--INSERT INTO matches_rps(id,number_of_plays,remainder_plays,player1Score,player2Score)
--VALUES (100002,10,5,3,2);
--
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100000,100000,'ROCK','PAPER',100000);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100001,100000,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100002,100000,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100003,100000,'ROCK','SCISSORS', 100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100004,100000,'ROCK','PAPER',100000);
--
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100010,100001,'ROCK','PAPER',100000);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100011,100001,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100012,100001,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100013,100001,'ROCK','SCISSORS',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100015,100001,'ROCK','PAPER',100000);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100016,100001,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100017,100001,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100018,100001,'ROCK','SCISSORS',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100019,100001,'ROCK','PAPER',100000);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100014,100001,'ROCK','PAPER',100000);
--
--
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100005,100002,'ROCK','PAPER',100000);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100006,100002,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100007,100002,'PAPER','ROCK',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100008,100002,'ROCK','SCISSORS',100);
--INSERT INTO plays_rps(id,match_rps_id,shape_hand_player1,shape_hand_player2,winner_id)
--VALUES (100009,100002,'ROCK','PAPER',100000);
