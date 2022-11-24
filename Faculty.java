
import java.util.Arrays;
import java.util.Objects;

public class Faculty extends Employee implements Comparable<Person> {
    private Course[] coursesTaught;
    private int numCoursesTaught; //controlled variable, assigned it as Integer
    private boolean isTenured; //Assigned isTenured as boolean variable

    public Faculty() {
        super();
        this.coursesTaught = new Course[100]; // Set the Course to 100 to assume that the maximum number of courses a faculty has
                                             // taught cannot exceed 100

        this.numCoursesTaught = 0;
        this.isTenured = false;
    }

    public Faculty(boolean isTenured) {
        super();
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String deptName, boolean isTenured) {
        super(deptName);
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
        super(name, birthYear, deptName);
        this.coursesTaught = new Course[100];
        this.numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Course[] getCoursesTaught() {
        return coursesTaught;
    }

    public Course getCourseTaught(int index) { // Index must be verified. Return “null” if invalid
        if (invalidIndex(index)) return null;
        return coursesTaught[index];
    }

    public String getCourseTaughtAsString(int index) { // index must be verified. Return “” if invalid

        Course course = getCourseTaught(index);
        if (course == null) return "";
        return String.format("%s-%s", course.getCourseDept(), course.getCourseNum()); // returns “courseDept-courseNum”
    }

    public String getAllCoursesTaughtAsString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numCoursesTaught; i++) {
            builder.append(getCourseTaughtAsString(i)).append(","); // comma separated list of all courses taught
                                                                   //  uses getCourseTaughtAsString(int index) as a helper method
        }
        return builder.length() > 0 ? builder.deleteCharAt(builder.length() - 1).toString() : builder.toString();
    }

    public void addCourseTaught(Course course) {
        if (numCoursesTaught < 100) {
            this.coursesTaught[numCoursesTaught++] = course;
        }
    }

    public void addCoursesTaught(Course[] course) {
        for (Course c : course) {
            addCourseTaught(c);
        }
    }

    private boolean invalidIndex(int index) {
        return index < 0 || index >= numCoursesTaught;
    }

    public int getNumCoursesTaught() {
        return numCoursesTaught;
    }

    public boolean isTenured() {
        return isTenured;
    }

    public void setTenured(boolean tenured) {
        isTenured = tenured;
    }

    @Override
    //Followed the content of Employee
    public String toString() {
        return String.format("%s Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s", super.toString(), isTenured ? "Is Tenured" : "Not Tenured", numCoursesTaught, getAllCoursesTaughtAsString());
    }

    @Override
    // use the Comparable interface specification, sort by
    // numCoursesTaught
    public int compareTo(Person p) {
        if (p == null) throw new NullPointerException("The specified object is null");
        if (this.getClass() != p.getClass()) throw new ClassCastException("The specified object type prevents it from being compared to this object");
        return Integer.compare(this.numCoursesTaught, ((Faculty) p).numCoursesTaught);
    }

    @Override
    //all attributes inherited+local must match for 2 Faculty objects to be considered equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Faculty faculty = (Faculty) o;
        return numCoursesTaught == faculty.numCoursesTaught &&
                isTenured == faculty.isTenured &&
                Arrays.equals(coursesTaught, faculty.coursesTaught);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), numCoursesTaught, isTenured);
        result = 31 * result + Arrays.hashCode(coursesTaught);
        return result;
    }
}
