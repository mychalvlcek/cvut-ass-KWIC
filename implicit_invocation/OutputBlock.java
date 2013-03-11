package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.util.Arrays;
import java.util.Collections;

/**
 * Last, forth, block outputs sorted shifts.
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class OutputBlock {
    public void print(LineStorage lines, IndexStorage indices) {
        System.out.println("\n====================== OUTPUT ======================\n");
        for( int i = 0; i < indices.size(); ++i ) {
            Index index = indices.get(i);
            String[] words = lines.get(index.getLineIndex()).split("\\s+");
            Collections.rotate(Arrays.asList(words), -index.getWordIndex());
            for(String s : words) {
                System.out.print(s + " \033[0;1m");
            }
            System.out.println("\033[0;0m");
        }
    }
}
