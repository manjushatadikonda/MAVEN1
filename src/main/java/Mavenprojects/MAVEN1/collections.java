package Mavenprojects.MAVEN1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class collections {
	//Collections-ArrayList
	public void addElementstoList(ArrayList<String> list,String s)
	{
		list.add(s);
	}
	//Collections-ArrayList
	public void removeElementsfromList(ArrayList<String> list,int index)
	{
		list.remove(index);
	}
	//Collections-HashSet
    public boolean checkelementcontains(Set<String> set,String element)
    {
    	 return set.contains(element);
    }
   // Collections-Hashset
    public int returnsizeofset(Set<String> set)
    {
    	return set.size();
    }
    //Collections-TreeSet
    public void sortorderusingtreeset(TreeSet<String> ts,Set<String> s)
    {
    	ts.addAll(s);
    }
  //Collections-TreeSet
    public String getlastoftreeset(TreeSet<String> ts)
    {
    	return ts.last();
    }
    //Collections-HashMap
    public boolean checkhashmapisEmpty(HashMap<Integer,String> map)
    {
    	return map.isEmpty();
    }
    //Collections-HashMap
    public String returnvalueofgivenKey(HashMap<Integer,String> map,int key)
    {
    	return map.get(key);
    }
    //Collections-TreeMap
    public void sortorderusingtreemap(TreeMap<Integer,String> tmap,HashMap<Integer,String> hmap)
    {
    	tmap.putAll(hmap);
    }
  //Collections-TreeMap
    public Entry<Integer, String> returnfirstEntryaftersorting(TreeMap<Integer,String> tmap)
    {
    	return tmap.firstEntry();
    }
public static void main(String[] args)
{
	collections c=new collections();
	ArrayList<String> list=new ArrayList<String>(6);
    
   
    
    c.addElementstoList(list,"Mango");
    c.addElementstoList(list,"Apple");
    c.addElementstoList(list,"Orange");
	c.addElementstoList(list,"Banana");
	c.addElementstoList(list,"Apple");
	
	c.removeElementsfromList(list,2);
	Set<String> set = new HashSet<>(list);
	boolean check=c.checkelementcontains(set,"Orange");
	System.out.println("List Values:"+list);
	System.out.println("Is Orange still in List? "+check);
	int setsize=c.returnsizeofset(set);
	System.out.println("Set Values:"+set);
	System.out.println("SetSize: "+setsize);

	 TreeSet<String> hashSetToTreeSet = new TreeSet<>();
	 c.sortorderusingtreeset(hashSetToTreeSet,set);
	System.out.println("TreeSetValues:"+hashSetToTreeSet);
	
	String lastvalueoftreeset=c.getlastoftreeset(hashSetToTreeSet);
	System.out.println(lastvalueoftreeset);
	
	HashMap<Integer,String> hmap=new HashMap<Integer,String>();
	Boolean b=c.checkhashmapisEmpty(hmap);
	if(b)
	{
		for(int i=0;i<list.size();i++)
		{
		hmap.put(i+1, list.get(i));
		}
	}
	String valueofhashmap=c.returnvalueofgivenKey(hmap,3);
	System.out.println("Value with Key{3}: "+valueofhashmap);
	System.out.println("HashMap Values: "+hmap);
	
	TreeMap<Integer,String> tmap=new TreeMap<Integer,String>();
	 c.sortorderusingtreemap(tmap,hmap);
	 System.out.println("TreeMap Values: "+tmap);
	 System.out.println("TreeMap first Entry: "+c.returnfirstEntryaftersorting(tmap));
}

	

}
