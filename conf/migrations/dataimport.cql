use system;

DROP KEYSPACE gee;

CREATE KEYSPACE gee WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

use gee;

CREATE TABLE users (id uuid PRIMARY KEY,
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
                    tacConfirmed true,
                    device_id uuid,
                    client_id uuid,
                    loggedIn true,
                    updated_at text,
                    PRIMARY KEY (id)
                    );

INSERT INTO users (id, firstname, lastname, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password)    VALUES
                  (756716f7-2e54-4715-9f00-91dcbea6cf50,
                   'Houran',
                   'Ketabdar',
                   'Houran.Ketabdar@gmail.com',
                   'Houran.Ketabdar@gmail.com',
                   '08-09-1987',
                   'female',
                   '01729260732',
                   '06-08-2015',
                   '1234');

INSERT INTO users (id, firstname, lastname, email, email_confirmed, dateOfBirth, gender, mobilePhone, createdAt, password)    VALUES
                  (756716f7-2e54-4715-9f00-91dcbea6cf51,
                   'rand',
                   'random',
                   'Houran.Ketabdar@gmail.com',
                   'Houran.Ketabdar@gmail.com',
                   '08-09-1987',
                   'male',
                   '01729260732',
                   '06-08-2015',
                   '1234');

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