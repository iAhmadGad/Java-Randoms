import java.util.Scanner;

/**
 * Tic Tac Toe
 * @author Ahmad Asaad
 *
 */

public class Main 
{
	public static Scanner scanner = new Scanner(System.in);
	
	public static char cells[] = new char[9];
	
	public TicTacToe()
	{
		for(byte i = 0; i < 9; i++) cells[i] = (char) (i + 49);
		System.out.print("- Tic Tac Toe by @iAhmadGad -\nEnter mode (singleplayer: s / multiplayer: m): ");
		char mode;
		do
		{
		mode = scanner.next().charAt(0);
		}
		while(mode != 's' && mode != 'm');
		byte round = 1;
		
		// Singleplayer mode
		if(mode == 's')
		{
			char player, computer;
			do {
			System.out.print("X or O? ");
			player = scanner.next().charAt(0);
			}
			while(player != 'X' && player != 'O');
			computer = (player == 'X') ? 'O' : 'X';
			do
			{
				System.out.println(getBoard());
				byte cell;
				if(round == 1 || round % 2 != 0) 
				{
					do
					{
					System.out.print(player + ": ");
					cell = scanner.nextByte();
					}
					while(cell < 1 || cell > 9 || cells[cell - 1] == 'X' || cells[cell - 1] == 'O');
					cells[cell - 1] = player;
				}
				else
				{
					do
					{
					cell = (byte) (1 + Math.random() * 9);
					}
					while(cells[cell - 1] == 'X' || cells[cell - 1] == 'O');
					System.out.println(computer + ": " + cell);
					cells[cell - 1] = computer;
				}
				System.out.println();
				round++;
			}
			while(getWinner() == -1);
		}
		
		// Multiplayer mode
		else if(mode == 'm')
		{
			do
			{
				System.out.println(getBoard());
				char player = '0';
				byte cell;
				if(round == 1 || round % 2 != 0) player = 'X';
				else player = 'O';
				do
				{
				System.out.print(player + ": ");
				cell = scanner.nextByte();
				}
				while(cell < 1 || cell > 9 || cells[cell - 1] == 'X' || cells[cell - 1] == 'O');
				cells[cell - 1] = player;
				round++;
			}
			while(getWinner() == -1);
		}
		System.out.println(getBoard());
		if(getWinner() == 1) System.out.println("X wins!");
		else if(getWinner() == 2) System.out.println("O Wins!");
		else System.out.println("Draw ')");
	}
	
	public static String getBoard()
	{
		String board = "" + cells[0] + " " + cells[1] + " " + cells[2] + "\n" 
	                      + cells[3] + " " + cells[4] + " " + cells[5] + "\n"
			              + cells[6] + " " + cells[7] + " " + cells[8];
		return board;
	}
	
	public static char[][] divideBoard()
	{
		char[][] divided = 
		{       
				// Rows
				{cells[0], cells[1], cells[2]},
				{cells[3], cells[4], cells[5]},
				{cells[6], cells[7], cells[8]},
				// Columns
				{cells[0], cells[3], cells[6]},
				{cells[1], cells[4], cells[7]},
				{cells[2], cells[5], cells[8]},
				// Diagonals
				{cells[0], cells[4], cells[8]},
				{cells[2], cells[4], cells[6]}
		};
		return divided;
	}
	
	public static byte getWinner()
	{
		char[][] dividedBoard = divideBoard();
		for(byte i = 0; i < 8; i++)
		{
			if(dividedBoard[i][0] == dividedBoard[i][1] && dividedBoard[i][1] == dividedBoard[i][2]) return (byte) ((dividedBoard[i][0] == 'X') ? 1 : 2);
		}
		if(isDraw()) return 0;
		return -1;
	}
	
	public static boolean isDraw()
	{
		for(byte i = 0; i < 9; i++)
		{
			if(Character.isDigit(cells[i])) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		boolean run = true;
		while(run)
		{
			new TicTacToe();
			System.out.print("run - Tic Tac Toe - again? (y/n): ");
			String s = scanner.next();
			if(s.compareTo("y") != 0) run = false;
		}
		System.exit(0);
	}
}
