package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCostumer extends JFrame implements ActionListener {

    JTextField nameField, nationField, citizenField, addressField, phoneField;
    JRadioButton genderbtnMale, genderbtnFemale;

    public AddCostumer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD COSTUMER DETAILS");
        heading.setBounds(200, 70, 500, 80);
        heading.setFont(new Font("Algerian", Font.PLAIN, 40));
        heading.setForeground(Color.red);
        add(heading);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/icons/emp.png"));
        JLabel i1 = new JLabel(image);
        i1.setBounds(600, 100, 200, 400);
        add(i1);

        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(50, 150, 140, 30);
        add(namelbl);

        nameField = new JTextField();
        nameField.setBounds(220, 150, 300, 30);
        add(nameField);

        JLabel nation = new JLabel("Nationality");
        nation.setBounds(50, 200, 140, 30);
        add(nation);

        nationField = new JTextField();
        nationField.setBounds(220, 200, 300, 30);
        add(nationField);

        JLabel citizenNo = new JLabel("Citizenship Number");
        citizenNo.setBounds(50, 250, 140, 30);
        add(citizenNo);

        citizenField = new JTextField();
        citizenField.setBounds(220, 250, 300, 30);
        add(citizenField);

        JLabel addresslbl = new JLabel("Address");
        addresslbl.setBounds(50, 300, 140, 30);
        add(addresslbl);

        addressField = new JTextField();
        addressField.setBounds(220, 300, 300, 30);
        add(addressField);


        ButtonGroup gendergroup = new ButtonGroup();

        JLabel genderlbl = new JLabel("Gender");
        genderlbl.setBounds(50, 350, 140, 30);
        add(genderlbl);
        genderbtnMale = new JRadioButton("Male");
        genderbtnMale.setBounds(220, 350, 140, 30);
        genderbtnMale.setBackground(null);
        add(genderbtnMale);

        genderbtnFemale = new JRadioButton("Female");
        genderbtnFemale.setBounds(380, 350, 140, 30);
        genderbtnFemale.setBackground(null);
        add(genderbtnFemale);

        gendergroup.add(genderbtnMale);
        gendergroup.add(genderbtnFemale);
        JLabel phonelbl = new JLabel("Phone Number");
        phonelbl.setBounds(50, 400, 140, 30);
        add(phonelbl);

        phoneField = new JTextField();
        phoneField.setBounds(220, 400, 300, 30);
        add(phoneField);

        JButton save = new JButton("Save");
        save.setBounds(220, 450, 300, 30);
        save.addActionListener(this);
        add(save);


        setSize(900, 600);
        setLocation(950, 300);
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

        new AddCostumer();
    }
}
