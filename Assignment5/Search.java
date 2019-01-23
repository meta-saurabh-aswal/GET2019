/*
 * Search class to search an element in the array using Linear or Binary search.
 * 
 */
class Search
{
/*
 * linear method to perform Linear search in the array.
 * 
 * @param array of numbers to traverse arr[] as int.
 * @param element to search x as int.
 * @param index as int to iterate over the array.
 * @return position of the element as int.
 */
	int linear(int arr[], int x, int index)
	{
		if(x == arr[index])
			return index+1;

		if(index == arr.length-1)
			return -1;
		else
		return linear(arr, x, index+1);
	}
	
	/*
	 * Method to perform binary searching in the array.
	 * 
	 * @param array of numbers arr as int.
	 * @param element to search x as array.
	 * @param front and rear as int for determining the
	          length of the array which needs to be searched.
	   @return position of the array as int.
	 */
       
	int binary(int arr[], int x, int front, int rear)
	{		
		if(front<=rear)
	  {
		int mid = front + (rear - front)/2;
		
		if(x == arr[mid])
			return mid+1;
		
		else if(x < arr[mid])
		{
			return binary(arr, x, front, mid-1 );
		}
		
		else
		{
			return binary(arr, x, mid+1, rear);
		}
	  }
		else
			return -1;

	}
}