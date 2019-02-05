import java.util.*;

/*
 * Screen class following Singleton Design Pattern.
 * This class consists of a list of shapes on the screen and
  	a list of shapes on the screen enclosing the given point.
  	
 * THe class has methods to add a shape to the screen, 
 	to delete a shape from the screen, to delete all shapes from the screen 
 	and to check which shapes are enclosing the given point.
 	
 * @author Saurabh Aswal
 */
class Screen
{
	//Dimensions of the screen as final.
	public static final double XMAX=1000, YMAX=1000, XMIN=0, YMIN=0;
	List<Shape> screenShapes = new ArrayList<Shape>();				//List to store the shapes on the screen.
	List<Shape> enclosers = new ArrayList<Shape>();					//List to store the shapes enclosing the given point.
	
	//Private constructor to allow Singleton class.
	private Screen(){}
	
	private static Screen screenObject = new Screen();				//Private object to restrict access to the object.
	
	/*
	 * Method to allow user to get the object of class Screen
	 	instead of re-instantiating.
	 *
	 *@return private object of Singleton class Screen.
	 */
	public static Screen getScreenObject()
	{
		return screenObject;
	}

	/*
	 * Method to add a shape to the screen.
	 * This method calls the createShape method of ShapeFactory Singleton class
	 	to create the respective shape.
	 * 
	 * @params name of the shape to be created as string
	 * @param dimensions of the shape created as a double array.
	 */
	void addShape(String inputShape, double[] param)
	{			
		Shape newShape = ShapeFactory.createShape(inputShape, param);
		screenShapes.add(newShape);
	}
	
	/*
	 * Method to delete a shape at a time from the screen.
	 * 
	 * @param name of the shape type as string.
	 * @param id of that shape as int.
	 */
	void deleteShape(String shapeName, int shapeId)
	{
		//Iterator to iterate through the list of shapes on the screen.
		Iterator<Shape> shapeItr = screenShapes.iterator();
		
		while(shapeItr.hasNext())
		{
			Shape s = shapeItr.next();
			
			if(s.getShapeId() == shapeId && s.getClass().getSimpleName().equalsIgnoreCase(shapeName))
			{
				shapeItr.remove();
				
			}
		}
	}
	
	/*
	 * To remove all shapes from the screen.
	 */
	void deleteAll()
	{
		screenShapes.clear();
		
	}
	
	/*
	 * To add the shapes enclosing the given point to the list of enclosers.
	 * 
	 * @param reference of the object of point p of type Point.
	 */
	void enclosingShapes(Point p)
	{
		Iterator<Shape> shapeItr = screenShapes.iterator();
		
		while(shapeItr.hasNext())
		{
			Shape s = shapeItr.next();
			
			if(s.isPointEnclosed(p))
			{
				enclosers.add(s);
			}
		}
	}

}
