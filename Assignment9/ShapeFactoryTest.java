import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeFactoryTest
{		
	@Test
	public void testAddDelete()
	{
		Screen screenObj = Screen.getScreenObject();
		
		//@params {X coordinate of origin, Y coordinate, length of the rectangle, width}
		double rParams[] = new double[] {5, 4, 2, 3};	
		screenObj.addShape("rectangle", rParams);
		
		//Circle {X coordinate of origin, Y coordinate, radius of the circle}
		double cParams[] = new double[] {4, 5, 3};
		screenObj.addShape("circle", cParams);
		
		//Square {X coordinate of origin, Y coordinate, side of the square}
		double sParams[] = new double[] {3, 3, 8};
		screenObj.addShape("square", sParams);
		
		//Triangle {X coordinate of origin, Y coordinate, sides of the triangle}
		double tParams[] = new double[] {2, 3, 10, 50, 80};
		screenObj.addShape("triangle", tParams);

		screenObj.deleteShape("rectangle", 1);
	}
	
	@Test
	public void testEnclosed()
	{	
		Screen screenObj = Screen.getScreenObject();
		List<Shape> enclosers = new ArrayList<Shape>();	
		
		//@params {X coordinate of origin, Y coordinate, length of the rectangle, width}
		double rParams[] = new double[] {5, 4, 2, 3};	
		screenObj.addShape("rectangle", rParams);
		
		//Circle {X coordinate of origin, Y coordinate, radius of the circle}
		double cParams[] = new double[] {6, 5, 3};
		screenObj.addShape("circle", cParams);
		
		Point p = new Point(6,5);
		enclosers = screenObj.enclosingShapes(p);	
	}
}
