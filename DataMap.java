package data;

import java.util.Comparator ;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import guests.Customer ;

public class DataMap {

	public static void main(String[] args){
		
		Map<Customer, Integer> data = new TreeMap<Customer, Integer>(new CustomerNameSort()) ;
		
		Customer x = new Customer() ;
		Customer y = new Customer() ;
		Customer z = new Customer() ;
		
		Customer[] during = {x, y, z} ; 
		
		for(Customer p : during){
			data.put(p, p.getVisitTimes()) ;
		}
		
		for(Entry<Customer, Integer> d : data.entrySet()){
			System.out.println(d.getKey().getName() + ":" + d.getValue());
		}
	}
}

class CustomerNameSort implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2){
		return o2.getVisitTimes() - o1.getVisitTimes() ;
	}	
}
