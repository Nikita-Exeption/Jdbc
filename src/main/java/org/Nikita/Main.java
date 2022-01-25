package org.Nikita;

import org.Nikita.entity.Product;
import org.Nikita.resource.CreateOwner;
import org.Nikita.resource.SelectOwner;
import org.Nikita.transaction.Transaction;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws SQLException {

        Product product = new Product();
        product.sortLessPrice(1100);

//        System.out.println("Application init \n" +
//                "Choose what are you want do \n" +
//                "1:Create new Owner\n" +
//                "2:Select information about user \n" +
//                "3:Plus your balance\n" +
//                "4:Minus your balance");
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        System.out.println("1");
//        if(number == 1){
//            System.out.println("1");
//            String name = scanner.nextLine();
//
//            System.out.println("2");
//            int balance = scanner.nextInt();
//            System.out.println("3");
//            int credit = scanner.nextInt();
//            System.out.println("4");
//            boolean sex = scanner.nextBoolean();
//            CreateOwner createOwner = new CreateOwner(name, balance , credit , sex);
//            System.exit(0);
//        }
//        System.out.println("Enter your id");
//            int id = scanner.nextInt();
//            SelectOwner selectOwner = new SelectOwner(id);
//            Transaction transaction = new Transaction(selectOwner, id);
//        switch (number){
//            case 2:
//                selectOwner.select();
//                break;
//            case 3:
//                System.out.println("How much you want add your balance:");
//                int money = scanner.nextInt();
//                transaction.plusTransaction(money);
//                break;
//            case 4:
//                System.out.println("How much you want minus your balance:");
//                int minus = scanner.nextInt();
//                transaction.minusTransaction(minus);
//                break;
//            default:
//                System.out.println("Try again , maybe you not correct enter number");
//                break;

      //  }
    }
}
