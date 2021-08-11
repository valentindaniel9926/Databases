package com.company;

import com.company.model.Artist;
import com.company.model.DataSource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Can't open datasource");
            return;
        }
       List<Artist> artists = dataSource.queryArtists();
        if(artists == null){
            System.out.println("No artists!");
            return;
        }
        for (Artist artist : artists){
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());

        }
        dataSource.close();
    }
}
