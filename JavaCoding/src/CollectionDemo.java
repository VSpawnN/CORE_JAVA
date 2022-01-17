import java.util.ArrayList;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1,2,3,1,2,3,2,3,3,5,6,3,2,6,4,2,1,2,1,2,3,4,5,5,5,3,7,8,9};
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++)
		{
			int count=1;
			if(!al.contains(a[i]))
			{
				al.add(a[i]);
				
				for(int j=i+1;j<a.length;j++)
				{
					if(a[i]==a[j])
					{
						count++;						
					}
				}
				System.out.println(a[i]+":"+count);
				if(count==1)
					System.out.println(a[i]+" is an unique number in the array");
			}
		}
		
	}

}
