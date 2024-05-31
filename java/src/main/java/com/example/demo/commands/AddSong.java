package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.SongService;

public class AddSong implements ICommand {

    private final SongService songService;
    public AddSong(SongService songService) {
        this.songService = songService;
    }
    @Override
    public void invoke(List<String> tokens) {
        String songName = tokens.get(1);
        String artistName = tokens.get(2);
        String albumName = tokens.get(3);
        String genre = tokens.get(4);
        
        songService.add_song(songName, artistName, albumName, genre);
        
    }
    
}
