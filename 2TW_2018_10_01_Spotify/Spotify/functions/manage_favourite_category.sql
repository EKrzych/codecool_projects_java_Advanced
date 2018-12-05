CREATE VIEW favourite_category AS
SELECT id_listener, id_category, count(id_category) as count FROM songs
  INNER JOIN playlists_songs ps on songs.id_song = ps.id_song
  INNER JOIN playlists_listeners ON ps.id_playlist = playlists_listeners.id_playlist
  GROUP BY id_listener, id_category;

DROP VIEW favourite_category;
DROP FUNCTION find_favourite_category;
CREATE OR REPLACE FUNCTION find_favourite_category(user_id INT)
RETURNS TABLE (
  number INT)
AS
  $$
BEGIN
RETURN QUERY SELECT id_category FROM favourite_category WHERE count = (SELECT max(count) FROM favourite_category WHERE id_listener = user_id)  AND id_listener = user_id ORDER BY RANDOM() LIMIT 1;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION list_songs_from_favourite_category(favourite_category_id INT)
  RETURNS TABLE (
    id INT,
    song_name VARCHAR(255),
    album_name VARCHAR(255),
    artist_name VARCHAR(255)) AS
  $$
  BEGIN
    RETURN QUERY SELECT songs.id_category, songs.name, albums.name, artists.name FROM songs
    INNER JOIN albums_songs on songs.id_song = albums_songs.id_song
    INNER JOIN songs_artists ON songs.id_song = songs_artists.id_song
    INNER JOIN albums on albums_songs.id_album = albums.id_album
    INNER JOIN artists on songs_artists.id_artist = artists.id_artist
    WHERE songs.id_category = favourite_category_id ORDER BY RANDOM() LIMIT 10;
  END;
  $$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION list_songs_from_categories()
  RETURNS TABLE (
    id INT,
    song_name VARCHAR(255),
    album_name VARCHAR(255),
    artist_name VARCHAR(255)) AS
  $$
  BEGIN
    RETURN QUERY SELECT songs.id_category, songs.name, albums.name, artists.name FROM songs
    INNER JOIN albums_songs on songs.id_song = albums_songs.id_song
    INNER JOIN songs_artists ON songs.id_song = songs_artists.id_song
    INNER JOIN albums on albums_songs.id_album = albums.id_album
    INNER JOIN artists on songs_artists.id_artist = artists.id_artist
    ORDER BY RANDOM() LIMIT 10;
  END;
  $$
  LANGUAGE plpgsql;


SELECT * FROM find_favourite_category(610);

SELECT list_songs_from_favourite_category(2);

SELECT list_songs_from_categories();