package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class Cancel extends JFrame implements ActionListener {

    JButton show, cancelbtn;
    JTextField pnrtf;
    JLabel namefld, fcodefld, datefld, cancelNo;

    public Cancel() {

        Random random = new Random();
        int genNumber = random.nextInt(1000000);

        JLabel header = new JLabel("CANCELATION");
        header.setFont(new Font("Algerian", Font.PLAIN, 32));
        header.setForeground(Color.red);
        header.setBounds(180, 30, 400, 30);
        add(header);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel i3 = new JLabel(image);
        i3.setBounds(360, 120, 200, 200);
        add(i3);

        JLabel pnrlbl = new JLabel("PNR Number");
        pnrlbl.setBounds(30, 80, 100, 30);
        add(pnrlbl);

        pnrtf = new JTextField();
        pnrtf.setBounds(150, 80, 150, 30);
        add(pnrtf);


        show = new JButton("Show Details");
        show.setBounds(320, 80, 150, 30);
        show.setForeground(Color.WHITE);
        show.setBackground(Color.BLACK);
        show.addActionListener(this);
        add(show);

        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(30, 120, 100, 30);
        add(namelbl);

        namefld = new JLabel();
        namefld.setBounds(150, 120, 100, 30);
        add(namefld);

        JLabel cancellbl = new JLabel("Cancellation no");
        cancellbl.setBounds(30, 170, 100, 30);
        add(cancellbl);

        cancelNo = new JLabel("" + genNumber);
        cancelNo.setBounds(150, 170, 100, 30);
        add(cancelNo);

        JLabel fcodelbl = new JLabel("Flight Code");
        fcodelbl.setBounds(30, 220, 100, 30);
        add(fcodelbl);

        fcodefld = new JLabel();
        fcodefld.setBounds(150, 220, 100, 30);
        add(fcodefld);


        JLabel datelbl = new JLabel("Date");
        datelbl.setBounds(30, 270, 100, 30);
        add(datelbl);

        datefld = new JLabel();
        datefld.setBounds(150, 270, 100, 30);
        add(datefld);

        cancelbtn = new JButton("Cancel");
        cancelbtn.setBackground(Color.BLACK);
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.setBounds(30, 320, 250, 30);
        cancelbtn.addActionListener(this);
        add(cancelbtn);

        setLayout(null);
        setLocation(800, 200);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == show) {
            String pnr = pnrtf.getText();
            try {
                Conn conn = new Conn();
                String query = "select * from reservation where PNR ='" + pnr + "'";

                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    namefld.setText(rs.getString("name"));
                    fcodefld.setText(rs.getString("flightcode"));
                    datefld.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Booking not Found");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelbtn) {
            String pnr = pnrtf.getText();
            String name = namefld.getText();
            String cancelno = cancelNo.getText();
            String fcode = fcodefld.getText();
            String date = datefld.getText();


            try {
                Conn conn = new Conn();
                String query = "insert into cancel values('" + pnr + "','" + name + "','" + cancelno + "','" + fcode + "','" + date + "')";

                conn.s.executeUpdate(query);

                conn.s.executeUpdate("delete from reservation where PNR = '" + pnr + "'");

                JOptionPane.showMessageDialog(null, "Ticket Cancled");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {
        new Cancel();
    }
}
