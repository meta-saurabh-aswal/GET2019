/*
 * MathsOpr class to calculate LCM and HCF of two numbers using Recursion.
 * MathsOprTest using JUnit to test the methods with test cases.
 * 
 * @author Saurabh Aswal
 */

class MathsOpr
{
	/*
	 * lcm method to calculate the LCM of two numbers.
	 * 
	 * @param x & y as integers.
	 * @return LCM of both the numbers as int.
	 */
	int lcm(int x, int y)
	{
		int hcf=hcf(x, y);				//Calculating HCF first.
		
		if(hcf==0)
		{
			throw new AssertionError();
		}
			return (x*y/hcf);			//Using LCM*HCF = x*y
	}
	
	/*
	 * hcf method to calculate the HCF of two numbers using Euclid's algo.
	 * 
	 * @param x and y as int.
	 * @return HCF of both the numbers as int.
	 */
	int hcf(int x, int y)
	{
		if(x == 0)						//Euclid's algo.
			return y;
		
		return hcf(y%x, x);
	}
}