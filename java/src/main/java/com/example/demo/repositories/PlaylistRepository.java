package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;

public class PlaylistRepository {
    private static Integer id = 0;
    private Map<String,Playlist>playlistDb;

    public PlaylistRepository() {
        playlistDb = new HashMap<>();
    }

    public Playlist save(String playlistName,List<Integer>songIds) {
        
        Playlist newPlaylist = new Playlist(++id, playlistName,songIds);
        
        playlistDb.put(playlistName, newPlaylist);
        return newPlaylist;
    }

    public Optional<Playlist> findByPlaylistName(String playlistName) {
        return Optional.ofNullable(playlistDb.get(playlistName));
    }
    public List<Playlist> findAll() {
        List<Playlist> listOfPlaylists = new ArrayList<Playlist>();
        playlistDb.entrySet().stream().forEach((mp)->{
            listOfPlaylists.add(mp.getValue());
        });
        return listOfPlaylists;
    }
    public boolean delete(String playlistName) {
        if(!playlistDb.containsKey(playlistName)) {
            return false;
        }       
        playlistDb.remove(playlistName);
        return true;
    }
    public List<Integer> deleteSongFromPlaylist(String playlistName,Integer id) {
        if(!playlistDb.containsKey(playlistName)) {
            System.out.println("Playlist not found");
        }
        playlistDb.get(playlistName).getAllSongsid().remove(id);
        return playlistDb.get(playlistName).getAllSongsid();
    }
}
