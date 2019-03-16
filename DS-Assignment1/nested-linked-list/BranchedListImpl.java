import java.util.Scanner;

public class BranchedListImpl
{
	public static int[] inputArray(int arraySize)
	{
		Scanner sc = new Scanner(System.in);
		int array[] = new int[arraySize];
		
		for(int i=0; i<arraySize; i++)
		{
			array[i] = sc.nextInt();
		}
		
		return array;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		LinearList list = new LinearList();

		do
		{
			System.out.println("\n Press 1 to ADD a node at the end\n Press 2 to ADD a node after a specific node\n Press 3 to add a list\n Press 4 to Display the linked list\n Press 5 to add a list to a position\n Press 6 to add from a JSON file\n Press 0 to EXIT");
		
			char choice = sc.next().charAt(0);
			int data, position, arraySize;
		
			switch(choice)
			{
			case '1':
				System.out.println("Enter the value of the node");
				data = sc.nextInt();
			
				list.addAtEnd(data);
				break;
				
			case '2':
				System.out.println("Enter the position and value of the node");
				position = sc.nextInt();
				data = sc.nextInt();
				
				list.addNodeAfter(position, data);
				break;
				
			case '3':
				System.out.println("Enter the size of the array");
				arraySize = sc.nextInt();
				System.out.println("Enter the array values");

				list.addFullList(inputArray(arraySize));
				break;
				
			case '4':
				list.printList();
				break;
				
			case '5':
				System.out.println("Enter the position of the array");
				position = sc.nextInt();
				
				System.out.println("Enter the size of the array");
				arraySize = sc.nextInt();
				
				System.out.println("Enter the array values");				
				list.addListAt(position, inputArray(arraySize));
				
				break;
				
			case '6':
				list.addJsonList();
				break;
				
			case '0':
				System.exit(0);
				
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}while(true);
	}

}
