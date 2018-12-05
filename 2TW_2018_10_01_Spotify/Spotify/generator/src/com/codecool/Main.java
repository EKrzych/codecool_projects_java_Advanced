package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private ArrayList<String> readDiscountFromFile(String fileWithArtist) {
        ArrayList<String> artists = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileWithArtist))) {
            String line;
            br.readLine();//header
            while ((line = br.readLine()) != null) {
                artists.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return artists;
    }

    public ArrayList<String> generateBigArr() {
        Main main = new Main();
        ArrayList<String> newArtists = new ArrayList<>();
        ArrayList<String> artists = main.readDiscountFromFile("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_01_TW/Spotify/example_data/artists.csv");
        for (int i = 0, j = 0 ; i < 100000; i++, j++){
            newArtists.add(artists.get(j)+String.valueOf(i));
            if(j == artists.size()-1) {
                j = 0;
            }
        }
        return newArtists;
    }

    public void write_to_file() {
        Main main = new Main();
        ArrayList<String> newArtists = main.generateBigArr();
        FileWriter writer = null;
        try {
            writer = new FileWriter("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_01_TW/Spotify/example_data/artists.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String str: newArtists) {
            try {
                writer.write(str + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.write_to_file();
    }
}
