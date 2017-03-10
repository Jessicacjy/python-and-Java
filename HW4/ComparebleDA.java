import java.util.*;
/**
 * ComparebleDA class connect to Comparator interface which imposes a total ordering on some collection of objects
 * Comparator can be passed to a sort method to allow precise control over the sort order.
 * @author Jessica C
 */
class ComparebleDA implements Comparator <Employee> {
	/**
	 * Comparable two objects' salary and return their results.
	 * @return 1 if first employee object has higher salary.
	 * @return -1 if second employee object has higher salary.
	 * @return 0 if the two employee objects have same salary.
	 */
    public int compare(Employee emp1, Employee emp2) {

        int value = 0;
        if (emp1.getSalary() > emp2.getSalary())
            value = 1;
        else if (emp1.getSalary() < emp2.getSalary() )
            value = -1;
        else if (emp1.getSalary()  == emp2.getSalary() )
            value = 0;
        return value;
    }
}