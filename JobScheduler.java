import java.util.*;

/*
 * JobScheduler class to schedule process on a FCFS basis.
 
 * It creates an array of (no. of processes)x2 of processes
   with their arrival time and burst time respectively.
   
 * Methods in the class calculate the completion time,
   turn around time, waiting time, average waiting time,
   and maximum waiting time of the process.
   
   @author Saurabh Aswal
 */
class JobScheduler
{
	final int arrivalTime=0;
	final int burstTime=1;
	static int columns=2;
	
	public static void main(String[] args)
	{
		JobScheduler job= new JobScheduler();
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("Enter the total number of processes");
		int total = in.nextInt();
		
		int allProcess[][] = new int [total][columns];					//Array of all the processes.
		
		allProcess = job.inputJobs(allProcess);
		
		System.out.println("Choose the process number for its details");
		int choice =in.nextInt()-1;							//subtract 1 from choice of process as array index starting from 0. 
		
		
		if(choice >= allProcess.length)					//If choice is greater than the array size.
		{
			System.out.println("Invalid process number");
			
		}
		else
		{
			int cTime = job.completionTime(allProcess, choice) ;
			int wTime = job.waitingTime(allProcess, choice);
			int taTime = job.turnaroundTime(allProcess, choice);
			double awTime = job.avgWaitTime(job.waitTimeArray(allProcess));			//Passing the waiting time of all processes to avg. waiting time.
			int mwTime = job.maxTime(job.waitTimeArray(allProcess));				//Passing the waiting time of all processes to max. waiting time.
			
			System.out.println("\nCompletion time : "+cTime+"\nWaiting time : "+wTime+"\nTurn Around Time : "+taTime+"\nAverage Waiting time the batch : "+awTime+"\nMaximum waiting time : "+mwTime);
		}
		//sc.close();
		
	}
	
	/*
	 * To calculate the completion time of the process.
	 * 
	 * @param 2D integer array of the processes.
	 * @param choice as int.
	 * @return completion time as int.
	 */
	int completionTime(int process[][], int ct)
	{
		int time = process[0][burstTime];
		
		for(int i=1; i<= ct; i++)
		{	
			if(process[i][arrivalTime] < time) 
			{
				time += process[i][burstTime];
			}
			else
			{
				time += process[i][burstTime] + (process[i][arrivalTime] - time);
				
			}
		}	
		
		return time;
	}
	
	/*
	 * To calculate the waiting time of the selected process.
	 * 
	 * @param 2D integer array of the processes.
	 * @param choice as int.
	 * @return waiting time as int.
	 */
	int waitingTime(int process[][], int wt)
	{
		int time = turnaroundTime(process, wt) - process[wt][burstTime];
		return time;
	}
	
	
	/*
	 * To calculate the waiting time of the selected process.
	 * 
	 * @param 2D integer array of the processes.
	 * @param choice as int.
	 * @return turnaround time as int.
	 */
	int turnaroundTime(int process[][], int tat)
	{
		int time = completionTime(process, tat) - process[tat][arrivalTime];
		return time;
	}
	
	/*
	 * To calculate the average waiting time of all the process.
	 * 
	 * @param integer array of the waiting time of all the processes.
	 * @return average waiting time as double.
	 */
	double avgWaitTime(int process[])
	{
		double time = 0;
		for(int i=0; i<process.length; i++)
		{
			time += process[i];
		}
		
		return (time/process.length);
	}
	
	/*
	 * To calculate the maximum waiting time of all the processes.
	 * 
	 * @param integer array of the waiting time of all the processes.
	 * @return average waiting time as double.
	 */
	int maxTime(int process[])
	{
		int max = 0;

		for(int i=0; i<process.length; i++)
		{	
			if(max < process[i])
				max = process[i];
		}
		return max;
	}
	
	/*
	 * Utility method.
	 * To calculate and store waiting time of all the processes.
	 * 
	 * @param integer array of all the processes.
	 * @return waitng time integer array of all the processes.
	 */
	int[] waitTimeArray(int process[][])
	{
		int wTime[] = new int[process.length];
		
		for(int i=0; i<process.length; i++)
		{
			wTime[i] = waitingTime(process, i);
		}
		return wTime;
	}
/*
 * To take input of the processes' arrival time and burst time.
 * 
 * @param the empty initialized array of processes.
 * @return the array with values input by the user.
 */
	int[][] inputJobs(int arr[][])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter all processes' arrival time and burst time");
		for(int i=0; i < arr.length; i++)
		{
			arr[i][arrivalTime] = sc.nextInt();
			arr[i][burstTime] = sc.nextInt();
		}
		//sc.close();
		return arr;
	}	

}
    
