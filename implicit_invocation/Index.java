package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

/**
 *
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class Index implements Comparable<Index> {
    private String word;
    private int lineIndex;
    private int wordIndex;

    public Index(String word, int lineIndex, int wordIndex) {
        this.word = word;
        this.lineIndex = lineIndex;
        this.wordIndex = wordIndex;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public void setLineIndex(int lineIndex) {
        this.lineIndex = lineIndex;
    }

    public int getWordIndex() {
        return wordIndex;
    }

    public void setWordIndex(int wordIndex) {
        this.wordIndex = wordIndex;
    }

    @Override
    public int compareTo(Index o) {
        return word.compareTo(o.word);
    }

}
