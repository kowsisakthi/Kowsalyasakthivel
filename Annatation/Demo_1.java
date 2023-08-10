package Annatation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Demo_1 {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Sample s = Container.set();
		s.m2();
	}

}

class Container {
	static public Sample set() throws NoSuchMethodException, SecurityException {
		Sample s = new Sample();
		Class c = s.getClass();
		Method m = c.getDeclaredMethod("m2");
		m.setAccessible(true);
		step t = m.getAnnotation(step.class);
		Success s1=m.getAnnotation(Success.class);
		// System.out.println(t);
		if (t != null) {
			return new Sample (new Feature(),t,new ExtraFeature(),s1);
		}
		else if(s1!=null) {
			return new Sample (new Feature(),t,new ExtraFeature(),s1);
		}
		return new Sample();
	}

}

class Sample {
	Feature feature;
	step t;
	ExtraFeature extra;
	Success s1;
	public Sample(Feature feature,step t,ExtraFeature extra,Success s1) {
		this.feature=feature;
		this.t=t;
		this.extra=extra;
		this.s1=s1;
		
	}
	public Sample() {
		// TODO Auto-generated constructor stub
	}

	public Sample(Feature feature, step t) {
		this.feature = feature;
		this.t = t;
	}

	public void m1() {
		System.out.println("this.......");

	}

	@step
	@Success
	public void m2() {
		System.out.println("this is m2");
		m1();
		if (t != null) {
			feature.add();
		}
		 if(s1!=null) {
			extra.fact();
		}
	}

}

class Feature {
	public void add() {

		System.out.println("this is the feature ...");
	}

}
class ExtraFeature{
	public void  fact() {
		System.out.println("this is the extra feature");
	}
	
}
@Retention(RetentionPolicy.RUNTIME)
@interface step {

}
@Retention(RetentionPolicy.RUNTIME)
@interface Success{
	
}