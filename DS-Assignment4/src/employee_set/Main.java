package employee_set;

import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Operations opr = new Operations();
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);	
			
			System.out.println("\n Enter 1 to add an employee\n Press 2 to sort naturally\n Press 3 to sort by name\n Press 4 to display the list\n Enter 0 to exit");
			char choice;
			choice = sc.nextLine().charAt(0);
			int id = 0;
			String name = null;
			String address = null;
			
			switch(choice)
			{
			case '1':
				id = sc.nextInt();sc.nextLine();
				name = sc.nextLine();
				address = sc.nextLine();
				opr.addEmployee(id, name, address);
				break;
				
			case '2':
				opr.sortNatural();
				break;
				
			case '3':
				opr.sortByName();
				break;
				
			case '4':
				opr.display();
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
