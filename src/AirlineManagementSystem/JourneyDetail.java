package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class JourneyDetail extends JFrame implements ActionListener {
    JTable table;
    JTextField pnr;
    JButton show;

    public JourneyDetail() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblpnr = new JLabel("PNR Number");
        lblpnr.setFont(new Font("Ahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);

        pnr = new JTextField();
        pnr.setBounds(160, 50, 200, 25);
        add(pnr);


        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(50, 85, 200, 30);
        show.addActionListener(this);
        add(show);

        JLabel label = new JLabel("Flight Details");
        label.setBounds(180, 120, 400, 80);
        label.setFont(new Font("Algerian", Font.PLAIN, 50));
        label.setForeground(Color.red);
        add(label);

        table = new JTable();
        table.setFont(new Font("Times New Romania", Font.BOLD, 10));


        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10, 200, 780, 200);
        add(jsp);


        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '" + pnr.getText() + "'");
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.revalidate();
            table.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetail();
    }
}
