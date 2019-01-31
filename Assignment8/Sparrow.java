/*
 * Sparrow class is to create a separate type of animals in the Bird category.
 * This class inherits class Bird as parent and class Animal as super class.
 * 
 * @author Saurabh Aswal
 */
public class Sparrow extends Bird
{
	
	Sparrow(String category, String type, String name)
	{
		this.name = name;
		this.type = type;
		this.category = category;
	}

}
