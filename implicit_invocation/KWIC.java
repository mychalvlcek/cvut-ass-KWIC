package cz.cvut.fel.cs.ass.kwic.implicit_invocation;

/**
 * KWIC Solution 3 - Implicit Invocation
 * ASS FEL CVUT @ 2013
 * @author Michal Vlcek <vlcekmi3@fel.cvut.cz>
 */
public class KWIC {
    
    private static final String INPUT_PATH = "kwic_input.txt";
    
    public static void main(String[] args) throws Exception {
        LineStorage lines = new LineStorage();
        IndexStorage indices = new IndexStorage();
        
        InputBlock input = new InputBlock();
        CircularShiftBlock shift = new CircularShiftBlock(indices);
        AlphabetizerBlock alphabetize = new AlphabetizerBlock();
        OutputBlock output = new OutputBlock();
        
        // add observers
        lines.addObserver(shift);
        indices.addObserver(alphabetize);
        
        input.read(INPUT_PATH, lines);
        output.print(lines, indices);
        
    }

}