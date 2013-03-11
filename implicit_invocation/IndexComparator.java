package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.util.Comparator;

/**
 * Custom index comparator
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
class IndexComparator implements Comparator<Index> {

    public IndexComparator() {
    }

    @Override
    public int compare(Index o1, Index o2) {
        return o1.compareTo(o2);
    }

}
