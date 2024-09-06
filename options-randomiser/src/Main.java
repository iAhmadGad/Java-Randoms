import java.util.Scanner;

/**
 * Options Randomiser
 * @author iAhmadGad
 *
 */

public class Main
{
	public static Scanner scanner = new Scanner(System.in);
	
	public OptionsRandomiser()
	{
		System.out.print("- Options Randomiser by @iAhmadGad -\nEnter number of options: ");
		short n = scanner.nextShort();
		System.out.print("Enter options (space-separated): ");
		String options[] = new String[n];
		for(short i = 0; i < n; i++) options[i] = scanner.next();
		System.out.println("result: " + options[(short)(Math.random() * n)]);
	}
	
	public static void main(String[] args)
	{
		boolean run = true;
		while(run)
		{
			new OptionsRandomiser();
			System.out.print("run - Options Randomiser - again? (y/n): ");
			String s = scanner.next();
			if(s.compareTo("y") != 0) run = false;
		}
		System.exit(0);
	}
}
