package com.example.demo.entities;

public class Song {
    private Integer id;
    private String songName;
    private String artistName;
    private String bandName;
    private String genre;

    
    public Song() {}

    public Song(Integer id,String songName, String artistName, String bandName,String genre) {
        this.id = id;
        this.songName = songName;
        this.artistName = artistName;
        this.bandName = bandName;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    public String getBandName() {
        return bandName;
    }
    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
