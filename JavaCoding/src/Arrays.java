
public class Arrays {

	public static void main(String[] args) {
		
		
		int[][] a = new int[3][3];
		a[0][0] = 545;
		a[0][1] = 600;
		a[0][2] = 22;
		a[1][0] = 782;
		a[1][1] = 232;
		a[1][2] = 23112;
		a[2][0] = 212;
		a[2][1] = 5232;
		a[2][2] = 6;
		largestNumber(a);
		
	}
	
	public static void largestNumber(int[][] a)
	{
		int largest=a[0][0];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(largest>a[i][j])
					continue;
				else	
				largest = a[i][j];	
			}
		}
		System.out.println(largest);
	}
	
	public static void smallestnumber(int[][] a)
	{
		int smallest=a[0][0];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(smallest<a[i][j])
					smallest = a[i][j];	
			}
		}
		System.out.println(smallest);
	}
	
	

}
