//package AirlineManagementSystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
//public class Home extends JFrame implements ActionListener {
//
//
//    public Home() {
//        getContentPane().setBackground(Color.getHSBColor(44, 44, 59));
//
//
//        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/icons/front.jpg"));
//        JLabel image = new JLabel(i1);
//        image.setBounds(0, 0, 1920, 1080);
//        add(image);
//        JLabel heading = new JLabel("Welcome to Airline management System ");
//        heading.setBounds(65, 40, 1900, 100);
//        heading.setForeground(Color.RED);
//        heading.setFont(new Font("Algerian", Font.PLAIN, 84));
//        image.add(heading);
//
//        JMenuBar menubar = new JMenuBar();
//        setJMenuBar(menubar);
//        JMenu details = new JMenu("Details");
//        menubar.add(details);
//
//        JMenuItem flightDetails = new JMenuItem("Flight Details");
//        flightDetails.addActionListener(this);
//
//        JMenuItem costumerDetails = new JMenuItem("Costumer Details");
//        costumerDetails.addActionListener(this);
//        JMenuItem bookFlights = new JMenuItem("Book Flights");
//        JMenuItem journeyDetails = new JMenuItem("Journey Details");
//        JMenuItem ticketCancel = new JMenuItem("Ticket Cancelation");
//
//
//        details.add(flightDetails);
//        details.add(costumerDetails);
//        details.add(bookFlights);
//        details.add(journeyDetails);
//        details.add(ticketCancel);
//
//        JMenu tickets = new JMenu("Tickets");
//        menubar.add(tickets);
//        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
//        tickets.add(boardingPass);
//
//
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setLocation(0, 0);
//        setVisible(true);
//
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        String text = ae.getActionCommand();
//        if (text.equals("Flight Details")) {
//            new FlightInfo();
//        } else if (text.equals("Costumer Details")) {
//            new AddCostumer();
//        } else if (text.equals("Book Flights")) {
//            new BookFlight();
//        } else if (text.equals("Journey Details")) {
//            new JourneyDetail();
//        } else if (text.equals("Ticket Cancelation")) {
//            new Cancel();
//        } else if (text.equals("Boarding Pass")) {
//            new BoardingPass();
//        }
//    }
//
//    public static void main(String[] args) {
//        new Home();
//    }
//}
//


package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton flightBtn, customerBtn, bookBtn, journeyBtn, cancelBtn, passBtn;

    public Home() {

        setTitle("Airline Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Enable smooth text
        System.setProperty("swing.aatext", "true");

        // BACKGROUND PANEL
        JPanel backgroundPanel = new JPanel() {
            Image bg = new ImageIcon(
                    ClassLoader.getSystemResource("AirlineManagementSystem/icons/front.jpg")
            ).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);
        add(backgroundPanel);

        // HEADING
        JLabel heading = new JLabel("Airline Management System");
        heading.setBounds(60, 40, 1300, 80);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 60));
        heading.setForeground(Color.WHITE);
        backgroundPanel.add(heading);

        // BUTTON PANEL
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(2, 3, 40, 40));
        panel.setBounds(200, 200, 900, 500);

        // CREATE BIG BUTTONS
        flightBtn = createButton("Flight Details");
        customerBtn = createButton("Customer Details");
        bookBtn = createButton("Book Flights");
        journeyBtn = createButton("Journey Details");
        cancelBtn = createButton("Cancel Ticket");
        passBtn = createButton("Boarding Pass");

        // add buttons
        panel.add(flightBtn);
        panel.add(customerBtn);
        panel.add(bookBtn);
        panel.add(journeyBtn);
        panel.add(cancelBtn);
        panel.add(passBtn);

        backgroundPanel.add(panel);

        setVisible(true);
    }

    // Method to make a modern rounded button
    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 24));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);

        // Button style
        btn.setBackground(new Color(0, 0, 0, 180)); // semi-transparent black
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addActionListener(this);

        // Hover Effect
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(255, 255, 255, 200));
                btn.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(0, 0, 0, 180));
                btn.setForeground(Color.WHITE);
            }
        });

        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == flightBtn) new FlightInfo();
        else if (src == customerBtn) new AddCostumer();
        else if (src == bookBtn) new BookFlight();
        else if (src == journeyBtn) new JourneyDetail();
        else if (src == cancelBtn) new Cancel();
        else if (src == passBtn) new BoardingPass();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Home::new);
    }
}


