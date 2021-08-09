package controllers;

import dao.SelectProduct;
import models.Product;
import services.CategoryService;
import services.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/sanpham",""})
public class ProductServlet extends HttpServlet {
    public ProductService productService = new ProductService();
    public CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null){
            action ="";
        }
        switch (action) {
            case "create" -> {
                req.setAttribute("listCate", categoryService.listCate);
                requestDispatcher = req.getRequestDispatcher("CreateProduct.jsp");
                requestDispatcher.forward(req, resp);
            }
            case "edit" -> {
                int indexEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("add", productService.list.get(indexEdit));
                req.setAttribute("listCate", categoryService.listCate);
                requestDispatcher = req.getRequestDispatcher("EditProduct.jsp");
                requestDispatcher.forward(req, resp);
            }
            case "delete" -> {
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    productService.delete(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/sanpham");
            }
            default -> {
                req.setAttribute("listProduct", productService.list);
                requestDispatcher = req.getRequestDispatcher("ShowProduct.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null){
            action ="";
        }
        switch (action){
            case "create" ->{
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int price = Integer.parseInt(req.getParameter("price"));
                int amount = Integer.parseInt(req.getParameter("amount"));
                String color = req.getParameter("color");
                String description = req.getParameter("description");
                int id_cate = Integer.parseInt(req.getParameter("id_cate"));

                Product product = new Product(id,name,price,amount,color,description,id_cate);
                try {
                    productService.save(product);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    ProductService.list = (ArrayList<Product>) SelectProduct.select();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/sanpham");
            }
            case "edit" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                int price = Integer.parseInt(req.getParameter("price"));
                int amount = Integer.parseInt(req.getParameter("amount"));
                String color = req.getParameter("color");
                String description = req.getParameter("description");
                int id_cate = Integer.parseInt(req.getParameter("id_cate"));

                Product product = new Product(id, name, price, amount,color,description,id_cate);

                try {
                    productService.edit(product);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    ProductService.list = (ArrayList<Product>) SelectProduct.select();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/sanpham");
            }
            case "find" -> {
                String findName = req.getParameter("nameFind");
                ArrayList<Product> productSearch = new ArrayList<>();
                for (Product s:productService.list
                ) {
                    if (s.getName().contains(findName)){
                        productSearch.add(s);
                    }
                }
                req.setAttribute("listProduct",productSearch);
                requestDispatcher = req.getRequestDispatcher("SearchProduct.jsp");
                requestDispatcher.forward(req,resp);
            }
        }
    }
}
