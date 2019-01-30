/*
 * Poly class to take polynomial expressions as input and operation on them.
 * Operatrions include addition, multiplication, evaluation with a value
 *  and finding the degree of a polynomial.
 *  
 *  @author Saurabh Aswal
 */

final class Poly
{
	//Global arrays for holding coefficients and their respective powers.
	final int coeff[], power[];
	
	/*
	 * Constructor of Poly class which takes integer arrays consisting
	 * of coefficient and power of the polynomial.
	 * 
	 * Assumption: No repeated value exist in the array with the same power.
	 * No element with 0 coefficient is inserted in the array.
	 * 
	 * @param x as int array for holding the coefficients.
	 * @param y as int array for holding the powers.
	 */
	
	Poly(int[]x, int[]y)				//x for array of coefficient and y for array of powers.
	{
		
		//Sorting the polynomial with w.r.t. their power.
		
		for(int i=0; i<y.length-1; i++)
		{
			for(int j=0; j<y.length-i-1; j++)
			{
				if(y[j]>y[j+1])				//Swapping power
				{
					int temp = y[j];
					y[j] = y[j+1];
					y[j+1] = temp;
					
					temp = x[j];			//Swapping coefficients w.r.t power.
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
			
		}
		//copying the sorted arrays to the global arrays of coefficient and power.
		this.coeff = x;	
		 this.power = y;
	}
	
	/*
	 * Method to remove elements with 0 coefficients after operations.
	 * 
	 * @param p as int array for powers.
	 * @param c as int array as coefficients.
	 * @return an object of class Poly with coefficients and power array as input.
	 */
	Poly filterArray(int []c, int[] p)
	{
		int count = 0;
		
		//Counting the number of non zero elements to determine the length of the resulting arrays.
		for(int i=0; i<c.length; i++)
		{
			if(c[i]!=0)
				count++;
		}
		
		int[] arrPower = new int[count];
		int[] arrCoeff = new int[count];
		int Itr = 0;				//To keep track of the resulting array.
		
		for(int i=0; i<c.length; i++)
		{
			//When coefficients are not equal to zero, copy them in the resultant array. 
			if(c[i] != 0)
			{
				arrPower[Itr] = p[i];
				arrCoeff[Itr] = c[i];
			}
		}
		
		return (new Poly(arrCoeff, arrPower));
	}
	
	/*
	 * Method to calculate the degree of the polynomial.
	 * 
	 * @return degree as integer.
	 */
	int degree()
	{		
		return power[power.length-1];				//Last element of sorted power array is the degree.
	}
	
	/*
	 * To evaluate the expression with a the value of x.
	 * 
	 * @param x as integer.
	 * @return the value of the polynomial with the value of x as int.
	 */
	int evaluate(double x)
	{
		double value = 0;
		
		for(int i=0; i<power.length; i++ )
		{
			//If power is not zero, raise x to that power.
			if(power[i] != 0)
			{			
				value += Math.pow(x, power[i])*coeff[i];
			}
			else if(power[i] ==0)
			{
				value += coeff[i];
			}
		}
		return (int)value;
	}
	
	/*
	 * To add two polynomials.
	 * 
	 * @param p1 and p2 of Poly type.
	 * @return resulting object of Poly class after additon.
	 */
	Poly add(Poly p1, Poly p2)
	{
		//Finding the maximum degree for addition to set the size of resultant arrays.
		int topDegree = (p1.degree() >= p2.degree())? p1.degree()+1: p2.degree();
		
		int sumCoeff[] = new int[topDegree+1];			//To store sum of coefficients of with same power.
		int sumPow[] = new int[topDegree+1];			//To store the powers covered.
		
		for(int i=0; i<p1.coeff.length; i++)
		{
			for(int j = 0; j<p2.coeff.length; j++)
			{
				if(p1.power[i] == p2.power[j])
				{
					sumCoeff[p1.power[i]] = p1.coeff[i] + p2.coeff[j];
					sumPow[p1.power[i]] = p1.power[i];
					break;
				}
			}
		}
		//filterArray to remove elements with 0 coefficients.
		return (filterArray(sumCoeff, sumPow));
		
	}
	
	/*
	 * To multiply two polynomials.
	 * 
	 * @param p1 and p2 of Poly type.
	 * @return resulting object of Poly class after multiplication.
	 */
	Poly multiply(Poly p1, Poly p2)
	{
		//Finding the maximum degree for multiplication to set the size of resultant arrays.
		int topDegree = p1.degree() + p2.degree();
		
		int arrPow[] = new int[topDegree+1];
		int arrCoeff[] = new int[topDegree+1];
		
		for(int i = 0; i<p1.coeff.length; i++)
		{
			for(int j=0; j<p2.coeff.length; j++)
			{
				int productCoeff = p1.coeff[i] * p2.coeff[j];			//Resultant coefficient.
				int productPow = p1.power[i] + p2.power[j];			//Resultant power.
				
				//Adding resultant coefficients to the value at arrCoeff[resultant power] to remove duplicacy of powers.
				arrCoeff[productPow] += productCoeff;				
			}
		}
		//To store all the degrees traversed.
		for(int i=0; i<topDegree; i++)
		{
			arrPow[i] = i;
		}
		//filterArray to remove elements with 0 coefficients.
		return filterArray(arrCoeff, arrPow);
	}
	
}