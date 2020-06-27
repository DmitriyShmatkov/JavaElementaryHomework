package homework22;

import homework22.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {

    public Student mapStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("student_id"),
                resultSet.getString("first_name"),
                resultSet.getString("middle_name"),
                resultSet.getString("second_name"),
                mapGroup(resultSet),
                resultSet.getInt("enter_year"),
                resultSet.getBoolean("is_deleted")
        );
    }

    public Group mapGroup(ResultSet resultSet) throws SQLException {
        return new Group(
                resultSet.getInt("student_group_id"),
                resultSet.getString("name")
        );
    }

    public StudentAssessment mapStudentAssessment(ResultSet resultSet) throws SQLException {
        return new StudentAssessment(
                resultSet.getInt("student_assessment_id"),
                mapStudent(resultSet),
                mapSubject(resultSet),
                resultSet.getInt("assessment")
        );
    }

    public Subject mapSubject(ResultSet resultSet) throws SQLException {
        return new Subject(
                resultSet.getInt("subject_id"),
                resultSet.getString("name"),
                mapLecturer(resultSet),
                resultSet.getInt("year")
        );
    }

    public Lecturer mapLecturer(ResultSet resultSet) throws SQLException {
        return new Lecturer(
                resultSet.getInt("lecturer_id"),
                resultSet.getString("first_name"),
                resultSet.getString("middle_name"),
                resultSet.getString("second_name"),
                mapDepartment(resultSet)
        );
    }

    public static Department mapDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getInt("department_id"),
                resultSet.getString("name"),
                resultSet.getString("head")
        );
    }
}
