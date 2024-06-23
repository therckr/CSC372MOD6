import java.util.ArrayList;
import java.util.Comparator;

// Student class
class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
}

// Comparator class to sort by rollno
class RollnoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.rollno, s2.rollno);
    }
}

// Merge sort implementation
public class MergeSort {
    public static void mergeSort(ArrayList<Student> students) {
        if (students.size() <= 1) {
            return;
        }
        
        int mid = students.size() / 2;
        ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));
        
        mergeSort(left);
        mergeSort(right);
        
        merge(students, left, right);
    }
    
    private static void merge(ArrayList<Student> students, ArrayList<Student> left, ArrayList<Student> right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.size() && j < right.size()) {
            if (left.get(i).rollno <= right.get(j).rollno) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }
        
        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }
        
        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        // Add 10 student objects to the ArrayList
        students.add(new Student(1, "Alice", "123 Main St"));
        students.add(new Student(5, "Bob", "456 Oak Rd"));
        students.add(new Student(3, "Charlie", "789 Elm St"));
        // Add 7 more student objects...
        
        // Sort the ArrayList by rollno using the custom merge sort
        mergeSort(students);
        
        // Print the sorted students
        for (Student student : students) {
            System.out.println("Rollno: " + student.rollno + ", Name: " + student.name + ", Address: " + student.address);
        }
    }
}
