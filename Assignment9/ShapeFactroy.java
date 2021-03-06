import java.util.*;

/*
 * Class ShapeFactory is a Singleton class which determines which type of shape is to be created.
 * The class provides shape id to each shape created.
 * It also validates if a shape can be created for the given screen.
 * 
 * @author Saurabh Aswal
 */
class ShapeFactory
{
	static int shapeId = 0;
	private static ShapeFactory factoryObj = new ShapeFactory();
	
	private ShapeFactory() {}
	
	//Method to let users use the object of singleton class ShapeFactory.
	public static ShapeFactory getFactory()
	{
		return factoryObj;
	}
	
	/*
	 * Method to create a shape according to the given name and dimensions.
	 * 
	 * @param an array of values of origin coordinate, length, width, side, radius, etc. of the respective shape.
	 * @return object of the respective shape.
	 */
	static Shape createShape(String inputShape, double[] param)
	{	
		Shape s = null;
		inputShape = inputShape.toUpperCase();				//Converting the shape type to uppercase for comparison with enum.
		Shape.ShapeType type = Shape.ShapeType.valueOf(inputShape);				//Converting the input shape type to enum.
		
		//Checking whether the input shape type is which one. Assertion Error if invalid type is as input.
		switch(type)
		{
		case RECTANGLE:
			if(!(validate( param[0], param[1], param[2], param[3])))				//Checking if the shape can be created in the screen with given dimensions.
				throw new AssertionError();
			
			 s = new Rectangle(++shapeId, param[0], param[1], param[2], param[3]);
			 break;
			 
		case TRIANGLE:
			if(!(validate(param[0], param[1], param[2], param[3])))
				throw new AssertionError();
			
			 s = new Triangle(++shapeId, param[0], param[1], param[2], param[3], param[4]); 
			 break; 
			 
		case SQUARE:
			if(!(validate( param[0], param[1], param[2], param[2])))
				throw new AssertionError();
			
			s = new Square(++shapeId, param[0], param[1], param[2]);
			break;
			
		case CIRCLE:
			if(!(validateCircle(param)))
				throw new AssertionError();
			
			s = new Circle(++shapeId, param[0], param[1], param[2]);
			break;
			
		default:
			throw new AssertionError();
		}
		
		return s;
	}
	
	/*
	 * Method to check if the rectangle,square or triangle can be built in the screen with given dimensions.
	 * 
	 * @param origin coordinates and sides of the rectangle, square or triangle as an array of double.
	 * @return true of false as per the validation.
	 */
	static boolean validate(double x, double y, double s1, double s2)
	{
		if(x > Screen.XMIN && y > Screen.YMIN && x+s1 <= Screen.XMAX && y+s2 <= Screen.YMAX)
			return true;
		else
			return false;
	}
	
	
	/*
	 * Method to check if the rectangle can be built in the screen with given dimensions
	 * by comparing the centre point with its distance from x and y axis.
	 * 
	 * @param origin coordinates & radius of the circle as an array of double.
	 * @return true of false as per the validation.
	 */
	static boolean validateCircle(double[] param)
	{
		/*param[0] & param[1] as x & y coordinate of the origin respectively.
		 * param[2] is radius of the circle.
		 */
		double toOriginLength = Math.sqrt(param[0]*param[0] + param[1]*param[1]);
		double toCentreLength = toOriginLength + param[2];
		
		double[] centrePoint = new double[2];
		
		//finding the centre of the circle.
		centrePoint[0] = (toCentreLength * param[0])/toOriginLength;
		centrePoint[1] = (toCentreLength * param[1])/toOriginLength;
		
		if(centrePoint[0]+param[2] <= Screen.XMAX && centrePoint[0]-param[2] >= Screen.XMIN && centrePoint[1]+param[2] <= Screen.YMAX &&centrePoint[1]-param[2] >= Screen.YMIN)
			return true;
		else
			return false;
	}
}
