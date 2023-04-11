package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.example.model.Product;
import org.example.model.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShopServlet extends HttpServlet {
    private ProductService productService;
    private ObjectMapper objectMapper = new ObjectMapper();

    public ShopServlet() throws SQLException, ClassNotFoundException {
        productService = new ProductService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> products;

//            PrintWriter out = resp.getWriter();
            String value =req.getParameter("id");
//            out.write(value);
            if (value ==null || value.isBlank() || value.isEmpty())
                products = productService.selectProduct();
            else
                products = productService.selectProduct(Integer.parseInt(value));

            String response = objectMapper.writeValueAsString(products);
            resp.setStatus(200);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(response);
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().println("عملیات با خطا مواجه شد");
            resp.getWriter().println(e.getMessage());
        } catch (ClassNotFoundException e) {
            resp.setStatus(500);
            resp.getWriter().println("عملیات با خطا مواجه شد");
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestBody = IOUtils.toString(req.getReader());

        Product product = objectMapper.readValue(requestBody, Product.class);
        try {
            Product productResp = productService.insertProduct(product);
            String response = objectMapper.writeValueAsString(productResp);
            resp.setStatus(200);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(response);
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().println("عملیات با خطا مواجه شد");
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  requestBody = IOUtils.toString(req.getReader());
        Product product = objectMapper.readValue(requestBody, Product.class);
        try {
            Product productResp = productService.updateProduct(product.getId(), product);
            String response = objectMapper.writeValueAsString(productResp);
            resp.setStatus(200);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write(response);
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().println("عملیات با خطا مواجه شد");
            resp.getWriter().println(e.getMessage());
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestBody= IOUtils.toString(req.getReader());
        try {
            Product product = productService.deleteProduct(Integer.parseInt(requestBody));
            resp.setStatus(200);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write("رکورد مورد نظر حذف شد ");
        } catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().println("عملیات با خطا مواجه شد");
            resp.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }
}
