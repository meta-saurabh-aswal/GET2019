import java.util.*;

/*
ArrOperations class is to do four operations on an array
Operations:
1. To find the maximum mirror sequence.
2. To split the array into 2 parts such that the sum of the elements
 of both parts is equal.
3. Return the number of clumps in the array, ie. same element occuring
 adjacent to itself.
4. Swap the next element of x value with y value.

The ArrOperationsTest class is being used to test the ArrOperatins classes' methods
using different test cases with anotations and methods provided by JUnit.
*/
public class ArrOperations
{
	
/*
To find the largest mirror sequence in the array.

@param array input as int.
@return the length of largest mirror sequence as int.
*/	
	int maxMirror(int arr[])
	{
		if(arr == null){
			throw new NullPointerException();
		}
		
		int len = arr.length;
		int tempCount = 1;
		int count = 1;
		int[] revArr = new int[len];			//Taking a reverse array for comparing.
		
		for(int i=0; i<len; i++)
		{
			revArr[i] = arr[len-1-i];
		}
		
		for(int i=0; i<len; i++)
		{
			for(int j=0; j<len-1; j++)
			{
				if(arr[i] == revArr[j] && (i+1 >= len-1 ||(arr[i+1] == revArr[j+1])))
				{
					tempCount++;
					i++; 
				}				
			}
			
			if(tempCount > count)			//Storing the largest sequence in count.
			{
				count = tempCount;
				tempCount = 1;			//resetting the value of count.
			}
		}
		return count;
	}
	
/*
To find the number of clumps int the array.

@param array input as int.
@return the total number of clumps as int.
*/
	int clumps(int arr[])
	{
		if(arr == null){
			throw new NullPointerException();
		}
		
		int count=0;
		
		for(int i=1; i < arr.length-1; i++)
		{
			if(arr[i] == arr[i-1] && (arr[i] != arr[i+1]) || i+1 == arr.length-1)		//Checking the current value with its previous and next value to ignore counting the sequence over and over.
			{
				count++;
			}
		}
		return count;
	}
/*
To swap the values of element next to x with y.

@param input int array.
@param values of x and y as int.
@return fixed array as int.
*/
	int[] fixXY(int arr[], int x, int y)
	{
		if(arr == null){
			throw new NullPointerException();
		}
		
		int len = arr.length;
		int flag = 0;
		
		for(int i=0; i<len; i++)
		{
			if(arr[i] == x)
			{
				for(int j=flag; j<len; j++)
				{
					if(arr[j] == y)
					{
						if(j == i+1){
							break;
						}
						else{
							int temp = arr[i+1];
							arr[i+1] = arr[j];
							arr[j] = temp;
							flag = i+2;
						}
					}
				}
			}
		}
		return arr;
	}
/*
To split the array into two parts where the sum of elements of both parts is equal.

@param input array as int.
@return -1 if the array can't be split or index of the splitting point.
*/
	int splitArray(int arr[])
	{
		if(arr == null){
			throw new NullPointerException();
		}
		
		int sumFront = 0;
		int len = arr.length;
		int sumRear = arr[len-1];
		
		for(int i=0; i<len-1; i++)
		{
			sumFront += arr[i];
		}
		
		if((sumFront + sumRear)%2 != 0)				//Checking if not even, i.e. cannot be halved to integers
			return -1;
		
		for(int i=len-2; i>=0; i--) 					//Neglecting the first and the last element by doing -2.
		{
			if(sumFront == sumRear)
				return i+1;							//Returning the index of the split.
			
			if(sumFront > sumRear)
			{
				sumFront -=  arr[i];
				sumRear += arr[i];
			}
			else					//Terminating when the last single element is larger than the sum of the rest of the array. 
				return -1;
		}
		return -1;
	}	

}
