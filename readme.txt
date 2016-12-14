ReadME:- 

	Hey there, please follow given instruction to run sudoku solver.

	1. There are 3 java files in src, please extract them and place in directory.

	2. Use command line to navigate there

	3. Please run below command to build program. The main file is Sudoku.java

		C:\Users\XYZ\ZYX> javac Sudoku.java

	4. To run program please enter below command to run sudoku solver.

		C:\Users\XYZ\ZYX> java Sudoku

	5. Program will greet you and ask input sequence as initial board position as sequence of continuous 81 integers
	   depicting initial board position.

	6. The program then will try to find solution to given problem, if there exists a solution then it will output with 
	   some statistics. Otherwise if the input sequence is faulty then it will state that. 

	7. The program runs in while loop, please enter 0 to exit


	Here is sample output:- 
	1)

	=================================================================================
	                           Welcome to Sudoku Solver
	=================================================================================
	                      Please enter 1 to solve new Sudoku
	                           Please enter 0 to exit
	=================================================================================
	Your Choice Please:- 1
	=================================================================================
	                    Please enter input sequence of 81 integers
	040050000010080020060000104100300900007649200002001008305000090020090070000060050
	=================================================================================
	Here is solution of Sudoku in format specified:-
	248156739713984526569732184156328947837649215492571368385417692621895473974263851

	Number of Nodes Expanded:- 3
	Number of Backtracks:- 0

	Solution in Readable Format:-

	2 4 8 1 5 6 7 3 9
	7 1 3 9 8 4 5 2 6
	5 6 9 7 3 2 1 8 4
	1 5 6 3 2 8 9 4 7
	8 3 7 6 4 9 2 1 5
	4 9 2 5 7 1 3 6 8
	3 8 5 4 1 7 6 9 2
	6 2 1 8 9 5 4 7 3
	9 7 4 2 6 3 8 5 1

	Time taken to find Solution:-
	0.026225516 sec
	=================================================================================
	                      Please enter 1 to solve new Sudoku
	                           Please enter 0 to exit
	=================================================================================
	Your Choice Please:- 0
	Terminating program ... !!


	2) faulty input

	=================================================================================
	                           Welcome to Sudoku Solver
	=================================================================================
	                      Please enter 1 to solve new Sudoku
	                           Please enter 0 to exit
	=================================================================================
	Your Choice Please:- 1
	=================================================================================
	                    Please enter input sequence of 81 integers
	040050000010080020060000104100300900007649200002001008305000090020090070000060055
	Please enter correct Sudoku
	=================================================================================
	                      Please enter 1 to solve new Sudoku
	                           Please enter 0 to exit
	=================================================================================
	Your Choice Please:- 0
	Terminating program ... !!