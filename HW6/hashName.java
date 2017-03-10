
public class hashName {
	private String name;
	private int size;
/**
 * Construction function for hashName class
 * @param s name
 * @param size size of the list of names
 */
	public hashName(String s, int size )
	{
		this.name = s;
		this.size = size;
	}
/**
 *@return absolute value of the default hash code of the name and mod 10
 */
	public int hashCode()
	{

		int cod = this.name.hashCode()%size + 1;
		return Math.abs(cod);
	}

	/**
	 * Hashcode uses sum of Ascii.
	 * @return hashcode of the sum of Ascii of the name characters
	 */
	public int hashCode1()
	{
		int hashKey = 0;
		for (char c: this.name.toCharArray()){
			hashKey+= (int) c;
		}
		return hashKey%size+1;
	}
	public String getName(){
		return this.name;
	}
	/**
	 * djb2 Hashing algorithim 
	 * this algorithm (k=33) was first reported by dan bernstein many years ago
	 * A newer version now uses xor: hash(i) = hash(i - 1) * 33 ^ str[i]; the magic of number 33 
	 * djb2 is a popular hashing algorithim that works quite well on all types of strings. 
	 * 
	 * It has excellent distribution, and speed, on many different sets of of keys/table sizes
	 */
	public int hashCode2(){
		String str = this.name;
		
	    int hashKey = str.length();

	      for(int i = 0; i < str.length(); i++)
	      {
	    	  hashKey += hashKey << 97 ^ (int) str.charAt(i);
	    	  //hashKey += ((hashKey << 5) ^ (hashKey >> 27)) ^ str.charAt(i);
	    	 // hashKey = hashKey * 33 + i;
	      }
	      return hashKey%size + 1;
	}
}
