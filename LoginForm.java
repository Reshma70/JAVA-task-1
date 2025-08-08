import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    JTextField userField;
    JPasswordField passField;

    public LoginForm() {
        setTitle("Login - Online Reservation System");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 30, 80, 25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(120, 30, 160, 25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 70, 80, 25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(120, 70, 160, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(120, 110, 90, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.equals("reshma") && pass.equals("krishna")) {
                new ReservationForm();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}