package unique_characters;

import java.util.Scanner;

public class UniqueCharImpl
{
	public static void main(String args[])
	{
		UniqueChar statement = new UniqueChar();
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);	
			
			System.out.println("\n Enter 1 to enter the String\n Enter 0 to exit");
			char choice;
			choice = sc.nextLine().charAt(0);
			
			switch(choice)
			{
			case '1':
				System.out.println("Enter the String");
				String input = sc.nextLine();
				int unique = statement.checkString(input);
				System.out.println(unique);
				break;
				
			case '0':
				System.exit(0);
				break;
				
			default:
					System.out.println("Invalid choice");
					break;
			}
		}
		
		
	}

}
