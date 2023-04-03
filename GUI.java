import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends Frame implements ActionListener{
    JTextField userInputBox;
    JLabel message;
    JButton convertButton, exitButton;

    public GUI(){
        
        //Frame instantiation
        JFrame f = new JFrame("Exercise 1");

        //TextField instantiation
        userInputBox = new JTextField("Enter a temperature");
        userInputBox.setBounds(20, 65, 150, 20); 

        //convert int button instantiation
        convertButton = new JButton("Convert");
        convertButton.setBounds(20,100,100, 40);
        convertButton.addActionListener(this);

        //Exit button instantiation
        exitButton = new JButton("Exit");
        exitButton.setBounds(150,100,100, 40);
        exitButton.addActionListener(this);

        //Label instantiation
        message = new JLabel("This is a farenheit to celsius temperature converter");
        message.setBounds(20,20,450, 40);
        
        //Setting bounds and adding elements to frame
        f.add(convertButton);f.add(userInputBox);f.add(message);f.add(exitButton);
        f.setSize(500,200);
        f.setLayout(null); 
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        //verify button action performed
        if (e.getSource()==convertButton) {

            String userInput = userInputBox.getText(); //gets text that is typed in the text box

            try { //int check using parse and try/catch

                double farenheit = Double.parseDouble(userInput);
                double celsius = (farenheit-32)/9*5; //conversion
                String statement = String.format("%.1f", celsius);
                message.setText("Your temperature in celsius is: " + statement);

            } catch (NumberFormatException nfe){

                message.setText(userInput + " is not a valid temperature, try again");

            };

        }

        //exit button action performed
        else if(e.getSource()==exitButton){
            System.exit(0);
        }
    }

}
