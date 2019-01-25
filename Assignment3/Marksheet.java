import java.util.*;

/*

@author Saurabh Aswal
@version 1.0
@since 20/01/18
*/
class Marksheet
{
	static Scanner sc = new Scanner(System.in);
	static int numStudents;						//numStudents for total number of students.
	int grades[];
	
	void fillArray()
	{
		System.out.println("Enter the marks of students");
		
		grades= new int[numStudents];
		
		for(int i=0; i<numStudents; i++)
		{
			grades[i] = sc.nextInt();
		}
	}
	
	double avgGrades()
	{
		int totalGrades = 0;
		
		for(int i=0; i<numStudents; i++)
		{
			totalGrades+=grades[i];
		}
		return (totalGrades/numStudents);
	}
	
	int minGrades()
	{
		int min = 100;
		
		for(int i=0; i< numStudents; i++)
		{
			if(grades[i] < min)
				min = grades[i];
		}
		return min;
	}
	
	int maxGrades()
	{
		int max = 0;
		
		for(int i=0; i< numStudents; i++)
		{
			if(grades[i] > max)
				max = grades[i];
		}
		return max;
	}
	
	double passPercent()
	{
		int count = 0;
		
		for(int i =0; i<numStudents; i++)
		{
			if(grades[i] >= 40)
				count++;
		}
		return (100*count/numStudents);
	}
	
	
	public static void main(String args[])
	{
		System.out.println("Enter the total number of students");
		numStudents = sc.nextInt();
		 
		 Marksheet mark = new Marksheet();
		mark.fillArray();
		
		System.out.println("\nAverage grades : "+ mark.avgGrades() + "\nMinimum grades : "+ mark.minGrades() + "\nMaximum Grades : "+ mark.maxGrades() + "\nPercentage of students passed : "+mark.passPercent() +"%");
		
	}
}
