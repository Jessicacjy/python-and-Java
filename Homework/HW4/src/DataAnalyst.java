import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * DataAnalyst create arraylist for employee objects and some function for information retrieval.
 */
public class DataAnalyst {

	private ArrayList<Employee> al;
	private int cur;
	private float salarySum;
	private String salaryMaxEmp;
	private int ageSum;
	private int numAb;

	/**
	 *  Constructor function for DataAnalyst 
	 */
	public DataAnalyst(){
		this.al = new ArrayList<Employee>();
		this.cur = 0;
		this.salaryMaxEmp = null;
		this.salarySum = 0;
		this.ageSum = 0;
		this.numAb = 0;
	}

	/**
	 * read txt file into a ArrayList contains employee objects.
	 * @param String filestr filename of employee record
	 * 
	 **/
	public void setEmployees(String filestr) throws ParseException, IOException{
		String thisLine = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filestr));
			while ((thisLine = br.readLine()) != null) {
				Employee ob = new Employee(thisLine);
				this.al.add(ob);
				++this.cur;
			}    
			br.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		this.setResult();
	}

	/**
	 * From the ArrayList, calculate the name of employee who has the maximum salary, total of age and total of salary.
	 */
	private void setResult(){
		float salaryMax = 0;
		for (int i = 0; i < this.cur; ++i){
			float tempS = this.al.get(i).getSalary();
			int tempA = this.al.get(i).getAge();
			if(tempS > salaryMax){
				salaryMax = tempS;
				this.salaryMaxEmp = this.al.get(i).getName();
			}
			this.salarySum += tempS;
			this.ageSum += tempA;
		}
	}

	/**
	 * Get the number of employees in the arraylist
	 * @return int number of employees
	 */
	public int numEmployee(){
		return this.cur;
	}

	/**
	 * Get the name of maximum Salary employee
	 * @return String name of the employee who has  maximum salary
	 */
	public String maxSalaryName(){
		//System.out.print(this.salaryMaxEmp);
		return this.salaryMaxEmp;
	}

	/**
	 * Get the average of employee salary
	 * @return float employee salary average
	 */
	public float avgSalary(){
		
		return this.salarySum/this.cur;
	}

	/**
	 * Get the number of employee that salary above average
	 * @return int: number of employees that has above average salary
	 */
	
	public int numAbov(){
		float avg = this.salarySum/this.cur;
		for (int i = 0; i < this.cur; ++i){
			if (al.get(i).getSalary()>avg) {
				++this.numAb;
			}
		}
		return this.numAb;
	}

	/**
	 * Get the average age of all the employee
	 * @return float: the average of all the employee
	 */
	public int aveAge(){
		return this.ageSum/this.cur;
	}

	/**
	 * Write file of all employee names sorted by their salary
	 * @throws IOException
	 */
	public void writeFile() throws IOException{
		Collections.sort(al, new ComparebleDA());
		try {
			FileWriter file = new FileWriter("EmployeeSalarySorted.txt");
			String sb = "\n==============================================\nThe Employee names sorted by their salary: \n";
			for (Employee e: al) {  
				sb += e.getName() + ","+e.getSalary()+"\n";
				file.write(sb);
			}
			file.close();
			System.out.println(sb);
		}catch(IOException e){
			
		}
	}
}




