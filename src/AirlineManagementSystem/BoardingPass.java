package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class BoardingPass extends JFrame implements ActionListener {

    JButton show;
    JTextField pnrtf;
    JLabel namefld, fcodefld, datefld, fnamefld, srcfld, destfld, nationfld;

    public BoardingPass() {

        JLabel header = new JLabel("Buddha Air");
        header.setFont(new Font("Algerian", Font.PLAIN, 32));
        header.setForeground(Color.red);
        header.setBounds(180, 15, 400, 30);
        add(header);

        JLabel subheader = new JLabel("Boarding Pass");
        subheader.setFont(new Font("Algerian", Font.PLAIN, 14));
        subheader.setForeground(Color.BLUE);
        subheader.setBounds(220, 45, 400, 30);
        add(subheader);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/icons/buddha-air.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel i3 = new JLabel(image);
        i3.setBounds(360, 120, 200, 150);
        add(i3);

        JLabel pnrlbl = new JLabel("PNR Number");
        pnrlbl.setBounds(30, 80, 100, 30);
        add(pnrlbl);

        pnrtf = new JTextField();
        pnrtf.setBounds(150, 80, 150, 30);
        add(pnrtf);


        show = new JButton("Enter");
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

        JLabel nationalitylbl = new JLabel("Nationality");
        nationalitylbl.setBounds(30, 170, 100, 30);
        add(nationalitylbl);

        nationfld = new JLabel();
        nationfld.setBounds(150, 170, 100, 30);
        add(nationfld);

        JLabel srclbl = new JLabel("Source");
        srclbl.setBounds(30, 220, 100, 30);
        add(srclbl);

        srcfld = new JLabel();
        srcfld.setBounds(150, 220, 100, 30);
        add(srcfld);

        JLabel destlbl = new JLabel("Dest");
        destlbl.setBounds(270, 220, 100, 30);
        add(destlbl);

        destfld = new JLabel();
        destfld.setBounds(380, 220, 100, 30);
        add(destfld);

        JLabel fnamelbl = new JLabel("Flight name");
        fnamelbl.setBounds(30, 270, 100, 30);
        add(fnamelbl);

        fnamefld = new JLabel();
        fnamefld.setBounds(150, 270, 100, 30);
        add(fnamefld);

        JLabel fcodelbl = new JLabel("Flight Code");
        fcodelbl.setBounds(270, 270, 100, 30);
        add(fcodelbl);

        fcodefld = new JLabel();
        fcodefld.setBounds(270, 270, 100, 30);
        add(fcodefld);


        JLabel datelbl = new JLabel("Date");
        datelbl.setBounds(30, 320, 100, 30);
        add(datelbl);

        datefld = new JLabel();
        datefld.setBounds(150, 320, 100, 30);
        add(datefld);


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
        }

    }


    public static void main(String[] args) {
        new BoardingPass();
    }
}
