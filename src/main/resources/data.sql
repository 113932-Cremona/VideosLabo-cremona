INSERT INTO players (id, user_name, password, email, avatar, last_login, created_at, updated_at)
VALUES (100000, 'APP', null, null, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),(1,'jaja','Pass#123','jaja@outlook.com',null,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO players (id, user_name, password, email, avatar, last_login, created_at, updated_at)
values (100,'juanupla', 'Password03#','juanupla@email.com',null,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

INSERT INTO games (id,code,name,description,rules)
VALUES (100000,'RPS','Rock paper scissors', 'descripcionejhgujf','reglas');

insert into matches(id,game_id,player_id,created_at,updated_at,status)
values (100000,100000,100,current_timestamp,current_timestamp,'STARTED');

insert into matches(id,game_id,player_id,created_at,updated_at,status)
values (100001,100000,100,current_timestamp,current_timestamp,'FINISHED');

insert into matches(id,game_id,player_id,created_at,updated_at,status)
values (100002,100000,100,current_timestamp,current_timestamp,'CANCELED');