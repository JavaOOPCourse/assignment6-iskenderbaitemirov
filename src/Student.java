import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    // TODO: Task 1 — Создай конструктор, который принимает имя, GPA и возраст
    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    // TODO: Task 1 — Добавь возможность изменить GPA
    public void setGpa(double newGpa) {
        this.gpa = newGpa;
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.getGpa(), other.getGpa());
    }

    @Override
    public String toString() {
        // TODO: Сделай красивый вывод
        return "Student\n1) name: "+getName()+ "\n2) age: "+ getAge()+ "\n3) GPA: "+ getGpa()+ "\n";
    }

//    public static final Comparator<Student> nameComporator = new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            return o1.getName().compareTo(o2.getName());
//        }
//    };
//    Can be written like this , I didn't know which one is better :)
//    left the first one that I came up with.
}
