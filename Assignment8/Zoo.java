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
	 	
	 	@param category of the animal as String
	 	@param type of the animal as string
	 	@param name of the animal that should be distinct.
	 	@return animal object with the properties of a specific type.
	 */
	Animal buildObj(String category, String type, String name)
	{
		Animal a = null;
		switch (type)
		{
		case "Tiger":
			a = new Tiger(category, type, name);
			break;
		
		case "Sparrow":
			a = new Sparrow(category, type, name);
			break;
			
		case "Snake":
			a = new Snake(category, type, name);
			break;
			
		}
		return a;
	}
	
/*
 * Method to add an animal to a cage of a specific type.
 * 
 * @param category of the animal as String
	@param type of the animal as string
	@param name of the animal that should be distinct.
 */
	void addAnimal(String category, String type, String name)
	{
		Animal animalObj = buildObj(category, type, name);
		
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
	 * @param category of the animal as String
		@param type of the animal as string
		@param name of the animal that should be distinct.
		@return the updated list of animals after removal.
	 */
	List<Animal> removeAnimal(String category, String type, String name)
	{
		Iterator<Zone> zoneItr = zoneList.iterator();
		
		while(zoneItr.hasNext())
		{
			Zone z = zoneItr.next();
			
			if(z.category.equalsIgnoreCase(category))
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
	 * Method to add a cage of specific type in a zone of of specific category.
	 * 
	 *  @param category of the cage as String
		@param type of the cage as string
		@param capacity of the cage.
	 */
	void addCage(String category, String type, int capacity)
	{
		int i;
		boolean flag = false;

		for(i=0; i < zoneList.size(); i++)
		{

			if(zoneList.get(i).category.equalsIgnoreCase(category) && zoneList.get(i).limit > zoneList.get(i).cageList.size())
			{
				zoneList.get(i).cageList.add(new Cage(type, capacity));
				flag = true;

				
				break;
			}			
		}
		if(!(flag))
			throw new AssertionError();
	}

	
}