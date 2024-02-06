package com.example.gui_cw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;
import static com.example.gui_cw.Customer.*;

public class FoodQueue {
    static String[][] q1 = {{"0","0","0"},{"0","0","0"}}; // Array for queue 1
    static String[][] q2 = {{"0","0","0"},{"0","0","0"},{"0","0","0"}}; // Array for queue 2
    static String[][] q3 = {{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"}}; // Array for queue 3
    static String[][][] q123 = {q1,q2,q3};           // This array contains queue 1,2 and 3.
    static String[] viewq1 = {"X","X"};              // This array for display queue 1 positions occupied or not
    static String[] viewq2 = {"X","X","X"};          // This array for display queue 2 positions occupied or not
    static String[] viewq3 = {"X","X","X","X","X"};  // This array for display queue 3 positions occupied or not
    static String[][] waitingQueue = {{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"},{"0","0","0"}};
    static int waitingNumber = 0;                   // This variable used for add customers to waiting queue
    public static void viewEmptyQueues(){
        System.out.print("Empty positions in QUEUE 1 - ");
        for(int i = 0;i<q1.length;i++){
            if (Objects.equals(q1[i][0], "0")){     // Check queue 1 each element and check whether occupied or not,
                System.out.print(i+1 +" ");             // if it is not occupied position will be printed
            }
        }
        System.out.println();
        System.out.print("Empty positions in QUEUE 2 - ");
        for(int i = 0;i<q2.length;i++){
            if (Objects.equals(q2[i][0], "0")){     // Check queue 2 each element and check whether occupied or not,
                System.out.print(i+1 +" ");             // if it is not occupied position will be printed
            }
        }
        System.out.println();
        System.out.print("Empty positions in QUEUE 3 - ");
        for(int i = 0;i<q3.length;i++){
            if (Objects.equals(q3[i][0], "0")){    // Check queue 3 each element and check whether occupied or not,
                System.out.print(i+1 +" ");            // if it is not occupied position will be printed
            }
        }
        System.out.println();
    }       // This method will display empty positions in each queue
    public static void viewAllQueues(){

        System.out.println("*****************");
        System.out.println("     CASHIER     ");
        System.out.println("*****************");

        // Check the 1 queue has customers or not
        for(int i = 0;i < q1.length;i++){
            if (Objects.equals(q1[i][0], "0")){
                viewq1[i] = "X";  // If it is true it means it's occupied, view array that element replaces "X"
            }else
                viewq1[i] = "O";  // If it is false it means it's occupied, view array that element replaces "O"
        }
        for(int i = 0;i < q2.length;i++){
            if (Objects.equals(q2[i][0], "0")){
                viewq2[i] = "X";  // If it is true it means it's occupied, view array that element replaces "X"
            }else
                viewq2[i] = "O";  // If it is false it means it's occupied, view array that element replaces "O"
        }
        for(int i = 0;i < q3.length;i++){
            if (Objects.equals(q3[i][0], "0")){
                viewq3[i] = "X";  // If it is true it means it's occupied, view array that element replaces "X"
            }else
                viewq3[i] = "O";  // If it is false it means it's occupied, view array that element replaces "O"
        }

        // This will create interface to see each queue positions occupied or not
        System.out.println("\t"+viewq1[0]+"\t"+viewq2[0]+"\t"+viewq3[0]);
        System.out.println("\t"+viewq1[1]+"\t"+viewq2[1]+"\t"+viewq3[1]);
        System.out.println("\t"+"\t"+viewq2[2]+"\t"+viewq3[2]);
        System.out.println("\t"+"\t"+"\t"+viewq3[3]);
        System.out.println("\t"+"\t"+"\t"+viewq3[4]);
    }         // This method will display what positions are occupied or not
    public static void rearrangeWaitingQueue(){
        for(int i=0; i< waitingQueue.length-1 ;i++){
            waitingQueue[i] = waitingQueue[i+1];
        }
        waitingQueue[waitingQueue.length-1] = new String[]{"0","0","0"};
        waitingNumber--;
    } // After first element leave, rest of them bring forward in waitingQ
    public static void queueIncome(){
        System.out.println("Income of queue 1 - "+ bugersSoldQ1*650);
        System.out.println("Income of queue 2 - "+ bugersSoldQ2*650);
        System.out.println("Income of queue 3 - "+ bugersSoldQ3*650);
    }           // This method created to determine each queue income
    public static void sortedNames(){

        int custermersQueues =0;

        for (String[] strings : q1) {                   // Count how many customers in queue 1
            if (!Objects.equals(strings[0], "0")) {
                custermersQueues++;
            }
        }
        for (String[] strings : q2) {                   // Count how many customers in queue 2
            if (!Objects.equals(strings[0], "0")) {
                custermersQueues++;
            }
        }
        for (String[] strings : q3) {                   // Count how many customers in queue 3
            if (!Objects.equals(strings[0], "0")) {
                custermersQueues++;
            }
        }

        String[] names = new String[custermersQueues];  // Create a new array with length, no.of customers in all queues

        int namesArrIndex=0;
        for (String[] strings : q1) {
            if (!Objects.equals(strings[0], "0")) {  //  If customers are in queue 1, add to names array
                names[namesArrIndex] = strings[0] + " " + strings[1];
                namesArrIndex++;
            }
        }
        for (String[] strings : q2) {
            if (!Objects.equals(strings[0], "0")) {  //  If customers are in queue 2, add to names array
                names[namesArrIndex] = strings[0] + " " + strings[1];
                namesArrIndex++;
            }
        }
        for (String[] strings : q3) {
            if (!Objects.equals(strings[0], "0")) {  //  If customers are in queue 3, add to names array
                names[namesArrIndex] = strings[0] + " " + strings[1];
                namesArrIndex++;
            }
        }

        int length = names.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (names[j].charAt(0) > names[j + 1].charAt(0) || (names[j].charAt(0) == names[j + 1].charAt(0) && names[j].charAt(1) > names[j + 1].charAt(1))) {
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }

        for (String element:names){
            System.out.println(element);  // Print the sorted names
        }
    }           // To sort all customers name in the queues this will be called
    public static void loadFile() throws FileNotFoundException {

        Scanner infile = new Scanner(new File("SD2.txt"));

        for(int emptyLineSet = 0; emptyLineSet<3;emptyLineSet++){
            String line1 = infile.nextLine();  // In my text file there are empty line, this code will be skipped that
        }

        for(int l1=0;l1<2;l1++){
            for(int i = 0; i<3;i++){
                q1[l1][i] = infile.nextLine();
            }
            String line7 = infile.nextLine();
        }

        for(int emptyLineSet = 0; emptyLineSet<3;emptyLineSet++){
            String line1 = infile.nextLine();  // In my text file there are empty line, this code will be skipped that
        }

        for(int l2=0; l2<3;l2++){
            for(int i = 0; i<3;i++){
                q2[l2][i] = infile.nextLine();
            }
            String line18 = infile.nextLine();
        }

        for(int emptyLineSet = 0; emptyLineSet<3;emptyLineSet++){
            String line1 = infile.nextLine();  // In my text file there are empty line, this code will be skipped that
        }

        for(int l3 = 0; l3<5; l3++){
            for(int i = 0; i<3;i++){
                q3[l3][i] = infile.nextLine();
            }

            String line33 = infile.nextLine();
        }

        System.out.println("Data successfully load in to Queue 1/ Queue 2/ Queue 3");

    }   // This method will be loaded data from the text file
    public static void writeFile() throws FileNotFoundException {

        PrintWriter outputFile = new PrintWriter("SD2.txt");

        outputFile.println("""
                            
                            This is queue 1 customer details ______________________________________
                            """);

        for (int i = 0; i<q1.length;i++){
            int k = i+1;
            if(Objects.equals(q1[i][0], "0")){
                outputFile.println("0");
                outputFile.println("0");
                outputFile.println("0");
            }else{
                outputFile.println(q1[i][0]);
                outputFile.println(q1[i][1]);
                outputFile.println(q1[i][2]);

            }
            outputFile.println();
        }

        outputFile.println("""
                            
                            This is queue 2 customer details ______________________________________
                            """);

        for (int i = 0; i<q2.length;i++){
            int k = i+1;
            if(Objects.equals(q2[i][0], "0")){
                outputFile.println("0");
                outputFile.println("0");
                outputFile.println("0");
            }else{
                outputFile.println(q2[i][0]);
                outputFile.println(q2[i][1]);
                outputFile.println(q2[i][2]);
            }
            outputFile.println();
        }

        outputFile.println("""
                            
                            This is queue 3 customer details ______________________________________
                            """);

        for (int i = 0; i<q3.length;i++){
            int k = i+1;
            if(Objects.equals(q3[i][0], "0")){
                outputFile.println("0");
                outputFile.println("0");
                outputFile.println("0");

            }else{
                outputFile.println(q3[i][0]);
                outputFile.println(q3[i][1]);
                outputFile.println(q3[i][2]);
            }
            outputFile.println();
        }

        outputFile.close();


        System.out.println("Queue data has been sucessfully saved in 'SD2.txt' file");
    }  // This method will be stored data from the text file
}
