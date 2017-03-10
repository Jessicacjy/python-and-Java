/**
 * 
 * Employee class creates employee objects.
 * 
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee{
	/* Declare private instance variables */
	private String name;
	private Date dob;
	private float salary;
	private int age;

	/*Constructor for Employee class */
	public Employee(String str) throws ParseException{
		String[] output = str.split(",");
		this.name = output[0];
		//Parse Date formate for date of birth
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.dob = formatter.parse(output[1]);
		this.salary = Float.valueOf(output[2]);
		this.age = setAge();
	}
	

	public String getName(){
		return this.name;
	}

	public Date getDob(){
		return this.dob;
	}

	public float getSalary(){
		return this.salary;
	}

	/**
	 * Calculate age of employee from date of birth.
	 * @return int age of employee
	 */
	public int setAge(){
		Calendar now = Calendar.getInstance();
		Calendar cal = new GregorianCalendar();
		cal.setTime(this.dob);
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    
	    // Cast date to integers and the age is Now- DOB/10000
	    return (-(year * 10000 + month * 100+ day) +( now.get(Calendar.YEAR)
	    		* 10000+ now.get(Calendar.MONTH) * 100 + now.get(Calendar.DAY_OF_MONTH)))/10000;
	    
	}
	
	
	public int getAge(){
		return this.age;
	}

}
