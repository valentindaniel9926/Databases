package com.company;

import com.company.model.Artist;
import com.company.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource datasource = new DataSource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(5);
        if(artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Carole King", DataSource.ORDER_BY_DESC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        datasource.close();
    }
}
