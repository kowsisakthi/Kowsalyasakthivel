package Lambda;

public class Lambda_Demo {
	public static void main(String[] args) {
		Sample s = new Sample1();
		s.add(10, 20);

		new Sample() {

			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		}.add(10, 25);

		Sample s1 = Lambda_Demo::m1;
		s1.add(30, 40);
		Sample s2 = new Lambda_Demo()::m2;
		s2.add(50, 60);
		Sample s3 = (int a, int b) -> {
			return a + b;
		};
		System.out.println(s3.add(20, 30));
		A1 aa = () -> {
			System.out.println("this is a classs...");
		};
		aa.a1();
		A1 aaa = () -> {
			System.out.println("kowsiii............");
		};
		aaa.a1();

	}

	static public int m1(int a, int b) {
		System.out.println();
		return a + b;
	}

	public int m2(int a, int b) {
		return a + b;

	}
}

interface Sample {
	public int add(int a, int b);
}

class Sample1 implements Sample {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

}

interface A1 {
	public void a1();
}