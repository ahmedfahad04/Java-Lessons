import java.util.*;

class Book {
	String author;
	String title;
	
	public Book(String authorName, String titleName) {
		this.author = authorName;
		this.title = titleName;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	// whenver gets printed the element address only, you need to get that you haven't mentioned any toString() method
	
	@Override
	public String toString() {
		return ("Author is: "+ getAuthor() + ", Title is: " + getTitle());
	}
	
}



public class streams {

	public static void main(String[] args) {
		ArrayList<Book> books = populateLibrary();
		
		books.stream().filter( book -> {
			return (book.getAuthor().startsWith("T"));
		}).filter( book -> {
			return book.getTitle().startsWith("F");
		}).forEach(System.out::println);
		
		// this nested filter is something like this:
		// from first filter if we get 5 results
		// then the second filter will search the specific inquiry in
		// the first selected 5 elements; not in whole arraylist.
	}
	
	static ArrayList<Book> populateLibrary() {
	
		ArrayList<Book> books = new ArrayList();
		
		books.add(new Book("Alice Walker", "The Color Purple"));
		books.add(new Book("Toni Morrison", "Beloved"));
		books.add(new Book("Toni Morrison", "Fazz"));
		books.add(new Book("John Steinbeck", "Paradise"));
		books.add(new Book("Kazuo Ishiguro", "Fast of Eden"));
		
		return books;
	}
	
	// whenever occure "cannot find symbol" it means you need to add relevant import statement
	
	
}
