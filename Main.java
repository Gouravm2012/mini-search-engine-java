package MiniSearchEngine;

import java.io.*; //for File class to locate files in my system
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        File folder = new File("MiniSearchEngine/documents"); //locate documents
        File[] files = folder.listFiles(); //add all files in an array
        HashMap<String, List<String>> frequency = new HashMap<>(); //to store the word and the file name

        for (File one_by_file : files) { //loop for each files
            Scanner sc = new Scanner(one_by_file); //read 
            while (sc.hasNextLine()) { //continue untill it's end
                String oneline = sc.nextLine(); //read one line
                String[] words = oneline.toLowerCase().split(" "); //cnverts to lowercase and split each words and store in array
                for (String word : words) { //loop for each words
                    if (!frequency.containsKey(word)) { //presentt in map or not
                        frequency.put(word, new ArrayList<>()); //if not, then add\
                    }
                    frequency.get(word).add(one_by_file.getName()); // if present then add file name to it
                }
            }
            sc.close();
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Search word: ");
        String search_word = sc.nextLine().toLowerCase();
        if (frequency.containsKey(search_word)) { //search for the word in the map
            System.out.println(frequency.get(search_word)); //if present then display
        } else {
            System.out.println("Not present in any text files");
        }
    }
}
