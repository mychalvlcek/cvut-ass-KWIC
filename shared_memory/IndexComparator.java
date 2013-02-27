package cz.cvut.fel.cs.ass.kwic.shared_memory;

import java.util.Comparator;

/**
 * Comparator for Index class
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class IndexComparator implements Comparator<Index> {
    @Override
    public int compare(Index t, Index t1) {
        return t.getWord().compareToIgnoreCase(t1.getWord());
    }
}