/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wuhao
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TrieNode {
    char c;
    ArrayList<Integer> songindex = new ArrayList<Integer>();
    ArrayList<Integer> songpop = new ArrayList<Integer>();
    ArrayList<String> songname = new ArrayList<String>();
    String[] songrank =  new String[4];
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    
    public TrieNode() {
    	//Arrays.fill(popular_songs, 0);
        Arrays.fill(songrank,"");
    	for(int i=0;i<4;i++){
    		songindex.add(0);
    		songpop.add(0);
    		songname.add("");
    	}
    }
 
    public TrieNode(char c){
    	this.c = c;
        Arrays.fill(songrank,"");
    	for(int i=0;i<4;i++){
    		songindex.add(0);
    		songpop.add(0);
    		songname.add("");
    	}
    	//Arrays.fill(popular_songs, 0);
    }
    public void add_popular_song(int rank, String song, int index, int pop){
	songindex.add(rank, index);
	songpop.add(rank, pop);
	songname.add(rank, song);
	songindex.remove(4);
	songpop.remove(4);
	songname.remove(4);
        for(int i=0;i<4;i++){
            songrank[i] = songname.get(i);
        }
    }
    
    public void popular_song_update(int rank, String song, int index, int pop){
        int original_song_rank = songindex.indexOf(index)+1;
        songindex.add(rank, index);
	songpop.add(rank, pop);
	songname.add(rank, song);
        songpop.remove(original_song_rank);
        songname.remove(original_song_rank);
        songindex.remove(original_song_rank);
        for(int i=0;i<4;i++){
            songrank[i] = songname.get(i);
        }
        
    }
    
}

