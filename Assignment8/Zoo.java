import java.util.*;

/*
 * Class Zoo to keep a list of zones in a zoo.
 * This class allows operations like adding a cage to a zone,
 * adding an animal to a cage of its respective type and category,
 * removing an animal from the zoo, and
 * keeping distinct names for each animal.
 * 
 * @author Saurabh Aswal
 */
public class Zoo
{
	//To allot a list of zones to a zoo.
	List<Zone> zoneList = new ArrayList<Zone>();

	void addZone(String category, int limit)
	{
		zoneList.add(new Zone(category, limit));
	}
	
	/*
	 * Utility method to create the object of specific type of animal based on the
	 	details input.
		The method gets the category of the type of animal from its superclass.
	 	
	 	@param type of the animal as string
	 	@param name of the animal that should be distinct.
	 	@return animal object with the properties of a specific type.
	 */
	Animal buildObj(String type, String name)
	{
		Animal a = null;
		switch (type)
		{
		case "Tiger":
			a = new Tiger(Tiger.class.getSuperclass().getSimpleName(), type, name);
			break;
		
		case "Sparrow":
			a = new Sparrow(Sparrow.class.getSuperclass().getSimpleName(), type, name);
			break;
			
		case "Snake":
			a = new Snake(Snake.class.getSuperclass().getSimpleName(), type, name);
			break;		
		}
		
		return a;
	}
	
/*
 * Method to add an animal to a cage of a specific type.
 * 
	@param type of the animal as string
	@param name of the animal that should be distinct.
 */
	void addAnimal(String type, String name)
	{
		Animal animalObj = buildObj(type, name);
		
		boolean flag = false;
		
		Iterator<Zone> zoneItr = zoneList.iterator();
		
		label1:
		while(zoneItr.hasNext())
		{
			Zone z = zoneItr.next();
			
			if(z.category.equalsIgnoreCase(animalObj.category))
			{
				Iterator<Cage> cageItr = z.cageList.iterator();
				
				while(cageItr.hasNext())
				{
					Cage c = cageItr.next();
					
					if(c.type.equalsIgnoreCase(animalObj.type) && c.capacity > c.cageAnimalList.size())
					{
						//To check if an animal with same name is already in the animal list of the cage.
						for(Animal a : c.cageAnimalList)
						{
							if(a.name.equalsIgnoreCase(name))
								throw new AssertionError();
						}
						
						//When no animal with same name is not in the list.
						c.cageAnimalList.add(animalObj);
						
						flag = true;
						break label1;
					}
				}
			}
		}
		
		if(!(flag))
		{
			//No cage available
			throw new AssertionError();
		}
	}
	
	
	/*
	 * Method to remove an animal from the zoo.
	 * 
		@param type of the animal as string
		@param name of the animal that should be distinct.
		@return the updated list of animals after removal.
	 */
	List<Animal> removeAnimal(String type, String name)
	{				
		Iterator<Zone> zoneItr = zoneList.iterator();
		
		while(zoneItr.hasNext())
		{
			Zone z = zoneItr.next();
			
			if(z.category.equalsIgnoreCase(getCategory(type)))
			{
				Iterator<Cage> cageItr = z.cageList.iterator();
				
				while(cageItr.hasNext())
				{
					Cage c = cageItr.next();
					
					if(c.type.equalsIgnoreCase(type))
					{
						Iterator<Animal> animalItr = c.cageAnimalList.iterator();
						
						while(animalItr.hasNext())
						{	
							Animal a = animalItr.next();
							
							if(a.name.equalsIgnoreCase(name))
							{
								animalItr.remove();
								
								return c.cageAnimalList;
							}
						}
					}
				}
			}
		}
		
		throw new AssertionError();
	}
	
	/*
	 * Method to add a cage of specific type in a zone of a specific category.
	 * 
		@param type of the cage as string
		@param capacity of the cage.
	 */
	void addCage(String type, int capacity)
	{
		int i;
		boolean flag = false;

		for(i=0; i < zoneList.size(); i++)
		{
			//Using getCategory method to get the category of an animal/cage type as string.
			if(zoneList.get(i).category.equalsIgnoreCase(getCategory(type)) && zoneList.get(i).limit > zoneList.get(i).cageList.size())
			{
				zoneList.get(i).cageList.add(new Cage(type, capacity));
				flag = true;

				
				break;
			}			
		}
		if(!(flag))
			throw new AssertionError();
	}
	
	/*
	 * Utility method to get the category of a type of animal for building a cage.
	 * 
	 * @param specific type of the animal for the cage as String.
	 * @return category of the type of animal as string.
	 */
	String getCategory(String type)
	{
		String cat = null;
		
		switch(type.toUpperCase())
		{
			case "TIGER":
				cat = Tiger.class.getSuperclass().getSimpleName();
				break;
			case "SPARROW":
				cat = Sparrow.class.getSuperclass().getSimpleName();
				break;
			case "SNAKE":
				cat = Snake.class.getSuperclass().getSimpleName();
				break;
		}
		return cat;
	}

	
}
