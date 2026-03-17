import java.util.Comparator;

public class customComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2){
        Comparator<Student> descGpa = new descendingGpaComparator();
        Comparator<Student> ascName = new nameComparator();
        int res =descGpa.compare(o1,o2);
        if(res==0){return ascName.compare(o1, o2);}
        else{return res;}
    }
}
