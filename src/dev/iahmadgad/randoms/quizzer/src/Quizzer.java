import java.util.Scanner;

/**
 * Simple Quiz
 * @author iAhmadGad
 *
 */

public class Quizzer
{
	public static Scanner scanner = new Scanner(System.in);

	public Quizzer()
	{
		System.out.print("- Quizzer by @iAhmadGad --- \n");
		String input = scanner.nextLine(); 
		int mistakes = 0;
		for (int i = 0; i < qna[0].length; i++) 
		{
			// Print the question and its answers, then read the input answer
			System.out.println(qna[0][i] + qna[1][i]);
			input = scanner.nextLine(); 
				
			// If the input answer is right continue to the next question
			if (input.compareTo(qna[2][i]) == 0)
			{
				System.out.println("True!");	
			}
				
			// If the input answer is wrong it decrease i by 1 to reprint the same question & increase mistakes by 1
			else 
			{
				System.out.println("Wrong! try again");
				i--;
				mistakes++;
			}
		}
			
		// Print the number of mistakes
		System.out.println("Congrats! You've passed the quiz. \nmistakes: " + mistakes);
	}
	
	public static String[][] qna =
	{
		//The 1st row includes the questions
		{"Who discovered the gravity?", "Who wrote les miserables?", "Who is the current king of saudi arabia?"},
			
		//The 2nd row includes the given answers
		{"\n1. Einestein \n2. Buhr \n3. Newton \n4. Coulomb",
		 "\n1. Victor Hugo \n2. Kafka \n3. Dostoevsky \n4. George Orwell", 
		 "\n1. Muhammed ibn saud \n2. King Abdulaziz \n3. King Faisal \n4. King Salman"},
			
		//The 3rd row includes the right answer number of each question
		{"3", "1", "4"}	
	};
	
	public static void main(String[] args)
	{
		boolean run = true;
		while(run)
		{
			new Quizzer();
			System.out.print("run - Quizzer - again? (y/n): ");
			String s = scanner.next();
			if(s.compareTo("y") != 0) run = false;
		}
		System.exit(0);
	}
}