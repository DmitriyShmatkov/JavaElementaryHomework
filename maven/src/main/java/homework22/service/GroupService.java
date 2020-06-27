package homework22.service;

import homework22.ConnectionManager;
import homework22.Mapper;
import homework22.entity.Group;
import homework22.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupService {
    Mapper mapper;

    public GroupService() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        mapper = new Mapper();
    }

    public List<Group> getAllGroups() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student_group");
        statement.close();
        connection.close();

        List<Group> groups = new ArrayList<>();
        while (resultSet.next()) {
            groups.add(mapper.mapGroup(resultSet));
        }
        return groups;
    }
}
