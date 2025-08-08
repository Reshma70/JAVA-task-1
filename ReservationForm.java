import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class ReservationForm extends JFrame {
    JTextField nameField, dateField, fromField, toField;
    JComboBox<String> trainBox, classBox;
    JTextArea outputArea;
    static int pnr = 1001;
    static HashMap<Integer, String> reservations = new HashMap<>();

    public ReservationForm() {
        setTitle("Reservation System");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel nameLbl = new JLabel("Name:");
        nameLbl.setBounds(30, 30, 80, 25);
        add(nameLbl);
        nameField = new JTextField();
        nameField.setBounds(120, 30, 150, 25);
        add(nameField);

        JLabel trainLbl = new JLabel("Train:");
        trainLbl.setBounds(30, 70, 80, 25);
        add(trainLbl);
        trainBox = new JComboBox<>(new String[]{"12627 - Karnataka Exp", "12861 - Link Exp", "12791 - Secunderabad Exp"});
        trainBox.setBounds(120, 70, 200, 25);
        add(trainBox);

        JLabel classLbl = new JLabel("Class:");
        classLbl.setBounds(30, 110, 80, 25);
        add(classLbl);
        classBox = new JComboBox<>(new String[]{"Sleeper", "AC", "General"});
        classBox.setBounds(120, 110, 100, 25);
        add(classBox);

        JLabel dateLbl = new JLabel("Date (dd-mm-yyyy):");
        dateLbl.setBounds(30, 150, 150, 25);
        add(dateLbl);
        dateField = new JTextField();
        dateField.setBounds(180, 150, 100, 25);
        add(dateField);

        JLabel fromLbl = new JLabel("From:");
        fromLbl.setBounds(30, 190, 80, 25);
        add(fromLbl);
        fromField = new JTextField();
        fromField.setBounds(120, 190, 100, 25);
        add(fromField);

        JLabel toLbl = new JLabel("To:");
        toLbl.setBounds(250, 190, 50, 25);
        add(toLbl);
        toField = new JTextField();
        toField.setBounds(300, 190, 100, 25);
        add(toField);

        JButton reserveBtn = new JButton("Reserve");
        reserveBtn.setBounds(120, 230, 100, 30);
        add(reserveBtn);

        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.setBounds(240, 230, 130, 30);
        add(cancelBtn);

        outputArea = new JTextArea();
        outputArea.setBounds(30, 280, 420, 150);
        outputArea.setEditable(false);
        add(outputArea);

        reserveBtn.addActionListener(e -> makeReservation());
        cancelBtn.addActionListener(e -> cancelReservation());

        setVisible(true);
    }

    void makeReservation() {
        String info = "PNR: " + pnr + "\n"
                + "Name: " + nameField.getText() + "\n"
                + "Train: " + trainBox.getSelectedItem() + "\n"
                + "Class: " + classBox.getSelectedItem() + "\n"
                + "Date: " + dateField.getText() + "\n"
                + "Route: " + fromField.getText() + " → " + toField.getText();
        reservations.put(pnr, info);
        outputArea.setText("Reservation Successful!\n\n" + info);
        pnr++;
    }

    void cancelReservation() {
        String input = JOptionPane.showInputDialog(this, "Enter PNR to cancel:");
        try {
            int pnrInput = Integer.parseInt(input);
            if (reservations.containsKey(pnrInput)) {
                int confirm = JOptionPane.showConfirmDialog(this, "Do you really want to cancel ticket?\n\n" + reservations.get(pnrInput), "Confirm", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    reservations.remove(pnrInput);
                    outputArea.setText("Ticket Cancelled for PNR: " + pnrInput);
                }
            } else {
                JOptionPane.showMessageDialog(this, "PNR not found.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid PNR input.");
        }
    }
}