package Encapsulation.assignmentproblems;

import java.util.Scanner;

public class Playlist {

    
    private String[] songs;

    
    private int songCount;

    
    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    
    public void addSong(String song) {

        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    
    public String[] getSongs() {

        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    
    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of songs: ");
        int maxSongs = sc.nextInt();
        sc.nextLine();

        Playlist p = new Playlist(maxSongs);

        System.out.print("Enter number of songs to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter song name: ");
            String song = sc.nextLine();

            p.addSong(song);
        }

        System.out.println("Song count: " + p.getSongCount());

        String[] copy = p.getSongs();

        System.out.println("Songs in playlist:");

        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

        
        if (copy.length > 0) {
            copy[0] = "Hacked";
        }

        System.out.println("\nAfter modifying returned array:");
        System.out.println("First song in playlist: " + p.getSongs()[0]);

        sc.close();
    }
}
