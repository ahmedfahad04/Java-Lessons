@FunctionalInterface
interface Shapes {

	public abstract int getArea(Square person);
	
}

class Square {
	
	int side;
	
	public Square(int sideLen){
		this.side = sideLen;
	}
	
	public int CalculateArea(){
		return side*side;
	}

} 


public class methodRef{
	public static void main(String[] args){
	
		Square s = new Square(6);
		
		// made a general way to assign the area to getArea() method
		Shapes shape = (sh) -> {
			System.out.println("Area is assigned to the interface.");
			return sh.CalculateArea();
		};

		
		// The above chunk of code can easily be replaced with this one 		   line code. This is called Method Reference.	It can only be 			   applicable in case of FunctionalInterface.	
		Shapes sh2 = Square::CalculateArea;
		
		System.out.println("AREA IS: " + s.CalculateArea());
		System.out.println("Shapes Area IS: " + sh2.getArea(s));
	
	}
}
