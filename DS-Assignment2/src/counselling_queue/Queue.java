package counselling_queue;

public interface Queue<type> 
{
	/**
	 * Method to add an element in the queue
	 * @param element
	 */
	void addElement(type element);
	
	/**
	 * Method to delete an element from the queue
	 * @return deleted element
	 */
	type deleteElement();
	
	/**
	 * Method to check whether the queue is empty or not
	 * @return true if queue is empty otherwise false
	 */
	boolean isQueueEmpty();
	
	
	/**
	 * Method to print queue
	 */
	void showQueue();
}
