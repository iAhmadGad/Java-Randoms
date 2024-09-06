import java.util.Scanner;

/**
 * Guess Number
 * @author iAhmadGad
 *
 */

public class Main
{
	public static Scanner scanner = new Scanner(System.in);

	public GuessNumber()
	{
		System.out.print("- Guess Number by @iAhmadGad -\nEnter min and max number(space separeted): ");
		int min = scanner.nextInt(), max = scanner.nextInt();
		int random = (int) (min + (Math.random() * ((max - min) + 1)));
		System.out.print("Guess the number: ");
		int guess;
		do
		{
			guess = scanner.nextInt();
			if(guess < random) System.out.print("The number is higher, guess again: ");
			else if(guess > random) System.out.print("The number is lower, guess again: ");
		}
		while(guess != random);
		System.out.println("You are right ^^ the number is " + random);
	}
	
	public static void main(String[] args)
	{
		boolean run = true;
		while(run)
		{
			new GuessNumber();
			System.out.print("run - Guess Number - again? (y/n): ");
			String s = scanner.next();
			if(s.compareTo("y") != 0) run = false;
		}
		System.exit(0);
	}
}
