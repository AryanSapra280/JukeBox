package com.example.demo;

import com.example.demo.commands.AddSong;
import com.example.demo.commands.AddSongToPlaylist;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreatePlaylist;
import com.example.demo.commands.DeletePlaylist;
import com.example.demo.commands.DeleteSongFromPlaylist;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongs;
import com.example.demo.commands.LoadPlaylist;
import com.example.demo.commands.NextSong;
import com.example.demo.commands.PlaySong;
import com.example.demo.commands.PreviousSong;
import com.example.demo.commands.StopSong;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final PlaylistRepository playlistRepository = new PlaylistRepository();
            private final SongRepository songRepository = new SongRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final PlaylistService playlistService = new PlaylistService(playlistRepository,songRepository);
            private final SongService songService = new SongService(songRepository);
            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final AddSong addSong = new AddSong(songService);
            private final AddSongToPlaylist addSongToPlaylist = new AddSongToPlaylist(playlistService);
            private final CreatePlaylist createPlaylist = new CreatePlaylist(playlistService);
            private final DeletePlaylist deletePlaylist = new DeletePlaylist(playlistService);
            private final DeleteSongFromPlaylist deleteSongFromPlaylist = new DeleteSongFromPlaylist(playlistService);
            private final ListSongs listSongs = new ListSongs(songService);
            private final LoadPlaylist loadPlaylist = new LoadPlaylist(playlistService);
            private final NextSong nextSong = new NextSong(playlistService);
            private final PlaySong playSong = new PlaySong(playlistService);
            private final PreviousSong previousSong = new PreviousSong(playlistService);
            private final StopSong stopSong = new StopSong(playlistService);
            

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG.getName(), addSong);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST.getName(), addSongToPlaylist);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST.getName(), createPlaylist);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST.getName(), deletePlaylist);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST.getName(), deleteSongFromPlaylist);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS.getName(),listSongs);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST.getName(),loadPlaylist);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG.getName(),nextSong);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG.getName(),playSong);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG.getName(),previousSong);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG.getName(),stopSong);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
            public PlaylistService getPlaylistService(){
                return playlistService;
            }
            public SongService getSongService(){
                return songService;
            }

}
