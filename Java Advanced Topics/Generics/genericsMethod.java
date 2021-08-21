import java.util.*;

class genericMethod{

	static Character[] charArray = {'I', 'S', 'T', 'I', 'A', 'Q'};
	static Boolean[] boolArray = { true, false , true};
	static Integer[] numArray = {12, 25, 26, 33, 47};
	
	
	public static <T> List arrayToList(T[] data, List<T> result){

		for(T o: data){
			System.out.println("Element: " + o);
			result.add(o);
		}
		
		return result;
	
	}

	public static void main(String[] args){
	
		List<Character> charList = arrayToList(charArray, new ArrayList<>());
		List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
		List<Integer> intList = arrayToList(numArray, new ArrayList<>()); 
		//List<String> intList2 = arrayToList(numArray, new ArrayList<>());  // type safety is not reserved in that sysetm. in second system this line will throw error in compile time.
		
		System.out.println(intList.get(0)); // create a runtime error
		
	}
	
	// GENERIC METHOD
	
	// Thats why, to make the method type safety we need to convert the method to a GENERIC Method By replacing the line as follows:
	
	//	Before: public static List arrayToList(Object[] data, List<Object> result)
	
	//  After: 	public static <T> List <T> arrayToList(T[] data, List<T> result)
	
	// In this way by using the generic method we can avoid type mismatching error within the compile of execusion.
	
		
	
}
	
