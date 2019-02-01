/*
 * Animal is the class defining the characteristics of animals.
 * This class is the parent of all the classes of categories and types of animals.
 * 
 * @author Saurabh Aswal
 */
public class Animal
{
	String name;
	String type;
	String category;
	static int totalAnimals;
	static int animalId = 0;
	
	public Animal()
	{
		animalId++;
		totalAnimals = animalId;
	}
	
}