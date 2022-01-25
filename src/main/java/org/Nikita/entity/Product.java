package org.Nikita.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
public class Product {

    private Connection setConnection() throws  SQLException{
        return  DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234");
    }

    public void selectAllProduct() throws SQLException {
            PreparedStatement preparedStatement = setConnection().prepareStatement("Select * from product");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("id: "+ resultSet.getInt("id"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("price: "+ resultSet.getInt("price"));
            }
        }


    public void createNewProduct(String name , int price) throws  SQLException{
        PreparedStatement preparedStatement = setConnection().prepareStatement("Insert product(name , price) values(? , ?)");
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,price);

        int count = preparedStatement.executeUpdate();
        System.out.println("Add new product: "+ count);

    }

    public void updateProduct(int id , String name , int price) throws SQLException{
            PreparedStatement preparedStatement = setConnection().prepareStatement("Update product set name = ? , price = ? where id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, price);
            preparedStatement.setInt(3, id);
            int update = preparedStatement.executeUpdate();
    }

    public void sortLessPrice(int price) throws SQLException{
        PreparedStatement preparedStatement = setConnection().prepareStatement("Select name , price from product where price <= ? Order By price");
        preparedStatement.setInt(1,price);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println("name: " + resultSet.getString("name"));
            System.out.println("price: " + resultSet.getInt("price"));
        }
    }

}
