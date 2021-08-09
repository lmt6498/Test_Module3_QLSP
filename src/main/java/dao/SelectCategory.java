package dao;

import models.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectCategory {
    static String select = "select * from category";
    public static List<Category> select() throws SQLException, ClassNotFoundException {
        ArrayList<Category> listDP = new ArrayList<>();
        Connection connection = Connect.getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id_cate"));
            String name = resultSet.getString("name_cate");

            listDP.add(new Category(id,name));
        }
        return listDP;
    }
}
