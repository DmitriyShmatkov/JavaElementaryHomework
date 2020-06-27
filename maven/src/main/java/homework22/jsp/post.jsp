<%@ page import="homework22.entity.Group" %>
<%@ page import="homework22.entity.Student" %>
<%@ page import="homework22.service.GroupService" %>
<%@ page import="homework22.service.StudentService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="homework22.ConnectionManager" %>
<%@ page import="java.sql.*" %>
<%
    GroupService groupService;
    try {
        groupService = new GroupService();
    } catch (ClassNotFoundException e) {
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
    Integer id = request.getParameter("id");
    String firstName = request.getParameter("firstName");
    String middleName = request.getParameter("middleName");
    String secondName = request.getParameter("secondName");
    String groupName = request.getParameter("groupName");
    Integer enterYear = request.getParameter("enterYear");
    Boolean isDeleted = false;

    List<Group> groups;
    try {
        groups = groupService.getAllGroups();
    } catch (SQLException e) {
        e.printStackTrace();
        return;
    }
    Optional<Group> optionalGroup = groups.stream().filter(group -> group.name().equals(groupName)).findAny();
    if (optionalGroup.isPresent()) {
        Group group = optionalGroup.get();
        Student student = new Student(id, firstName, middleName, secondName, group, enterYear, isDeleted);

        Connection connection;
        PreparedStatement statement;
        try {
            connection = ConnectionManager.getConnection();
            statement = connection.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, firstName);
            statement.setString(2, middleName);
            statement.setString(3, secondName);
            statement.setInt(4, group.id());
            statement.setInt(5, enterYear);
            statement.setBoolean(6, isDeleted);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

%>
<h2>Добавить студента</h2>
<p>ID: <%=id%>></p>
<p>Фамилия: <%=secondName%>
</p>
<p>Имя: <%=firstName%>
</p>
<p>Отчество: <%=middleName%>
</p>
<p>Год поступления: <%=enterYear%>
</p>
<p>Название группы: <%=groupName%>
</p>
</body>
</html>