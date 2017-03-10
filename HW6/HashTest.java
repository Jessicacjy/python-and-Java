import java.util.InputMismatchException;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Scanner;

public class HashTest {
	/**
	 * Ask user for size input only 100 or 200 are allowed
	 * @return integer size
	 */

	private static int getSize(){
		int size;
		while(true){
			System.out.println("Please input the size of the array: ");
			Scanner scan = new Scanner(System.in);
			try{
				size = scan.nextInt();
				if(size == 100 || size == 200){
					//System.out.println(up);
					//System.out.print(i);
					return size;
				}
				throw new InputMismatchException();

			}
			catch(InputMismatchException exception){
				System.err.println("Invalid input! Please Try again");
			}
			scan.next();
		}
	}
	/**
	 * Write hash table into text file. 
	 * @param file
	 * @param hashmap
	 * @param size
	 * @return empty hash code rate
	 * @throws IOException
	 */
	private static float writeHash(File file, HashMap<Integer, String> hashmap, int size) throws IOException{
		int empty = 0;

		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			for (int i=1; i < size+1; i++){
				if (hashmap.containsKey(i)){
					bw.write(i+": "+hashmap.get(i));
					bw.newLine();
				}
				else {
					empty += 1;
				}
			}
			bw.close();
		return (float)empty / size;
	}

	/**
	 * main function
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int size; 
		size = getSize();
		System.out.println(size);
		BufferedReader br = new BufferedReader (new FileReader ("/Users/Jesica/Documents/workspace/HW6/src/input.txt"));
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> hmap1 = new HashMap<Integer, String>();
		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();
		HashMap<Integer, String> hmap3 = new HashMap<Integer, String>();
		for (int i = 0; i < size; i++){
			hashName name = new hashName(br.readLine(),size);
			if (hmap1.containsKey(name.hashCode())){
				String temp = hmap1.get(name.hashCode()) + ", " + name.getName();
				hmap1.put(name.hashCode(), temp);
			}
			else{
				hmap1.put(name.hashCode(),name.getName());}
			if (hmap2.containsKey(name.hashCode1())){
				String temp = hmap2.get(name.hashCode1()) + ", " + name.getName();
				hmap2.put(name.hashCode1(), temp);
			}
			else{
				hmap2.put(name.hashCode1(),name.getName());}
	
		if (hmap3.containsKey(name.hashCode2())){
			String temp = hmap3.get(name.hashCode2()) + ", " + name.getName();
			hmap3.put(name.hashCode2(), temp);
		}
		else{
			hmap3.put(name.hashCode2(),name.getName());}
		}
		for (Map.Entry<Integer, String> entry : hmap1.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		File fout1 = new File("output1"+"_size"+".txt");
		float rate1 = writeHash(fout1, hmap1,size );
		File fout2 = new File("output2"+"_size"+".txt");
		float rate2 = writeHash(fout2, hmap2,size );
		File fout3 = new File("output3"+"_size"+".txt");
		float rate3 = writeHash(fout3, hmap3,size );
		System.out.printf("For size %d, the empty rate for default hash code is %f, \nthe empty rate for Ascii method is %f,\nthe empty rate for new method is %f", size, rate1, rate2,rate3);
	}

}
