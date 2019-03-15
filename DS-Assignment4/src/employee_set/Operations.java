package employee_set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Operations
{
	Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
	
	public void addEmployee(int id, String name, String address)
	{
		if(empMap.get(id) == null)
		{		
			Employee emp = new Employee(id, name, address);
			empMap.put(emp.id, emp);
		}
	}
	
	public void display()
	{
		for(int idKey : empMap.keySet())
		{
			int id = empMap.get(idKey).id;
			String name = empMap.get(idKey).name;
			String address = empMap.get(idKey).address;
			
			System.out.println(id +"\t"+ name +"\t"+ address);
		}
	}
	
	public void sortNatural()
	{
		ArrayList<Integer> empList = new ArrayList<Integer>(empMap.keySet());
		Collections.sort(empList);
		
		Map<Integer, Employee> tempMap = new TreeMap<Integer, Employee>();
		
		for(Integer e: empList)
		{
			tempMap.put(e, empMap.get(e));
			System.out.println(empMap.get(e).id +"\t"+ empMap.get(e).name +"\t"+ empMap.get(e).address);
		}
		
		empMap = tempMap;
	}

	public void sortByName()
	{
	        Set<Entry<Integer, Employee>> entries = empMap.entrySet();
	        
	        Comparator<Entry<Integer, Employee>> valueComparator = new Comparator<Entry<Integer, Employee>>()
	        {
	        	@Override public int compare(Entry<Integer, Employee> e1, Entry<Integer, Employee> e2)
	        	{
	        		Employee v1 = e1.getValue(); Employee v2 = e2.getValue(); return v1.name.compareTo(v2.name);
	        	}
	        };
	        
	        ArrayList<Entry<Integer, Employee>> empList = new ArrayList<Entry<Integer, Employee>>(entries); 
	        Map <Integer, Employee> tempMap = new LinkedHashMap<Integer, Employee>();
	        
	        Collections.sort(empList, valueComparator);
	        
	        for(Entry<Integer, Employee> entry : empList)
	        {
	        	tempMap.put(entry.getKey(), entry.getValue());
	        	
	        	System.out.println((entry.getKey()) + "\t " + entry.getValue().name);
	        }
	        
	        empMap = tempMap;
	}
	
}
