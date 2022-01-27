package org.Nikita.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.*;
import java.util.Collection;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    public static int id = 2;
    private String login;
    private String password;

    public User(String login , String password){
        this.login = login;
        this.password = password;
    }

    public boolean authorization() throws SQLException {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("Select login , password from users_shop where (login = ?) AND (password = ?)");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            String loginCheck = "";
            String passwordCheck = "";
            while (resultSet.next()){
                 loginCheck = resultSet.getString("login");
                 passwordCheck = resultSet.getString("password");
            }
            if(loginCheck.isEmpty() || passwordCheck.isEmpty()){
                return false;
            }else
                return true;
        }
    }

    public String singIn() throws SQLException{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("Insert users_shop(id , login , password) values(? , ? , ? )");
            preparedStatement.setLong(1,++id);
            preparedStatement.setString(2,login);
            preparedStatement.setString(3,password);

            int count = preparedStatement.executeUpdate();
            System.out.println("Created new User: " +toString());

        }
        return toString();
    }

    public void addProductId(Product product , int id) throws SQLException{
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("Update users_shop set product_id = ? where id = ?");
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setInt(2,id);

            int count = preparedStatement.executeUpdate();
            System.out.println("Added product: "+ product.toString());
        }
    }
}
