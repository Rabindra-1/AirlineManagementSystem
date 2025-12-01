package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
    JButton submitbtn, closebtn, resetbtn;
    JTextField userin;
    JPasswordField passin;

    public Login() {
        getContentPane().setBackground(Color.getHSBColor(44, 44, 59));
        setVisible(true);
        setSize(400, 280);
        setLocation(600, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel header = new JLabel("LOGIN");
        header.setBounds(60, 20, 400, 100);
        header.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 80));
        header.setForeground(Color.DARK_GRAY);

        JLabel uname = new JLabel("Username : ");
        uname.setBounds(50, 120, 90, 20);

        userin = new JTextField();
        userin.setBounds(150, 120, 190, 20);

        JLabel pass = new JLabel("Password : ");
        pass.setBounds(50, 150, 90, 20);

        passin = new JPasswordField();
        passin.setBounds(150, 150, 190, 20);

        resetbtn = new JButton("Reset");
        resetbtn.setBounds(50, 220, 130, 20);
        resetbtn.addActionListener(this);

        submitbtn = new JButton("Submit");
        submitbtn.setBounds(50, 180, 290, 30);
        submitbtn.addActionListener(this);

        closebtn = new JButton("Close");
        closebtn.setBounds(210, 220, 130, 20);
        closebtn.addActionListener(this);

        add(header);
        add(uname);
        add(pass);
        add(userin);
        add(passin);
        add(resetbtn);
        add(closebtn);
        add(submitbtn);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitbtn) {


            String username = userin.getText();
            String password = passin.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);

//                System.out.println("Username = " + username);
//                System.out.println("Password = " + password);
//                System.out.println("Query = " + query);

                if (rs.next()) {

                    Home home = new Home();
                    home.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    home.setVisible(true);
                } else {
                    System.out.println("Login Failed");
                    JOptionPane.showMessageDialog(null, "Invalid Username or password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == closebtn) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(false);
        } else if (ae.getSource() == resetbtn) {
            userin.setText("");
            passin.setText("");

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
