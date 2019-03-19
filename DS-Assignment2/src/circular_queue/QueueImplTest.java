package circular_queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueImplTest
{

	@Test
	public void testCase() throws Exception
	{
		Queue queue = new QueueImpl();
		
		queue.Enqueue(1);
		queue.Enqueue(2);
		
		assertFalse(queue.isEmpty());
		assertFalse(queue.isFull());
	}
	
	@Test
	public void testCase2() throws Exception
	{
		Queue queue = new QueueImpl();
		
		queue.Enqueue(1);
		queue.Enqueue(2);
		queue.Dequeue();
		queue.Dequeue();
		
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
	}	
	
	@Test
	public void testCase3() throws Exception
	{
		Queue queue = new QueueImpl();
		
		queue.makeCircular();
		
		for(int i=0;i<100;i++)
		{
			queue.Enqueue(i);
		}
		
		queue.Dequeue();
		
		
		assertFalse(queue.isFull());
	}

}
