package counselling_queue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Class provides Methods To fetch the data
 *
 */
public class Fetcher 
{

	private List<Program> programs;
	private List<Student> students;

	public Fetcher() 
	{
		programs = new ArrayList<Program>();
		students = new ArrayList<Student>();
		
	}
	
	public List<Program> getPrograms() 
	{
		return programs;
	}

	public void setPrograms(List<Program> programs) 
	{
		this.programs = programs;
	}

	public List<Student> getStudents() 
	{
		return students;
	}

	public void setStudents(List<Student> students) 
	{
		this.students = students;
	}
	
	public List<Program> fetchPrograms(String fileSource)
	{
		
		Workbook workbook = null; 
		
		try
		{			
			workbook = Workbook.getWorkbook(new File(fileSource));
			Sheet sheet = workbook.getSheet(0);
			
			Cell cell;
			
			Program program;
			int rows = sheet.getRows();
			
			System.out.println(rows);
			
			for(int i=0; i<rows; i++)
			{   
				program = new Program();
				//System.out.println(i);
				cell = sheet.getCell(0,i);
				
				program.setProgramName(cell.getContents());
				cell = sheet.getCell(1,i);
				
				program.setAvailableSeatsInProgram(Integer.parseInt(cell.getContents()));
				//System.out.println(program.getProgramName());
				
				programs.add(program);
			}
		}
		catch (IOException e) 
		{
            e.printStackTrace();
        } 
		catch (BiffException e) 
		{
            e.printStackTrace();
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return programs;
	}
	
	public List<Student> fetchStudents(String fileSource)
	{
		
		Workbook workbook = null;
		 		
		try{
			
			workbook = Workbook.getWorkbook(new File(fileSource));
			
			Sheet sheet = workbook.getSheet(0);
			Cell cell;
			Student student; 
			
			
			int rows = sheet.getRows();
			System.out.println(rows);
			
			for(int i=0; i<rows; i++)
			{				
				student = new Student();
				cell = sheet.getCell(0,i);   //get the name of the student(from 1st row)
				student.setName(cell.getContents());
				
				//getting program list of Students according to his/her priority
				cell = sheet.getCell(1,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(2,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(3,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(4,i);
				student.getPrograms().add(cell.getContents());
				
				cell = sheet.getCell(5,i);
				student.getPrograms().add(cell.getContents());
				
				students.add(student);
			}
		}
		catch (IOException e) 
		{
            e.printStackTrace();
        } catch (BiffException e) 
		{
            e.printStackTrace();
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return students;
	}
	
}