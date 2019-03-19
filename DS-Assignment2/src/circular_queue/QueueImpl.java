package circular_queue;

public class QueueImpl implements Queue
{
		int front = 0;
		int rear = 0;
		int size = UtilityClass.FIXED_SIZE;
		
		boolean circularFlag = false;
		int[] queue = new int[size];
		
		
		//This method will add the data into the queue
		@Override
		public void Enqueue(int data) throws Exception
		{
			if(circularFlag)
			{
				if(rear == size-1)
					rear = 0;
			}
			if(!isFull())
			{
				queue[rear] = data;
				rear += 1;
			}
			else
				throw new Exception("Queue is Full");
		}

		//This method will delete the data from the queue and returns the deleted value
		@Override
		public int Dequeue() throws Exception
		{
			if(circularFlag)
			{
				if(front == size-1)
					front=0;
			}
			if(!isEmpty())
			{
				return queue[front++];
			}
			else
				throw new Exception("Queue is Empty");
			
		}

		//This method checks whether queue is empty or not
		@Override
		public boolean isEmpty()
		{
			if(rear == front)
				return true;
			
			return false;
		}

		//This method will check whether queue is full or not
		@Override
		public boolean isFull()
		{
			if(circularFlag)
			{
				if(rear == front-1)
					return true;
				
				return false;
			}
			if(rear == size-1 && front == 0)
			{
				return true;
			}
			return false;
		}

		//This will make the queue as circular queue
		@Override
		public void makeCircular()
		{
			circularFlag = true;
		}	
}
