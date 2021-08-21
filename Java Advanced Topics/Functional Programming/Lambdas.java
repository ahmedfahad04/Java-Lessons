@FunctionalInterface
interface GreetingsMessage{

	// this is a functional Interface because it only contains one
	// abstract method
	public abstract void greet(String name);
}


public class Lambdas {

	public static void main(String[] args) {
	
		GreetingsMessage gm = (Entity) -> {
		
			// this is simply the body of that abstract function
			System.out.println("Hello " + Entity + ", How are you?"); 
		}; // careful about this semicolon
				
		
		gm.greet("Ahmed Fahad");
		
	}
}
