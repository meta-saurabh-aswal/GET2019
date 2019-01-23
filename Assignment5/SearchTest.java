import static org.junit.Assert.*;
import org.junit.Test;

public class SearchTest
{
	Search sr = new Search();
	
	@Test
	public void test1Linear()
	{
		int []arr = new int[]{10, 20, 35, 40, 21, 3};
		int result = sr.linear(arr, 20, 0);
		assertEquals(2, result);
	}
	
	@Test
	public void test2Linear()
	{
		int []arr = new int[]{11, 1, 35, 28, 20, 3, 8};
		int result = sr.linear(arr, 3, 0);
		assertEquals(6, result);
	}
	
	@Test
	public void test3Linear()
	{
		int []arr = new int[]{15, 28, 31, 40, 45, 62, 63};
		int result = sr.linear(arr, 29, 0);
		assertEquals(-1, result);
	}
	
	@Test
	public void test1Binary()
	{
		int []arr = new int[]{10, 20, 35, 40, 60, 62};
		int result = sr.binary(arr, 60, 0, 6);
		assertEquals(5, result);
	}
	
	@Test
	public void test2Binary()
	{
		int []arr = new int[]{15, 28, 29, 40, 45, 62, 63};
		int result = sr.binary(arr, 29, 0, 7);
		assertEquals(3, result);
	}
	
	@Test
	public void test3Binary()
	{
		int []arr = new int[]{15, 28, 31, 40, 45, 62, 63};
		int result = sr.binary(arr, 29, 0, 7);
		assertEquals(-1, result);
	}
	
}
