package user;

import java.util.Scanner;

public class UserCreation {

    private String userName;

    //    Method to store user input as the name
    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        //    Declare userName field
        userName = scanner.nextLine();
        System.out.println("Thank you " + userName + ", welcome to our card games!");
    }

    public String getUserName() {
        return userName;
    }

    public static void main(String[] args) {
        UserCreation userCreation = new UserCreation();
        userCreation.createUser();
        System.out.println("Stored user name: " + userCreation.getUserName());
    }
}
