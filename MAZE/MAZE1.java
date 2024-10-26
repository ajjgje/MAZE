import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/*
[CS1101] Comprehensive Lab 2
This work is to be done individually. It is not permitted to.
share, reproduce, or alter any part of this assignment for any
purpose. Students are not permitted to share code, upload
this assignment online in any form, or view/receive/
modifying code written by anyone else. This assignment is part.
of an academic course at The University of Texas at El Paso and
a grade will be assigned for the work produced individually by
the student.
*/
public class MAZE1{

// setting global maze
// and global intilaized row and col

	static char[][] userMaze = new char[0][0];

	static int row;
	static int col;

	public static void main(String[] args) throws FileNotFoundException{

// printing the methods
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("---- Enter the file path ----");
			System.out.println("File names:\n maze1.txt\n maze2.txt \n maze3.txt");
			String userInput = scanner.nextLine();
			createSquareMaze(userInput);
			loadMaze(userInput);
			findStartPosition();

// printing the movement and the maze
			while(userMaze[row][col] != 'F'){
				displayMaze();
				movePlayer();		
			}
						
		}catch(Exception e){
			System.out.println("Error!" + e);
		}
	}
	public static void createSquareMaze(String userFile){

		// creating the global maze and reading it
		try{

		int size = 0;
		File file = new File(userFile);
		Scanner reader = new Scanner(file);			

		while(reader.hasNextLine()){
			size ++;
			reader.nextLine();
		}
//using size and not row and col here because the array is same in col and row
		userMaze = new char [size][size];
		}catch(Exception e){
			System.out.println("Error!" + e);
			}
		}
	
	public static void loadMaze(String userFile){
	
	// reading the maze and its characters
		try{
			File file = new File(userFile);
			Scanner reader = new Scanner(file);	
			Scanner scanner = new Scanner(System.in);
			
			int n = 0;
			while(reader.hasNextLine()){
				String line = reader.nextLine();
				for(int i = 0; i < userMaze.length; i++){

					char content = line.charAt(i);
					userMaze[n][i] = content;	
				}
				n++;
			}
		}catch(Exception e){
		System.out.println("Error!" + e);
	}
}
	public static void findStartPosition(){

// finding the start postion and setting is as the current position

		for(int i = 0; i < userMaze.length; i++){
			for(int n = 0; n < userMaze[i].length; n++){
				if(userMaze[i][n] == 'S'){
					userMaze[i][n] = 'P';	
					row = i;
					col = n;
				}
			}
		}
	}

	public static void displayMaze(){
	
	// traversing through the maze to print it out

		for(int i = 0; i < userMaze.length; i++){
			for(int n = 0; n < userMaze[i].length; n++){
				System.out.print(userMaze[i][n]);
			}
			System.out.println();
			}
		}

	public static boolean movePlayer(){

// moving the players position depending on which keys they press
// return result works as a break for the cases
		boolean result = false;
		char playerPos;
		char wall = '#';
		char open = '.';
		char finished = 'F';

		Scanner scanner = new Scanner(System.in);
		System.out.println("W = up ; S = down ; A = left ; D = right");
		System.out.println("Pick from W,A,S,D");
		
//this get the suer input as a character
		char direction = scanner.nextLine().charAt(0);

		switch(direction){
		case 'W':
			if(userMaze[row-1][col] == '.' && row-1 < userMaze.length){

				userMaze[row][col] = '.';
				row--;
				userMaze[row][col] = 'P';
				result = true;
			}
			if(userMaze[row-1][col] == 'F'){
				userMaze[row][col] = 'P';
				System.out.println("**************");
				System.out.println("   Success!   ");
				System.out.println("**************");
				
				System.exit(0);
				result = true;
			}
			return result;
			
		case 'A':
			if(userMaze[row][col-1] == '.' && col-1 < userMaze.length){
				userMaze[row][col] = '.';
				col--;
				userMaze[row][col] = 'P';
				result = true;
			}
			if(userMaze[row][col-1] == 'F'){
				userMaze[row][col] = 'P';
				System.out.println("**************");
				System.out.println("   Success!   ");
				System.out.println("**************");
				
				System.exit(0);
				result = true;
			}
				return result;
			
		case 'S':
			if(userMaze[row+1][col] == '.' && row +1 < userMaze.length){
				userMaze[row][col] = '.';
				row++;
				userMaze[row][col] = 'P';
				result = true;
			}
			if(userMaze[row+1][col] == 'F'){
				userMaze[row][col] = 'P';
				System.out.println("**************");
				System.out.println("   Success!   ");
				System.out.println("**************");
				
				System.exit(0);
				result = true;
			}
				return result;

		case 'D':
			if(userMaze[row][col+1] == '.' && col+1 < userMaze.length){
				userMaze[row][col] = '.';
				col++;
				userMaze[row][col] ='P';
				result = true;
			}
			if(userMaze[row][col] == 'F'){
				userMaze[row][col] = 'P';
				System.out.println("**************");
				System.out.println("   Success!   ");
				System.out.println("**************");
				
				System.exit(0);
				result = true;
			}
				return result;

		default:
			System.out.println("Invalid pick from W,A,S,D");
			System.out.println("                         ");
			return result;
		}
		
}
}