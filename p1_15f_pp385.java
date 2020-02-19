/*
 * Parash Patel
 * UCID: 31265329
 */

//Import statements
import java.util.Scanner;

/*
 * URL Detector DFA
 */
public class p1_15f_pp385
{
	public static void main(String[] args)
	{
		String response; // Holds the users response on entering another string
		String input; // Holds the users string input
		
		// Create a Scanner Object
		Scanner keyboard = new Scanner(System.in);
		
		// Print information for the user
		System.out.println("Welcome to the URL Detector!");
		System.out.println("Would you like to enter a string? (y/n)");
		response = keyboard.nextLine();
		
		// Start the DFA
		do
		{	
			if(response.compareToIgnoreCase("y") == 0)
			{
				System.out.println("Please enter the string...");
				input = keyboard.nextLine();
				System.out.println("You entered: " + input);
				
				int count = 0;
				int s1 = 0; // Holds the first set value
				char s2 = '.'; // Holds the second set value
				int s3 = 0; // Holds the third set value
				String state = ""; // Holds the current state value
				boolean tf = false; // Holds end state
				
				// Start state
				if(input.charAt(0) == 'w' && 
				   input.charAt(1) == 'w' && 
				   input.charAt(2) == 'w' &&
				   input.charAt(3) == '.')
				{
					state = "q1";
				}
				else if(input.charAt(0) >= 'a' && input.charAt(0) <= 'z')
				{
					state = "q2";
				}
				else
				{
					state = "q5";
				}
				
				for (int i = 0; i < input.length(); i++) 
				{
					char value = input.charAt(i);
					
					// State q1
					if(state.compareToIgnoreCase("q1") == 0)
					{
						if(value == 'w')
						{
							System.out.println("State: q1\tCharacter: " + value);
							s1++;
							if(s1==3)
							{
								state = "q1_1";
							}
						}
					}
					else if(state.compareToIgnoreCase("q1_1") == 0)
					{
						if(value == '.')
						{
							System.out.println("State: q1\tCharacter: " + value);
							s1++;
							if(s1==4)
							{
								state = "q2";
							}
						}
					} // End State q1
					
					// State q2
					else if(state.compareToIgnoreCase("q2") == 0)
					{
						if(value >= 'a' && value <= 'z')
						{
							System.out.println("State: q2\tCharacter: " + value);
							count++;
						}
						else if(value==s2 && count>0)
						{
							System.out.println("State: q3\tCharacter: " + value);
							state = "q3";
						}
						else
						{
							System.out.println("State: q5\tCharacter: " + value);
							state = "q5";
						}
					} // End State q2
					
					// State q3
					else if(state.compareToIgnoreCase("q3") == 0)
					{
						if(value == 'c' && s3 == 0)
						{
							System.out.println("State: q3\tCharacter: " + value);
							s3++;
						}
						else if(value == 'o' && s3 == 1)
						{
							System.out.println("State: q3\tCharacter: " + value);
							s3++;
						}
						else if(value == 'm' || value == '.' && s3 == 2)
						{
							System.out.println("State: q3\tCharacter: " + value);
							s3++;
							tf = true;
						}
						else if(value == 'u' && s3 == 3)
						{
							System.out.println("State: q3\tCharacter: " + value);
							s3++;
							tf = false;
						}
						else if(value == 'k' && s3 == 4)
						{
							System.out.println("State: q3\tCharacter: " + value);
							tf = true;
						}
						else
						{
							System.out.println("State: q5\tCharacter: " + value);
							state = "q5";
							tf = false;
						}
					} // End State q3
					
					// State q5 (Trap State/End State)
					else if(state.compareToIgnoreCase("q5") == 0)
					{
						System.out.println("State: q5\tCharacter: " + value);
						tf = false;
					} // End State q5
				}
				if(tf==true)
				{
					System.out.println("Final state is q4.");
					System.out.println("The DFA accepts the string!");
				}
				else
				{
					System.out.println("Final state is " + state + ".");
					System.out.println("The DFA rejects the string!");
				}
			}
			else if(response.compareToIgnoreCase("n") == 0)
			{
				System.out.println("Program Terminated!");
				System.exit(0);
			}
			
			System.out.println("Would you like to enter a string? (y/n)");
			response = keyboard.nextLine();
		}while(response.compareToIgnoreCase("y") == 0);
		System.out.println("Program Terminated!");
		System.exit(0);
	}
} // End of Program
