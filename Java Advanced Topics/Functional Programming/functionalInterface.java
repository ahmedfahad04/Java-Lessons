@FunctionalInterface
interface GreetingsMessage{

	// this is a functional Interface because it only contains one
	// abstract method
	public abstract void greet(String name);
}


public class functionalInterface {

	public static void main(String[] args) {
	
		GreetingsMessage gm = new GreetingsMessage() { // careful about 														  syntax
			@Override
			public void greet(String name){
			 	System.out.println("Hello " + name + ", How are you??");
			}
		};
		
		gm.greet("Fahad");
		
	}
}
