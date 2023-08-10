package Exception;

public class ExceptionClass {
	public static  void excep()
	{
		throw new ArithmeticException("this is the arithmetic exception");
	}
	public static void main(String[] args) {
		try {
			//excep();
			throw new ArrayIndexOutOfBoundsException();
		}
		catch(ArithmeticException ex)
		{
			//System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e1)
		{
			e1.printStackTrace();
		}
		
	}

}
