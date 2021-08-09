package services;

import dao.SelectCategory;
import models.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryService {
    public static ArrayList<Category> listCate = new ArrayList<>();

    public CategoryService() {
        try {
            listCate = (ArrayList<Category>) SelectCategory.select();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
