import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LinkedListTest
{
	LinkedList list = new LinkedList();
	
	@Test
	void testRotate()
	{
		int array[] = {23, 34, 45, 56, 67, 78, 89, 90};
		
		list.addFullList(array);
		list.printList();
		list.rotateSublist(2, 6, 4);
		
		int result[] = list.printList();
		int expected[] = {23, 34, 56, 67, 78, 89, 45, 90};
		
		assertEquals(true, Arrays.equals(result, expected));	
	}

	@Test
	void testLoop()
	{
		int array[] = {23, 34, 45, 56, 67, 78, 89, 90};
		
		list.addFullList(array);
		
		int result = list.loopDetect();
		
		assertEquals(-1, result);
	}
}
