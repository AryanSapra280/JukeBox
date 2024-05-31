package com.example.demo.entities;

import java.util.List;

public class Playlist {
    private Integer id = 0;
    private String playlistName;
    private List<Integer>allSongsid;

    public Playlist() {}
    public Playlist(Integer id, String playlistName, List<Integer> allSongsid) {
        this.id = id;
        this.playlistName = playlistName;
        this.allSongsid = allSongsid;
    }
    public String getPlaylistName() {
        return playlistName;
    }
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
    public List<Integer> getAllSongsid() {
        return allSongsid;
    }
    public void setAllSongsid(List<Integer> allSongsid) {
        this.allSongsid = allSongsid;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
   
}
