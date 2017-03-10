import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Monthly extends Appointment{
	private Date date1;
	private Date date2;
	private int day;

	public Monthly(int year1, int month1, int year2, int month2, int day,String description) throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm"); 
		this.date1 = dt.parse(String.format("%d-%d-01", year1, month1)); 
		this.date2 = dt.parse(String.format("%d-%d-31", year2, month2));
		this.day = day;
		this.setDescription(description);
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean occursOn(int year_ck, int month_ck, int day_ck) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		Date date_check;
		try {
			date_check = dt.parse(String.format("%d-%d-%d", year_ck, month_ck, day_ck));
			return this.date1.before(date_check) && this.date2.after(date_check) && day_ck == this.day;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	

	@Override
	public void printApp(int year_ck, int month_ck, int day_ck) {
		if (occursOn(year_ck, month_ck, day_ck)){
			System.out.printf("Monthly %d-%d-%d\t%s\n",year_ck, month_ck, day_ck,this.getDescription());
		}
	}

}
