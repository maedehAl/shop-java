package org.example.model;

import org.example.infrastructure.dbmsConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService extends dbmsConnection {
    String query;
    ResultSet resultSet;
    Scanner input;
    dbmsConnection dbmsConn;

    public ProductService() throws SQLException, ClassNotFoundException {
        this.input = new Scanner(System.in);
        this.dbmsConn = new dbmsConnection();
    }


    public Product insertProduct(Product product) throws SQLException {
        this.query = "insert into product values (?,?,?,?,?,?,?);";
        Connection connection = this.dbmsConn.getConnection();
        PreparedStatement preStatement = connection.prepareStatement(this.query);
        preStatement.setString(1, (String) null);
        preStatement.setString(2, product.getNAME());
        preStatement.setInt(3, product.getCOUNT());
        preStatement.setInt(4, product.getPRICE());
        preStatement.setString(5, product.getDESCRIPTION());
        preStatement.setInt(6, product.getCATEGORY());
        preStatement.setBoolean(7, product.getIS_ACTIVE());
        preStatement.execute();
        System.out.println("inserted");
        this.dbmsConn.closeConnection(connection, preStatement);
        return product;
    }

    public Product deleteProduct(int id) throws SQLException {
        this.query = "Delete from product " +
                    "where ID in (?);";
        Connection connection = this.dbmsConn.getConnection();
        PreparedStatement preStatement = connection.prepareStatement(this.query);
        preStatement.setInt(1, id);
        preStatement.execute();
        System.out.println("Deleted");
        this.dbmsConn.closeConnection(connection, preStatement);
        return null;//؟؟؟
    }

    public Product updateProduct(int id , Product product) throws SQLException {
        Connection connection = this.dbmsConn.getConnection();
        this.query = "UPDATE product " +
                "Set NAME=?," +
                "COUNT=?," +
                "PRICE=?," +
                "DESCRIPTION=?," +
                "CATEGORY =?," +
                "IS_ACTIVE=? " +
                "WHERE ID =? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(this.query);
        preparedStatement.setString(1, product.getNAME());
        preparedStatement.setInt(2, product.getCOUNT());
        preparedStatement.setInt(3, product.getPRICE());
        preparedStatement.setString(4, product.getDESCRIPTION());
        preparedStatement.setInt(5, product.getCATEGORY());
        preparedStatement.setBoolean(6, product.getIS_ACTIVE());
        preparedStatement.setInt(7, id);
        preparedStatement.execute();
        System.out.println("Updated");
        this.dbmsConn.closeConnection(connection, preparedStatement);
        return product;

    }

    public List<Product> selectProduct( int id) throws SQLException, ClassNotFoundException {
        Connection connection = this.dbmsConn.getConnection();
        this.query = "Select * from product where ID is null or  ID = ?;";
//
        PreparedStatement preparedStatement = connection.prepareStatement(this.query);
        preparedStatement.setInt(1,id);
        this.resultSet = preparedStatement.executeQuery();
        List<Product> products = new ArrayList();


        while (this.resultSet.next()) {
            Product product = new Product();
            product.setId(this.resultSet.getInt("ID"));
            product.setNAME(this.resultSet.getString("NAME"));
            product.setCOUNT(this.resultSet.getInt("COUNT"));
            product.setPRICE(this.resultSet.getInt("PRICE"));
            product.setDESCRIPTION(this.resultSet.getString("DESCRIPTION"));
            product.setCATEGORY(this.resultSet.getInt("CATEGORY"));
            product.setIS_ACTIVE(this.resultSet.getBoolean("IS_ACTIVE"));
            products.add(product);
        }

        products.stream().forEach((t) -> {
            System.out.println(t.toString());
        });
        return products;
    }
    public List<Product> selectProduct() throws SQLException, ClassNotFoundException {
        Connection connection = this.dbmsConn.getConnection();
        this.query = "Select * from product ;";
//
        PreparedStatement preparedStatement = connection.prepareStatement(this.query);
        this.resultSet = preparedStatement.executeQuery();
        List<Product> products = new ArrayList();


        while (this.resultSet.next()) {
            Product product = new Product();
            product.setId(this.resultSet.getInt("ID"));
            product.setNAME(this.resultSet.getString("NAME"));
            product.setCOUNT(this.resultSet.getInt("COUNT"));
            product.setPRICE(this.resultSet.getInt("PRICE"));
            product.setDESCRIPTION(this.resultSet.getString("DESCRIPTION"));
            product.setCATEGORY(this.resultSet.getInt("CATEGORY"));
            product.setIS_ACTIVE(this.resultSet.getBoolean("IS_ACTIVE"));
            products.add(product);
        }

        products.stream().forEach((t) -> {
            System.out.println(t.toString());
        });
        return products;
    }
}
