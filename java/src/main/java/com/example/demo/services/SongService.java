package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

public class SongService {
    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song add_song(String songName, String artistName, String albumName, String genre) {
        Song song = songRepository.save(songName,artistName,albumName,genre);
        if(song == null) {
            return null;
        }
        System.out.println(String.format("Song [id=%d]",song.getId()));
        return song;
    }

    public List<Song> list_songs() {
        return songRepository.findAll();
    }
}
