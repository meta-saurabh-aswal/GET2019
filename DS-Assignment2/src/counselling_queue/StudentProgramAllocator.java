package counselling_queue;

/**
 * Main Driver Class
 */
public class StudentProgramAllocator 
{

	public static void main(String list[])
	{
		Fetcher fetcher = new Fetcher();
		String programListDestination="C:/Users/admin/eclipse-workspace/DS-Assignment2/programs.xls";
		String studentListDestination= "C:/Users/admin/eclipse-workspace/DS-Assignment2/students.xls";
		
		
		fetcher.fetchPrograms(programListDestination);
		fetcher.fetchStudents(studentListDestination);
		
		//System.out.println(fetcher.getPrograms());
		
		//System.out.println(fetcher.getStudents());
		ProgramAllocator allocator = new ProgramAllocator();

		try
		{
			allocator.allocator(fetcher.getPrograms() ,fetcher.getStudents(), "C:/Users/admin/eclipse-workspace/DS-Assignment6/AllocatedList.xls");
			System.out.println("Allocated");
			//System.out.println(fetcher.getPrograms());
		}
		catch(Exception e)
		{			
			e.printStackTrace();
		}
	}
}
