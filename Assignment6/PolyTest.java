import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class PolyTest
{
	
	@Test
	public void testAdd()
	{		
		int[] power1 = new int[]{ 4, 5, 6, 3};
		int [] coeff1 = new int[]{2, 3, 4, 5};
		
		int[] power2 = new int[]{ 4, 5, 2, 3};
		int [] coeff2 = new int[]{3, 4, 4, 6};
		
		Poly p1 = new Poly(coeff1, power1);
		Poly p2 = new Poly(coeff2, power2);
		
		Poly exp = new Poly(new int[]{5, 7, 8, 11}, new int[] {4, 5, 6, 3});
		Poly result = p1.add(p1, p2);
		
		assertEquals(true, Arrays.equals(result.coeff, exp.coeff));
	}

	@Test
	public void test2Degree()
	{
		int[] power = new int[]{ 4, 5, 6, 3};
		int [] coeff = new int[]{2, 3, 4, 5};
		
		Poly exp = new Poly(coeff, power);
		int result = exp.degree();

		assertEquals(6, result);
	}
	
	@Test
	public void test3Evaluate()
	{
		int[] power = new int[]{ 4, 5, 6, 3};
		int [] coeff = new int[]{2, 3, 4, 5};
		
		Poly exp = new Poly(coeff, power);
		int result = exp.evaluate(2);

		assertEquals(424, result);
	}
	
	@Test
	public void test4Multiply()
	{
		int[] power = new int[]{ 4, 5};
		int [] coeff = new int[]{2, 3};
		Poly p1 = new Poly(coeff, power);
		Poly p2 = new Poly(coeff, power);
		
		Poly expected = new Poly(new int[]{4, 12, 9}, new int[]{8, 9, 10});
		Poly result = p1.multiply(p1, p2);
		assertEquals(true, Arrays.equals(result.coeff, expected.coeff));;
	}
}
