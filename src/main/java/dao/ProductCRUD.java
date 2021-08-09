package dao;

import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductCRUD {
    static Connection connection;

    static {
        try {
            connection = Connect.getConnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Product product) throws SQLException, ClassNotFoundException {


        String create = "insert into product values(?,?,?,?,?,?,?)";

        PreparedStatement prep = connection.prepareStatement(create);
        prep.setInt(1, product.getId());
        prep.setString(2,product.getName());
        prep.setInt(3, product.getPrice());
        prep.setInt(4, product.getAmount());
        prep.setString(5,product.getColor());
        prep.setString(6,product.getDescription());
        prep.setInt(7,product.getId_cate());
        prep.execute();
    }
    public static void update(Product product) throws SQLException, ClassNotFoundException {

        String create = "update product " +
                "set name = ?, price = ?, amount = ?, color = ?, description = ?, id_cate = ? " +
                "where id = ?";

        PreparedStatement prep = connection.prepareStatement(create);
        prep.setString(1,product.getName());
        prep.setInt(2, product.getPrice());
        prep.setInt(3, product.getAmount());
        prep.setString(4,product.getColor());
        prep.setString(5,product.getDescription());
        prep.setInt(6,product.getId_cate());
        prep.setInt(7, product.getId());
        prep.execute();
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = connection.prepareStatement("delete from product where id =?");
        prep.setInt(1,id);
        prep.execute();

    }
}
