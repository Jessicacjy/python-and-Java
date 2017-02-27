import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.lang.Object;
import java.lang.reflect.Array;


public class testAppointment{
	/**
	 * This get a correct integer input within its lower and upper bound
	 * @param str String to print for output
	 * @param lw Lowerbound of the integer
	 * @param up Uperbound of the integer
	 * @return
	 */
	
	private static int getInt(String str,int lw, int up){
		Scanner scan = new Scanner(System.in);
		
		int i;
		while(true){
			System.out.println(str);
			try{
				i = scan.nextInt();
				if(i > up || i < lw){
					//System.out.println(up);
					//System.out.print(i);
					throw new InputMismatchException();
				}

				return i;
			}
			catch(InputMismatchException exception){
				System.err.println("Invalid input! Please Try again");
			}
			scan.next();
		}
	}
	private static int getday(String day, int mon_i) throws Exception{
		if (mon_i == 2){
			return getInt(day,1,28);
		}
		if (mon_i == 4 || mon_i == 6 ||mon_i == 9 ||mon_i == 11){
			return getInt(day,1,30);
		}
		return getInt(day,1,31);
	}
	private static String getDesc (){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the description:\n");
		return scan.nextLine();
	}

	public static void main(String[] args) throws Exception { 
		ArrayList<Appointment> apps = new ArrayList<>();
		int curr = 0;
		Scanner scan = new Scanner(System.in);
		Appointment[] appArr = new Appointment[1000];
		int idx = 0;
		String instruct1 = "Please enter your appointment type\n 1 One time\n 2 Daily \n 3 Monthly\n :";
		String instruct2 = "Please enter the description: ";
		String instruct = "Check summary: 1 add appointment, 2 list appointment date, 0 Eit\n";
		String year1 = "Please enter the start date year yyyy: ";
		String mon1 = "Please enter the start date month mm: ";
		String day1 = "Please enter the start date day dd: ";
		String year2 = "Please enter the end date year yyyy: ";
		String mon2 = "Please enter the end date month mm: ";
		String day2 = "Please enter the end date day dd: ";
		String year = "Please enter the date year yyyy: ";
		String mon = "Please enter the date month mm: ";
		String day = "Please enter the date day dd: ";
		String monday = "Please enter the date of month dd: ";
		String check_y = "Year:";
		String check_m = "Month:";
		String check_d = "Day:";
		
				
		
		String Formate = "mm/dd/yyyy";
		final int[] mon31day = new int[] {1,3,5,7,8,10,12};

		
		int ans = getInt(instruct,0, 2);
		while(ans != 0){
			System.out.print(ans);
			switch(ans){
			case 1:
				int ans1 = getInt(instruct1,1, 3);
				switch(ans1){
				case 1: 
					//One time
					int year_i = getInt(year,1900, 2100);
					int mon_i = getInt(mon,1,12);
					int day_i = getday(day, mon_i);
					String desc = getDesc();
					apps.add(new Onetime(year_i, mon_i, day_i, desc));
					++ curr;
					break;
				case 2:
					int year_b = getInt(year1,1900, 2100);
					int mon_b = getInt(mon1,1,12);
					int day_b = getday(day1, mon_b);
					int year_e = getInt(year2,1900, 2100);
					int mon_e = getInt(mon2,1,12);
					int day_e = getday(day2, mon_e);
					String desc_d = getDesc();
					apps.add(new Daily(year_b, mon_b, day_b, year_e, mon_e, day_e, desc_d));
					++ curr;
					break;
				case 3:
					int year_be = getInt(year1,1900, 2100);
					int mon_be = getInt(mon1,1,12);
					int year_en = getInt(year2,1900, 2100);
					int mon_en = getInt(mon2,1,12);
					int day_en = getInt(monday, 1,31);
					String desc_m = getDesc();
					apps.add(new Monthly(year_be, mon_be,  year_en, mon_en, day_en, desc_m));
					++ curr;
					break;
				}
				break;

			case 2:
				// check appointment date
				int year_ck = getInt(year,1900, 2100);
				int mon_ck = getInt(mon,1,12);
				int day_ck = getday(day, mon_ck);
				//System.out.println("fj 2");
				System.out.println("Type\t Date \t\t Description");
				for (int i=0; i<curr; i++){
					
				    apps.get(i).printApp(year_ck, mon_ck, day_ck);//this will set names in format newNameX
				}
				break;

			}
			//scan.next();
			ans = getInt(instruct,0, 2);
			
		}
		System.out.print("Thank you!");
	}
}