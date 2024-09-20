import java.util.Scanner;

/**
 * Rock Paper Scissors
 * @author iAhmadGad
 *
 */

public class Main 
{
	public static Scanner scanner = new Scanner(System.in);
	
	public static String options[] = {"scissors", "paper", "rock"};
	
	public Main()
	{
		System.out.print("- Rock Paper Scissors by @iAhmadGad -\nEnter mode and rounds number(singleplayer: s / multiplayer: m - n): ");
		String mode = scanner.next();
		short rounds = scanner.nextShort();
		String name1 = null, name2 = null;
		int points1 = 0, points2 = 0;
		
		// Singleplayer mode
		if(mode.compareTo("s") == 0)
		{
			System.out.print("Your name: ");
			name1 = scanner.next();
			name2 = "Computer";
			
			for(short i = 0 ; i < rounds; i++)
			{
				String option1;
				do
				{
					System.out.print(name1 + ": ");
					option1 = scanner.next();
				}
				while(option1.compareTo("scissors") != 0 && option1.compareTo("paper") != 0 && option1.compareTo("rock") != 0);
				String option2 = options[(byte) (Math.random() * 2)];
				System.out.print("Computer: " + option2);
				
				if((option1.compareTo("scissors") == 0 && option2.compareTo("paper") == 0) 
					|| (option1.compareTo("paper") == 0 && option2.compareTo("rock") == 0) 
					|| (option1.compareTo("rock") == 0 && option2.compareTo("scissors") == 0))
				{
					points1++;
					System.out.println("\n" + name1 + " +1 point!" + "\n");
				}
				else if(option1.compareTo(option2) == 0)
				{
					System.out.println("\nNo one got a point ')" + "\n");
				}
				else
				{
					points2++;
					System.out.println("\nComputer +1 point" + "\n");
				}
				
			}
			
			if(points1 > points2) System.out.println(name1 + " wins!");
			else if(points1 < points2) System.out.println("Computer wins!");
			else System.out.println("Tie ')");
		}
		
		// Multiplayer mode
		else if(mode.compareTo("m") == 0)
		{
			System.out.print("1st player name: ");
			name1 = scanner.next();
			System.out.print("2nd player name: ");
			name2 = scanner.next();
			
			for(short i = 0 ; i < rounds; i++)
			{
				String option1;
				do
				{
					System.out.print(name1 + ": ");
					option1 = scanner.next();
				}
				while(option1.compareTo("scissors") != 0 && option1.compareTo("paper") != 0 && option1.compareTo("rock") != 0);
				
				String option2;
				do
				{
					System.out.print(name2 + ": ");
					option2 = scanner.next();
				}
				while(option2.compareTo("scissors") != 0 && option2.compareTo("paper") != 0 && option2.compareTo("rock") != 0);
				
				if((option1.compareTo("scissors") == 0 && option2.compareTo("paper") == 0) 
					|| (option1.compareTo("paper") == 0 && option2.compareTo("rock") == 0) 
					|| (option1.compareTo("rock") == 0 && option2.compareTo("scissors") == 0))
				{
					points1++;
					System.out.println("\n" + name1 + " +1 point!" + "\n");
				}
				else if(option1.compareTo(option2) == 0)
				{
					System.out.println("\nNo one got a point ')" + "\n");
				}
				else
				{
					points2++;
					System.out.println("\n" + name2 + " +1 point" + "\n");
				}
				
			}
			
			if(points1 > points2) System.out.println(name1 + " wins!");
			else if(points1 < points2) System.out.println(name2 + " wins!");
			else System.out.println("Tie ')");
		}
	}
	
	public static void main(String[] args) 
	{
		boolean run = true;
		while(run)
		{
			new Main();
			System.out.print("run - Rock Paper Scissors - again? (y/n): ");
			String s = scanner.next();
			if(s.compareTo("y") != 0) run = false;
		}
		System.exit(0);
	}
}
