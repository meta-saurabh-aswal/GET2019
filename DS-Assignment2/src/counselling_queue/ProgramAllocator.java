package counselling_queue;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import java.util.*;

public class ProgramAllocator 
{
	private ArrayQueue<Student> studentQueue;
		
	public void allocator(List<Program> allPrograms, List<Student> students, String fileDestination)
	{
		studentQueue = new ArrayQueue<Student>(students.size());
		WritableWorkbook workbook = null;
		
		for(Student student: students)
		{
			studentQueue.addElement(student);
		}
		
		try{
			workbook = Workbook.createWorkbook(new File(fileDestination));
			
			WritableSheet sheet = workbook.createSheet("Allocation", 0);
			
			Label label;
			
			int row = 0;
			
			while(!studentQueue.isQueueEmpty())
			{
				
				    Student student = studentQueue.deleteElement();
					
					label = new Label(0,row,student.getName());
					
					sheet.addCell(label);
					
				
					for(String program : student.getPrograms())
					{
						
						if(isProgramAvailable(program, allPrograms))
						{
							label = new Label(1, row ,program + "(Allocated)");
							sheet.addCell(label);
							
							break;
						}
					}
					
					row++;
				}
			
			workbook.write();
			workbook.close();
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
}
	
public boolean isProgramAvailable(String programToCheck, List<Program>allPrograms)
{
		
		boolean result = false;
		
		for(Program program : allPrograms)
		{
			if(program.getProgramName().equals(programToCheck) && program.getAvailableSeatsInProgram() > 0)
			{
				program.setAvailableSeatsInProgram(program.getAvailableSeatsInProgram()-1);
				result = true;
			}
		}
		return result;
	}
}
