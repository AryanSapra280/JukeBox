package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class AddSongToPlaylist  implements ICommand {

    private PlaylistService playlistService;
    public AddSongToPlaylist(PlaylistService playlistService) {
        this.playlistService = playlistService; 
    }
    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Integer songId = Integer.parseInt(tokens.get(2));

        playlistService.add_song_to_playlist(playlistName, songId);
        
    }

}
