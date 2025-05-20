package practice1;

public class GenericMethodPractice {

	public static void main(String[] args) {//caller function
		// TODO Auto-generated method stub
		
		int sum = add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,20));
		System.out.println(add(30,20));
		int diff = sub(10,20);
		System.out.println(diff);
		int multiplication = mul(10,20);
		System.out.println(multiplication);
		int division = div(10,20);
		System.out.println(division);
	}

	public static int add(int a, int b)//called function-generic method
	{
				int c=a+b;
		        return c;
	}
	
	public static int add(int a, int b,int s)//called function-generic method
	{
				int c=a+b+s;
		        return c;
	}
	
	
	public static int sub(int a, int b)//called function-generic method
	{
				int c=a-b;
		        return c;
	}
	
	public static int mul(int a, int b)//called function-generic method
	{
				int c=a*b;
		        return c;
	}
	
	public static int div(int a, int b)//called function-generic method
	{
				int c=a/b;
		        return c;
	}
}
