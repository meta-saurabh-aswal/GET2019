import java.util.*;

/*
 * Cage class is to define the capacity and type of cage for animals.
 * 
 * @author Saurabh Aswal
 */
public class Cage
{
	String type;
	int capacity = 0;
	
	//To allot a list of animals to each cage.
	List<Animal> cageAnimalList = new ArrayList<Animal>();
	
	Cage(String type, int capacity)
	{
		this.type = type;
		this.capacity = capacity;
	}
	
}

