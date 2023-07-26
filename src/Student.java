public class Student {
    public int studentId;
    public String studentName;
    public double studentCGPA;

    Student() {}

    Student(int studentID, String studentName, double studentCGPA) {
        this.studentId = studentID;
        this.studentName = studentName;
        this.studentCGPA = studentCGPA;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Student name: " + studentName + ", Student CGPA: " + studentCGPA;
    }
}