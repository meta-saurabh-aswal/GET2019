import java.util.Scanner;

public class LinkedListImpl
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		
		do
		{
			System.out.println("\n Press 1 to ADD a node at the end\n Press 2 to ADD a node after a specific node\n Press 3 to Display the linked list\n Press 4 to Rotate the list\n Press 5 to detect the loop\n Press 0 to EXIT");
		
			char choice = sc.next().charAt(0);
			int data, position;
		
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
				list.printList();
				break;
				
			case '4':
				System.out.println("Enter the position of left node, right node and the roatation value");
				int L = sc.nextInt();
				int R = sc.nextInt();
				int N = sc.nextInt();
			
				list.rotateSublist(L, R, N);
				break;
				
			case '5':
				list.loopDetect();
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
