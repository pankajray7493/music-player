package com.pankaj;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums=new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","AC/DC");
        album.addsong("TNT",4.5);
        album.addsong("BTS song",5.5);
        album.addsong("Highway to hell",6.5);
        album.addsong("Kala chusma",3.2);
        album.addsong("Blue ice",4.5);
        albums.add(album);

        album = new Album("Album2","Enimen");
        album.addsong("Rap god",4.5);
        album.addsong("Not afraid",3.5);
        albums.add(album);

        LinkedList<song> playlist1 = new LinkedList<>();

        albums.get(0).addToplaylist("TNT",playlist1);
        albums.get(0).addToplaylist("BTS song",playlist1);
        albums.get(0).addToplaylist("Highway to hell",playlist1);
        albums.get(0).addToplaylist("Kala chusma",playlist1);
        albums.get(0).addToplaylist("Blue ice",playlist1);

        play(playlist1);

    }
    private static void play(LinkedList<song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<song> listIterator = playlist.listIterator();

        if (playlist.size() == 0){
            System.out.println("This playlist have no song");
        }
        else{
            System.out.println("Now playing"+ listIterator.next().toString());
            printmenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit= true;
                    break;

                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing" + listIterator.next().toString());
                    }
                    else {
                        System.out.println("No song available. reached to end of the list");
                        forward= false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }
                    else {
                        System.out.println("We are at the fist song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at the start of the start");
                        }
                    }
                    else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward = true;
                        }
                        else {
                            System.out.println("We are end of the list");
                        }
                    }break;
                case 4:
                    playlist(playlist);
                    break;
                case 5:
                    printmenu();
                    break;
                case 6:
                    if (playlist.size() >0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing" + listIterator.next().toString());
                        }
                        else{
                            if (listIterator.hasPrevious()){
                                System.out.println("Now playing" + listIterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }
    private static void printmenu(){
        System.out.println("Available optios \n press");
        System.out.println(" 0 - to quit \n"+
                " 1 - to play next song\n"+
                " 2 - to play previous song\n"+
                " 3 - to replay the current song\n"+
                " 4 - list of all songs\n"+
                " 5 - print all available option\n"+
                " 6 - delete current song");
    }
    private static void playlist(LinkedList<song> playlist){
        Iterator<song> iterator = playlist.iterator();
        System.out.println("............................");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("............................");
    }
}
