import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		
		Calendar cal= Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("MM/DD/YYYY");
		System.out.println("Date Formatted into MM/DD/YYYY:\t"+sd.format(cal.getTime()));
		System.out.println("Getting the day of the current month:\t"+cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Getting the hour of the current day in 12 hour time:\t"+cal.get(Calendar.HOUR));
		System.out.println("Getting the hour of the current day in 24 hour time:\t"+cal.get(Calendar.HOUR_OF_DAY));

	}

}
