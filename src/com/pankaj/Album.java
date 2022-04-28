package com.pankaj;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private  String name;
    private String artist;
    private ArrayList<song> songs;

    public Album(String name,String artist){
        this.name=name;
        this.artist=artist;
        this.songs = new ArrayList<song>();
    }
    public Album(){

    }
    public song findSong(String title){

        for (song checkedSong : songs){
            if (checkedSong.getTitle().equals(title)) return checkedSong;
        }
        return null;
    }
    public boolean addsong(String title,double duration){
        if (findSong(title)== null){
            songs.add(new song(title,duration));
          //  System.out.println(title + "song successfully add to the list");
            return true;
        }
        else {
           // System.out.println("song with name" + title+ "is already exist in this list");
            return false;
        }
    }
   /* public boolean addToplaylist(int tracknumer, LinkedList<song> playlist){
        int index = tracknumer-1;
        if (index>0 && index<= this.songs.size()){
            playlist.add(this.songs.get(index));
            return true;
        }
        //System.out.println("This album does not have song with tracknumber" + tracknumer);
        return false;

    }

    */
    public boolean addToplaylist(String title,LinkedList<song> playlist){
        for(song checkedsong : this.songs){
            if(checkedsong.getTitle().equals(title)){
                playlist.add(checkedsong);
                return  true;
            }
        }
        //System.out.println(title + "There is no such song in album");
        return false;
    }
}
