
public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n=4;
		normalLoop(n);
		invertedLoop(n);
		resetLoop(n);
		multipleOfThree(n);
	}
	
	public static void normalLoop(int n)
	{
		int num=1;
		System.out.println("Normal Loop Started");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-i;j++)
			{
				System.out.print(num+"\t");
				num++;
			}
			System.out.println("");
		}
		System.out.println("Normal Loop End");
	}
	
	public static void invertedLoop(int n)
	{
		int num=1;
		System.out.println("Inverted Loop Started");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(num+"\t");
				num++;
			}
			System.out.println("");
		}
		System.out.println("Inverted Loop End");
	}
	
	public static void resetLoop(int n)
	{
		System.out.println("Reset Loop Started");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(j+"\t");
			}
			System.out.println("");
		}
		System.out.println("Reset Loop End");
	}
	
	public static void multipleOfThree(int n)
	{
		int num=1;
		System.out.println("Multiple of 3 Loop Started");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(num*3 + "\t");
				num++;
			}
			System.out.println("");
		}
		System.out.println("Multiple of 3 Loop End");
	}

}
/*
1
2	3
4	5	6
7	8	9	10
*/

