package counselling_queue;

/*
 * Array Representation of Queue (Circular Queue)
 */
public class ArrayQueue <type> implements Queue<type>
{
	private int front = -1;
	private int end = -1;
	private int queueLength = 0;
	private type queueArray[];
	
	ArrayQueue(int size)
	{
		queueArray = (type[]) new Object [size];  //initializes the queue of given size
	}
	
	/**
	 * Method to get queue Length
	 */
	public int getQueueLength()
	{
		return queueLength;
	}
	
	/**
	 * Method to add an element in the Queue
	 * @param element
	 */
	@Override
	public void addElement(type element)
	{
		if(queueLength==queueArray.length)
		{
			throw new AssertionError("Queue is full. Can't add new element.");
		}
		if(end == -1)
		{
			end++;
			front++;
		}
		else if((end+1) % queueArray.length != front)
		{
			end = (end +1) % queueArray.length;
		}
		queueLength++;
		queueArray[end]= element;
		
	}
	
	/**
	 * Method to get front Index
	 */
	public int getFront()
	{
		return front;
	}
	
	
	/**
	 * Method to get Queue AS Array
	 * @return
	 */
	public type[] getQueue()
	{
		return queueArray;
	}
	
	/**
	 * Method to delete an element from the queue
	 * @return deleted element
	 */
	@Override
	public type deleteElement()
	{   
		type deletedElement;
		if(queueLength==0)
		{
			throw new AssertionError("Can't delete element. No such element found.");
		}  
		deletedElement=queueArray[front];
	    
		if(queueLength==1)
		{
			front=end=-1;
		}
		else
		{
			front = (front+1) % queueArray.length;
		}
		queueLength--;
			
		return deletedElement;
	}
	
	
	/**
	 * Method to check whether the Queue is Empty or not
	 * @return true if Queue is empty otherwise false
	 */
	@Override
	public boolean isQueueEmpty()
	{
		if(queueLength==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Method to check whether the Queue is full or not
	 * @return true if Queue is full otherwise false
	 */
	public boolean isQueueFull()
	{
		if((end-front)==queueArray.length-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	/**
	 * Method to print Queue
	 */
	@Override
	public void showQueue()
	{
		if(queueLength == 0)
		{
			throw new AssertionError("Empty Queue!!!");
		}
		for(int i=front;i<=end;i++)
		{
			System.out.print(queueArray[i] +" ");
		}
	}

}
