package org.Nikita.resource;


import lombok.Getter;
import lombok.Setter;

import java.sql.*;

@Getter
@Setter
public class CreateOwner {

    private final String name;
    private final int balance;
    private final int credit;
    private final boolean sex;

    public CreateOwner(String name, int balance, int credit, boolean sex, String login , String password) {
        this.name = name;
        this.balance = balance;
        this.credit = credit;
        this.sex = sex;
    }

    public void createOwner() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement("Insert javaee(name , balance , credit , sex) Values(  ? , ? , ? , ?)");

            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,balance);
            preparedStatement.setInt(3,credit);
            preparedStatement.setBoolean(4,sex);

             int count = preparedStatement.executeUpdate();
            System.out.println("Created new Owner " + count );
        }
    }
}
