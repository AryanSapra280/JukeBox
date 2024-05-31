package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class DeleteSongFromPlaylist  implements ICommand {

    private PlaylistService playlistService;
    public DeleteSongFromPlaylist(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    
    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Integer id = Integer.parseInt(tokens.get(2));
        playlistService.delete_song_from_playlist(playlistName, id);
        
    }
}
