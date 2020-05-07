package homework22;

import java.sql.*;
import java.util.*;

public class StudentService {

    public StudentService() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    public List<Student> getAllStudents() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university_db", "postgres", "DShmatkov");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("""
                SELECT * FROM student
                LEFT JOIN student_group
                ON student.student_group_id = student_group.student_group_id""");
        statement.close();
        connection.close();

        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(mapStudent(resultSet));
        }
        return students;
    }

    public List<Student> getAllStudentsByGroup(Group group) throws SQLException {
        List<Student> students = getAllStudents();
        students.removeIf(student -> !group.equals(student.group()));
        return students;
    }

    public List<Student> getAllStudentsByEnterYear(Integer enterYear) throws SQLException {
        List<Student> students = getAllStudents();
        students.removeIf(student -> !enterYear.equals(student.enterYear()));
        return students;
    }

    public List<StudentAssessment> getStudentAssessment(Student student) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/university_db", "postgres", "DShmatkov");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("""
                SELECT * FROM student_assessment
                LEFT JOIN student
                ON student_assessment.student_id = student.student_id
                LEFT JOIN (
                    SELECT * FROM subject
                    LEFT JOIN (
                        SELECT * FROM lecturer
                        LEFT JOIN department
                        ON lecturer.department_id = department.department_id) l
                    ON subject.lecturer_id = l.lecturer_id) s
                ON student_assessment.subject_id = s.subject_id""");
        statement.close();
        connection.close();

        List<StudentAssessment> assessments = new ArrayList<>();
        while (resultSet.next()) {
            assessments.add(mapStudentAssessment(resultSet));
        }
        return assessments;
    }

    public Double getAverageAssessment(Student student) throws SQLException {
        OptionalDouble optionalDouble = getStudentAssessment(student)
                .stream()
                .mapToInt(StudentAssessment::assessment)
                .average();
        return optionalDouble.isPresent() ? optionalDouble.getAsDouble() : null;
    }


    private Student mapStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("student_id"),
                resultSet.getString("first_name"),
                resultSet.getString("middle_name"),
                resultSet.getString("second_name"),
                mapGroup(resultSet),
                resultSet.getInt("enter_year")
        );
    }

    private Group mapGroup(ResultSet resultSet) throws SQLException {
        return new Group(
                resultSet.getInt("student_group_id"),
                resultSet.getString("name")
        );
    }

    private StudentAssessment mapStudentAssessment(ResultSet resultSet) throws SQLException {
        return new StudentAssessment(
                resultSet.getInt("student_assessment_id"),
                mapStudent(resultSet),
                mapSubject(resultSet),
                resultSet.getInt("assessment")
        );
    }

    private Subject mapSubject(ResultSet resultSet) throws SQLException {
        return new Subject(
                resultSet.getInt("subject_id"),
                resultSet.getString("name"),
                mapLecturer(resultSet),
                resultSet.getInt("year")
        );
    }

    private Lecturer mapLecturer(ResultSet resultSet) throws SQLException {
        return new Lecturer(
                resultSet.getInt("lecturer_id"),
                resultSet.getString("first_name"),
                resultSet.getString("middle_name"),
                resultSet.getString("second_name"),
                mapDepartment(resultSet)
        );
    }

    private Department mapDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getInt("department_id"),
                resultSet.getString("name"),
                resultSet.getString("head")
        );
    }

}
