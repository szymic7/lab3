import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3JFrame implements ActionListener {
    private JFrame jframe;
    private JPanel jpanel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel textFieldLabel;
    private JLabel passwordFieldLabel;
    private JButton button;
    private JTextArea textArea;
    String user;
    char[] password;
    String stringPassword;

    public Lab3JFrame() {

        jframe = new JFrame("Logowanie");
        jframe.setSize(500, 500);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jpanel = new JPanel();
        jframe.add(jpanel);
        jpanel.setLayout(null);

        textFieldLabel = new JLabel("Login: ");
        textFieldLabel.setBounds(70, 30, 80, 25);
        jpanel.add(textFieldLabel);

        textField = new JTextField(20);
        textField.setBounds(170, 30, 150, 25);
        jpanel.add(textField);

        passwordFieldLabel = new JLabel("Password: ");
        passwordFieldLabel.setBounds(70, 60, 80, 25);
        jpanel.add(passwordFieldLabel);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(170, 60, 150, 25);
        jpanel.add(passwordField);

        button = new JButton("Log in");
        button.setBounds(340, 60, 100, 25);
        button.addActionListener(this);
        jpanel.add(button);

        textArea = new JTextArea("");
        textArea.setBounds(140, 130, 200, 120);
        jpanel.add(textArea);

        //jframe.getContentPane().add(textField, BorderLayout.CENTER);
        //jframe.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab3JFrame().getJFrame().setVisible(true);
            }
        });
    }

    public JFrame getJFrame() {
        return this.jframe;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        user = textField.getText();
        password = passwordField.getPassword();
        stringPassword = new String(password);

        if(user.equals("marek") && stringPassword.equals("haslo"))
            textArea.setText("\n Wprowadzone dane:\n Login: " + user + "\n Haslo: " + stringPassword + "\n\n Logowanie udane.");
        else
            textArea.setText("\n Wprowadzone dane:\n Login: " + user + "\n Haslo: " + stringPassword + "\n\n Logowanie nieudane.");
    }
}
