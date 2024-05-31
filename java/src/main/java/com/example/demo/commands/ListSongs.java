package com.example.demo.commands;

import java.util.LinkedList;
import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class ListSongs  implements ICommand {

    private SongService songService;
    
    public ListSongs(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> tokens) {
        
        List<Song> songs =songService.list_songs();
        List<String>printSongs = new LinkedList<>();
        if(!songs.isEmpty()) {
            for(Song song:songs) {
                String temp = String.format("Song [id=%d]",song.getId());
                printSongs.add(temp);
            }
        }
        System.out.println(printSongs);
    }
}
