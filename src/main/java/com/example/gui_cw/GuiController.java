package com.example.gui_cw;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.util.Objects;

import static com.example.gui_cw.Customer.*;
import static com.example.gui_cw.FoodQueue.*;

public class GuiController {
    @FXML
    public Label q1p1;
    @FXML
    private Label q1p2;
    @FXML
    private Label q2p1;
    @FXML
    private Label q2p2;
    @FXML
    private Label q2p3;
    @FXML
    private Label q3p1;
    @FXML
    private Label q3p2;
    @FXML
    private Label q3p3;
    @FXML
    private Label q3p4;
    @FXML
    private Label q3p5;
    @FXML
    private Label burgersSoldq1;
    @FXML
    private Label burgersSoldq2;
    @FXML
    private Label burgersSoldq3;
    @FXML
    private Label issuedQ1;
    @FXML
    private Label issuedQ2;
    @FXML
    private Label issuedQ3;
    @FXML
    private Label burgerStock;
    @FXML
    private Label incomeq1;
    @FXML
    private Label incomeq2;
    @FXML
    private Label incomeq3;
    @FXML
    private Label name1;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label name6;
    @FXML
    private Label name7;
    @FXML
    private Label name8;
    @FXML
    private Label name9;
    @FXML
    private Label name10;
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
    @FXML
    private Label searchCustomerQueue;
    @FXML
    private Label searchCustomerPlace;
    @FXML
    private Label searchCustomerBurgers;
    @FXML
    private Label searchCustomerFname;
    @FXML
    private Label searchCustomerLname;
    @FXML
    private AnchorPane queueIncomePane;
    @FXML
    private AnchorPane customerDetails;
    @FXML
    private AnchorPane stockDetails;
    @FXML
    private AnchorPane searchDetails;
    @FXML
    private AnchorPane waitingDetails;
    @FXML
    private Pane searchResult;
    @FXML
    private ImageView happy;
    @FXML
    private ImageView oops;
    @FXML
    private Label foundoops;
    @FXML
    public Label waiting1;
    @FXML
    private Label waiting2;
    @FXML
    private Label waiting3;
    @FXML
    private Label waiting4;
    @FXML
    private Label waiting5;
    @FXML
    private Label waiting6;
    @FXML
    private Label waiting7;
    @FXML
    private Label waiting8;

    @FXML
    public void handleButtonClick(ActionEvent event) {
        Platform.exit();
    }


    public void openIncomeWindow(){
        queueIncomePane.setVisible(true);
        customerDetails.setVisible(false);
        stockDetails.setVisible(false);
        searchDetails.setVisible(false);
        searchResult.setVisible(false);
        waitingDetails.setVisible(false);
    }
    public void openCustomerWindow(){
        customerDetails.setVisible(true);
        queueIncomePane.setVisible(false);
        stockDetails.setVisible(false);
        searchDetails.setVisible(false);
        searchResult.setVisible(false);
        waitingDetails.setVisible(false);
    }
    public void openStockWindow(){
        customerDetails.setVisible(false);
        queueIncomePane.setVisible(false);
        stockDetails.setVisible(true);
        searchDetails.setVisible(false);
        searchResult.setVisible(false);
        waitingDetails.setVisible(false);
    }
    public void close(){
        queueIncomePane.setVisible(false);
        customerDetails.setVisible(false);
        stockDetails.setVisible(false);
        searchDetails.setVisible(false);
        searchResult.setVisible(false);
        waitingDetails.setVisible(false);
    }
    public void openSearchWindow(){
        searchDetails.setVisible(true);
        queueIncomePane.setVisible(false);
        customerDetails.setVisible(false);
        stockDetails.setVisible(false);
        searchResult.setVisible(false);
        waitingDetails.setVisible(false);
    }
    public void openWaitingWindow(){
        waitingDetails.setVisible(true);
        searchDetails.setVisible(false);
        queueIncomePane.setVisible(false);
        customerDetails.setVisible(false);
        stockDetails.setVisible(false);
        searchResult.setVisible(false);
    }

