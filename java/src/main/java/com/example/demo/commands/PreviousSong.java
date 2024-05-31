package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class PreviousSong  implements ICommand {

    private PlaylistService playlistService;
    public PreviousSong(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    
    @Override
    public void invoke(List<String> tokens) {
        playlistService.previous_song();
    }
}
