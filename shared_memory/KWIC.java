package cz.cvut.fel.cs.ass.kwic.shared_memory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * KWIC Solution 1 - Shared Memory
 * ASS FEL CVUT @ 2013
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class KWIC {
    private static String keyword; /* searched keyword */
    private static String path; /* path to textfile */
    
    private static ArrayList<String> lines = new ArrayList<String>();
    private static ArrayList<Index> indices = new ArrayList<Index>();
    
    
    public static void main(String[] args) throws Exception {
        if(args.length != 2) throw new Exception("Bad number of arguments: " + args.length);
        keyword = args[0].toLowerCase();
        path = args[1];
        
        input();
        shift();
        aplhabetize();
        output();
        
    }

    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null) {
                if(!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File '" + path + "' not found!");
        } catch (IOException ex) {
            System.err.println("Error while reading file:  " + ex.getMessage());
        }
    }
    
    private static void shift() {
        for(int i = 0 ; i < lines.size() ; i++) {
            String[] line = lines.get(i).split("\\s+");
            for(int j = 0 ; j < line.length ; j++) {
                indices.add(new Index(line[j], i, j));
            }
        }
    }
    
    private static void aplhabetize() {
        Collections.sort(indices, new IndexComparator());
    }
    
    private static void output() {
        System.out.println("\n====================== OUTPUT ======================\n");
        for( int i = 0; i < indices.size(); ++i ) {
            Index index = indices.get(i);
            String[] words = lines.get(index.getLine()).split("\\s+");
            Collections.rotate(Arrays.asList(words), -index.getIndex());
            for(String s : words) {
                System.out.print(s + " \033[0;1m");
            }
            System.out.println("\033[0;0m");
        }
        System.out.println("\n====================== CONTEXT FOR '" + keyword + "' ======================\n");
        ArrayList<Integer> keywordIndices = getIndicesOfKeyword(keyword);
        Collections.sort(keywordIndices);
        if(keywordIndices.get(0) != -1) {
            for(Integer i : keywordIndices)
                printContext(indices.get(i).getLine());
        } else {
            System.out.println("Not found.");
        }
    }
    
    private static ArrayList<Integer> getIndicesOfKeyword(String keyword) {
        int index = getIndexOfKeyword(keyword);
        ArrayList<Integer> keywordIndices = new ArrayList<Integer>();
        keywordIndices.add(index);
        int indexTmp = index;
        if(index > -1) {
            while(indexTmp > -1 && indices.get(--indexTmp).getWord().toLowerCase().replaceAll("\\W", "").compareTo(keyword) == 0) {
                keywordIndices.add(indexTmp);
            }
            indexTmp = index;
            while(indexTmp < indices.size() && indices.get(++indexTmp).getWord().toLowerCase().replaceAll("\\W", "").compareTo(keyword) == 0) {
                keywordIndices.add(indexTmp);
            }
            return keywordIndices;
        } else {
            
            return keywordIndices;
        }
    }
    
    private static int getIndexOfKeyword(String keyword) {
        return getIndexOfKeyword(keyword, 0, indices.size()-1);
    }
    
    private static int getIndexOfKeyword(String keyword, int start, int end) {
        if(start > end) return -1;
        int mid = (start + end)/2;
        String word = indices.get(mid).getWord().toLowerCase().replaceAll("\\W", "");
        if(word.compareTo(keyword) > 0) {
            return getIndexOfKeyword(keyword, start, mid-1);
        } else if(word.compareTo(keyword) < 0) {
            return getIndexOfKeyword(keyword, mid+1, end);
        } else {
            return mid;
        }
    }
    
    private static void printContext(int line) {
        if(line-1 > -1)
            System.out.println((line-1) + ": " + lines.get(line-1));
        System.out.println((line) + ": " + lines.get(line));
        if(line+1 < lines.size())
            System.out.println((line+1) + ": " + lines.get(line+1));
        
        System.out.println("");
    }

}