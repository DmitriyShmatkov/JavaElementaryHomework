<%@ page import="homework22.entity.Student" %>
<%@ page import="homework22.service.StudentService" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
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
    <title>Add new student</title>
</head>
<body>
<%
    StringBuilder stringBuilder = new StringBuilder();
    int counter = 0;
    for (Student student : students) {
        if (!student.isDeleted()) {
            counter++;
            stringBuilder
                    .append(counter).append(". ")
                    .append("ID: ").append(student.id()).append(", ")
                    .append(student.secondName()).append(" ")
                    .append(student.firstName()).append(" ")
                    .append(student.middleName()).append(", ")
                    .append(student.group().name()).append(", ")
                    .append("год поступления: ").append(student.enterYear()).append("\n");
        }
    }
%>

<h2>Список студентов</h2>
<p><%=stringBuilder%></p>
</body>
</html>