import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        System.out.println("td1");
        students.put("1",new Student("Isken",4.0,18));
        students.put("0",new Student("Alty",4.0,18));
        students.put("2",new Student("Jopa",1.0,95));
        students.put("3",new Student("Cheburek",3.5,8));
        students.put("4",new Student("Diva",3.2,20));
        students.put("5",new Student("Yoda",4.0,45));
        // TODO: Напечатай всех студентов (ID + объект)
        System.out.println("td2");
        for(Student s: students.values()){
            System.out.println(s);
        }
        // TODO: Найди студента по ID и выведи его
        System.out.println("td3");
        System.out.println(students.getOrDefault("1",null));
        // TODO: Удали одного студента по ID
        System.out.println("td4");
        students.remove("2");
        // TODO: Обнови GPA у одного студента
        System.out.println("td5");
        students.get("4").setGpa(3.3);
        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        System.out.println("td6");
        ArrayList<Student> allStudents = new ArrayList<>(students.values());
        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        System.out.println("td7");
        Collections.sort(allStudents);
        System.out.println(allStudents);
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        System.out.println("td8");
        allStudents.sort(new nameComparator());
        System.out.println(allStudents);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        ArrayList<Student> studs = new ArrayList<>(students.values());
        studs.sort(new descendingGpaComparator());
        for(int i = 0 ; i<3;i++){
            System.out.println(studs.get(i));
        }
        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double,ArrayList<Student>> studByGpa = new HashMap<Double,ArrayList<Student>>();
        for (Student s : studs){
            if(!studByGpa.containsKey(s.getGpa())){
                studByGpa.put(s.getGpa(),new ArrayList<Student>());
            }
            studByGpa.get(s.getGpa()).add(s);
        }
        for(Map.Entry<Double,ArrayList<Student>> gs : studByGpa.entrySet()){
            if(gs.getValue().size()>1){
                System.out.println(gs);
            }
        }
        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        courseMap.put(new Course("Java_pl"),studs.stream().toList());
        courseMap.put(new Course("Korean"),List.of(new Student("lola",2.5,21),new Student("Aktan",4.0,20)));
        courseMap.put(new Course("Software"),List.copyOf(studs.subList(0,3)));
        for(Map.Entry<Course,List<Student>> e: courseMap.entrySet()){
            System.out.println("Course: "+ e.getKey()+ "\nStudents: "+ e.getValue());
        }
        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        Comparator<Student> custom = new customComparator();
        Collections.sort(studs,custom);
        System.out.println(studs);
    }
}



