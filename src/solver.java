//package dlx;

import java.awt.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class solver{
	ArrayList<Integer> next = new ArrayList<>();
	public int nodes = 0;
	private boolean useBiderectional = false;
	
	public void setbid(boolean val){
		this.useBiderectional = val;
	}
	
	public int backtrack = 0;
	
	
	private boolean solveSudoku(Board board, int offset) throws CloneNotSupportedException{
		if (offset == 81) {
			if(board.isValidSudoku()){
				System.out.println("=================================================================================");
				System.out.println("Here is solution of Sudoku in format specified:- ");
				System.out.println(board.getBoard());
				System.out.println();
				System.out.println("Number of Nodes Expanded:- "  + nodes);
				System.out.println("Number of Backtracks:- " + backtrack);
				System.out.println();
				System.out.println("Solution in Readable Format:- ");
				System.out.println();
				board.printBoard();
				
				return true;
			}
			return false;
        }
		
		int loc = offset;
		int x, y;

        if (useBiderectional && loc % 2 == 0) {
            x = (loc / 2) / 9;
            y = (loc / 2) % 9;
        } else if (useBiderectional) {
            x = (80 - (loc / 2)) / 9;
            y = (80 - (loc / 2)) % 9;
        } else {
            x = loc / 9;
            y = loc % 9;
        }

		
   
        if(board.isZero(x, y)){
            return solveSudoku(board, offset + 1);
        } else {
        	for(Integer val: board.getdomain(x, y)){
        		nodes += 1;
        		String curBoard = board.getBoard();
        		if(true){	        		
	        		Board empty = new Board();
	        		
	        		empty.makeBoard(curBoard);	        		
	        		empty.makeDomain();
	        		empty.removeDomain();
	        		
	        		
	        		if(empty.setVal(x, y, val)){
	        			if(solveSudoku(empty, offset + 1)){
	        				return true;
	        			}
	        		}
	        		empty = null;
        		}
        	}
        	board.setZero(x, y);
        }
        backtrack += 1;
        return false;
	}
	
	
	
	public boolean solve(String s) throws CloneNotSupportedException{
		Board board = new Board();
		backtrack = 0;
		board.makeBoard(s);
		board.makeDomain();
		board.removeDomain();
		return solveSudoku(board, 0);
	}
	
}