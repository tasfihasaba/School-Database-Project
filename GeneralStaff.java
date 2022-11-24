
import java.util.Objects;

public class GeneralStaff extends Employee {
    private String duty; //Assigned duty as String

    public GeneralStaff() {
        super();
        this.duty = ""; //referring to the current object, which is duty
    }

    public GeneralStaff(String duty) {
        super();
        this.duty = duty;
    }

    public GeneralStaff(String deptName, String duty) {
        super(deptName);
        this.duty = duty;
    }

    public GeneralStaff(String name, int birthYear, String deptName, String duty) {
        super(name, birthYear, deptName);
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public String toString() {
        return String.format("%s GeneralStaff: Duty: %10s", super.toString(), duty);
    }

    @Override
    //all attributes inherited+local must match for 2 Staff objects to be considered equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GeneralStaff that = (GeneralStaff) o;
        return Objects.equals(duty, that.duty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duty);
    }
}
