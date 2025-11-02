package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel label = new JLabel("Flight Details");
        label.setBounds(180, 20, 400, 80);
        label.setFont(new Font("Algerian", Font.PLAIN, 50));
        label.setForeground(Color.red);
        add(label);


        JTable table = new JTable();
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from flight");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }
        table.setBounds(20, 90, 780, 480);
        table.setFont(new Font("Times New Romania", Font.BOLD, 10));
        add(table);


        JScrollPane jsp = new JScrollPane();
        jsp.setBounds(20, 90, 780, 480);
        add(jsp);

        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
