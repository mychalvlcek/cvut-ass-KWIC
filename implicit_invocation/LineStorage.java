package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Storage for lines of readed document
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class LineStorage extends Observable {
    ArrayList<String> lines = new ArrayList<String>();
    
    public void add(String line) {
        lines.add(line);
        // notify
        setChanged();
        notifyObservers();
    }
    
    public String get(int index) {
        return lines.get(index);
    }
    
    public int size() {
        return lines.size();
    }

}
