import static org.junit.Assert.*;

import org.junit.Test;


public class ArrOperationsTest {
	ArrOperations arrop = new ArrOperations();
	
	@Test
	public void test1MaxMirror()
	{
		int[] arr = new int[] {1, 2, 3, 8, 9, 3, 2, 1};
		int result = arrop.maxMirror(arr);
		assertEquals(3, result);
	}
	
	@Test
	public void test2MaxMirror()
	{
		int [] arr = new int[]{7, 1, 4, 9, 7, 4, 1};
		int result = arrop.maxMirror(arr);
		assertEquals(3, result);
	}
	
	@Test
	public void test3MaxMirror()
	{
		int [] arr = new int[]{1, 4, 5, 3, 5, 4, 1};
		int result = arrop.maxMirror(arr);
		assertEquals(7, result);
	}
	
	@Test(expected = NullPointerException.class)
	public void test0MaxMirror()
	{
		int result = arrop.maxMirror(null);
		assertEquals(null, result);
	}
	
	@Test
	public void test1Clumps()
	{
		int[] arr =new int[]{1,1,2,3,3,3,5};
		int result=arrop.clumps(arr);
		assertEquals(2,result);
	}
	
	@Test
	public void test2Clumps()
	{
		int[] arr =new int[]{1, 1, 1, 1, 1};
		int result=arrop.clumps(arr);
		assertEquals(1,result);
	}
	
	@Test
	public void test3Clumps()
	{
		int[] arr =new int[]{1, 1, 2, 1, 1};
		int result=arrop.clumps(arr);
		assertEquals(2,result);
	}
	
	@Test(expected = NullPointerException.class)
	public void test0Clumps()
	{
		int result = arrop.clumps(null);
		assertEquals(null, result);
	}
	
	@Test
	public void test1fixXY()
	{
		int arr[] = new int[]{5, 4, 9, 4, 9, 5};
		int result[] = arrop.fixXY(arr, 4, 5);
		int expected[] = new int[]{9, 4, 5, 4, 5, 9};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test2FixXY()
	{
		int arr[] = new int[]{1, 4, 1, 5};
		int result[] = arrop.fixXY(arr, 4, 5);
		int expected[] = new int[]{1, 4, 5, 1};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void test3FixXY()
	{
		int arr[] = new int[]{1, 4, 1, 5, 5, 4, 1};
		int result[] = arrop.fixXY(arr, 4, 5);
		int expected[] = new int[]{1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(expected, result);
	}
	
	@Test(expected = NullPointerException.class)
	public void test0FixXY()
	{
		int[] result=arrop.fixXY(null, 2, 3);
		assertArrayEquals(null, result);
	}
	
	@Test
	public void test1SplitArray()
	{
		int arr[] = new int[] {1, 1, 1, 2, 1};
		int result = arrop.splitArray(arr);
		assertEquals(3, result);
	}
	
	@Test
	public void test2SplitArray()
	{
		int arr[] = new int[] {10, 10};
		int result = arrop.splitArray(arr);
		assertEquals(1, result);
	}
	
	@Test
	public void test3SplitArray()
	{
		int arr[] = new int[] {2, 1, 1, 2, 1};
		int result = arrop.splitArray(arr);
		assertEquals(-1, result);
	}
	
	@Test(expected = NullPointerException.class)
	public void test0SplitArray()
	{
		int result=arrop.splitArray(null);
		assertEquals(null, result);
	}

}
