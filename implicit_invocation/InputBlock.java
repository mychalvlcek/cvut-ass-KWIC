package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * First block reads input file. Each readed line notify circular shift block
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class InputBlock {
    
    public void read(String path, LineStorage lines) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null) {
                if(!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File '" + path + "' not found!");
        } catch (IOException ex) {
            System.err.println("Error while reading file:  " + ex.getMessage());
        }
    }
}
