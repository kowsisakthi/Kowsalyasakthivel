package MutilThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Method_Lock {
	public static void main(String[] args) {
		Counselling coun= new Counselling();
		ExecutorService ex= Executors.newFixedThreadPool(3);
		ex.execute(new Runnable() {
			
			@Override
			public void run() {
				Thread.currentThread().setName("kowsi");
				coun.table1();
				coun.table2();
				coun.table3();
				
			}
		});
		ex.execute(new Runnable() {
			
			@Override
			public void run() {
				Thread.currentThread().setName("kavi");
				coun.table1();
				coun.table2();
				coun.table3();
				
			}
		});
	}
	

}
class Counselling{
	 synchronized public void table1() {
		String name=Thread.currentThread().getName();
		System.out.println(name+""+ "in table1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+""+"the out of table1");
	}
	synchronized public void table2() {
		String name= Thread.currentThread().getName();
		System.out.println(name+ " "+"in table2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+""+"the out of the table2"); 
	}
	synchronized public void table3() {
		String name= Thread.currentThread().getName();
		System.out.println(name+""+"in tabel3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+""+"the out of the table3");
	}
}