package com.example.demo.commands;

public enum CommandKeyword {

    // Register Command Keywords
    CREATE_GREETING_COMMAND("CREATE_GREETING"),
    LIST_GREETING_COMMAND ("LIST_GREETING"),
    GET_GREETING_COMMAND ("GET_GREETING"),
    ADD_SONG ("ADD_SONG"),
    ADD_SONG_TO_PLAYLIST("ADD_SONG_TO_PLAYLIST"),
    CREATE_PLAYLIST("CREATE_PLAYLIST"),
    DELETE_PLAYLIST("DELETE_PLAYLIST"),
    DELETE_SONG_FROM_PLAYLIST("DELETE_SONG_FROM_PLAYLIST"),
    LIST_SONGS("LIST_SONGS"),
    LOAD_PLAYLIST("LOAD_PLAYLIST"),
    NEXT_SONG("NEXT_SONG"),
    PLAY_SONG("PLAY_SONG"),
    PREVIOUS_SONG("PREVIOUS_SONG"),
    STOP_SONG("STOP_SONG");

    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     } 
}
