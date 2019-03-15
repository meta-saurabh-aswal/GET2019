package virat_kohli;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinRunsTest
{
	MinRuns mRuns = new MinRuns();

	@Test
	void test()
	{
		int totalBalls = 20;
		String[] names = {"A", "B", "C", "D",  "E"};
		int [] ballQuota = {3, 5, 2, 6, 4};
		
		mRuns.addList(totalBalls, names, ballQuota);
		mRuns.displayList();
		mRuns.startBowling();
	
		mRuns.displayBowling();
	}

}

