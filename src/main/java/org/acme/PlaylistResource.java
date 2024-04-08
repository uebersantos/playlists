package org.acme;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/playlist")
public class PlaylistResource<MusicService> {

    private static List<Playlist> playlists = new ArrayList<>();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> createPlaylist(@FormParam("name") String name, @FormParam("owner") String owner) {
        Playlist newPlaylist = new Playlist(name, owner);
        playlists.add(newPlaylist);
        return playlists;
    }



    @Inject
    MusicService musicService;

    @POST
    @Path("/addMusic")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist addMusicToPlaylist(@FormParam("playlistName") String playlistName, @FormParam("musicTitle") String musicTitle) {
        Playlist playlist = findPlaylistByName(playlistName);
        if (playlist != null) {
            Music music = ((Object) musicService).getMusicByTitle(musicTitle);
            if (music != null) {
                playlist.getMusics().add(music);
            }
        }
        return playlist;
    }

    private Playlist findPlaylistByName(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(playlistName)) {
                return playlist;
            }
        }
        return null;
    }
}