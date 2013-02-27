package cz.cvut.fel.cs.ass.kwic.shared_memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class Line {
    private String line;
    private ArrayList<String> words = new ArrayList<String>();
    private int wordCount = 0;

    public Line(String line) {
        this.line = line;
        this.wordCount = line.length();
        this.words = (ArrayList<String>) Arrays.asList(line.split("\\s+"));
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }
}
