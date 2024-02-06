package com.example.gui_cw;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import static com.example.gui_cw.FoodQueue.*;
import static com.example.gui_cw.FoodQueue.waitingNumber;

public class Customer {
    static Scanner customerInputs = new Scanner(System.in);
    static boolean addedToQueue = true;
    static int bugersSoldQ1 = 0;            // This variable is to maintain how many no.of burgers issued from queue 1
    static int bugersSoldQ2 = 0;            // This variable is to maintain how many no.of burgers issued from queue 2
    static int bugersSoldQ3 = 0;            // This variable is to maintain how many no.of burgers issued from queue 3
    static int noOfBurgersStock = 50;       // Number of burgers in stock
    static boolean rightQueue = true;       // If user enter correct queue this variable used to stop the loop
    static boolean rightPosition = true;    // If user enter correct position this variable used to stop the loop
    static boolean queueEmpty = true;       // This variable is used to check whether queue empty or not
    static boolean rightServedQueue = true; // If user enter correct queue this variable used to stop the loop
    public static void addCustomer(){
        addedToQueue = true;
        boolean foundEmptyPlace = false;

        System.out.print("Enter customer's first name  : ");
        String fname = customerInputs.nextLine(); // Get customer's first name and save as 'fname'
        System.out.print("Enter customer's last name   : ");
        String lname = customerInputs.nextLine(); // Get customer's last name and save as 'lname'

        int noBurgersReq = 0;
        boolean integer_burgers = false;

        while (!integer_burgers) {
            try {
                System.out.print("Enter No. of burgers required: ");
                noBurgersReq = Integer.parseInt(customerInputs.nextLine()); // Get the number of burgers customer requires
                integer_burgers = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer value.");
            }
        }


        if(noOfBurgersStock - noBurgersReq <= 0){
            System.out.println("Out of stock. Call '109' option to add");
            addedToQueue = false;

        } else if (noOfBurgersStock - noBurgersReq <= 10) {
            System.out.println("Burgers in stock is low. There are only "+ (noOfBurgersStock-noBurgersReq) +" burgers remaining");
        }

        while (addedToQueue){

            // In this method, It checks the all first places in queue 1,2 and 3
            for(int i=0; i<3;i++){
                if(Objects.equals(q123[i][0][0], "0")){
                    q123[i][0][0]= fname;
                    q123[i][0][1]= lname;
                    q123[i][0][2]= String.valueOf(noBurgersReq);
                    int qNum = i+1; // This variable used to display the queue number which is customer is added

                    if (i == 0)
                        bugersSoldQ1 = bugersSoldQ1 + noBurgersReq; // Increase the no of burgers sold in queue 1
                    else if (i == 1)
                        bugersSoldQ2 = bugersSoldQ2 + noBurgersReq; // Increase the no of burgers sold in queue 2
                    else
                        bugersSoldQ3 = bugersSoldQ3 + noBurgersReq; // Increase the no of burgers sold in queue 3

                    noOfBurgersStock = noOfBurgersStock - noBurgersReq; // Decrease the no of burgers customer ordered in stock

                    System.out.println(fname + " successfully added to the queue " + qNum ); // Display message which is removed customer name and queue
                    foundEmptyPlace = true;
                    break;
                }
            }

            if (foundEmptyPlace) {
                break; // If it finds empty place and store data, this will break the main loop unless below code execute and data will be duplicated
            }

            // In this method, It checks the all second places in queue 1,2 and 3
            for(int i=0; i<3;i++){
                if(Objects.equals(q123[i][1][0], "0")){
                    q123[i][1][0]= fname;
                    q123[i][1][1]= lname;
                    q123[i][1][2]= String.valueOf(noBurgersReq);
                    int qNum = i+1; // This variable used to display the queue number which is customer is added

                    if (i == 0)
                        bugersSoldQ1 = bugersSoldQ1 + noBurgersReq; // Increase the no of burgers sold in queue 1
                    else if (i == 1)
                        bugersSoldQ2 = bugersSoldQ2 + noBurgersReq; // Increase the no of burgers sold in queue 2
                    else
                        bugersSoldQ3 = bugersSoldQ3 + noBurgersReq; // Increase the no of burgers sold in queue 3

                    noOfBurgersStock = noOfBurgersStock - noBurgersReq; // Decrease the no of burgers customer ordered in stock

                    System.out.println(fname + " successfully added to the queue " + qNum); // Display message which is removed customer name and queue
                    foundEmptyPlace = true; // This used to stop the main loop
                    break;
                }
            }

            if (foundEmptyPlace) {
                break; // If it finds empty place and stored data, this will break the main loop unless below code execute and data will be duplicated
            }

            // In this method, It checks the all third places in queue 2 and 3
            for(int i=1; i<3;i++){
                if(Objects.equals(q123[i][2][0], "0")){
                    q123[i][2][0]= fname;
                    q123[i][2][1]= lname;
                    q123[i][2][2]= String.valueOf(noBurgersReq);

                    int qNum = i+1; // This variable used to display the queue number which is customer is added

                    if (i == 1)
                        bugersSoldQ2 = bugersSoldQ2 + noBurgersReq; // Increase the no of burgers sold in queue 2
                    else
                        bugersSoldQ3 = bugersSoldQ3 + noBurgersReq; // Increase the no of burgers sold in queue 3

                    noOfBurgersStock = noOfBurgersStock - noBurgersReq; // Decrease the no of burgers customer ordered in stock

                    System.out.println(fname + " successfully added to the queue " + qNum); // Display message which is removed customer name and queue
                    foundEmptyPlace = true;
                    break;
                }
            }

            if (foundEmptyPlace) {
                break; // If it finds empty place and store data, this will break the main loop unless below code execute and data will be duplicated
            }

            // In this method, It checks the all last two positions in queue 3
            for(int i=3; i<5;i++){
                if(Objects.equals(q123[2][i][0], "0")){
                    q123[2][i][0]= fname;
                    q123[2][i][1]= lname;
                    q123[2][i][2]= String.valueOf(noBurgersReq);

                    bugersSoldQ3 = bugersSoldQ3 + noBurgersReq; // Increase the no of burgers sold in queue 3

                    noOfBurgersStock = noOfBurgersStock - noBurgersReq;

                    System.out.println(fname + " successfully added to the queue 3"); // Display message which is removed customer name and queue
                    foundEmptyPlace = true;
                    break;

                } else if (!Objects.equals(q123[2][4][0], "0")) {
                    // If last positions of queue 3 is not empty, customer will be added to the waiting queue
                    waitingQueue[waitingNumber] = new String[]{fname, lname, String.valueOf(noBurgersReq)};
                    waitingNumber++;
                    noOfBurgersStock = noOfBurgersStock-noBurgersReq;

                    System.out.println(fname + " added to the waiting queue due to the all queues are full");

                    addedToQueue = false;
                    break;
                }
            }

            if (foundEmptyPlace) {
                break; // If it finds empty place and store data, this will break the main loop unless below code execute and data will be duplicated
            }
        }



    }           // If user want to add a customer queue this will be called
    public static void removeCustomer(){
        int removeQueue = 0;

        while (rightQueue){

            try{
                System.out.print("Enter queue number   : ");
                removeQueue = customerInputs.nextInt();

                // Check whether any customers are in queue 1
                if (removeQueue == 1){
                    for(String[] s: q1){
                        queueEmpty = true;
                        if(!Objects.equals(s[0], "0")){
                            queueEmpty = false;  // Inform that queue 1 is not empty
                            rightQueue = false;  // Stop the loop if there are any customers
                            break;
                        }
                    }
                    if (queueEmpty)  // If queue 1 has no any customers to remove, this will execute
                        System.out.println("This queue is empty");

                }
                // Check whether any customers are in queue 2
                else if (removeQueue == 2){
                    for(String[] s: q2){
                        queueEmpty = true;
                        if(!Objects.equals(s[0], "0")){
                            queueEmpty = false;  // Inform that queue 2 is not empty
                            rightQueue = false;  // Stop the loop if there are any customers
                            break;
                        }
                    }
                    if (queueEmpty)  // If queue 2 has no any customers to remove, this will execute
                        System.out.println("This queue is empty");



                }
                // Check whether any customers are in queue 3
                else if (removeQueue == 3){
                    for(String[] s: q3){
                        queueEmpty = true;
                        if(!Objects.equals(s[0], "0")){
                            queueEmpty = false;  // Inform that queue 3 is not empty
                            rightQueue = false;  // Stop the loop if there are any customers
                            break;
                        }
                    }
                    if (queueEmpty)  // If queue 3 has no any customers to remove, this will execute
                        System.out.println("This queue is empty");

                }
                // If user entered 999 Remove method will be stopped
                else if(removeQueue == 999){
                    rightQueue    = false;  // Stop the QUEUE CHECKING loop
                    rightPosition = false;  // Stop the POSITION CHECKING loop
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter queue number as a INTEGER !!!");
                customerInputs.next(); // Consume the invalid input
            }


        }

        // If user enter correct queue number, this will ask which position customer need to remove
        while (rightPosition){

            try{
                System.out.print("Enter queue position : ");
                int queuePosition = customerInputs.nextInt();

                customerInputs.nextLine();

                // Check weather entered position in queue 1 has a customer, if true remove the customer from queue 1
                if(removeQueue == 1 && queuePosition<3 && queuePosition>0 && !Objects.equals(q1[queuePosition - 1][0], "0")){

                    // When user remove specific customer, rest of them will come to forward
                    if(queuePosition == 1){
                        bugersSoldQ1 = bugersSoldQ1 - Integer.parseInt(q1[queuePosition-1][2]);
                        System.out.println(q1[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q1[0] = q1[1];
                        q1[1] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    } else {
                        System.out.println(q1[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q1[2] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    }
                }
                // Check weather entered position in queue 2 has a customer, if true remove the customer from queue 2
                else if(removeQueue == 2 && queuePosition<4 && queuePosition>0 &&!Objects.equals(q2[queuePosition - 1][0], "0")){

                    // When user remove specific customer, rest of them will come to forward
                    if(queuePosition == 1){
                        bugersSoldQ2 = bugersSoldQ2 - Integer.parseInt(q2[queuePosition-1][2]);
                        System.out.println(q2[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q2[0] = q2[1];
                        q2[1] = q2[2];
                        q2[2] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    } else if (queuePosition == 2){
                        bugersSoldQ2 = bugersSoldQ2 - Integer.parseInt(q2[queuePosition-1][2]);
                        System.out.println(q2[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q2[1] = q2[2];
                        q2[2] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    } else {
                        bugersSoldQ2 = bugersSoldQ2 - Integer.parseInt(q2[queuePosition-1][2]);
                        System.out.println(q2[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q2[2] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    }

                }
                // Check weather entered position in queue 3 has a customer, if true remove the customer from queue 3
                else if(removeQueue == 3 && queuePosition<6 && !Objects.equals(q3[queuePosition - 1][0], "0")){

                    // When user remove specific customer, rest of them will come to forward
                    if(queuePosition == 1){
                        bugersSoldQ3 = bugersSoldQ3 - Integer.parseInt(q3[queuePosition-1][2]);
                        System.out.println(q3[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q3[0] = q3[1];
                        q3[1] = q3[2];
                        q3[2] = q3[3];
                        q3[3] = q3[4];
                        q3[4] = waitingQueue[0];

                        rearrangeWaitingQueue();
                        break;
                    } else if (queuePosition == 2){
                        bugersSoldQ3 = bugersSoldQ3 - Integer.parseInt(q3[queuePosition-1][2]);
                        System.out.println(q3[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q3[1] = q3[2];
                        q3[2] = q3[3];
                        q3[3] = q3[4];
                        q3[4] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    } else if (queuePosition == 3){
                        bugersSoldQ3 = bugersSoldQ3 - Integer.parseInt(q3[queuePosition-1][2]);
                        System.out.println(q3[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q3[2] = q3[3];
                        q3[3] = q3[4];
                        q3[4] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    }else if (queuePosition == 4){
                        bugersSoldQ3 = bugersSoldQ3 - Integer.parseInt(q3[queuePosition-1][2]);
                        System.out.println(q3[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q3[3] = q3[4];
                        q3[4] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    } else {
                        bugersSoldQ3 = bugersSoldQ3 - Integer.parseInt(q3[queuePosition-1][2]);
                        System.out.println(q3[queuePosition-1][0]+ " removed from the " + (removeQueue) + " queue");
                        q3[4] = waitingQueue[0];
                        rearrangeWaitingQueue();
                        break;
                    }
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please enter queue position as a INTEGER !!!");
                customerInputs.next();
            }

        }

        rightQueue = true;

    }        // This method will remove customer from the queue
    public static void removeServedCustomer(){
        while (rightServedQueue){
            try{
                System.out.print("Enter queue served number : ");
                int servedQueue = customerInputs.nextInt();

                customerInputs.nextLine();

                if (servedQueue == 1 && !Objects.equals(q1[0][0], "0")){
                    System.out.println(q1[0][0] + " has been served");
                    q1[0] = q1[1];          // After removing first customer and rest of them bring one position forward
                    q1[1] = waitingQueue[0];// Last position will be waiting queue first position
                    rearrangeWaitingQueue();// Rest of the waiting queue positions bring forward
                    break;
                }

                else if (servedQueue == 2 && !Objects.equals(q2[0][0], "0")) {
                    System.out.println(q2[0][0] + " removed from 2 queue.");
                    q2[0]=q2[1];
                    q2[1]=q2[2];
                    q2[2]=waitingQueue[0];
                    rearrangeWaitingQueue();
                    break;
                }
                else if (servedQueue == 3 && !Objects.equals(q3[0][0], "0")) {
                    System.out.println(q3[0][0] + " removed from 3 queue.");
                    for(int i=0;i<q3.length-1;i++){
                        q3[i] = q3[i+1];  // After removing first customer and rest of them bring one position forward
                    }
                    q3[4]=waitingQueue[0];// Last position will be waiting queue first position
                    rearrangeWaitingQueue();// Rest of the waiting queue positions bring forward
                    break;
                }
                else{
                    System.out.println("This Queue has no customers to serve !!");
                    break;
                }

            }
            catch(InputMismatchException e) {
                System.out.println("Please enter queue number as a INTEGER !!!");
                customerInputs.next();
            }

        }
    }  // After serving customer in specific queue, customer will be removed
    public static void refillStock(){

        int addBurgers = 0;
        Boolean correct_type = false;

        while (!correct_type){
            try {
                System.out.print("How many bugers do you need to add : ");
                addBurgers = customerInputs.nextInt();
                correct_type = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                customerInputs.nextLine();
                correct_type = false;
            }
        }

        customerInputs.nextLine();

        noOfBurgersStock = noOfBurgersStock + addBurgers;

        if(noOfBurgersStock > 50){
            noOfBurgersStock = 50;
            System.out.println("Please burgers amount can not be exceeded!. Maximum amount is 50.");
            System.out.println("Currently 50 burgers in stock");

        }else{
            System.out.println("Currently there are "+ noOfBurgersStock + " burgers in stock");
        }

    }           // This method used for,If user want to refill the stock

}
