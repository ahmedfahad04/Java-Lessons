class ThreadExample extends Thread {

	public void run(){

		int i = 0;
		while(i < 10){
			System.out.println(i + ", " + this.getName());
			i++;
		}
	}
	
}

class RunnableExample implements Runnable {
	
	public void run(){

		int i = 30;
		while(i < 50){
		System.out.println(i + ", " + Thread.currentThread().getName());
			i++;
		}
	}
	
}


public class JavaThreading {
	public static void main(String [] args) {
		
		ThreadExample thread1 = new ThreadExample();
		thread1.setName("FIRST");
		thread1.start();
		
		ThreadExample thread2 = new ThreadExample();
		thread2.setName("SECOND");
		thread2.start();
		
		Thread t1 = new Thread(new RunnableExample());
		t1.setName("THIRD");
		t1.start();
		
		Thread t2 = new Thread(new RunnableExample(){
			public void run(){
				System.out.println("INSIDE FOURTH THREADING");
			}
		});
		t2.setName("FOURTH");
		t2.start();
		
		Thread t4 = new Thread(() -> { // using lambda expressoin
			System.out.println("INSIDE FIFTH THREADING.....");
		});
		t4.setName("FIFTH");
		t4.start();
		
		System.out.println("TOTAL THREAD: " + Thread.activeCount());
		
		
	}
}
