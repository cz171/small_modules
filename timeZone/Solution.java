package timeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
		Date date = new Date(2016, 2, 22);
		Date date1 = new Date(2016, 2, 22, 22, 2);
		System.out.println(date);
		System.out.println(date1);
		
		Calendar calendar = new GregorianCalendar();
		TimeZone timeZone = calendar.getTimeZone();
		System.out.println(timeZone.getDisplayName());
	}

}
