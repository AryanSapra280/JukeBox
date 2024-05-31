package com.example.demo.services;

import java.lang.StackWalker.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import com.example.demo.Configuration;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;

public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private Playlist playlistRunning;
    private static int runningSong = 0;
    private static Boolean paused = false;
    public PlaylistService(PlaylistRepository playlistRepository,SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public Playlist create_playlist(String playlistName, List<Integer>ids) {
        Playlist playlist = playlistRepository.save(playlistName, ids);
        System.out.println(String.format("Playlist [id=%d]",playlist.getId()));
        return playlist;
    }
    public void add_song_to_playlist(String playlistName,Integer songId) {
        Optional<Playlist>playlist = playlistRepository.findByPlaylistName(playlistName);
        if(playlist.isPresent()) {
            playlist.get().getAllSongsid().add(songId);
            System.out.print(String.format("Playlist %s is revised with ",playlist.get().getPlaylistName()));
            List<String>songs = new LinkedList<>();
            for(Integer id:playlist.get().getAllSongsid()) {
                String songName = String.format("Song [id=%d]",songRepository.findById(id).get().getId());
                songs.add(songName);
            }
            System.out.println(songs);
        }
        return;
    }
    public void delete_song_from_playlist(String playlistName,Integer id) {
        List<Integer> ids = playlistRepository.deleteSongFromPlaylist(playlistName,id);
        System.out.print("Playlist " + playlistName + " is revised with ");
        List<String>songs = new LinkedList<>();
        for(Integer i:ids) {
            String songName = String.format("Song [id=%d]",songRepository.findById(i).get().getId());
            songs.add(songName);
        }
        System.out.println(songs);
    }
    public void delete_playlist(String playlistName) {
        boolean done = playlistRepository.delete(playlistName);
        if(!done) {
            System.out.println("Playlist not found");
        }
        else {
            System.out.println("Playlist " + playlistName + " is deleted!");
        }
    }
    public void load_playlist(String playlistName) {
        Optional<Playlist>pOptional =  playlistRepository.findByPlaylistName(playlistName);
        if(pOptional.isPresent()) {
            playlistRunning = pOptional.get();
            System.out.println(String.format("Playlist %s is loaded!",playlistRunning.getPlaylistName()));
        }
        else {
            System.out.println("Playlist Not Found");
        }
    }
    public void play_song() {
        if(playlistRunning != null) {
            if(!paused) {
                List<Integer>songIds = playlistRunning.getAllSongsid();
                System.out.println(String.format("Song [id=%d] is playing!",songRepository.findById(songIds.get(runningSong)).get().getId()));
                paused = true;
            }
            else {
                List<Integer>songIds = playlistRunning.getAllSongsid();
                System.out.println(String.format("Song [id=%d] is paused!",songRepository.findById(songIds.get(runningSong)).get().getId()));
                paused = false;
            }
            
        }
        else {
            System.out.println("Load the playlist first");
        }
    }
    public void next_song() {
        if(playlistRunning != null) {
            List<Integer>songIds = playlistRunning.getAllSongsid();
            runningSong += 1;
            
            System.out.println(String.format("Song [id=%d] is playing!",songRepository.findById(songIds.get(runningSong)).get().getId()));
        }
    }
    public void previous_song() {
        if(playlistRunning != null) {
            List<Integer>songIds = playlistRunning.getAllSongsid();
            runningSong -= 1;
            if(runningSong < 0) {
                runningSong = songIds.size()-1;
            }
            System.out.println(String.format("Song [id=%d] is playing!",songRepository.findById(songIds.get(runningSong)).get().getId()));
        }
    }
    public void stop_song() {
        if(playlistRunning != null) {
            List<Integer>songIds = playlistRunning.getAllSongsid();
            System.out.println(String.format("Song [id=%d] is stopped!",songRepository.findById(songIds.get(runningSong)).get().getId()));
        }
    }
}
