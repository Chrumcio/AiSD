
public class Student {
    String index;
    String name;
    String surname;

    public Student(String index, String name, String surname ){
        this.index = index;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
