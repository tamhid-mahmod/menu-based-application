public class Faculty {
    public int facultyId;
    public String facultyName;
    public String facultyPosition;

    Faculty() {}

    Faculty(int facultyId, String facultyName, String facultyPosition) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPosition = facultyPosition;
    }

    @Override
    public String toString() {
        return "Faculty ID: " + facultyId + ", Faculty name: " + facultyName + ", Faculty position: " + facultyPosition;
    }
}