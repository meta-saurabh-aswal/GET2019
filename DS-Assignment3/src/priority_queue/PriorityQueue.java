package priority_queue;

public class PriorityQueue
{
	Element queue[] = new Element[10];
	int start = 0;
	int end = 0;
	
	public void enQueue(String data, int priority)
	{
		queue[end] = new Element(data, priority);
		end++;
	}
	
	//Utility
	public void positionMax()
	{
		Element max = new Element(null, 0);
		int index = 0;
		
		for(int i=0; i<end; i++)
		{
			if(queue[i].priority > max.priority)
			{
				max.priority = queue[i].priority;
				max.data = queue[i].data;
				index = i;
			}
		}	
		
		queue[index] = queue[start];
		queue[start] = max;
	}
	
	public void deQueue()
	{
		positionMax();
		
		for(int i=0; i<end-1; i++)
		{
			queue[i] = queue[i+1];
		}
		end--;
	}
	
	public void displayQueue()
	{
		for(int i=0; i<end; i++)
		{
			System.out.println(queue[i].data +"\t"+ queue[i].priority);
		}
	}
}
