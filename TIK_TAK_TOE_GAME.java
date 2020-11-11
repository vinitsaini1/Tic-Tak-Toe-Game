import java.util.*;
// Copyrights--Vinit Saini
public class TIK_TAK_TOE_GAME {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args)
	{
		// The basic Layout of the Tic-Tak-Toe Board
		char[] [] gameBoard = {
							   {' ', '|' , ' ', '|', ' '},
							   {'-', '+' , '-', '+', '-'},
							   {' ', '|' , ' ', '|', ' '},
				                           {'-', '+' , '-', '+', '-'},
				                           {' ', '|' , ' ', '|', ' '}
				      };
		
		printGameBoard(gameBoard);
		
		
		while(true) {
			//Taking the input parameters
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placements ( 1 - 9) : ");
			int playerPos = scan.nextInt();
			
			while(playerPositions.contains(playerPos)||cpuPositions.contains(playerPositions))
			{
				playerPos = scan.nextInt();
			}
			
			PlacePiece(gameBoard,playerPos,"player");
			
			String result = checkWinner();
			if(result.length() > 0)
			 {
				 System.out.println(result);
				 break;
			 }
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while(playerPositions.contains(cpuPos)||cpuPositions.contains(cpuPos))
			{
				cpuPos = rand.nextInt(9) + 1;
				//PlayerPos = scan.nextInt();
			}
			
			
			PlacePiece(gameBoard,cpuPos,"cpu");
			
			printGameBoard(gameBoard);
			 result = checkWinner();
			 if(result.length() > 0)
			 {
				 System.out.println(result);
				 break;
			 }
			System.out.println(result);
			
		}
		
}
	
	                   // Outside Main Method
	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row : gameBoard)
		{
			for(char c  : row)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void PlacePiece(char[][] gameBoard,int pos,String user)
	{
		// We have 2 players on is the user and other one is cpu.
		char symbol = ' ';
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		}
		else if(user.equals("cpu"))
				{
			symbol = 'O';
			cpuPositions.add(pos);
		}
		switch(pos) {
		case 1: 
			gameBoard[0][0] = symbol;
			break;
		case 2: 
			gameBoard[0][2] = symbol;
			break;
		case 3: 
			gameBoard[0][4] = symbol;
			break;
		case 4: 
			gameBoard[2][0] = symbol;
			break;
		case 5: 
			gameBoard[2][2] = symbol;
			break;
		case 6: 
			gameBoard[2][4] = symbol;
			break;
		case 7: 
			gameBoard[4][0] = symbol;
			break;
		case 8: 
			gameBoard[4][2] = symbol;
			break;
		case 9: 
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
}
	}
	
	public static String checkWinner() {
		// Checking for the three rows if they are matched
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		
		// Checking for the three Columns if they are matched
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		
		// Checking for the two diagonals if they are matched
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(3, 5, 7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning)
		{
			if(playerPositions.containsAll(l))
			{
				return "Congratulations you won!!. Well Played";
			}
			else if(cpuPositions.containsAll(l))
			{
				return "You Lost, Try Again :(";
			}
			else if(playerPositions.size() + cpuPositions.size()==9)
			{
				return "Its a Draw !!!";
			}
		}
		return ""; 
	}
//--Copyrights--Vinit Saini
}
