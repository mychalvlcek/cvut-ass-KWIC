package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Storage for indexing
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class IndexStorage extends Observable {
    ArrayList<Index> indices = new ArrayList<Index>();
    
    public void add(Index index) {
        indices.add(index);
        // notify
        setChanged();
        notifyObservers();
    }
    
    public Index get(int index) {
        return indices.get(index);
    }
    
    public int size() {
        return indices.size();
    }

}
