
public class CurrencyConvertor {
	/**Write a java program that:
		- Ask the user to type the price for one dollar in Japanese yen.
		- The program will allow the user to convert from dollars to yen and vice versa.
		- At any point of time the user can request to change the conversion rate.
		- The program stops after a sentinel character entry.
		Insure user entry validation at all time. No Crashes or unexpected results.
	**/
	float rate;
	public CurrencyConvertor(){
		this.rate = 0;
	}

	public void setCurrencyConvertor(float rate){
		this.rate = rate;
	}
	public float dyConvert(float d){
		return d*this.rate;
	}
	public float ydConvert(float y){
		return y/this.rate;
	}
	
}
