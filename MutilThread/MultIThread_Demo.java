package MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultIThread_Demo {
	public static void main(String[] args) {
		CinemaHall c1= new CinemaHall();
		CinemaHall c2= new CinemaHall();
		ExecutorService ex= Executors.newFixedThreadPool(2);
		ex.execute(new Runnable() {
			
			@Override
			public void run() {
				synchronized ( Toilet.class) {//class lock
					Thread.currentThread().setName("kamal");
				CinemaHall.t.useToilet();
					
					
				}
				
			}
		});
		//ex.shutdown();
	
	ex.execute(new Runnable() {
		
		public void run() {
			synchronized ( Toilet.class) {
				Thread.currentThread().setName("ranjini");
			CinemaHall.t.useToilet();
				
				
			}
			
		}
	});
	ex.shutdown();
}

}
class CinemaHall{
	 static Toilet t= new Toilet();
	 public CinemaHall() {
		 System.out.println("Cinemahall is created.....");
	}
	
}
class Toilet{
	public Toilet() {
		System.out.println("Toilet is created...");
	}
	public void useToilet() {
		Thread t= Thread.currentThread();
		String name= t.getName();
		System.out.println(name+" "+"is use it");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			
		}
		System.out.println(name+" "+"cominng out ");
}
}