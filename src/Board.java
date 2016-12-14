//package test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Board implements Serializable  {
	private Integer[][] board = new Integer[9][9];
	
	private HashMap<Integer, ArrayList<Integer>> domain = new HashMap<>();
	
	
	public void setDomain(HashMap<Integer, ArrayList<Integer>> d1){
		this.domain.putAll(d1);
	}
	
	public HashMap<Integer, ArrayList<Integer>> getDomain(){
		return this.domain;
	}
	
	public void makeBoard(String num){
        int cnt = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                board[i][j] = (int)num.charAt(cnt) - 48;
                cnt += 1;
            }
        } 
	}
	
	public boolean isZero(int row, int column){
		return board[row][column] != 0;
	}

	public boolean setVal(int row, int column, int val){
		board[row][column] = val;
		ArrayList<Integer> lis = new ArrayList<Integer>(Arrays.asList(val));
		this.domain.put(9*row+column, lis);
		if(rmRow(row,column) && rmCol(row,column) && rmBox(row,column)){
			return true;
		}
		return false;
	}
	
	public void setZero(int row, int column){
		board[row][column] = 0;
	}
	
	
	public boolean rmRow(int row, int column){
		int[] setBoard = new int[9];
		Arrays.fill(setBoard, 0);
		
		for(int col = 0; col < 9; col++){
			int key = 9 * row + col;
			if(col != column){
				ArrayList<Integer> options = this.domain.get(key);
				if(options.contains(board[row][column])){
					options.remove(board[row][column]);
					this.domain.put(key, options);
					
					if(options.size() == 0){
						return false;
					}
					
					if(options.size() == 1){
						setBoard[col] = options.get(0);
					}
				}
			}
		}
		
		for(int col = 0; col < 9; col++){
			if(setBoard[col] != 0){
				if(!this.setVal(row, col, setBoard[col])){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean rmCol(int row, int column){
		int[] setBoard = new int[9];
		for(int row1 = 0; row1 < 9; row1++){
			int key = 9 * row1 + column;
			if(row1 != row){
				ArrayList<Integer> options = this.domain.get(key);
				if(options.contains(board[row][column])){				
					options.remove(board[row][column]);
					this.domain.put(key, options);
					
					if(options.size() == 0){
						return false;
					}
					
					if(options.size() == 1){
						setBoard[row1] = options.get(0);
					}
				}
			}
		}
		
		for(int row1 = 0; row1 < 9; row1++){
			if(setBoard[row1] != 0){
				if(!this.setVal(row1, column, setBoard[row1])){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean rmBox(int row, int column){
		int[] setBoard = new int[81];
		
		int rb = row - row % 3;
		int cb = column - column % 3;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int key = 9 * (rb + i) + (cb + j);
				if(!(rb+i == row && cb+j == column)){
					ArrayList<Integer> options = this.domain.get(key);
					if(options.contains(board[row][column])){
						options.remove(board[row][column]);	
						this.domain.put(key, options);
						
						if(options.size() == 0){
							return false;
						}
						
						if(options.size() == 1){
							setBoard[key] = options.get(0);
						}
					}
				}
			}
		}
		
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int key = 9 * (rb + i) + (cb + j);
				if(setBoard[key]!=0){
					if(!this.setVal(rb+i, cb+j, setBoard[key])){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	
	public void makeDomain(){
		//HashMap<Integer, ArrayList<Integer>> domain = new HashMap<>();
		for(int i = 0; i < 81; i++){
			int x = i / 9;
			int y = i % 9;			
			if(board[x][y] != 0){
				ArrayList<Integer> options = new ArrayList<Integer>(Arrays.asList(board[x][y]));	
				this.domain.put(i, options);
			}
			else{
				ArrayList<Integer> options = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
				this.domain.put(i, options);	
			}
			
		}
		
		//return domain;
	}
	
	public ArrayList<Integer> getdomain(int row, int column){
		
		return this.domain.get(9 * row + column);
	}
	
	public boolean removeDomain(){
		for(int i = 0; i < 81; i++){
			int x = i / 9;
			int y = i % 9;
			if(board[x][y] != 0){
				if(!rmRow(x,y)){
					return false;
				}
				if(!rmCol(x,y)){
					return false;
				}
				if(!rmBox(x,y)){
					return false;
				}
			}
		}
		return true;
	}
	
	
	public void printBoard(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public String getBoard(){
		String s = "";
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				s += board[i][j];
			}
			
		}
		return s;
	}
	
	public void printDomain(){
		for(int i = 0; i < 81; i++){
			System.out.println(Arrays.toString(this.domain.get(i).toArray()));
		}
		//System.out.println(Arrays.toString(domain.get(0).toArray()));
	}
	
	public boolean isValidSudoku() {
		for (int i = 0; i < 9; i++) {
            boolean[] array = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    if (array[board[i][j]-1]) {
                        return false;
                    }
                    array[board[i][j]-1] = true;
                }
            }
        }
        //column
        for (int j = 0; j < 9; j++) {
            boolean[] array = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != 0) {
                    if (array[board[i][j]-1]) {
                        return false;
                    }
                    array[board[i][j]-1] = true;
                }
            }
        }
        //block
        for (int k = 0; k < 9; k++) {
            int rowStart = (k / 3) * 3;
            int colStart = (k % 3) * 3;
            boolean[] array = new boolean[9];
            for (int i = rowStart; i < rowStart + 3; i++) {
                for (int j = colStart; j < colStart + 3; j++) {
                    if (board[i][j] != 0) {
                        if (array[board[i][j]-1]) {
                            return false;
                        }
                        array[board[i][j]-1] = true;
                    }
                }
            }
        }
        return true;
    }
	
	
	public boolean gotSolution(){
		
		for(int i = 0; i < 80; i++){
			if(board[i/9][i%9] == 0){
				return false;
			}
		}
		return true;
	}
	
}
