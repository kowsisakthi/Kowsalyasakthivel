package Reflaction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DemoAssinment {
	static Disease corona = new Corona();

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter the property name...:");
		System.out.println("property names are..:name,infectious,c,s");
		String p = scan.nextLine();
		findsuperclass(corona, p);
	}

	static void findsuperclass(Object c, String p) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class subclass = c.getClass();
		superclassfind(subclass, p);
	}

	static void superclassfind(Class a, String p) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class superclass = a.getSuperclass();
		if (superclass != null) {
			for (Field f : superclass.getDeclaredFields()) {
				if (f.getName().equals(p)) {
					if (f.getType() == String.class) {
						String str = f.getName();
						String s = "get" + Character.toUpperCase(str.charAt(0)) + str.substring(1);
						System.out.println(s);
						Class c = corona.getClass();
						Method m = c.getDeclaredMethod(s);
						// m.invoke(corona);
						System.out.println(m.invoke(corona));

					} else if (f.getType() == boolean.class) {
						String s = f.getName();
						String st = "is" + Character.toUpperCase(s.charAt(0)) + s.substring(1);
						System.out.println(st);
						Class c2 = corona.getClass();
						Method m = c2.getDeclaredMethod(st);
						m.invoke(corona);
						System.out.println(m.invoke(corona));

					}
				}
			}
			System.out.println(superclass);
			superclassfind(superclass, p);
		}
	}
}
	

	class Disease {
		public String name = "infectious";
		public boolean infectious = true;
		String c = "a";
		boolean s = false;
		public String getName() {
			return this.name;
		}

	}

	class Corona extends Disease {
		
		public boolean isInfectious() {
			return infectious;
		}

		String getC() {
			return this.c;
		}

		boolean isS() {
			return this.s;
		}
	}