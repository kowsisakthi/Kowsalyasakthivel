package MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutiThread_ObjectLockDemo {
	public static void main(String[] args) {
		ReservationTicket central= new ReservationTicket();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				synchronized (central) {
					Thread.currentThread().setName("Kamal");
					central.bookTicket(1000);
					central.getChange();
					
				}
				
			}
		});
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				//synchronized (central) {
					Thread.currentThread().setName("rajini");
					central.bookTicket(500);
					central.getChange();
					
				}
				
			//}
		});
		es.shutdown();
	}

}
class ReservationTicket{
	int amt;
	public void bookTicket(int amt) {
		 String name=Thread.currentThread().getName();
		 this.amt=amt;
		 System.out.println(name+"book the ticket");
	}
	public void getChange() {
		String name=Thread.currentThread().getName();
		amt=amt-100;
		System.out.println("the change is give to"+name+"::"+amt);
	}
}