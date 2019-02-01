import java.util.*;

/*
 * Zone class is to allot the zones for cages containing different categories of animals.
 * It specifies the category and limit for cages.
 * Each zone can hold a specific category of animals only.
 * 
 * @author Saurabh Aswal
 */
class Zone
{
	static int zoneId = 0;
	String category;
	int limit;
	
	Zone(String category, int limit)
	{
		this.category = category;
		this.limit = limit;
		this.zoneId++;
	}
	
	//To allot a list of cages to each zone.
	List<Cage> cageList = new ArrayList<Cage>();
	
}
