
import java.util.Objects;

public class Employee extends Person implements Comparable<Person> {
	
	private String deptName; //Assigned deptName as String
	private static int numEmployees; //Assigned numEmployees as Integer
    private int employeeID; //Assigned employee as Integer

    public Employee() {
        super();
        deptName = "";
        this.employeeID = ++numEmployees;
    }

    public Employee(String deptName) {
        super();
        this.deptName = deptName;
        this.employeeID = ++numEmployees;
    }

    public Employee(String name, int birthYear, String deptName) { //employeeID Compted
        super(name, birthYear);
        this.deptName = deptName;
        this.employeeID = ++numEmployees;
    }

    public String getDeptName() {
        return deptName;
    }

    public static int getNumEmployees() {
        return numEmployees;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return String.format("%s Employee: Department: %20s | Employee Number: %3d", super.toString(), deptName, employeeID);
    }

    @Override
    //use the Comparable interface specification. Sort by employeeID
    public int compareTo(Person p) {
        if (p == null) throw new NullPointerException("The specified object is null");
        if (this.getClass() != p.getClass()) throw new ClassCastException("The specified object type prevents it from being compared to this object");
        return Integer.compare(this.employeeID, ((Employee) p).employeeID);
    }

    @Override
    //all attributes inherited+local must match for 2 Employee objects to be considered equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID &&
                deptName.equals(employee.deptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deptName, employeeID);
    }
}
