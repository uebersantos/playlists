package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private String owner;
    private List<String> musics;

    public Playlist(String name, String owner) {
        this.name = name;
        this.owner = owner;
        this.musics = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getMusics() {
        return musics;
    }

    public void setMusics(List<String> musics) {
        this.musics = musics;
    }
}
