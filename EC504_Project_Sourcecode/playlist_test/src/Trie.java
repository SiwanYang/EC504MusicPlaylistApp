/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wuhao
 */
import java.util.HashMap;
import java.util.Map;


public class Trie {
    private TrieNode root;
	 
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public TrieNode getroot(){
        return root;
    }
    public void insert(String song, int pop, int index) {
        HashMap<Character, TrieNode> children = root.children;
 
        for(int i=0; i<song.length(); i++){
            char c = song.charAt(i);
 
            TrieNode t;
            
            if(children.containsKey(c)){
                t = children.get(c);
                for(int j=0; j<4; j++){
                    if(t.songpop.get(j)<pop){
                        if(t.songindex.contains(index)){
                            t.popular_song_update(j, song, index, pop);
                            break;
                        }
                        else{
                            t.add_popular_song(j, song, index, pop);
                            break;
                        }
                    }
                }
            }else{
                t = new TrieNode(c);
                t.add_popular_song(0, song, index, pop);
                children.put(c, t);
            }
 
            children = t.children;
 
            //set leaf node
            if(i==song.length()-1)
                t.isLeaf = true;    
        }
    }

    public TrieNode searchNode(String str){
        if(str.length()==0) return root;
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
 
        return t;
    }
    
}
