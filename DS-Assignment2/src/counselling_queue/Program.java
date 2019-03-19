package counselling_queue;

public class Program 
{
	private String programName;
	private int availableSeatsInProgram;
	
	public String getProgramName() {
		return programName;
	}
	
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public int getAvailableSeatsInProgram() {
		return availableSeatsInProgram;
	}
	
	public void setAvailableSeatsInProgram(int availableSeatsInProgram) {
		this.availableSeatsInProgram = availableSeatsInProgram;
	}
	
	@Override
	public String toString() {
		return "Program [Program name: " + programName + ", Seats Available :" + availableSeatsInProgram + "]";
	}
	
}
