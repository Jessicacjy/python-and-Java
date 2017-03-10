import java.util.Date;

public abstract class Appointment {
	private String description;
	private Date date;
	
	public abstract boolean occursOn(int year_ck, int month_ck, int day_ck);
	//check if the object has given date appointment.
	
	public abstract void printApp(int year_ck, int month_ck, int day_ck);
	//print if the object has given data appointment
	
	public Date getDate(){
		return this.date;
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
}
