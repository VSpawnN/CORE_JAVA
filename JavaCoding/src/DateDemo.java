import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date= new Date();
		SimpleDateFormat sd = new SimpleDateFormat("MM/D/YYYY");
		System.out.println(date.toString());
		System.out.println(sd.format(date));
		
	}

}
