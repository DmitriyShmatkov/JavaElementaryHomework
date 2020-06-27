<%@ page import="java.util.List" %>
<%@ page import="homework22.entity.Student" %>
<%@ page import="homework22.service.StudentService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Optional" %>
<%@ page import="homework22.ConnectionManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%
    List<Student> students;
    StudentService studentService;
    try {
        studentService = new StudentService();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        return;
    }
    try {
        students = studentService.getAllStudents();
    } catch (SQLException e) {
        e.printStackTrace();
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete student</title>
</head>
<body>
<%
    Integer id = request.getParameter("id");
    Optional<Student> optionalStudent = students.stream().filter(student -> student.id().equals(id)).findAny();
    if (optionalStudent.isPresent()) {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("""
                    UPDATE student
                    SET is_deleted = true
                    WHERE student_id = ?""");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

<h2>Удалить студента</h2>
<p>ID: <%=id%>
</p>
</body>
</html>