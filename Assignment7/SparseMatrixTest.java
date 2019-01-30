import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;


public class SparseMatrixTest
{

	@Test
	public void test1Symmetric()
	{
		int[][] x = new int[][]{{0, 0, 3, 0}, {0, 0, 4, 0}, {0, 1, 0, 1}, {0, 0, 0, 0}};
		SparseMatrix sp = new SparseMatrix(x);
		boolean result = sp.symmetric();
		
		assertEquals(false, result);
	}

	@Test(expected = AssertionError.class)
	public void test0Symmetric()
	{
		int[][] x = new int[][]{{0, 0, 3, 0}, {0, 0, 4, 0}, {0, 1, 0, 1}};
		SparseMatrix sp = new SparseMatrix(x);
		boolean result = sp.symmetric();
	}

	@Test
	public void test1Add()
	{
		int[][] x = new int[][]{{0, 0, 3, 0}, {0, 0, 4, 0}, {0, 1, 0, 1}};
		int[][] y = new int[][]{{0, 1, 3, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}};
		SparseMatrix sp = new SparseMatrix(x);
		SparseMatrix sp1 = new SparseMatrix(y);
		int[][] result = sp.add(sp, sp1);
		
		int[][] exp = new int [][]{{0, 1, 6, 0}, {0, 0, 4, 0}, {1, 2, 0, 1}};
		
		SparseMatrix expected = new SparseMatrix(exp);
		
		assertEquals(true, Arrays.deepEquals(expected.matrix, result));
	}
	
	@Test
	public void test1Multiply(){
		int[][] input = {{0,0,1},
				       {2,0,2},
				       {0,0,1}};
		int[][] multi = {{1,1,0,0},
				       {4,0,0,2},
				       {0,5,1,0}};
		int[][] exp = {{0,5,1,0},
				        {2,12,2,0},
				        {0,5,1,0}};
		
		SparseMatrix sp1 = new SparseMatrix(input);
		SparseMatrix sp2 = new SparseMatrix(multi);
		SparseMatrix expected = new SparseMatrix(exp);
		
		int[][] result = sp1.multiply(sp1, sp2);
		assertEquals(true, Arrays.deepEquals(expected.matrix, result));
	}
}
