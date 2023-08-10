package Exception;

public class Exception1 {
	public static void main(String[] args) {
		System.out.println("Exception handling");
		try {
			int a=5/0;
			int []arry= new int[0];
			int s=0;
			System.out.println(arry[0]);
			System.out.println(a);
		}
		
		catch(ArithmeticException e) {
			e.printStackTrace();
			
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
			System.out.println("Arayy.......");
			
		}
		catch(Exception e) {
			
		}
		finally {
			System.out.println("this is finally block.....");
		}
	}

}
