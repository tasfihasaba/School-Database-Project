

import java.util.Objects;

public class Course implements Comparable<Course> {
	
    private boolean isGraduateCourse;  //Assigned isGraduateCourse as boolean
    private int courseNum;    // Assigned courseNum as Integer
    private String courseDept; //Assigned courseDept as String
    private int numCredits; //Assigned numCredits as Integer

    //Constructor
    public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
        this.isGraduateCourse = isGraduateCourse; //referring to the current object in the constructor
        this.courseNum = courseNum;               //to eliminate the confusion between class attributes and parameters
        this.courseDept = courseDept;
        this.numCredits = numCredits;
    }

    public boolean isGraduateCourse() {
        return isGraduateCourse;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public int getNumCredits() {
        return numCredits;
    }

    //return String of “U” or “G” + courseDept + courseNum
    public String getCourseName() {
        return String.format("%s%s%s", isGraduateCourse ? "G" : "U", courseDept, courseNum);
    }

    @Override
    //all attributes must match for 2 Course objects to be considered equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (isGraduateCourse != course.isGraduateCourse) return false;
        if (courseNum != course.courseNum) return false;
        if (numCredits != course.numCredits) return false;
        return courseDept.equals(course.courseDept);
    }

    @Override
    public String toString() {
        return String.format("Course: %3s-%3d | Number of Credits: %02d | %s", courseDept, courseNum, numCredits, isGraduateCourse ? "Graduate" : "Undergraduate");
       
    }
    //use the Comparable interface specification. Sort by courseNum
    public int compareTo(Course c) {
        if (c == null) throw new NullPointerException("The specified object is null");
        if (this.getClass() != c.getClass()) throw new ClassCastException("The specified object type prevents it from being compared to this object");
        return Integer.compare(this.courseNum, c.courseNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isGraduateCourse, courseNum, courseDept, numCredits);
    }
}



