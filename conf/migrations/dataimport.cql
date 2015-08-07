use system;

DROP KEYSPACE gee;

CREATE KEYSPACE gee WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

use gee;

CREATE TABLE users (id uuid,
                    collection_id uuid,
                    firstname text,
                    lastname text,
                    login text,
                    email text,
                    email_confirmed text,
                    dateOfBirth text,
                    gender text,
                    mobilePhone text,
                    createdAt text,
                    password text,
                    picUrl text,
                    tacConfirmed text,
                    device_id uuid,
                    client_id uuid,
                    loggedIn text,
                    updated_at text,
                    PRIMARY KEY (id, email, password)
                    );

INSERT INTO users (id, collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password, picUrl,
                    tacConfirmed, device_id, client_id, loggedIn, updated_at)    VALUES
                  (756716f7-2e54-4715-9f00-91dcbea6cf50,
                   756716f7-2e54-4715-9f00-91dcbea6cf52,
                   'Houran',
                   'Ketabdar',
                   'hour',
                   'Houran.Ketabdar',
                   'Houran.Ketabdar',
                   '08-09-1987',
                   'female',
                   '01729260732',
                   '06-08-2015',
                   '1234',
                   'http://...',
                   'true',
                   756716f7-2e54-4715-9f00-91dcbea6cf58,
                   756716f7-2e54-4715-9f00-91dcbea6cf54,
                   'true',
                   '09-08-2015');

INSERT INTO users (id, collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password, picUrl,
                    tacConfirmed, device_id, client_id, loggedIn, updated_at)    VALUES
                  (756716f7-2e54-4715-9f00-91dcbea6cf60,
                   756716f7-2e54-4715-9f00-91dcbea6cf61,
                   'rand',
                   'random',
                   'hour1234',
                   'Houran.Ketabdarbb@gmail.com',
                   'Houran.Ketabdarbb@gmail.com',
                   '08-09-1987',
                   'female',
                   '01729260732',
                   '06-08-2015',
                   '123456',
                   'http://...',
                   'true',
                   756716f7-2e54-4715-9f00-91dcbea6cf62,
                   756716f7-2e54-4715-9f00-91dcbea6cf63,
                   'true',
                   '09-08-2015');

INSERT INTO users (id, collection_id, firstname, lastname, login, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password, picUrl,
                    tacConfirmed, device_id, client_id, loggedIn, updated_at)    VALUES
                  (756716f7-2e54-4715-9f00-91dcbea6cf64,
                   756716f7-2e54-4715-9f00-91dcbea6cf65,
                   'test',
                   'test123',
                   'hour1234test',
                   'Houran.Ketabdaraa@gmail.com',
                   'Houran.Ketabdaraa@gmail.com',
                   '08-09-1987',
                   'female',
                   '01729260732',
                   '06-08-2015',
                   '123478',
                   'http://...',
                   'true',
                   756716f7-2e54-4715-9f00-91dcbea6cf66,
                   756716f7-2e54-4715-9f00-91dcbea6cf67,
                   'true',
                   '09-08-2015');


CREATE TABLE userPrefs (
           id uuid,
           user_id uuid,
           pref text,
           tag text,
           PRIMARY KEY (id)
           );

INSERT INTO userPrefs (id, user_id, pref, tag)
         VALUES (
            2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,
            756716f7-2e54-4715-9f00-91dcbea6cf50,
            'aaaa',
            'bbbb'
            );

CREATE TABLE collections (
           id uuid,
           item_id uuid,
           type text,
           title text,
           PRIMARY KEY (id)
           );

INSERT INTO collections (id, item_id, type, title)
         VALUES (
            2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,
            756716f7-2e54-4715-9f00-91dcbea6cf50,
            'aaaa',
            'bbbb'
            );

CREATE TABLE items (
           itemId uuid,
           itemTitle text
           );

INSERT INTO items (itemId, itemTitle)
         VALUES (
            2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,
            'bbbb'
            );

CREATE TABLE devices (
           deviceId uuid,
           device text
           );

INSERT INTO devices (deviceId, device)
         VALUES (
            2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,
            'bbbb'
            );

CREATE TABLE clients (
           clientId uuid,
           client text
           );

INSERT INTO clients (clientId, client)
         VALUES (
            2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,
            'bbbb'
            );