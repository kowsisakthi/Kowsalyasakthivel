package Exception;
import java.util.Scanner;
public class DemoException {
	
	public static void main(String[] args) throws Exception {
		Scanner input= new Scanner (System.in);
		
		Tiger t= new Tiger();
		Villagers v= new Villagers();
		System.out.println("enter the weapon.....");
		String weaa=input.next();
		Weapon wep= (Weapon) Class.forName(weaa).newInstance();
		v.fightwithTiger(t, wep);
		
	}

}
class Tiger{
	public void  equipment(Weapon w) throws TigerException
	{
		w.material();
	}
}
class Villagers{
	public void fightwithTiger(Tiger t,Weapon ww) {
		try {
			t.equipment(ww);
		}
		catch (TigerException e) {
			e.visit();
			e.printStackTrace();
		}
	}
	
}
  class ForestOfficer{
	public void handle(TigerBiteException di) {
		System.out.println("call the ambalance..... ");
	}
	public void handle(TigerSoundException ds) {
		System.out.println("Rnu fast........");
	}
	public void handle(TigerRunException dr) {
		System.out.println("the tiger is  run.....");
	}
}
 
 
 abstract class Weapon{
	 abstract void material() throws TigerException;
 }
 class Stick extends Weapon{

	@Override
	void material() throws TigerException {
		throw new TigerBiteException();
	}
	 
 }
 class Stone extends Weapon{

	@Override
	void material() throws TigerException {
		throw new TigerSoundException();
		
	}
	 
 }
 class Gun extends Weapon{

	@Override
	void material() throws TigerException {
		throw new TigerRunException();
	}
	 
 }
 
abstract class TigerException extends Exception{
	abstract void visit();
}
class TigerBiteException extends TigerException{

	@Override
	void visit() {
		new ForestOfficer().handle(this);
		
	}
	
}
class TigerSoundException extends TigerException{

	@Override
	void visit() {
		new ForestOfficer().handle(this);
	}
	
}
class TigerRunException extends TigerException{

	@Override
	void visit() {
		new ForestOfficer().handle(this);
	}
	
}
