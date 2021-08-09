package services;

import dao.ProductCRUD;
import dao.SelectProduct;
import models.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Product> list = new ArrayList<>();

    public ProductService() {
        try {
            list = (ArrayList<Product>) SelectProduct.select();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Product product) throws SQLException, ClassNotFoundException {
        ProductCRUD.insert(product);
        list.add(product);
    }

    public void edit(Product product) throws SQLException, ClassNotFoundException {
        ProductCRUD.update(product);
    }

    public void delete(int index) throws SQLException, ClassNotFoundException {
        ProductCRUD.delete(list.get(index).getId());
        list.remove(index);
    }
}
