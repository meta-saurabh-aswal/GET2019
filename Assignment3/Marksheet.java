import java.util.*;

/*
Marksheet class is to input the grades (0 to 100) of n students
and calculate the average of all grades, calculate the percentage
of students passed, find the minimum and maximum of all grades.

@author Saurabh Aswal
*/
class Marksheet
{ 
	static int n;					//Total number of Students.
	double grades[];				//Array of grades of the students.
	
	/*
	 * To input the grades and keep them in an array 'grades'.
	 * 
	 * @param x is the number of students of type int.
	 */
	void fillArray(int x)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the grades of students in Positive numbers");
		
		grades = new double[x];
		
		for(int i=0; i<n; i++)
		{
			grades[i] = sc.nextDouble();
		}
		sc.close();					//closing the scanner object.
	}
	
	/*
	 * To calculate the average grades from the array 'grades'.
	 * 
	 * @return average of grades of n students as type double.
	 */
	double avgGrades()
	{
		double totalGrades = 0;
		
		for(int i=0; i<n; i++)
		{
			totalGrades+=grades[i];
		}
		return (totalGrades/n);
	}
	
	/*
	 * To find the minimum of all the grades.
	 * 
	 * @return minimum of all the grades as type double.
	 */
	double minGrades()
	{
		double min = 100;					//Initializing minimum with maximum value for comparison.
		
		for(int i=0; i< n; i++)
		{
			if(grades[i] < min)
				min = grades[i];
		}
		return min;
	}
	
	/*
	 * To find the maximum of all the grades.
	 * 
	 * @return maximum of all the grades as type double.
	 */
	double maxGrades()
	{
		double max = 0;					//Initializing maximum with the lowest value for comparison.
		
		for(int i=0; i< n; i++)
		{
			if(grades[i] > max)
				max = grades[i];
		}
		return max;
	}
	
	/*
	 * To calculate the percentage of total students passed.
	 * 
	 *  @return percentage of students passed as type double.
	 */
	double passPercent()
	{
		int count = 0;					//For counting the number of students passed.
		
		for(int i =0; i<n; i++)
		{
			if(grades[i] >= 40)
				count++;
		}
		return (100*count/n);
	}
	
	
	public static void main(String args[])
	{
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the total number of students");
		n = sc1.nextInt();				//Input total number of students.
		 
		Marksheet mark = new Marksheet();
		mark.fillArray(n);
		
		System.out.println("\nAverage grades : "+ mark.avgGrades() + "\nMinimum grade : "+ mark.minGrades() + "\nMaximum Grade : "+ mark.maxGrades() + "\nPercentage of students passed : "+mark.passPercent() +"%");
		sc1.close();
	}
}