    public void searchCustomer(){



        String FirstName = firstName.getText();
        boolean found = false;

        for(int i=0;i<2;i++){
            if(Objects.equals(q1[i][0], FirstName)){
                int place = i+1;
                searchCustomerQueue.setText("First Queue" );
                searchCustomerPlace.setText(String.valueOf(place));
                searchCustomerBurgers.setText(q1[i][2]);
                searchCustomerFname.setText(q1[i][0]);
                searchCustomerLname.setText(q1[i][1]);
                found = true;
                break;
            }
        }
        for(int i=0;i<3;i++){
            if(Objects.equals(q2[i][0], FirstName)){
                int place = i+1;
                searchCustomerQueue.setText("Second Queue" );
                searchCustomerPlace.setText(String.valueOf(place));
                searchCustomerBurgers.setText(q2[i][2]);
                searchCustomerFname.setText(q2[i][0]);
                searchCustomerLname.setText(q2[i][1]);
                found = true;
                break;
            }
        }
        for(int i=0;i<5;i++){
            if(Objects.equals(q3[i][0], FirstName)){
                int place = i+1;
                searchCustomerQueue.setText("Third Queue");
                searchCustomerPlace.setText(String.valueOf(place));
                searchCustomerBurgers.setText(q3[i][2]);
                searchCustomerFname.setText(q2[i][0]);
                searchCustomerLname.setText(q2[i][1]);
                found = true;
                break;
            }
        }

        if (found) {
            foundoops.setText("Found");
            happy.setVisible(true);
            oops.setVisible(false);
        }else {
            searchCustomerQueue.setText("Not found");
            foundoops.setText("Oops");
            searchCustomerPlace.setText("none");
            searchCustomerBurgers.setText("none");
            searchCustomerFname.setText("none");
            searchCustomerLname.setText("none");
            oops.setVisible(true);
            happy.setVisible(false);
        }
        searchResult.setVisible(true);
    }


    public void initialize() {

        // Burger stock details
        burgersSoldq1.setText(String.valueOf(bugersSoldQ1));
        issuedQ1.setText(String.valueOf(bugersSoldQ1));
        burgersSoldq2.setText(String.valueOf(bugersSoldQ2));
        issuedQ2.setText(String.valueOf(bugersSoldQ2));
        burgersSoldq3.setText(String.valueOf(bugersSoldQ3));
        issuedQ3.setText(String.valueOf(bugersSoldQ3));
        burgerStock.setText(String.valueOf(noOfBurgersStock));

        // Queue income details
        incomeq1.setText(String.valueOf(bugersSoldQ1*650));
        incomeq2.setText(String.valueOf(bugersSoldQ2*650));
        incomeq3.setText(String.valueOf(bugersSoldQ3*650));

        // Customer details
        name1.setText(q1[0][0] + " " + q1[0][1]);
        name2.setText(q1[1][0] + " " + q1[1][1]);
        name3.setText(q2[0][0] + " " + q2[0][1]);
        name4.setText(q2[1][0] + " " + q2[1][1]);
        name5.setText(q2[2][0] + " " + q2[2][1]);
        name6.setText(q3[0][0] + " " + q3[0][0]);
        name7.setText(q3[1][0] + " " + q3[1][0]);
        name8.setText(q3[2][0] + " " + q3[2][0]);
        name9.setText(q3[3][0] + " " + q3[3][0]);
        name10.setText(q3[4][0] + " " + q3[4][0]);

        // Waiting queue details
        waiting1.setText(waitingQueue[0][0] + " " + waitingQueue[0][1]);
        waiting2.setText(waitingQueue[1][0] + " " + waitingQueue[1][1]);
        waiting3.setText(waitingQueue[2][0] + " " + waitingQueue[2][1]);
        waiting4.setText(waitingQueue[3][0] + " " + waitingQueue[3][1]);
        waiting5.setText(waitingQueue[4][0] + " " + waitingQueue[4][1]);
        waiting6.setText(waitingQueue[5][0] + " " + waitingQueue[5][1]);
        waiting7.setText(waitingQueue[6][0] + " " + waitingQueue[6][1]);
        waiting8.setText(waitingQueue[7][0] + " " + waitingQueue[7][1]);



        if(!Objects.equals(q1[0][0], "0")){
            q1p1.setText(q1[0][0]);
        }else
            q1p1.setText("null");
        if(!Objects.equals(q1[1][0], "0")){
            q1p2.setText(q1[1][0]);
        }else
            q1p2.setText("null");

        if(!Objects.equals(q2[0][0], "0")){
            q2p1.setText(q2[0][0]);
        }else
            q2p1.setText("null");
        if(!Objects.equals(q2[1][0], "0")){
            q2p2.setText(q2[1][0]);
        }else
            q2p2.setText("null");
        if(!Objects.equals(q2[2][0], "0")){
            q2p3.setText(q2[2][0]);
        }else
            q2p3.setText("null");


        if(!Objects.equals(q3[0][0], "0")){
            q3p1.setText(q3[0][0]);
        }else
            q3p1.setText("null");
        if(!Objects.equals(q3[1][0], "0")){
            q3p2.setText(q3[1][0]);
        }else
            q3p2.setText("null");
        if(!Objects.equals(q3[2][0], "0")){
            q3p3.setText(q3[2][0]);
        }else
            q3p3.setText("null");
        if(!Objects.equals(q3[3][0], "0")){
            q3p4.setText(q3[3][0]);
        }else
            q3p4.setText("null");
        if(!Objects.equals(q3[4][0], "0")){
            q3p5.setText(q3[4][0]);
        }else
            q3p5.setText("null");
    }
}