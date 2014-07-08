/**
 *
 * @author Chris Minich
 *         cfminich@gmail.com
 */

package mario;

import java.io.*;

public class Mario {
    private int height;
    public StringBuilder pyramid = new StringBuilder();
    
    public Mario() {
        height = 0;
    }
    
    public void resetHeight() {
        System.out.print("Enter pyramid height (2 - 23) ");
        do {
            height = Integer.parseInt(System.console().readLine());
        } while ((height < 1) || (height > 23));
    }
    
    public void buildPyramid() {
        for (int row = 1; row <= height; row++) {
            int spaces = height - row;
            for (int col = 1; col <= height; col++) {
                if (col <= spaces) pyramid.append(" ");
                else pyramid.append("#");
            }
            pyramid.append("#\n");
        }
    }
    
    public void printPyramid() {
        System.out.print(pyramid.toString());
    }
    
    public void writePyramid(String fileName) {
    	FileOutputStream fout = null;
    	int charCountOfPyramid = pyramid.length();
    	int eachChar;
    	try {
    		fout = new FileOutputStream(fileName);
    		for (int i=0; i<charCountOfPyramid; i++) {
    			eachChar = pyramid.charAt(i);
    			fout.write(eachChar);
    		}
    	}
    	catch (IOException exc) {
    		System.out.println("I/O Error: " + exc);
    	}
    	finally {
    		try {
    			if (fout != null) fout.close();
    		}
    		catch (IOException exc) {
    			System.out.println("Error closing output file");
    		}
    	}
    }

    /**
     * @param args: output file
     */
    public static void main(String[] args) {
        Mario myPyramid = new Mario();
        myPyramid.resetHeight();
        myPyramid.buildPyramid();
        if (args.length > 0)
        	myPyramid.writePyramid(args[0]);
        else
        	myPyramid.printPyramid();
    }
    
}
