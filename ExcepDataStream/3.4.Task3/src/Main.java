import java.io.*;
import java.util.ArrayList;

class Student implements Serializable {
    private String id;
    private String name;
    private int age;

    public Student(String student_name, int student_age) {
        this.id = generateStudentID();
        this.name = student_name;
        this.age = student_age;
    }

    public String generateStudentID() {
        int sequence_num = 10;
        int[] format = new int[sequence_num];
        int rand_num;
        String format_string = "";

        for (int i = 0; i < sequence_num; i++) {
            rand_num = (int) (Math.random() * 10);
            format[i] = rand_num;
        }

        for (int i = 0; i < format.length; i++) {
            format_string += String.valueOf(format[i]);
        }

        return format_string;
    }

    public String getStudentID() {
        return id;
    }

    public String getStudentName() {
        return name;
    }

    public int getStudentAge() {
        return age;
    }

    public static void storeAllIntoList(ArrayList<Student> arrayList, Student ... student_params) {
        for (Student student : student_params) {
            arrayList.add(student);
        }
    }
}

class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseName, String instructor) {
        this.courseCode = generateCourseID();
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String generateCourseID() {
        int sequence_num = 10;
        int[] format = new int[sequence_num];
        int rand_num;
        String format_string = "";

        for (int i = 0; i < sequence_num; i++) {
            rand_num = (int) (Math.random() * 10);
            format[i] = rand_num;
        }

        for (int i = 0; i < format.length; i++) {
            format_string += String.valueOf(format[i]);
        }

        return format_string;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public static void storeAllIntoList(ArrayList<Course> arrayList, Course ... course_params) {
        for (Course course : course_params) {
            arrayList.add(course);
        }
    }
}

class Enrollment implements Serializable {
    Student student;
    Course course;
    String enrollmentDate;
    // static ArrayList<Enrollment> enrollments = new ArrayList<>();

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public static void storeAllIntoList(ArrayList<Enrollment> arrayList, Enrollment ... enrollment_params) {
        for (Enrollment student_enroll : enrollment_params) {
            arrayList.add(student_enroll);
        }
    }

}

class EnrollmentSystem implements Serializable {
    private ArrayList<Enrollment> enrollments;

    public EnrollmentSystem() {
        this.enrollments = new ArrayList<>();
    }

    public void addEnrollment(Enrollment enrollment) {
        for (Enrollment student_enrolled : enrollments) {
            if (student_enrolled.student.getStudentName().equals(enrollment.student.getStudentName()) && student_enrolled.course.getCourseCode().equals(enrollment.course.getCourseCode())) {
                System.out.println("Student is already enrolled. ");
                return;
            }
        }

        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void displayEnrollments() {
        System.out.println("All enrolled students: ");
        for (Enrollment student_enrolled : enrollments) {
            System.out.println(student_enrolled.student.getStudentName() + " (" + student_enrolled.student.getStudentID() + ")" + " enrolled in " + student_enrolled.course.getCourseName() + " (" + student_enrolled.course.getCourseCode() + ") " + "on " + student_enrolled.enrollmentDate);
        }
    }

}



public class Main {

    private final static String FILENAME = "object_output.ser";

    public static void main(String[] args) {


        Student jackson = new Student("Jackson", 18);
        Student emma = new Student("Emma", 19);
        Student liam = new Student("Liam", 20);
        Student sophia = new Student("Sophia", 18);
        Student noah = new Student("Noah", 21);

        ArrayList<Student> list_of_students = new ArrayList<>();
        ArrayList<Course> list_of_courses = new ArrayList<>();
        ArrayList<Enrollment> list_of_enrollments = new ArrayList<>();


        Student.storeAllIntoList(list_of_students, jackson, emma, liam, sophia, noah);



        Course ap_calc = new Course("AP Calc", "Juha Kopu");
        Course linearAlgebra = new Course("Linear Algebra", "Matti Meikäläinen");
        Course physics = new Course("Physics I", "Anna Virtanen");
        Course programming = new Course("Intro to Programming", "Kalle Korhonen");



        Course.storeAllIntoList(list_of_courses, ap_calc, linearAlgebra, physics, programming);



        Enrollment jacksonApCalc = new Enrollment(jackson, ap_calc, "2023-02-19");

        Enrollment emmaLinear = new Enrollment(emma, linearAlgebra, "2023-01-10");

        Enrollment liamPhysics = new Enrollment(liam, physics, "2023-01-12");

        Enrollment sophiaProgramming = new Enrollment(sophia, programming, "2023-01-15");

        Enrollment jacksonProgramming = new Enrollment(jackson, programming, "2023-01-20");

        Enrollment noahApCalc = new Enrollment(noah, ap_calc, "2023-02-01");

        Enrollment.storeAllIntoList(list_of_enrollments, jacksonApCalc, emmaLinear, liamPhysics, sophiaProgramming, jacksonProgramming, noahApCalc);

        EnrollmentSystem enrollmentSystem = new EnrollmentSystem();

        for (Enrollment enrollment : list_of_enrollments) {
            enrollmentSystem.addEnrollment(enrollment);
        }

        File f = new File(FILENAME);

        if (f.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(FILENAME);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                list_of_students = (ArrayList<Student>) objectInputStream.readObject();
                list_of_courses = (ArrayList<Course>) objectInputStream.readObject();
                list_of_enrollments = (ArrayList<Enrollment>) objectInputStream.readObject();

                for (Student student : list_of_students) {
                    System.out.println(student.getStudentName() + " (" + student.getStudentID() + ") ");
                }

                System.out.println();

                for (Course course : list_of_courses) {
                    System.out.println(course.getCourseName() + " (" + course.getCourseCode() + ") ");
                }

                System.out.println();

                for (Enrollment enrollment : list_of_enrollments) {
                    System.out.println(enrollment.student.getStudentName() + " (" + enrollment.student.getStudentID() + ") " + "enrolled in: " + enrollment.course.getCourseName() + " (" + enrollment.course.getCourseCode() + ") " + "on: " + enrollment.enrollmentDate);
                }

            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
            }

        } else {
            try (FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

                objectOutputStream.writeObject(list_of_students);
                objectOutputStream.writeObject(list_of_courses);
                objectOutputStream.writeObject(list_of_enrollments);

            } catch (Exception e) {
                System.out.println("Error writing file: " + e.getMessage());
            }
        }




    }

}



