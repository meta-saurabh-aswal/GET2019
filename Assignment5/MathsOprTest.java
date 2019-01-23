import static org.junit.Assert.*;
import org.junit.Test;

public class MathsOprTest
{
	MathsOpr opr = new MathsOpr();
	
	@Test(expected=AssertionError.class)
	public void testLcmWhenBothInputAreZero()
	{
		int output=opr.lcm(0, 0);
		assertEquals(0,output);
	}
	
	@Test
	public void testLcm()
	{
		int output=opr.lcm(3, 5);
		assertEquals(15,output);
	}

	
	@Test
	public void testHcfWhenEitherInputIsZero()
	{
		int output=opr.hcf(0, 0);
		assertEquals(0,output);
	}
	
	@Test
	public void testHcf()
	{
		int output=opr.hcf(28, 64);
		assertEquals(4,output);
	}
}
