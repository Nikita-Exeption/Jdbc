package org.Nikita.transaction;

import org.Nikita.resource.SelectOwner;

import java.sql.*;

public class Transaction {

    private final SelectOwner selectOwner;

    private int id;

    public Transaction(SelectOwner selectOwner, int id) {
        this.selectOwner = selectOwner;
        this.id = id;
    }

    public Connection setConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/auto", "root", "1234");
    }

    public boolean minusTransaction(int value) throws SQLException {
            PreparedStatement preparedStatement = setConnection().prepareStatement("select balance from javaee where id = "+ id);

            ResultSet resultSet = preparedStatement.executeQuery();
            int current = 0;
            while (resultSet.next()) {
                current = resultSet.getInt("balance");
            }
            if (current >= value) {
                int result = current - value;
                preparedStatement.executeUpdate("Update javaee set balance = " + result + " where id = " + id);
                System.out.println("Current Balance: " + result);
                return true;
            } else {
                System.out.println("You balance not have so more money ,that transaction will be successfully ");
                return false;
            }

        }


    public int plusTransaction(int value) throws SQLException {
        int newBalance = 0;
        PreparedStatement preparedStatement = setConnection().prepareStatement("Select balance from javaee where id = "+ id);

        ResultSet resultSet = preparedStatement.executeQuery();
        int current = 0;
        while (resultSet.next()) {
            current = resultSet.getInt("balance");
        }
        newBalance = current + value;
        preparedStatement.executeUpdate("Update javaee set balance = " + newBalance +" where id = " + id);
        System.out.println("Your new balance: "+ newBalance);
        return newBalance;
    }

}
