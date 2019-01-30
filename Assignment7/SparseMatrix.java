import java.util.*;

/*
 * SparseMatrix class to store the matrix in 2D rcv (row, column, value) array.
 * The rcv array contains only the non zero elements and their index.
 * Operations on the matrix are transpose, addition, multiplication, and complement.
 * 
 * @author Saurabh Aswal
 */
final class SparseMatrix
{
	int matrix[][];
	int [] dimension = new int[2];
	final int row = 0;
	final int col = 1;
	final int val = 2;
	final int totalCols = 3;
	
	public SparseMatrix(int[][] x)
	{
		dimension[row] = x.length;
		dimension[col] = x[0].length;
		int tempMatrix[][] = new int [countElements(x)][totalCols] ;			//To store the non zero rcv of the Sparse matrix.
		 
		int matrixItr=0;
		
		for(int i=0; i<x.length; i++)
		{
			for(int j=0; j<x[0].length; j++)
			{				
				 if(x[i][j] != 0)
				 {
					 tempMatrix[matrixItr][row] = i;
					 tempMatrix[matrixItr][col] = j;
					 tempMatrix[matrixItr][val] = x[i][j];
					 
					 matrixItr++;
					
				 }
			}
			
			this.matrix = tempMatrix;
		}
	}
	 
	/*
	 * To count the number of non zero elements in a sparse matrix.
	 * 
	 * @param Sparse matrix as 2D int array.
	 * @return number of non zero values as count.
	 */
	 int countElements(int [][] arr)
	 {
		 int count = 0;					//For counting the number of non zero elements.
		 
		 for(int i=0; i<arr.length; i++)
		 {
			 for(int j =0; j<arr[0].length; j++)
			 {
				 if(arr[i][j] != 0)
				 {
					 count++;
				 }
			 }
		 }
		 return count;
		 
	 }
	 
	 /*
	  * Utility method to sort a sparse matrix.
	  * 
	  * @param int 2D rcv array.
	  * @return sorted 2D rcv array.
	  * 
	  */
	 int[][] sortSparse(int arr[][])
	 {
		 int temp;
		 
		 for(int i=0; i< arr.length-1; i++)
		 {
			 for(int j=0; j< arr.length-i-1; j++)
			 {
				 
				 if(arr[j][row] > arr[j+1][row])
				 {
					 //Sorting the columns and values w.r.t row index.
					 temp = arr[j][row];
					 arr[j][row] = arr[j+1][row];
					 arr[j+1][row] = temp;
					 
					 temp = arr[j][col];
					 arr[j][col] = arr[j+1][col];
					 arr[j+1][col] = temp;
					 
					 temp = arr[j][val];
					 arr[j][val] = arr[j+1][val];
					 arr[j+1][val] = temp;
				 }
			 }
		 }

		 return arr;
	 }
	 
	 /*
	  * Utility method to convert an arrayList to array.
	  * 
	  * @param rcv arrayList
	  * @return converted 2D rcv array.
	  */
	 int[][] conversion(List<Integer[]> list)
	 {
			int[][] result = new int[list.size()][totalCols];
			
			for(int indexRow = 0; indexRow < list.size(); indexRow++)
			{
				Integer internalArray[] = list.get(indexRow);
				
				for(int indexCol=0; indexCol < totalCols; indexCol++)
				{
					result[indexRow][indexCol] = internalArray[indexCol].intValue();
				}
			}
			return result;
		}
	 
	/*
	 * To find the transpose of a sparse matrix using rcv values.
	 * 
	 * @return 2D array of rcv values of the transposed sparse matrix. 
	 */
	int [][] transpose()
	{
		int [][] transposeMatrix = new int[matrix.length][totalCols];
		
		for(int i =0; i<matrix.length; i++)
		{
			transposeMatrix[i][row] = matrix[i][col];
			transposeMatrix[i][col] = matrix[i][row];
		}

		transposeMatrix = sortSparse(transposeMatrix); 
		
		return transposeMatrix;
	}
	
	/*
	 * To check if both the matrices are symmetric.
	 * 
	 * @return true or false.
	 */
	boolean symmetric()
	{
		if(dimension[row] != dimension[col])
			throw new AssertionError();
		
			int [][] transposeMatrix = transpose();
			
		return Arrays.equals(matrix, transposeMatrix);		
	}
	
