package Genrices;

import java.util.Scanner;

import javax.xml.parsers.FactoryConfigurationError;

public class Annotation_Genrices {
public static void main(String[] args) {
	Car c=CarContainer.getCar();
	System.out.println(c);
}
}

class CarContainer {
	static Scanner sc = new Scanner(System.in);

	public  static Car getCar() {
		Car c1=null;
		System.out.println("enter the car :: Maruthi or Audi or Suzcki or Safori");
		String name = sc.next();
		if (name .equals("Maruthi")) {
			CarFactory f1 = new MaruthiFactory();
			ShowRoom s1 = new ShowRoom();
			c1 = s1.SellCar(f1);
			//System.out.println(c1);
		}
		if (name .equals("Audi")) {
			CarFactory f1 = new AudiFactory();
			ShowRoom s1 = new ShowRoom();
			c1 = s1.SellCar(f1);
		}
		if (name.equals("Suzcki") ) {
			CarFactory f1 = new SuzckiFactory();
			ShowRoom s1 = new ShowRoom();
			c1 = s1.SellCar(f1);

		}
		if (name .equals("Safori") ) {
			CarFactory f1 = new SaforiFactory();
			ShowRoom s1 = new ShowRoom();
			c1 = s1.SellCar(f1);

		}
		return c1;
	}
}

abstract class Car {
}

class Maruthi extends Car {
}

class Audi extends Car {
}

class Suzcki extends Car {
}

class Safori extends Car {
}

abstract class Factory {
	public abstract void make();
}

abstract class CarFactory extends Factory {

	@Override
	public void make() {
		makeCar();
	}

	public abstract Car makeCar();
}

class MaruthiFactory extends CarFactory {

	@Override
	public Car makeCar() {
		return new Maruthi();
	}

}

class AudiFactory extends CarFactory {

	@Override
	public Car makeCar() {
		return new Audi();
	}

}

class SuzckiFactory extends CarFactory {

	@Override
	public Car makeCar() {
		return new Suzcki();
	}

}

class SaforiFactory extends CarFactory {

	@Override
	public Car makeCar() {
		return new Safori();
	}

}

abstract class Seller {
	public abstract Car sell(CarFactory fact);
}

abstract class CarSeler extends Seller {

	@Override
	public Car sell(CarFactory fact) {
		return SellCar(fact);
	}

	public abstract Car SellCar(CarFactory fact);
}

class ShowRoom extends CarSeler {

	@Override
	public Car SellCar(CarFactory fact) {
		return fact.makeCar();
	}

}