/*
 * Tiger class is to create a separate type of animals in the Mammal category.
 * This class inherits class Mammal as parent and class Animal as super class.
 * 
 * @author Saurabh Aswal
 */
public class Tiger extends Mammal
{
	
	Tiger(String category, String type, String name)
	{
		this.name = name;
		this.type = type;
		this.category = category;
	}

}
