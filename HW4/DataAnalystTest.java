/*
 * Data Analyst Question Test
 * Read from text file and answer all the questions in Q3
 */

import java.io.IOException;
import java.text.ParseException;

public class DataAnalystTest {
	/**
	 * Create DataAnalyst object and use its function to retrieve information.
	 * @param args String[]
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParseException, IOException {
		String filename = "/Users/Jesica/Google Drive/422Python and Java/HW4/src/employees.txt";
		DataAnalyst da = new DataAnalyst();
		da.setEmployees(filename);
		System.out.printf("The number of Employee: %d.\n", da.numEmployee());
		System.out.printf("%s has the Highest salary.\n", da.maxSalaryName());
		System.out.printf("The average salary is %f.\n", da.avgSalary());
		System.out.printf("The average age of employees is %d.\n", da.aveAge());
		System.out.printf("There are %d employees' salary above average",da.numAbov());
		da.writeFile();
	}

}
