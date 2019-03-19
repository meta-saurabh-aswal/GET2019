package circular_queue;

//Queue interface defined with the following operations
public interface Queue
{
	//to add the data at the end of the list
	public void Enqueue(int data) throws Exception;
	
	//to delete the data from the start of the queue
	public int  Dequeue() throws Exception;
	
	//to check whether queue is empty or not
	public boolean isEmpty();
	
	//to check whether queue is full or not
	public boolean isFull();
	
	//to make the queue circular
	public void makeCircular();
	
}