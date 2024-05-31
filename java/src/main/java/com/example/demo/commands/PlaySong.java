package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class PlaySong  implements ICommand {
    private PlaylistService playlistService;
    public PlaySong(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.play_song();
    }
    
}
