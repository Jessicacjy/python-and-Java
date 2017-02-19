/**Write a java program that:
	- Ask the user to type the price for one dollar in Japanese yen.
	- The program will allow the user to convert from dollars to yen and vice versa.
	- At any point of time the user can request to change the conversion rate.
	- The program stops after a sentinel character entry.
	Insure user entry validation at all time. No Crashes or unexpected results.
 **/
import java.util.Scanner;
import java.util.InputMismatchException;

public class CurrencyConvertorTest {

	/**
	 * Given a String that can parse to a float, check if exception and ask user input
	 * until there is a correct input
	 * @param str user input
	 * @return float: float contains in the input.
	 */
	private static float getFloat(String str){
		Scanner scan = new Scanner(System.in);
		float flt;
		while(true){
			System.out.println(str);
			try{
				flt = scan.nextFloat();
				break;
			}
			catch(InputMismatchException exception){
				System.err.println("Invalid input! please try again!");
				scan.nextLine();
			}
		}
		return flt;
	}
	
	/**
	 * Given a String that can parse to a int, check if exception and ask user input
	 * until there is a correct input
	 * @param str user input
	 * @return int: int that contains in the input.
	 */
	private static int getInt(String str){
		Scanner scan = new Scanner(System.in);
		int i;
		while(true){
			System.out.println(str);
			try{
				i = scan.nextInt();
				return i;
			}
			catch(InputMismatchException exception){
				System.err.println("Invalid input! Please Try again");
				scan.nextLine();
			}
		}
	}

	/**
	 * public static void main block for program execution.
	 * @param args
	 */
	public static void main(String[] args) {
		float rate;
		int convType = 0;
		String backCommand = "Please enter the number for the following options: \n0 New rate; \n1 Dollar to Yen; \n2 Yen to Dollor;  \n-1 Exit \n";
		String setRate = "Please enter a conversion rate for one dollar in Japanese yen:";
		String dy = "Please enter the Dollar amount: ";
		String yd = "Please enter the Yen amount: ";
		CurrencyConvertor cr = new CurrencyConvertor();
		//use while loop to ask for different options until -1 exit
		while(convType != -1){
			switch(convType){
			case 0:
				rate = getFloat(setRate);
				while (rate < 0){
					System.out.println("Invalid rate, please try again");
					rate = getFloat(setRate);
				}

				cr.setCurrencyConvertor(rate);
				break;
			case 1:
				System.out.printf("Yen: %.2f \n", cr.dyConvert(getFloat(dy)));
				break;
			case 2:
				System.out.printf("Dollar: %.2f \n", cr.ydConvert(getFloat(yd)));
				break;
			case -1:
				break;
			default:
				System.out.println("Invalild input! Please try again.");
			}
			convType = getInt(backCommand); 
		}
	}
}