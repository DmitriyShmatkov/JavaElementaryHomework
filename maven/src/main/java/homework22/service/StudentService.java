package homework22.service;

import homework22.ConnectionManager;
import homework22.Mapper;
import homework22.entity.Group;
import homework22.entity.Student;
import homework22.entity.StudentAssessment;

import java.sql.*;
import java.util.*;

public class StudentService {
    Mapper mapper;

    public StudentService() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        mapper = new Mapper();
    }

    public List<Student> getAllStudents() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("""
                SELECT * FROM student
                LEFT JOIN student_group
                ON student.student_group_id = student_group.student_group_id""");
        statement.close();
        connection.close();

        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(mapper.mapStudent(resultSet));
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
        Connection connection = ConnectionManager.getConnection();
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
            assessments.add(mapper.mapStudentAssessment(resultSet));
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
}
