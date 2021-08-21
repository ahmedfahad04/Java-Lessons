import java.util.*;

class House extends Building { 
	public int rooms = 10;
	
	public String toString() {
		return ("HOUSE");
	}
	
	public int getRooms() {
		return rooms;
	}
	
	public void setRooms(int num) {
		this.rooms = num;
	}
	
}

class Building {
	public int rooms = 7;
	
	public String toString() {
		return ("BUILDING");
	}
	
	public int getRooms() {
		return rooms;
	}
	
	public void setRooms(int num) {
		this.rooms = num;
	}
	
}

class Office extends Building {

	public String toString() {
		return ("Office");
	}
	
}



public class wildcardgenerics{


	public static void main(String[] args){
	
		// List of Buildings
		List<Building> buildings = new ArrayList();
		buildings.add(new Building());
		buildings.add(new Building());
		System.out.println("Printing objects");
		printList(buildings);
		
		
		
		// List of Houses
		List<House> houses = new ArrayList();
		houses.add(new House());
		houses.add(new House());
        printList(houses); // error: incompatible types: List<House> cannot be converted to List<Building>

        
                
        // List of Offices
        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        printList(offices); 
        //  error: incompatible types:List<Office> cannot be converted to List<Building>

              
				
	}
	
	static void printList(List<? extends Building> builds) {
	
		
		for(int i=0 ; i < builds.size(); i++){
		 	System.out.println(builds.get(i).toString());
		 }
		
	}
	
	// Normally Childclasses are not allowed to be passed replacing the parent classes. 
	
	// To pass the childclasses we need to use generics like this:
	
	// Before: static void printList(List<Building> builds)
	
	// After: static void printList(List<? extends Building> builds)
	
	// Now the child classes can also be passes through this method. Its called wild card in generics.
			
		
	
}
	
