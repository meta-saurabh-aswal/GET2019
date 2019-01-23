import java.util.*;

public class ArrOperations
{
	int maxMirror(int arr[])
	{
		if(arr == null){
			throw new NullPointerException();
		}
		
		int len = arr.length;
		int tempCount = 1;
		int count = 1;
		int[] revArr = new int[len];
		
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
			
			if(tempCount > count)
			{
				count = tempCount;
				tempCount = 1;
			}
		}
		return count;
	}
	
	
	int clumps(int arr[])
	{
		if(arr == null){
			throw new NullPointerException();
		}
		
		int count=0;
		
		for(int i=1; i < arr.length-1; i++)
		{
			if(arr[i] == arr[i-1] && (arr[i] != arr[i+1]) || i+1 == arr.length-1)
			{
				count++;
			}
		}
		return count;
	}
	
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
