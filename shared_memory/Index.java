package cz.cvut.fel.cs.ass.kwic.shared_memory;

import java.util.Collections;
import java.util.Comparator;

/**
 * An Index representation
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class Index {
    private String word;
    private int line;
    private int index;

    public Index(String word, int line, int index) {
        this.word = word;
        this.line = line;
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
