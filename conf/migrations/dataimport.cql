use system;

DROP KEYSPACE gee;

CREATE KEYSPACE gee WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

use gee;

CREATE TABLE songs (id uuid PRIMARY KEY,
                    firstname text,
                    lastname text,
                    email text,
                    tags set<text>,
                    data blob ) ;

INSERT INTO songs (id, firstname, lastname, email, tags)    VALUES
                  (756716f7-2e54-4715-9f00-91dcbea6cf50,
                   'Houran',
                   'Ketabdar',
                   'Houran.Ketabdar@gmail.com',
                   {'jazz', '2013'}   );

CREATE TABLE playlists (
           id uuid,
           firstname text,
           lastname text,
           artist text,
           song_id uuid,
           PRIMARY KEY (id, firstname, lastname, artist)
        );

INSERT INTO playlists (id, song_id, firstname, lastname, artist)
         VALUES (
            2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,
            756716f7-2e54-4715-9f00-91dcbea6cf50,
            'Houran',
            'Ketabdar',
            'Josphine Baker'
          )
       ;
