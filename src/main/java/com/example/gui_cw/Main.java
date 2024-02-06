package com.example.gui_cw;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

import static com.example.gui_cw.Customer.*;  // Import Customer class variable
import static com.example.gui_cw.FoodQueue.*; // Import FoodQueue class variable

public class Main extends Application {

    public static void main(String[] args) throws IOException {

        menu();

        while (op){
            System.out.println();
            System.out.println("__________________________");
            System.out.print(  "Enter your option : ");
            String option = inputs.nextLine();                 // Get the option which user require
            System.out.println("______________________________________________");
            System.out.println();

            switch (option) {

                case "100", "VFQ" -> viewAllQueues();

                case "101", "VEQ" -> viewEmptyQueues();

                case "102", "ACQ" -> addCustomer();

                case "103", "RCQ" -> removeCustomer();

                case "104", "PCQ" -> removeServedCustomer();

                case "105", "VCS" -> sortedNames();

                case "106", "SPD" -> writeFile();

                case "107", "LPD" -> loadFile();

                case "108", "STK" -> System.out.println(noOfBurgersStock + " burgers in stock");

                case "109", "AFS" -> refillStock();

                case "110", "IFQ" -> queueIncome();

                case "999", "EXT" -> exit();

                case "112", "GUI" -> {
                    System.out.println("GUI successfully opened");
                    Application.launch(Main.class, args);
                }
                default -> {
                    System.out.println("Please enter accurate option as above !!");
                    continue;
                }
            }

            // This loop used to ask whether user want any option or not
            while (againMenu){
                System.out.println();
                System.out.print("Do you want option menu again (y or n) : ");
                String again = inputs.nextLine();

                if(Objects.equals(again, "y" ) || Objects.equals(again, "yes")){
                    break;  // If user enter 'y' or 'yes', this loop will break and ask option again
                } else if (Objects.equals(again, "n") || Objects.equals(again, "no")) {
                    op = false;         // If user enter 'n',main loop will be stopped
                    againMenu = false;  // If user enter 'n',this loop will be stopped
                    break;
                }
            }
        }
    }

    static Scanner inputs = new Scanner(System.in);
    // This is the code block which creates gui window
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();
        Scene scene = new Scene(root, 1110, 570);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
    static boolean op = true;           // This is for read option input
    static boolean againMenu = true;    // This boolean value used to continue and stop the loop (other option)
    public static void exit(){
        System.out.println("👋 Thank you");
        op = false;
        againMenu = false;
    }      // (M0) When user want to exit the program, this method will be called

    public static void menu(){
        System.out.println("__________________________________________________________");
        System.out.println();
        System.out.println("                FOODIES FAVE FOOD CENTRE                  ");
        System.out.println("__________________________________________________________");
        System.out.println();
        System.out.println("100 or VFQ : View ALL Queues");
        System.out.println("101 or VEQ : View all Empty Queues");
        System.out.println("102 or ACQ : Add customer to a Queue");
        System.out.println("103 or RCQ : Remove a customer from a Queue");
        System.out.println("104 or PCQ : Remove a served customer");
        System.out.println("105 or VCS : View Customers Sorted in alphabetical order");
        System.out.println("106 or SPD : Store Program Data into file");
        System.out.println("107 or LPD : Load Program Data from file");
        System.out.println("108 or STK : View Remaining burgers Stock");
        System.out.println("109 or AFS : Add burgers to Stock");
        System.out.println("110 or IFQ : View each queue income");
        System.out.println("112 or GUI : Open GUI");
        System.out.println("999 or EXT : Exit the Program");
    }      // This method will be displayed menu options
}
