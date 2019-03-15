package virat_kohli;

public class MinRuns
{	
	Bowler bowlerList[];				//To store the list of bowlers with their balling quota.
	String bowling[];					//To store the list of bowlers bowling each ball.
	
	public void addList(int totalBalls, String bowlers[], int[] ballQuota)
	{
		bowlerList = new Bowler[bowlers.length];
		bowling = new String[totalBalls];
		
		for(int i=0; i<bowlerList.length; i++)
		{
			bowlerList[i] = new Bowler(bowlers[i], ballQuota[i]);
		}
	}
	
	//Utility
	public void orderBowlers()
	{
		for(int i=0; i<bowlerList.length; i++)
		{
			for (int j = 0; j < bowlerList.length-i-1; j++) 
			{
				if (bowlerList[j].balls < bowlerList[j+1].balls) 
                { 
                    // swap 
                    Bowler temp = bowlerList[j]; 
                    bowlerList[j] = bowlerList[j+1]; 
                    bowlerList[j+1] = temp; 
                }
			}
		}
	}
	
	public void startBowling()
	{
		orderBowlers();
		
		//balls of last bowler -- least number of balls
		int leastBalls = bowlerList[bowlerList.length-1].balls;
		int current = 0;				//Current bowler acc. to sorted list
		int lastBall = 0;
		
		System.out.println(leastBalls);
		
		for(int i=0; i<bowling.length; i++)
		{
			if(bowlerList[current].balls > leastBalls+1)
			{
				bowling[i] = bowlerList[current].name;
				bowlerList[current].balls--;
				
				if(bowlerList[current].balls == leastBalls+1)
				{
					current++;
				}
			}
			else
			{
				current++;
			}
			
			if(current >= bowlerList.length-1)
			{
				lastBall = i;
				break;
			}
		}
		
		//Setting the current bowler to the first.
		current = 0;
		for(int i=lastBall; i<bowling.length; i++)
		{
			//ball done by baller 'name'
			bowling[i] = bowlerList[current].name;
			bowlerList[current].balls--;				//decreasing the balls of the respective bowler
			current++;									//changing the current bowler on each ball
			
			//when the current bowler is the last one, shifting the bowling again to the first bowler
			if(current >= bowlerList.length)
			{
				current = 0;
			}
			
		}
		
	}
	
	public void displayList()
	{
		for(Bowler b : bowlerList)
		{
			System.out.println(b.name +"\t"+ b.balls);
		}
	}
	
	public void displayBowling()
	{
		for(String s: bowling)
		{
			System.out.println(s);
		}
	}

}
