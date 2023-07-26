import java.util.*;

public class Course {
    public String courseId;
    public String courseTitle;
    public double credit;
    public List<Student> studentList;
    public int numberOfStudents;
    public Faculty faculty;

    Course() {
        studentList = new ArrayList<>();
        numberOfStudents = 0;
    }

    Course(String courseId, String courseTitle, double credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
        studentList = new ArrayList<>();
        numberOfStudents = 0;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course title: " + courseTitle + ", Course credit: " + credit;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        numberOfStudents++;
    }

    public void dropStudent(int studentId) {
        for(int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).studentId == studentId) {
                studentList.remove(i);
                numberOfStudents--;
                return;
            }
        }
    }

    public void addFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void dropFaculty() {
        this.faculty = null;
    }

    public void printStudentList() {
        System.out.println("Students enrolled in the course: " + courseTitle);

        for(Student student : studentList) {
            System.out.println("Student Id: " + student.studentId);
            System.out.println("Student Name: " + student.studentName);
            System.out.println("Student CGPA: " + student.studentCGPA);
            System.out.println();
        }
    }
}