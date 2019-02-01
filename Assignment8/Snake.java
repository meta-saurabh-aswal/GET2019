/*
 * Snake class is to create a separate type of animals in the Reptile category.
 * This class inherits class Reptile as parent and class Animal as super class.
 * 
 * @author Saurabh Aswal
 */
public class Snake extends Reptile
{

	Snake(String category, String type, String name)
	{
		this.name = name;
		this.type = type;
		this.category = category;
	}

}
