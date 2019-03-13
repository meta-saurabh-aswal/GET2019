package priority_queue;

import java.util.Scanner;

public class PriorityQueueImpl
{
	
	public static void main(String args[])
	{
		PriorityQueue pq = new PriorityQueue();
		
		while(true)
		{
			System.out.println(" Press 1 to add element\n Press 2 to remove element with highest priority\n Press 3 to Display the queue\n Press 0 to exit");
			
			Scanner sc = new Scanner(System.in);
			char choice = sc.next().charAt(0);
			
			switch(choice)
			{
			case '1':
				String data = sc.next();
				int priority = sc.nextInt();
				pq.enQueue(data, priority);
				break;
				
			case '2':
				pq.deQueue();
				break;
				
			case '3':
				pq.displayQueue();
				break;
				
			case '0':
				System.exit(0);
			}
		}
	}

}

