package org.Nikita.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.*;

@Data
@ToString
public class Product {

    private int id;
    private String name;
    private int price;

    public Product(int id){
        this.id = id;
    }

    public Product(){}

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

    public Product select() throws  SQLException{
        PreparedStatement preparedStatement = setConnection().prepareStatement("Select * from product where id = ?");
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            name = resultSet.getString("name");
            price = resultSet.getInt("price");
        }
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setId(id);
        return product;
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

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setId(int id){
        this.id = id;
    }

}
