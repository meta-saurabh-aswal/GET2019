import static org.junit.Assert.*;

import org.junit.Test;


public class ZooTest
{

	@Test
	public void testAddAnimal()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Mammal", "Tiger", 3);
		zoo1.addAnimal("Mammal","Tiger", "boora");
		
		zoo1.addCage("Bird", "Sparrow", 1);
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		zoo1.addAnimal("Mammal", "Tiger", "haha");

	}
	
	@Test(expected = AssertionError.class)
	public void test0AddAnimal()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Mammal", "Tiger", 3);
		zoo1.addAnimal("Mammal","Tiger", "boora");
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		
		zoo1.addCage("Bird", "Sparrow", 1);
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		zoo1.addAnimal("Mammal", "Tiger", "haha");
	}
	
	
	@Test
	public void testRemoveAnimal()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Mammal", "Tiger", 3);
		zoo1.addAnimal("Mammal","Tiger", "boora");
		
		zoo1.addCage("Bird", "Sparrow", 1);
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		zoo1.addAnimal("Mammal", "Tiger", "haha");
		
		zoo1.removeAnimal("Mammal", "tiger", "haha");
	}
	
	
	@Test(expected = AssertionError.class)
	public void test0AddCage()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Mammal", "Tiger", 3);
		zoo1.addAnimal("Mammal","Tiger", "boora");
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		
		zoo1.addCage("Bird", "Sparrow", 1);
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		zoo1.addAnimal("Mammal", "Tiger", "haha");
	}
	
	@Test(expected = AssertionError.class)
	public void test0SameName()
	{
		Zoo zoo1 = new Zoo();
		
		zoo1.addZone("Bird", 7);
		zoo1.addZone("Mammal", 5);
		zoo1.addZone("Reptile", 4);
				
		zoo1.addCage("Mammal", "Tiger", 3);
		zoo1.addAnimal("Mammal","Tiger", "boora");
		zoo1.addAnimal("Bird", "Sparrow", "nini");
		zoo1.addAnimal("Mammal", "Tiger", "boora");
	}
}
