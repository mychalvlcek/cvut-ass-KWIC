package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

/**
 * Third block sorts inserted index alphabetically
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class AlphabetizerBlock implements Observer {
    
    private IndexStorage indices;

    @Override
    public void update(Observable o, Object arg) {
        this.indices = (IndexStorage) o;
        alphabetize();
    }
    
    private void alphabetize() {
        Collections.sort(indices.indices, new IndexComparator());
    }

}
