package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.util.Observable;
import java.util.Observer;

/**
 * Second block makes shifts of readed line. Each shift notify alphabetizer
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class CircularShiftBlock implements Observer {
    private LineStorage lines;
    private IndexStorage indices;

    public CircularShiftBlock(IndexStorage indices) {
        this.indices = indices;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.lines = (LineStorage) o;
        shift();
    }
    
    private void shift() {
        int index = lines.size()-1;
        String[] line = lines.get(index).split("\\s+");
        for(int j = 0 ; j < line.length ; j++) {
            indices.add(new Index(line[j], index, j));
        }
    }

}
