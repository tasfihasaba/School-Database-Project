

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person implements Comparable<Person> {
    
	private static int numStudents;
    private int studentID;
    private Course[] coursesTaken;
    private int numCoursesTaken;
    private boolean isGraduate;
    private String major;

    public Student() {
        super();
        this.coursesTaken = new Course[50]; //initialize to length of 50
        this.numCoursesTaken = 0;
        this.isGraduate = false;
        setMajor(null);
        this.studentID = ++numStudents; //generated
    }

    public Student(boolean isGraduate) {
        super(); //calling the superclass methods, to access the superclass constructor
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        setMajor(null);
        this.studentID = ++numStudents;
    }

    public Student(String major, boolean isGraduate) {
        super();
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        setMajor(major);
        this.studentID = ++numStudents;
    }

    public Student(String name, int birthYear, String major, boolean isGraduate) {
        super(name, birthYear);
        this.coursesTaken = new Course[50];
        this.numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        setMajor(major);
        this.studentID = ++numStudents;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean graduate) {
        isGraduate = graduate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null || major.isEmpty()) {
            this.major = "undeclared";
        } else {
            this.major = major;
        }
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public int getStudentID() {
        return studentID;
    }

    public void addCourseTaken(Course course) {
        if (numCoursesTaken < 50) {
            this.coursesTaken[numCoursesTaken++] = course;
        }
    }

    public void addCoursesTaken(Course[] course) {
       for (Course c : course) {
           addCourseTaken(c);
       }
    }

    public Course[] getCoursesTaken() {
        return coursesTaken;
    }

    public int getNumCoursesTaken() {
        return numCoursesTaken;
    }

    public Course getCourseTaken(int index) {
        if (invalidIndex(index)) return null;
        return coursesTaken[index];
    }

    public String getCourseTakenAsString(int index) {
        Course course = getCourseTaken(index);
        if (course == null) return "";
        return String.format("%s-%s", course.getCourseDept(), course.getCourseNum());
    }

    public String getAllCoursesTakenAsString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numCoursesTaken; i++) {
            builder.append(getCourseTakenAsString(i)).append(",");
        }
        return builder.length() > 0 ? builder.deleteCharAt(builder.length() - 1).toString() : builder.toString();
    }

    public int getNumCredits() {
        int credits = 0;
        for (int i = 0; i < numCoursesTaken; i++) {
            credits += coursesTaken[i].getNumCredits();
        }
        return credits;
    }

    private boolean invalidIndex(int index) {
        return index < 0 || index >= numCoursesTaken;
    }

    @Override
    //use the Comparable interface specification, sort by numCredits
    public int compareTo(Person p) {
        if (p == null) throw new NullPointerException("The specified object is null");
        if (this.getClass() != p.getClass()) throw new ClassCastException("The specified object type prevents it from being compared to this object");
        return Integer.compare(this.numCoursesTaken, ((Student) p).numCoursesTaken);
    }

    @Override
    //Followed the content of person
    public String toString() {
        return String.format("%s Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", super.toString(), studentID, major, isGraduate ? "Graduate" : "Undergraduate", numCoursesTaken, getAllCoursesTakenAsString());
    }

    @Override
    //all attributes inherited+local must match for 2 Student objects to be considered equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentID == student.studentID &&
                numCoursesTaken == student.numCoursesTaken &&
                isGraduate == student.isGraduate &&
                Arrays.equals(coursesTaken, student.coursesTaken) &&
                major.equals(student.major);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), studentID, numCoursesTaken, isGraduate, major);
        result = 31 * result + Arrays.hashCode(coursesTaken);
        return result;
    }
}



