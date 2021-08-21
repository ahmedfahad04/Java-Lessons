import java.util.*;

class Generics{


	public static void main(String[] args){
	
		List dept = new ArrayList();
		dept.add("IIT");
		dept.add("GE");
		dept.add("SWE");
		dept.add("CEE");
		dept.add(1204); // no type safety
		System.out.println("MY department is: " + dept.get(4));
 		
 		// This is mainly called as the Generic version of List
  		// where we have already declared the type of List
  		
		List<String> country = new ArrayList<>(); //import must
		country.add("Bangladesh");
		country.add("USA");
		country.add("Afganisthan");
		// country.add(1700); // type is checked when we declare String as a data type
		System.out.println("MY country is: " + country.get(2));
		

	}
	

	// Static method error
    // String can't convert to Object
	
	
}
	
