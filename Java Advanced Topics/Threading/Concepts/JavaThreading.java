package Concepts;

class ThreadExample extends Thread {

	public void run(){
		int i = 0;
		while(i < 3){
			System.out.println(i + ", " + this.getName());
			i++;
		}
	}
	
}

class RunnableExample implements Runnable {
	
	public void run(){
		int i = 0;
		while(i < 5){
		System.out.println(i + ", " + Thread.currentThread().getName());
			i++;
		}
	}
	
}


public class JavaThreading {
	public static void main(String [] args) {

		// Method 1 - using simple thread class object
		ThreadExample thread1 = new ThreadExample();
		thread1.setName("FIRST");
		thread1.start();
		
		ThreadExample thread2 = new ThreadExample();
		thread2.setName("SECOND");
		thread2.start();

		// Method 2 - passing runnable class object into thread class
		Thread t1 = new Thread(new RunnableExample());
		t1.setName("THIRD");
		t1.start();

		// Method 3 - overwriting run method while creating thread object
		Thread t2 = new Thread( new RunnableExample(){
			public void run(){
				System.out.println("INSIDE FOURTH THREADING");
			}
		});
		t2.setName("FOURTH");
		t2.start();

		// Method 4 - using lambda expression
		Thread t4 = new Thread(() -> { // using lambda expression (by default it means the scope of run() method)
			System.out.println("INSIDE FIFTH THREADING.....");
		});
		t4.setName("FIFTH");
		t4.start();
		
		System.out.println("TOTAL THREAD: " + Thread.activeCount());
		
		
	}
}
