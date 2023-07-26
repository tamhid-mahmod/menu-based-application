import java.util.*;

public class Main {
    public static List<Student> students = new ArrayList<>();
    public static List<Course> courses = new ArrayList<>();
    public static List<Faculty> faculties = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    // display main menu
    public static void initialMenu() {
        System.out.println("A) Add");
        System.out.println("B) Delete");
        System.out.println("C) Update");
        System.out.println("D) Print");
        System.out.println("E) Search");
        System.out.println("0) Exit");
    }

    // display add menu
    public static void printAddMenu() {
        System.out.println("A) Add a Student");
        System.out.println("B) Add a Course");
        System.out.println("C) Add a Faculty");
        System.out.println("#) Go back to Main Menu");
    }

    // handle add menu
    public static void handleAddMenu() {
        char addCh;
        do {
            printAddMenu();
            System.out.print("Enter your choice: ");
            addCh = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // Consume the newline character left by next()

            switch (addCh) {
                case 'a':
                    addStudent();
                    break;
                case 'b':
                    addCourse();
                    break;
                case 'c':
                    addFaculty();
                    break;
                case '#':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (addCh != '#');
    }

    // add new student
    public static void addStudent() {
        Student newStudent = new Student();

        System.out.print("Enter Student ID: ");
        newStudent.studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter Student Name: ");
        newStudent.studentName = sc.next();
        sc.nextLine(); // Consume the newline character left by next()

        System.out.print("Enter Student CGPA: ");
        newStudent.studentCGPA = sc.nextDouble();

        boolean isSuccess = students.add(newStudent);
        if(isSuccess) {
            System.out.println("Student added successfully.");
            return;
        }
        System.out.println("There was a problem to add student.");
    }

    // add new course
    public static void addCourse() {
        Course newCourse = new Course();
        System.out.print("Enter course ID: ");
        newCourse.courseId = sc.nextLine();

        System.out.print("Enter course title: ");
        newCourse.courseTitle = sc.next();
        sc.nextLine(); // Consume the newline character left by next()

        System.out.print("Enter course credit: ");
        newCourse.credit = sc.nextDouble();

        boolean isSuccess = courses.add(newCourse);
        if(isSuccess) {
            System.out.println("Course added successfully.");
            return;
        }
        System.out.println("There was a problem to add course.");
    }

    // add new faculty
    public static void addFaculty() {
        Faculty newFaculty = new Faculty();
        System.out.print("Enter faculty ID: ");
        newFaculty.facultyId = sc.nextInt();

        System.out.print("Enter faculty name: ");
        newFaculty.facultyName = sc.next();
        sc.nextLine(); // Consume the newline character left by next()

        System.out.print("Enter faculty position: ");
        newFaculty.facultyPosition = sc.nextLine();

        boolean isSuccess = faculties.add(newFaculty);
        if(isSuccess) {
            System.out.println("Faculty added successfully.");
            return;
        }
        System.out.println("There was a problem to add faculty.");
    }

    // display delete menu
    public static void printDeleteMenu() {
        System.out.println("A) Delete a Student");
        System.out.println("B) Delete a Course");
        System.out.println("C) Delete a Faculty");
        System.out.println("#) Go back to Main Menu");
    }

    // handle delete menu
    public static void handleDeleteMenu() {
        char deleteCh;
        do {
            printDeleteMenu();
            System.out.print("Enter your choice: ");
            deleteCh = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // Consume the newline character left by next()

            switch (deleteCh) {
                case 'a':
                    deleteStudent();
                    break;
                case 'b':
                    deleteCourse();
                    break;
                case 'c':
                    deleteFaculty();
                    break;
                case '#':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (deleteCh != '#');
    }

    // delete student
    public static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for(Student student : students) {
            if(student.studentId == studentId) {
                students.remove(student);
                System.out.println("Student with ID " + studentId + " has been deleted.");
                isFound = true;
                break;
            }
        }

        if(!isFound) System.out.println("Student with ID " + studentId + " not found.");
    }

    // delete course
    public static void deleteCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = sc.nextLine();

        boolean isFound = false;
        for(Course course : courses) {
            if(course.courseId.equals(courseId)) {
                courses.remove(course);
                System.out.println("Course with ID " + courseId + " has been deleted.");
                isFound = true;
                break;
            }
        }

        if(!isFound) System.out.println("Course with ID " + courseId + " not found.");
    }

    // delete faculty
    public static void deleteFaculty() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for(Faculty faculty : faculties) {
            if(faculty.facultyId == facultyId) {
                faculties.remove(faculty);
                System.out.println("Faculty with ID " + facultyId + " has been deleted.");
                isFound = true;
                break;
            }
        }

        if(!isFound) System.out.println("Faculty with ID " + facultyId + " not found.");
    }

    // display update menu
    public static void printUpdateMenu() {
        System.out.println("A) Update a Student");
        System.out.println("B) Update a Course");
        System.out.println("C) Update a Faculty");
        System.out.println("#) Go back to Main Menu");
    }

    // handel update menu
    public static void handleUpdateMenu() {
        char updateCh;
        do {
            printUpdateMenu();
            System.out.print("Enter your choice: ");
            updateCh = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // Consume the newline character left by next()

            switch (updateCh) {
                case 'a':
                    updateStudent();
                    break;
                case 'b':
                    updateCourse();
                    break;
                case 'c':
                    updateFaculty();
                    break;
                case '#': break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while(updateCh != '#');
    }

    // update student
    public static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for(Student student : students) {
            if(student.studentId == studentId) {
                System.out.print("Enter new Student Name: ");
                student.studentName = sc.next();
                sc.nextLine(); // Consume the newline character left by next()

                System.out.print("Enter new Student CGPA: ");
                student.studentCGPA = sc.nextDouble();

                System.out.println("Student with ID " + studentId + " has been updated.");
                isFound = true;
                break;
            }
        }

        if(!isFound) System.out.println("Student with ID " + studentId + " not found.");
    }

    // update course
    public static void updateCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = sc.nextLine();

        boolean isFound = false;
        for(Course course : courses) {
            if(course.courseId.equals(courseId)) {
                System.out.print("Enter new Course Title: ");
                course.courseTitle = sc.next();
                sc.nextLine(); // Consume the newline character left by next()

                System.out.print("Enter new Course Credit: ");
                course.credit = sc.nextDouble();

                System.out.println("Course with ID " + courseId + " has been updated.");
                isFound = true;
                break;
            }
        }

        if(!isFound) System.out.println("Course with ID " + courseId + " not found.");
    }

    // update faculty
    public static void updateFaculty() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for(Faculty faculty : faculties) {
            if(faculty.facultyId == facultyId) {
                System.out.print("Enter new Faculty Name: ");
                faculty.facultyName = sc.next();
                sc.nextLine(); // Consume the newline character left by next()

                System.out.print("Enter new Faculty Position: ");
                faculty.facultyPosition = sc.nextLine();

                System.out.println("Faculty with ID " + facultyId + " has been updated.");
                isFound = true;
                break;
            }
        }

        if(!isFound) System.out.println("Faculty with ID " + facultyId + " not found.");
    }

