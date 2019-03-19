package counselling_queue;

import java.util.ArrayList;

public class Student 
{
	private String studentName;
	private ArrayList<String> programPrecedenceList  ;
	
	Student()
	{
		programPrecedenceList= new ArrayList<String>();
	}
	
	String getName()
	{
		return studentName;
	}
	
	void setName(String studentName)
	{
		this.studentName = studentName;
	}
	
	public ArrayList<String> getPrograms() 
	{
		return programPrecedenceList;
	}

	public void setPrograms(ArrayList<String> programs) 
	{
		this.programPrecedenceList = programs;
	}
	
	@Override
	public String toString() 
	{
		return "Student [ Student Name=" + studentName + ", Programs Precedence List =" + programPrecedenceList + "]";
	}
}