	/*
	 * To add two Sparse matrices using their rcv values.
	 * 
	 * @param s1 & s2 as SparseMatrix objects consisting of rcv arrays of each.
	 * @return 2D array of added matrices.
	 */
	int[][] add(SparseMatrix s1, SparseMatrix s2)
	{
		if(s1.dimension[col] != s2.dimension[col] || s1.dimension[row] != s2.dimension[row])
			throw new AssertionError();
		
		List<Integer[]> sparseSum = new ArrayList<Integer[]>();	
		List<Integer> tracedElement = new ArrayList<Integer>();				//To keep track of the elements which are at same index in both matrices.
		int j, sum, rowIndex, colIndex;
		
		for(int i=0; i<s1.matrix.length; i++)
		{
			for(j=0; j<s2.matrix.length; j++)
			{
				//Adding when values of row of s1 and s2 are equal and values of columns of s1 and s2 are equal.
				if(s1.matrix[i][row] == s2.matrix[j][row] && s1.matrix[i][col] == s2.matrix[j][col])
				{
					sum = s1.matrix[i][val] + s2.matrix[j][val];
					rowIndex = s1.matrix[i][row];
					colIndex = s1.matrix[i][col];
					
					sparseSum.add(new Integer[] {rowIndex, colIndex, sum });					
					tracedElement.add(j);					//Marking the object as traced.
					break;
				}				
			}
			//When no same row and column indices are found in both matrices.
			if(j == s2.matrix.length)
			{
				rowIndex = s1.matrix[i][row];
				colIndex = s1.matrix[i][col];
				
				sparseSum.add(new Integer[] {rowIndex, colIndex, s1.matrix[i][val]});
			}
		}
		
		for(int i =0; i<s2.matrix.length; i++)
		{
			if(!(tracedElement.contains(i)))
			{	
				rowIndex = s2.matrix[i][row];
				colIndex = s2.matrix[i][col];
				
				//To add elements other than those with same indices (left out elements).
				sparseSum.add(new Integer[] {rowIndex, colIndex, s2.matrix[i][val]});
				tracedElement.add(i);				//Adding the element in touched list after it has been added to sparseSum.
			}
			
		}
		//Converting the ArrayList to array and then sorting it.
		int [][] converted = sortSparse(conversion(sparseSum));			
		
		return converted;
	}
	
	/*
	 * Method to multiply the rcv arrays of two sparse matrices.
	 * 
	 * @param s1 and s2 of type Sparsematrix consisting of the rcv array of each.
	 * @return the rcv array of the product matrix.
	 */
	public int[][] multiply(SparseMatrix s1, SparseMatrix s2)
	{
		/*
		 * if column of s1 matrix is not equal to row of s2 matrix, then throw assertion error.
		 */
		if(s1.dimension[col] != s2.dimension[row])
		{
			throw new AssertionError("Columns of first must be equal to rows of Second");
		}
		
		List<Integer[]> rcv = new ArrayList<Integer[]>();				//To store the multiplied elements and their index.
		
		for(int i=0; i< s1.matrix.length; i++)
		{
			for(int j=0; j < s2.matrix.length; j++)
			{
				int sumValue = 0;
				
				//Checking if the row of the s1 matrix rcv array is equal to column of s2 matrix rcv array.
				if(s1.matrix[i][col] == s2.matrix[j][row])
				{	
					// multiplying the values if column of first is equal to row of second.
					sumValue = s1.matrix[i][val] * s2.matrix[j][val];								
					
					if(i > 0)
					{
						/*
						 *If the element is not first element in the list, then checking
						 *if the previous element's row and column value are the same as that of the current element.
						 *If true, then adding the current product value with the old value, and removing the old value (to avoid duplicacy).
						 *If false, then simply add the rcv array to the list.
						 */
						int oldRow = rcv.get(rcv.size()-1)[row];															
						int oldCol = rcv.get(rcv.size()-1)[col];
						
						if(s1.matrix[i][row] == oldRow && s2.matrix[j][col] == oldCol )
						{
							int oldValue = rcv.get(rcv.size()-1)[val];
							sumValue += oldValue;
							rcv.remove(rcv.size()-1);
							rcv.add(new Integer[]{s1.matrix[i][row], s2.matrix[j][col], sumValue});
						}
						else
						{
							rcv.add(new Integer[]{s1.matrix[i][row], s2.matrix[j][col], sumValue});
						}
					}	
					else
					{
						//For first element, simply add its rcv array to the list.
						rcv.add(new Integer[]{s1.matrix[i][row], s2.matrix[j][col], sumValue});
					}
				}

			}
			
		}
		
		//converting the ArrayList to an array of rcv. 
		int[][] result = conversion(rcv);
		
		return result;
	}
}
