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
		
		//Circle
		double cParams[] = new double[] {4, 5, 3};
		screenObj.addShape("circle", cParams);
		
		screenObj.deleteShape("rectangle", 1);
	}
	
	@Test
	public void testEnclosed()
	{	
		Screen screenObj = Screen.getScreenObject();
		
		//@params {X coordinate of origin, Y coordinate, length of the rectangle, width}
		double rParams[] = new double[] {5, 4, 2, 3};	
		screenObj.addShape("rectangle", rParams);
		
		//Circle {X coordinate of origin, Y coordinate, radius of the circle}
		double cParams[] = new double[] {6, 5, 3};
		screenObj.addShape("circle", cParams);
		
		Point p = new Point(6,4);
		screenObj.enclosingShapes(p);
	}
}
