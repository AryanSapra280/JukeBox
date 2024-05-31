package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class LoadPlaylist  implements ICommand {

    private PlaylistService playlistService;
    public LoadPlaylist(PlaylistService playlistService){
        this.playlistService = playlistService;
    }
    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        playlistService.load_playlist(playlistName);
    }
}