    // display print menu
    public static void printPrintMenu() {
        System.out.println("A) Print all students");
        System.out.println("B) Print all course");
        System.out.println("C) Print all faculties");
        System.out.println("D) Print information of a student");
        System.out.println("E) Print information of a course");
        System.out.println("F) Print information of a faculty");
        System.out.println("G) Print student list and faculty information of a course");
        System.out.println("H) Print courses taken by a student");
        System.out.println("#) Go back to Main Menu");
    }

    // handel print menu
    public static void handlePrintMenu() {
        char printCh;
        do {
            printPrintMenu();
            System.out.print("Enter your choice: ");
            printCh = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // Consume the newline character left by next()

            switch (printCh) {
                case 'a':
                    printAllStudents();
                    break;
                case 'b':
                    printAllCourses();
                    break;
                case 'c':
                    printAllFaculties();
                    break;
                case 'd':
                    printStudentInfo();
                    break;
                case 'e':
                    printCourseInfo();
                    break;
                case 'f':
                    printFacultyInfo();
                    break;
                case 'g':
                    printStudentListAndFacultyInfo();
                    break;
                case 'h':
                    printCoursesTakenByStudent();
                    break;
                case '#':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (printCh != '#');
    }

    // print all students
    public static void printAllStudents() {
        if (students.size() == 0) {
            System.out.println("Student List Empty.");
            return;
        }

        System.out.println("All Students:");
        for(Student student : students) {
            System.out.println(student.toString());
        }
    }

    // print all courses
    public static void printAllCourses() {
        if (courses.size() == 0) {
            System.out.println("Courses List Empty.");
            return;
        };

        System.out.println("All Courses:");
        for(Course course : courses) {
            System.out.println(course.toString());
        }
    }

    // print all faculties
    public static void printAllFaculties() {
        if (faculties.size() == 0) {
            System.out.println("Faculty List Empty.");
            return;
        };

        System.out.println("All Faculties:");
        for(Faculty faculty : faculties) {
            System.out.println(faculty.toString());
        }
    }

    // print student info
    public static void printStudentInfo() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println("Student Information:");
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    // print course info
    public static void printCourseInfo() {
        System.out.print("Enter Course ID: ");
        String courseId = sc.nextLine();

        for (Course course : courses) {
            if (course.courseId.equals(courseId)) {
                System.out.println("Course Information:");
                System.out.println(course.toString());
                return;
            }
        }
        System.out.println("Course not found with ID: " + courseId);
    }

    // print faculty info
    public static void printFacultyInfo() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        for (Faculty faculty : faculties) {
            if (faculty.facultyId == facultyId) {
                System.out.println("Faculty Information:");
                System.out.println(faculty.toString());
                return;
            }
        }
        System.out.println("Faculty not found with ID: " + facultyId);
    }

    // print student list and faculty info
    public static void printStudentListAndFacultyInfo() {
        System.out.print("Enter Course ID: ");
        String courseId = sc.nextLine();

        boolean isfound = false;
        for (Course course : courses) {
            if (course.courseId.equals(courseId)) {
                System.out.println("Course Information:");
                System.out.println(course.toString());

                System.out.println("Faculty Information:");
                System.out.println(course.faculty.toString());

                System.out.println("Students enrolled in the course " + course.courseTitle + ":");
                for (Student student : course.studentList) {
                    System.out.println(student.toString());
                }
                isfound = true;
                break;
            }
        }

        if (!isfound) System.out.println("Course not found with ID: " + courseId);
    }

    // print courses taken by student
    public static void printCoursesTakenByStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println("Courses taken by student " + student.studentName + ":");

                for (Course course : courses) {
                    for (Student enrolledStudent : course.studentList) {
                        if (enrolledStudent.studentId == studentId) {
                            System.out.println(course.toString());
                            isFound = true;
                            break;
                        }
                    }
                }
                break;
            }
        }

        if (!isFound) System.out.println("Student not found with ID: " + studentId);
    }

    // display search menu
    public static void printSearchMenu() {
        System.out.println("A) Search a Student");
        System.out.println("B) Search a Course");
        System.out.println("C) Search a Faculty");
        System.out.println("D) Search whether a student takes a course");
        System.out.println("E) Search whether a faculty teaches a course");
        System.out.println("F) Search courses taken by a student");
        System.out.println("G) Search courses taught by a faculty");
        System.out.println("#) Go back to Main Menu");
    }

    // handel search menu
    public static void handleSearchMenu() {
        char searchCh;
        do {
            printSearchMenu();
            System.out.print("Enter your choice: ");
            searchCh = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // Consume the newline character left by next()

            switch (searchCh) {
                case 'a':
                    searchStudent();
                    break;
                case 'b':
                    searchCourse();
                    break;
                case 'c':
                    searchFaculty();
                    break;
                case 'd':
                    searchStudentCourseEnrollment();
                    break;
                case 'e':
                    searchFacultyCourseTeaching();
                    break;
                case 'f':
                    searchCoursesTakenByStudent();
                    break;
                case 'g':
                    searchCoursesTaughtByFaculty();
                    break;
                case '#':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (searchCh != '#');
    }

    // search student
    public static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println("Student found:");
                System.out.println(student.toString());
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    // search course
    public static void searchCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = sc.nextLine();

        for (Course course : courses) {
            if (course.courseId.equals(courseId)) {
                System.out.println("Course found:");
                System.out.println(course.toString());
                return;
            }
        }
        System.out.println("Course not found with ID: " + courseId);
    }

    // search faculty
    public static void searchFaculty() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        for (Faculty faculty : faculties) {
            if (faculty.facultyId == facultyId) {
                System.out.println("Faculty found:");
                System.out.println(faculty.toString());
                return;
            }
        }
        System.out.println("Faculty not found with ID: " + facultyId);
    }

    // search student course enrollment
    public static void searchStudentCourseEnrollment() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println("Enter Course ID: ");
                String courseId = sc.nextLine();

                for (Course course : courses) {
                    if (course.courseId.equals(courseId)) {
                        for (Student enrolledStudent : course.studentList) {
                            if (enrolledStudent.studentId == studentId) {
                                System.out.println("Student with ID " + studentId + " is enrolled in the course " + course.courseTitle);
                                return;
                            }
                        }
                    }
                }
                System.out.println("Student with ID " + studentId + " is not enrolled in the course with ID: " + courseId);
                return;
            }
        }

        System.out.println("Student not found with ID: " + studentId);
    }

    // search faculty course teaching
    public static void searchFacultyCourseTeaching() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        for (Faculty faculty : faculties) {
            if (faculty.facultyId == facultyId) {
                System.out.println("Enter Course ID: ");
                String courseId = sc.nextLine();

                for (Course course : courses) {
                    if (course.courseId.equals(courseId)) {
                        if (course.faculty != null && course.faculty.facultyId == facultyId) {
                            System.out.println("Faculty with ID " + facultyId + " teaches the course " + course.courseTitle);
                        } else {
                            System.out.println("Faculty with ID " + facultyId + " does not teach the course with ID: " + courseId);
                        }
                        return;
                    }
                }
                System.out.println("Course with ID: " + courseId + " not found.");
                return;
            }
        }

        System.out.println("Faculty not found with ID: " + facultyId);
    }

    // search courses taken by student
    public static void searchCoursesTakenByStudent() {
        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println("Courses taken by student " + student.studentName + ":");

                for (Course course : courses) {
                    for (Student enrolledStudent : course.studentList) {
                        if (enrolledStudent.studentId == studentId) {
                            System.out.println(course.toString());
                            isFound = true;
                            break;
                        }
                    }
                }
                break;
            }
        }

        if (!isFound) System.out.println("Student not found with ID: " + studentId);
    }

    // search courses taught by faculty
    public static void searchCoursesTaughtByFaculty() {
        System.out.print("Enter Faculty ID: ");
        int facultyId = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        boolean isFound = false;
        for (Faculty faculty : faculties) {
            if (faculty.facultyId == facultyId) {
                System.out.println("Courses taught by faculty " + faculty.facultyName + ":");

                for (Course course : courses) {
                    if (course.faculty != null && course.faculty.facultyId == facultyId) {
                        System.out.println(course.toString());
                        isFound = true;
                    }
                }
                break;
            }
        }

        if (!isFound) {
            System.out.println("Faculty not found with ID: " + facultyId);
        }
    }

    public static void main(String[] args) {
        char ch;
        do {
            initialMenu();
            System.out.print("Enter your choice: ");
            ch = sc.next().toLowerCase().charAt(0);
            sc.nextLine(); // Consume the newline character left by nextLine

            switch (ch) {
                case 'a':
                    handleAddMenu();
                    break;
                case 'b':
                    handleDeleteMenu();
                    break;
                case 'c':
                    handleUpdateMenu();
                    break;
                case 'd':
                    handlePrintMenu();
                    break;
                case 'e':
                    handleSearchMenu();
                    break;
                case '0':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (ch != '0');
        sc.close();
    }
}