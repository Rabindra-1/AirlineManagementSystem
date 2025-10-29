package AirlineManagementSyayem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Home extends JFrame implements ActionListener {


    public Home() {
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(600, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae) {
    }

    public static void main(String[] args) {
        new Home();
    }
}
