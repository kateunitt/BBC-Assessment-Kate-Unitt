/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package createlife;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Kate Unitt
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label titleLabel;
    
    @FXML
    private TextArea environmentTextArea;
    
    @FXML
    private TextArea instructionsTextArea;
    
    @FXML
    private ComboBox chooseSeedComboBox;
    
    @FXML
    private Button giveLifeButton;
    
    @FXML
    private Button resetButton;
    
    seeds[] seeds;
    
    /* @FXML
    public void selectSeeds(ActionEvent ae) 
    {
        seeds selectedseeds = seeds[chooseSeedComboBox.getSelectionModel().getSelectedIndex()];
        environmentTextArea.setText(selectedseeds.environment);
        
    } */
    
    @FXML
    private void giveLifeButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        titleLabel.setText("Game of Life - Initialise World...!");
    }
    
    @FXML
    private void resetButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        titleLabel.setText("Game of Life - World End...!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        //THE SEEDS BEING USED IN THE ENVIRONMENT//
        
        //empty
        
        /* seeds emptySeed = new seeds();
        
        environmentTextArea.setText(selectedSeeds.environment);
        
        emptySeed.environment = "Ryan Reynolds"; */
        
        //end> empty
        
        
        
        
    }    
    
}


