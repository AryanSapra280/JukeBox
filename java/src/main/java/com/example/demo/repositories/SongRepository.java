package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entities.Song;

public class SongRepository {
    private static Integer id = 0;
    private Map<Integer,Song>songsDb;

    public SongRepository() {
        songsDb = new HashMap<>();
    }

    public Song save(String songName, String  artistName, String bandName, String genre) {

        Song newSong = new Song(++id,songName,artistName,bandName,genre);
        songsDb.put(id, newSong);
        return newSong;
    }

    public Optional<Song> findById(Integer id) {
        return Optional.ofNullable(songsDb.get(id));
    }
    public List<Song> findAll() {
        List<Song> listOfSongs = new ArrayList<Song>();
        songsDb.entrySet().stream().forEach((mp)->{
            listOfSongs.add(mp.getValue());
        });
        return listOfSongs;
    }
    public void delete(Integer id) {
        songsDb.remove(id);
    }
}
