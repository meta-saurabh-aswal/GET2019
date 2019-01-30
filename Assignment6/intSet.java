import java.util.ArrayList;
import java.util.Collections;

/*
 * intSet class to take integer array between 1-1000 as input and perform operations on it.
 * Operations are to find if a number is the member of the integer set passed,
 * if another array is a subset of the first array, to get complement of the
 * array passed and to get the union of two arrays.
 * 
 * @author Saurabh Aswal.
 */
final public class intSet
{
	final int uniSet[] = new int[1000];				//Universal set of all integers form 1 to 1000.
	
	final ArrayList<Integer> numSet = new ArrayList<>();			//Array list to store the list of integers passed.
	
	/*
	 * intSet constructor takes an array of integers as input and stores them in numSet list.
	 * universal set from 1-1000 is created in the constructor itself.
	 * 
	 * @param array of integers.
	 */
	intSet(int [] setPassed)
	{
		for (int i=0; i < setPassed.length; i++)
		{
			numSet.add(setPassed[i]);
		}
		
		universalSet();
	}
	
	/*
	 * To create a universal set of integers from 1-1000.
	 */
	void universalSet()
	{
		for(int i=0; i<1000; i++)
		{
			uniSet[i] = i+1;
		}
	}
	
	/*
	 * To check if the element x is a member of the integer array.
	 * 
	 * @param x element as int.
	 * @return true or false regarding the 
	 */
	public boolean isMember(int x)
	{
		for(int i=0; i<numSet.size(); i++)
		{
			if(x == numSet.get(i))
				return true;
		}
		
		return false;
	}
	
	/*
	 * To calculate the size of the array input.
	 * 
	 * @return size of the array as int.
	 */
	public int size()
	{
		return numSet.size();
	}
	
	/*
	 * To check if the array of s is a subset of numSet array.
	 * 
	 * @param object s of class intSet.
	 * @return true or false if the array of s is the subset of numSet or not respectively.
	 */
	public boolean isSubset(intSet s)
	{
		int itr = 0;					//To traverse s.numSet array.
		int sLen = s.numSet.size();
		
		for(int i=0; i < numSet.size(); i++)
		{	
			if(itr < sLen && s.numSet.get(itr).intValue() == numSet.get(i).intValue())			//Comparing value of elements of s.numSet to current numSet.
			{
				itr++;
			}
			else
			{
				if(itr == sLen)				//If all the elements of s.numSet are traversed.
				{
					return true;
				}
				
				itr = 0;				//If any wrong element is found in between, then itr is reseted.
			}
		}
			
		return false;
	}
	
	/*
	 * To find the complement set of the current numSet.
	 * 
	 * @return array of the complement integers.
	 */		
	public int[] getComplement()
	{
		int itr = 0;				//To traverse current numSet.
		int comItr=0;				//To keep track of the array storing complements.
		
		int complement[] = new int[1000 - numSet.size()];

		Collections.sort(numSet);

		for(int i=0; i<1000; i++)			//int i to traverse the universal array.
		{				
			if(itr < numSet.size() && uniSet[i] == numSet.get(itr))
			{
				itr++;
			}
			else
			{
				complement[comItr] = uniSet[i];
				comItr++;
			}
		}
		
		return complement;
	}
	
	/*
	 * To calculate the union of two sets.
	 * 
	 * @param s1 and s2 of intSet class.
	 * @return ArrayList of union of both the arrays.
	 */
	
	public ArrayList<Integer> union(intSet s1, intSet s2)
	{
		boolean numTable[] = new boolean[1001];				//A boolean hash table to check if repeating elements.
		
		int s1Len = s1.numSet.size();
		int s2Len = s2.numSet.size();
		
		ArrayList<Integer> unionArr = new ArrayList<Integer>();
		
		int len = (s1Len > s2Len)? s1Len: s2Len;
		
		for (int i=0; i < len; i++)
		{
			
			if(i < s1Len && !numTable[s1.numSet.get(i).intValue()])
			{
				unionArr.add(Integer.valueOf(s1.numSet.get(i)));
				numTable[s1.numSet.get(i).intValue()] = true;
			}
			if(i < s2Len && !numTable[s2.numSet.get(i).intValue()])
			{
				unionArr.add(Integer.valueOf(s2.numSet.get(i)));
				numTable[s2.numSet.get(i).intValue()] = true;
			}		
		}
		return unionArr;	
	}
}
