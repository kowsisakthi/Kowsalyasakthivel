package MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread_Demo {
	public static void main(String[] args) {
		//new Thread_Demo();
		
		ExecutorService ex= Executors.newFixedThreadPool(2);
		ex.execute(new ThreadJob());
		ex.execute(new ThreadJob1());
		System.out.println("Main Thread calling........");
//	ThreadJob t= new ThreadJob();
//	t.run();
	}
	public Thread_Demo() {
		//thread created
		//ExecutorService ex= Executors.newFixedThreadPool(2);
		//execute thread
		//ex.execute(new ThreadJob());
		//ex.execute(new ThreadJob1());
	}

}

class ThreadJob implements Runnable{

	@Override
	public void run() {
		System.out.println("hiiiii.................");
		get() ;
	}
	public void get() {
		System.out.println("kowsi....");
	}
	
}
class ThreadJob1 implements Runnable{

	@Override
	public void run() {
		System.out.println("hello.................");
		get() ;
	}
	public void get() {
		System.out.println("kowsisakthi....");
	}
	
}

