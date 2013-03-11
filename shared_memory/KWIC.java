package cz.cvut.fel.cs.ass.kwic.shared_memory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * KWIC Solution 1 - Shared Memory
 * ASS FEL CVUT @ 2013
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class KWIC {
    private static String path = "kwic_input.txt";
    
    private static int[] chars;
    private static int[] lines;
    private static int[][] shifts;
    
    private static int lineCount = 1;
    private static int wordCount = 1;
    
    
    public static void main(String[] args) throws Exception {
        
        input();
        shift();
        aplhabetize();
        output();
        
    }

    private static void input() {
        try {
            File file = new File(path);
            chars = new int[(int)file.length()];
            BufferedReader br = new BufferedReader(new FileReader(file));
            int charIndex = 0;
            int lineIndex = 0;
            int c;
            // chars
            while((c = br.read()) != -1) {
                chars[charIndex++] = c;
                if(c == 10) lineCount++;
                if(c == 32 || c == 10) wordCount++;
            }
            // lines
            lines = new int[lineCount];
            lines[lineIndex++] = 0;
            for( int i = 0 ; i < chars.length ; i++ ) {
                if(chars[i] == 10) lines[lineIndex++] = i+1;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File '" + path + "' not found!");
        } catch (IOException ex) {
            System.err.println("Error while reading file:  " + ex.getMessage());
        }
    }
    
    private static void shift() {
        shifts = new int[wordCount][2];
        int shiftIndex = 0;
        int lineIndex = 0;
        shifts[shiftIndex++] = new int[] {0,0};
        for(int i = 0 ; i < chars.length ; i++) {
            
            if(chars[i] == 10 || chars[i] == 32) {
                // line index, first char of each word index
                if(chars[i] == 10) lineIndex++;
                shifts[shiftIndex++] = new int[] {lineIndex,i+1};
            }
        }
    }
    
    private static void aplhabetize() {
        shifts = mergesort(shifts);
    }
    
    private static void output() {
        System.out.println("\n====================== OUTPUT ======================\n");
        for (int i = 0; i < shifts.length; i++) {
            int endCharIndex = 0;
            int startCharIndex = lines[shifts[i][0]];
            if(shifts[i][0]+1 == lines.length ) {
                endCharIndex = chars.length;
            } else {
                endCharIndex = lines[shifts[i][0]+1];
            }
            // after
            for (int j = shifts[i][1]; j < endCharIndex; j++) {
                if(chars[j] != 10)
                    System.out.print((char)chars[j]);
            }
            System.out.print(" ");
            // before
            for (int j = startCharIndex; j < shifts[i][1]; j++) {
                if(chars[j] != 10)
                    System.out.print((char)chars[j]);
            }
            System.out.println("");
        }
    }
    
    // MERGE SORT
    private static int[][] mergesort(int[][] array) {
        if (array.length < 2) return array;
        return merge(mergesort(getFirstHalfOf(array)), mergesort(getSecondHalfOf(array)));
    }
    
    private static int[][] getFirstHalfOf(int[][] array) {
        double origLength = array.length;
        int length = (int) Math.ceil(origLength/2);
        int[][] half = new int[length][2];
        System.arraycopy(array, 0, half, 0, length);
        return half;
    }

    private static int[][] getSecondHalfOf(int[][] array) {
        double origLength = array.length;
        int length = (int) Math.floor(origLength/2);
        int[][] half = new int[length][];
        System.arraycopy(array, length+array.length%2, half, 0, length);
        return half;
    }

    private static int[][] merge(int[][] firstHalf, int[][] secondHalf) {
        int[][] arr = new int[firstHalf.length + secondHalf.length][2];
        int i = 0, j = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            String a = String.valueOf((char)chars[firstHalf[i][1]]);
            String b = String.valueOf((char)chars[secondHalf[j][1]]);
            if(a.compareToIgnoreCase(b) < 0) {
                arr[i+j] = firstHalf[i++];
            } else {
                arr[i+j] = secondHalf[j++];
            }
        }
        while(i == firstHalf.length && j != secondHalf.length) arr[i+j] = secondHalf[j++];
        while(i != firstHalf.length && j == secondHalf.length) arr[i+j] = firstHalf[i++];
        return arr;

    }

}