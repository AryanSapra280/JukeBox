package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class StopSong  implements ICommand {

    private PlaylistService playlistService;
    public StopSong(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        playlistService.stop_song();
    }
}
