/*
 * Interface Shape to declare the operations of a shape.
 * An enum containing the names of all the shapes is defined in this interface.
 */
interface Shape
{	
	double getArea();					//Method to get the area of a shape.
	double getPerimeter();				//method to get the perimeter of a shape.
	double[] getOrigin();				//Method to get the origin coordinates of a shape.
	boolean isPointEnclosed(Point p);			//Method to check if the given point is enclosed by the shape.
	int getShapeId();					//Method to get the shapeId of a shape.
	
	//Enum of all the shape types.
	enum ShapeType
	{
		SQUARE, TRIANGLE, RECTANGLE, CIRCLE;
	}
	
}
