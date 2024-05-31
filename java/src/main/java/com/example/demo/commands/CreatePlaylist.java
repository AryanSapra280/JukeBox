package com.example.demo.commands;

import java.util.LinkedList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class CreatePlaylist implements ICommand {

    private PlaylistService playlistService;

    public CreatePlaylist(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    
    @Override
    public void invoke(List<String> tokens) {
        
        String playlistName = tokens.get(1);
        
        List<Integer>ids = new LinkedList<>();
        for(int i=2;i<tokens.size();i++) {
            ids.add(Integer.parseInt(tokens.get(i)));
        }
        
        playlistService.create_playlist(playlistName, ids);
    }    
}
