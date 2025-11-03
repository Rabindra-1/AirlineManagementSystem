package AirlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame implements ActionListener {


    public Home() {
        getContentPane().setBackground(Color.getHSBColor(44, 44, 59));


        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AirlineManagementSystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1920, 1080);
        add(image);
        JLabel heading = new JLabel("Welcome to Airline management System ");
        heading.setBounds(65, 40, 1900, 100);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Algerian", Font.PLAIN, 84));
        image.add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);

        JMenuItem costumerDetails = new JMenuItem("Costumer Details");
        costumerDetails.addActionListener(this);
        JMenuItem bookFlights = new JMenuItem("Book Flights");
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        JMenuItem ticketCancel = new JMenuItem("Ticket Cancelation");


        details.add(flightDetails);
        details.add(costumerDetails);
        details.add(bookFlights);
        details.add(journeyDetails);
        details.add(ticketCancel);

        JMenu tickets = new JMenu("Tickets");
        menubar.add(tickets);
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        tickets.add(boardingPass);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(0, 0);
        setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        if (text.equals("Flight Details")) {
            new FlightInfo();
        } else if (text.equals("Costumer Details")) {
            new AddCostumer();
        } else if (text.equals("Book Flights")) {
            new BookFlight();
        } else if (text.equals("Journey Details")) {
            new JourneyDetail();
        } else if (text.equals("Ticket Cancelation")) {
            new Cancel();
        } else if (text.equals("Boarding Pass")) {
            new BoardingPass();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
