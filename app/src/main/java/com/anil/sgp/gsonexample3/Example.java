
package com.anil.sgp.gsonexample3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("song_name")
    @Expose
    private String songName;
    @SerializedName("song_id")
    @Expose
    private String songId;
    @SerializedName("artist_name")
    @Expose
    private String artistName;

    /**
     * @return The songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName The song_name
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * @return The songId
     */
    public String getSongId() {
        return songId;
    }

    /**
     * @param songId The song_id
     */
    public void setSongId(String songId) {
        this.songId = songId;
    }

    /**
     * @return The artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @param artistName The artist_name
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

}
