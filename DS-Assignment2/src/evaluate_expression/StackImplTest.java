package evaluate_expression;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackImplTest
{
	@Test
	public void testCase1() throws Exception
	{
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		assertEquals(20, evaluateExpression.evaluate("5 4 *"));
	}
	
	@Test
	public void testCase2() throws Exception
	{
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		assertEquals(-4, evaluateExpression.evaluate("2 3 1 * + 9 -"));
	}
	
	@Test
	public void testCase3() throws Exception
	{
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		
		Assertions.assertThrows(Exception.class, () -> evaluateExpression.evaluate("2 3 1 * + 9 @"));
	}
}
