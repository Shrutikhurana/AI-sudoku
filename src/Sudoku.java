import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Sudoku{
	public static void main(String[] args) throws IOException, CloneNotSupportedException{
		Scanner sc = new Scanner(System.in);
		solver s1 = new solver();
		
		BufferedReader br = null;
        ArrayList<String> seq = new ArrayList<>();
        
		boolean rep = true;
		System.out.println("=================================================================================");
        System.out.println("                           Welcome to Sudoku Solver                              ");
		
		while(rep){
			System.out.println("=================================================================================");
			System.out.println("                      Please enter 1 to solve new Sudoku                         ");
			System.out.println("                           Please enter 0 to exit                                ");
			System.out.println("=================================================================================");
			System.out.print("Your Choice Please:- ");
			String choice = sc.next();
			int choice1 = 0;
			try{
				choice1 = Integer.parseInt(choice);
			}catch(NumberFormatException e){
				System.out.println("You should have entered Integer, terminating program to save the world!!");
			};
	        if(choice1 == 1){
	        	System.out.println("=================================================================================");
		        System.out.println("                    Please enter input sequence of 81 integers                  ");
		        String ip = sc.next();
		        if(isValidInput(ip)){
			        long startTime = System.nanoTime();
					
			        if(!s1.solve(ip)){
			        	System.out.println("Please enter correct Sudoku");
			        	continue;
			        }
			    	long stopTime = System.nanoTime();
			    	double tot = ((stopTime - startTime)*1.0/1000000000);
			    	System.out.println();
			        System.out.println("Time taken to find Solution:- ");
			        System.out.println(tot + " sec");
		        }
		        else{
		        	System.out.println("Please enter correct input sequence .. !!");
		        }
	        }
	        else if(choice1 == 0){
	        	rep = false;
	        	System.out.println("Terminating program ... !!");
	        }
	        else{
	        	System.out.println("Please make valid choice");
	        }
        }
        /*
        double act1 = 0;
        double act2 = 0;
        for(int i = 0; i < seq.size(); i++){
        	
        	long startTime = System.nanoTime();
    		s1.solve(seq.get(i));
        	long stopTime = System.nanoTime();
        	double tot = ((stopTime - startTime)*1.0/1000000000);
        	act1 += tot;
        	System.out.println(tot);
        	//String s = System.lineSeparator() + tot;
		    //Files.write(Paths.get("output_forward_v2.txt"), s.getBytes(), StandardOpenOption.APPEND);
        	//System.out.println(i)
        }
        
        System.out.println(act1 + " " + act2);
        */
	}
    

	public static int[][] format(String num){
        int[][] intFor = new int[9][9];
        
        int cnt = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                intFor[i][j] = (int)num.charAt(cnt) - 48;
                cnt += 1;
            }
        }
        
        return intFor;        
    }
	
	public static boolean isValidInput(String s){
		for(int i = 0; i < 81; i++){
			int temp = (int)s.charAt(i);
			if(!(temp >= 48 && temp <= 57)){
				return false;
			}
		}
		return true;
	}
    
}