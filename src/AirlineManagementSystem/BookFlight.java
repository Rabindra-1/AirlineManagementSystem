package AirlineManagementSystem;

import com.toedter.calendar.JCalendar.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookFlight extends JFrame implements ActionListener {

    JTextField citizenField;
    JRadioButton genderbtnMale, genderbtnFemale;
    JLabel nameField, phoneField, nationField, addressField, genderlbl, genderField, flightNameData, flightCodeData;

    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Book Flights");
        heading.setBounds(200, 70, 500, 80);
        heading.setFont(new Font("Algerian", Font.PLAIN, 40));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel i3 = new JLabel(image);
        i3.setBounds(550, 200, 500, 410);
        add(i3);

        JLabel citizenNo = new JLabel("Citizenship Number");
        citizenNo.setBounds(50, 150, 140, 30);
        add(citizenNo);

        citizenField = new JTextField();
        citizenField.setBounds(220, 150, 180, 30);
        add(citizenField);

        JButton fetchButton = new JButton("Fetch Data");
        fetchButton.setBounds(410, 150, 110, 30);
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        add(fetchButton);

        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(50, 250, 140, 30);
        add(namelbl);

        JLabel nameField = new JLabel();
        nameField.setBounds(220, 250, 300, 30);
        add(nameField);

        JLabel nation = new JLabel("Nationality");
        nation.setBounds(50, 200, 140, 30);
        add(nation);

        nationField = new JLabel();
        nationField.setBounds(220, 200, 300, 30);
        add(nationField);


        JLabel addresslbl = new JLabel("Address");
        addresslbl.setBounds(50, 300, 140, 30);
        add(addresslbl);

        addressField = new JLabel();
        addressField.setBounds(220, 300, 300, 30);
        add(addressField);


        genderlbl = new JLabel("Gender");
        genderlbl.setBounds(50, 350, 140, 30);
        add(genderlbl);

        genderField = new JLabel();
        genderField.setBounds(220, 250, 140, 30);


        JLabel sourcelbl = new JLabel("Source");
        sourcelbl.setBounds(50, 400, 140, 30);
        add(sourcelbl);

        Choice source = new Choice();
        source.setBounds(220, 400, 180, 30);
        add(source);

        JLabel destinationlbl = new JLabel("Destination");
        destinationlbl.setBounds(50, 450, 180, 30);
        add(destinationlbl);

        Choice destination = new Choice();
        destination.setBounds(220, 450, 180, 30);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton fetchFlights = new JButton("Fetch Flights");
        fetchFlights.setBounds(410, 450, 110, 30);
        fetchFlights.setBackground(Color.BLACK);
        fetchFlights.setForeground(Color.WHITE);
        add(fetchFlights);

        JLabel flightNamelbl = new JLabel("Flight Name");
        flightNamelbl.setBounds(50, 500, 140, 30);
        add(flightNamelbl);

        flightNameData = new JLabel();
        flightNameData.setBounds(220, 500, 140, 30);
        add(flightNameData);

        JLabel flightCodelbl = new JLabel("Flight Code");
        flightCodelbl.setBounds(50, 550, 140, 30);
        add(flightCodelbl);

        flightCodeData = new JLabel();
        flightCodeData.setBounds(220, 550, 140, 30);
        add(flightCodeData);

        JLabel datelbl = new JLabel("Date of Travel");
        datelbl.setBounds(50, 600, 140, 30);
        add(datelbl);

        JDateChooser dcdate = new JDateChooser();
        dcdate.setBounds(220, 600, 180, 30);
        add(dcdate);


        JButton save = new JButton("Book Flights");
        save.setBounds(220, 650, 300, 30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);


        setSize(1100, 800);
        setLocation(750, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String name = nameField.getText();
        String nationality = nationField.getText();
        String citizen = citizenField.getText();
        String address = addressField.getText();
        String gender = null;
        if (genderbtnMale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String phone = phoneField.getText();
        try {
            Conn conn = new Conn();
            String query = "insert into passenger values('" + name + "','" + nationality + "','" + citizen + "','" + address + "','" + phone + "','" + gender + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Costumer Added Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new BookFlight();
    }
}
