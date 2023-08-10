package Genrices;

import java.awt.Container;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Genrices_Demo1 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		success ss = () -> {
			System.out.println("your mobile name is....");
		};
		ss.all();

		Mobile<Sim> si = new SimContainer().getSim();
		Sim s1 = si.getT();
		s1.SIM();

		Mobile<Memery> mw = new MemeryContainer().getMem();
		Memery n = mw.getT();
		//n.quality();

		Memery AA = Mycontainer.mycon();
		AA.quality();
	}

}

class Mobile<T> {
	T obj;

	public void setT(T obj) {
		this.obj = obj;
	}

	public T getT() {
		return obj;
	}

}

class SimContainer {
	Mobile<Sim> getSim() {
		Mobile<Sim> m = new Mobile<>();
		m.setT(new Oppo());
		return m;
	}
}

class MemeryContainer {
	Mobile<Memery> getMem() {
		Mobile<Memery> m1 = new Mobile<>();
		m1.setT(new Oppo1());
		return m1;
	}
}

class Mycontainer {
	public static Memery mycon() throws NoSuchMethodException, SecurityException {
		Oppo1 opp = new Oppo1();
		Class c = opp.getClass();
		Method m1 = c.getDeclaredMethod("quality");
		m1.setAccessible(true);
		next n = (next) m1.getAnnotation(next.class);
		if (n != null) {
			opp.setOpp(new OppoFeature(), n);
		}
		return opp;
	}

}

abstract class Sim {
	public abstract void SIM();
}

class Vivo extends Sim {

	@Override
	public void SIM() {
		System.out.println("this is jio sim...,");
	}

}

class Oppo extends Sim {

	@Override
	public void SIM() {
		System.out.println("this is vodophone.....");
	}

}

class Nokia extends Sim {

	@Override
	public void SIM() {
		System.out.println("this is Airtel.....");
	}

}

abstract class Memery {
	public abstract void quality();
}

class Vivo1 extends Memery {

	@Override
	public void quality() {
		System.out.println("this memery is 32 GB...");
	}

}

class Oppo1 extends Memery {
	OppoFeature op;
	next n;

	public void setOpp(OppoFeature op, next n) {
		this.op = op;
		this.n = n;
	}
	
	@Override
	 @next
	public void quality() {

		if (n != null) {
			op.camera();

		}

		System.out.println("this memery is 64 GB....");
	}
}

class OppoFeature {
	public void camera() {
		System.out.println("The oppo mobile camera is high quality....");
	}
}

class Nokia1 extends Memery {

	@Override
	public void quality() {
		System.out.println("this memery is 16 GB..");
	}

}

interface success {
	public void all();
}

@Retention(RetentionPolicy.RUNTIME)
@interface next {

}
