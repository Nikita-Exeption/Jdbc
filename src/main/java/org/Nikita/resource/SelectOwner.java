package org.Nikita.resource;

import lombok.Getter;

import java.sql.*;
import java.util.Scanner;


public class SelectOwner {

    static int countConnection = 0;

    int id;
    public SelectOwner(int id){
        this.id = id;
    }

    public void select() throws SQLException {
        countConnection++;
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from javaee Where id = ?");
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getInt(3));
                System.out.println(resultSet.getInt(4));
                System.out.println(resultSet.getBoolean(5));
            }
        }catch (SQLException e){
            System.out.println("Connection Error...");
        }
    }
}
