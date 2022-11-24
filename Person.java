
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name; //Assigned name as String
    private int birthYear; //Assigned birthyear as Integer

    public Person() {
        this.name = "";
        this.birthYear = 0; //Set birthyear to 0
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    //use the Comparable interface specification. Sort by birthYear.
    public int compareTo(Person p) {
        if (p == null) throw new NullPointerException("The specified object is null");
        if (this.getClass() != p.getClass()) throw new ClassCastException("The specified object type prevents it from being compared to this object");
        return Integer.compare(this.birthYear, p.birthYear);
    }

    @Override
    //Testing if all attributes match 2 Course objects; It must match 2 course objects to be considered equal
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthYear);
    }

    @Override
    public String toString() {
        return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
    }
}
