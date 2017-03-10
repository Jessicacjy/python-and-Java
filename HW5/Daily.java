import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Daily extends Appointment{
	private Date date1;
	private Date date2;

	public Daily(int year1, int month1, int day1,int year2, int month2, int day2, String description) throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		this.date1 = dt.parse(String.format("%d-%d-%d", year1, month1, day1)); 
		this.date2 = dt.parse(String.format("%d-%d-%d", year2, month2, day2));
		this.setDescription(description);
	}

	@Override
	public boolean occursOn(int year_ck, int month_ck, int day_ck) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		Date date_check;
		try {
			date_check = dt.parse(String.format("%d-%d-%d", year_ck, month_ck, day_ck));
			return this.date1.before(date_check) && this.date2.after(date_check);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	

	@Override
	public void printApp(int year_ck, int month_ck, int day_ck) {
		//System.out.println(this.getDescription());
		if (occursOn(year_ck, month_ck, day_ck)){
			System.out.printf("Daily %d-%d-%d\t %s \n",year_ck, month_ck, day_ck,this.getDescription());
		}
	}

}
