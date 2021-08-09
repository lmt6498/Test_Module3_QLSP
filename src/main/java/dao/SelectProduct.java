package dao;

import models.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectProduct {

    static String select = "select p.id,p.name,p.price,p.amount,p.color,p.description, category.name_cate " +
            "from product p " +
            "inner join category on p.id_cate = category.id_cate " +
            "order by p.id";
    public static List<Product> select() throws SQLException, ClassNotFoundException {
        ArrayList<Product> list = new ArrayList<>();
        Connection connection = Connect.getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            int price = Integer.parseInt(resultSet.getString("price"));
            int amount = Integer.parseInt(resultSet.getString("amount"));
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int id_cate = Integer.parseInt(resultSet.getString("id"));
            String name_cate =resultSet.getString("name_cate");

            list.add(new Product(id,name,price,amount,color,description,id_cate,name_cate));
        }
        return list;
    }
}
