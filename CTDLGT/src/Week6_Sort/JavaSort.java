package Week6_Sort;

import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getCgpa() { return cgpa; }
}

class StudentComparator implements Comparator<Student> {
    // @Override
    public int compare(Student s1, Student s2){
        double cgpa1 = s1.getCgpa();
        double cgpa2 = s2.getCgpa();

        if (Math.abs(cgpa1 - cgpa2) < .00000001){
            int nameComparator = s1.getName().compareTo(s2.getName());
            if(nameComparator == 0){
                return s1.getId()-s2.getId();
            }
            return nameComparator;
        }
        return (cgpa1 < cgpa2) ? 1 : (cgpa1 > cgpa2 ? -1 : 0);
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();

        List <Student> students = new ArrayList<Student>();
        while (testcases > 0){
            int id = sc.nextInt();
            String fname = sc.next();
            double cgpa = sc.nextDouble();

            Student st = new Student(id, fname, cgpa);
            students.add(st);

            testcases--;
        }

        Collections.sort(students, new StudentComparator());
        for (Student st : students){
            System.out.println(st.getName());
        }

    }
}
