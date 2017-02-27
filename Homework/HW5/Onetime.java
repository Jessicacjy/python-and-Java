import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Onetime extends Appointment{
	private Date date;

	public Onetime(int year, int month, int day, String description) throws ParseException{
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		this.date = dt.parse(String.format("%d-%d-%d",year, month, day));
		this.setDescription(description);
	}	

	@Override
	public boolean occursOn(int year_ck, int month_ck, int day_ck) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		Date date_ck;
		try {
			date_ck = dt.parse(String.format("%d-%d-%d",year_ck, month_ck, day_ck));
			return (date_ck.equals(this.date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void printApp(int year_ck, int month_ck, int day_ck) {

		if (occursOn(year_ck, month_ck, day_ck)){
			System.out.printf("Onetime %d-%d-%d\t %s\n",year_ck, month_ck, day_ck,this.getDescription());
			}
	}
}


