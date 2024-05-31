package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class NextSong  implements ICommand {
    private PlaylistService playlistService;
    public NextSong(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @Override
    public void invoke(List<String> tokens) {
        
        playlistService.next_song();
    }
}
