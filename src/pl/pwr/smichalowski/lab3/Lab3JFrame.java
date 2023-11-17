package pl.pwr.smichalowski.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3JFrame {
    private JFrame jframe;
    private JPanel jpanel;
    private JTextField login, imie;
    private JPasswordField password;
    private JLabel textFieldLabel, passwordFieldLabel, imieTextLabel;
    private JButton button, sprawdzHaslo, button1, button2, button3, button4, ok;
    private JTextArea textArea;
    public String user, stringPassword;
    public char[] passwordArray;
    public int choice, textAreaLoc, duzeLitery = 0, cyfry = 0, znakiSpecjalne = 0, silaHasla = 0;
    public String[] kolory = {"Niebieski", "Zielony", "Pomaranczowy"};
    public Font font = new Font("Arial", Font.BOLD, 12);
    public Font font1 = new Font("Arial", Font.PLAIN, 16);

    public Lab3JFrame() {

        // Zmiana czcionki dla wszystkich wiadomosci, ktore beda wyswietlane w JOptionPane
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));


        // JFrame
        jframe = new JFrame("Zadania 1, 2, 5 - Logowanie i sprawdzanie sily hasla");
        jframe.setSize(700, 700);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JPanel
        jpanel = new JPanel();
        jframe.add(jpanel);
        jpanel.setLayout(null);


        // label - Login
        textFieldLabel = new JLabel("   Login: ");
        textFieldLabel.setBounds(150, 30, 100, 30);
        textFieldLabel.setFont(font1);
        jpanel.add(textFieldLabel);


        // textField - Login
        login = new JTextField(20);
        login.setBounds(250, 30, 150, 30);
        jpanel.add(login);


        // label - Password
        passwordFieldLabel = new JLabel("Password: ");
        passwordFieldLabel.setBounds(150, 70, 100, 30);
        passwordFieldLabel.setFont(font1);
        jpanel.add(passwordFieldLabel);


        // passwordField
        password = new JPasswordField(20);
        password.setBounds(250, 70, 150, 30);
        jpanel.add(password);


        // button - Log in
        button = new JButton("Log in");
        button.setBounds(275, 110, 100, 30);
        button.setFont(font);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user = login.getText();
                passwordArray = password.getPassword();
                stringPassword = new String(passwordArray);

                if(user.equals("marek") && stringPassword.equals("haslo"))
                    textArea.setText("\n Wprowadzone dane:\n Login: " + user + "\n Haslo: " + stringPassword + "\n\n Logowanie udane.");
                else
                    textArea.setText("\n Wprowadzone dane:\n Login: " + user + "\n Haslo: " + stringPassword + "\n\n Logowanie nieudane.");
            }
        });
        jpanel.add(button);


        // sprawdzHaslo (button) - sprawdzanie sily hasla
        sprawdzHaslo = new JButton("Sprawdz sile hasla");
        sprawdzHaslo.setBounds(420, 70, 150, 30);
        sprawdzHaslo.setFont(font);
        jpanel.add(sprawdzHaslo);
        sprawdzHaslo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordArray = password.getPassword();
                stringPassword = new String(passwordArray);

                for(char znak : passwordArray){
                    if(znak >= 'A' && znak <= 'Z')
                        duzeLitery++;
                    else if((znak >= 33 && znak <= 47) || (znak >= 58 && znak <= 64) || (znak >= 91 && znak <= 96) || (znak >= 123 && znak <= 126))
                        znakiSpecjalne++;
                    else if(znak >= '0' && znak <= '9')
                        cyfry++;
                }

                // Czynniki wplywajace na 'wspolczynnik sily hasla' a) przynajmniej 1 wielka litera, b) przynajmniej 1 cyfra,
                // c) przynajmniej 1 znak specjalny d) dlugosc hasla >= 10 znakow. Im wiecej warunkow spelnionych tym wyzszy
                // 'wspolczynnik sily hasla', a co za tym idzie - silniejsze haslo

                if(duzeLitery > 0)
                    silaHasla++;
                if(znakiSpecjalne > 0)
                    silaHasla++;
                if(cyfry > 0)
                    silaHasla++;
                if(stringPassword.length() >= 10)
                    silaHasla++;

                switch(silaHasla){
                    case 0:
                        JOptionPane.showMessageDialog(jframe, "Wprowadzone haslo: " + stringPassword + "\nSila hasla: bardzo slabe", "Sila hasla", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(jframe, "Wprowadzone haslo: " + stringPassword + "\nSila hasla: slabe", "Sila hasla", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(jframe, "Wprowadzone haslo: " + stringPassword + "\nSila hasla: srednie", "Sila hasla", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(jframe, "Wprowadzone haslo: " + stringPassword + "\nSila hasla: silne", "Sila hasla", JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(jframe, "Wprowadzone haslo: " + stringPassword + "\nSila hasla: bardzo silne", "Sila hasla", JOptionPane.PLAIN_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(jframe, "Sprawdzanie sily hasla zakonczone bledem. \nSprobuj ponownie.", "Sila hasla", JOptionPane.ERROR_MESSAGE);
                        break;
                }

                duzeLitery = 0;
                znakiSpecjalne = 0;
                cyfry = 0;
                silaHasla = 0;
            }
        });


        // textArea - dane uzytkownika
        textArea = new JTextArea("");
        textArea.setBounds(200, 200, 250, 150);
        textAreaLoc = 0;
        textArea.setFont(font1);
        textArea.setEditable(false);
        jpanel.add(textArea);


        // button1 - powiekszanie przycisku
        button1 = new JButton("Powieksz przycisk 'Log in'");
        button1.setFont(font);
        button1.setBounds(30, 500, 200, 50);
        jpanel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBounds(250, 110, 150, 70);
                button.setFont(new Font("Arial", Font.BOLD, 20));
            }
        });


        // button2 - przesuwanie pola tekstowego
        button2 = new JButton("Przesun pole tekstowe");
        button2.setFont(font);
        button2.setBounds(250, 500, 200, 50);
        jpanel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textAreaLoc == 0) {
                    textArea.setBounds(200, 270, 250, 150);
                    textAreaLoc = 1;
                } else if (textAreaLoc == 1) {
                    textArea.setBounds(200, 200, 250, 150);
                    textAreaLoc = 0;
                }
            }
        });


        // button3 - zmiana koloru tla
        button3 = new JButton("Zmien kolor tla");
        button3.setFont(font);
        button3.setBounds(470, 500, 200, 50);
        jpanel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = JOptionPane.showOptionDialog(jframe, "Na jaki kolor chcesz zmienić tlo okienka aplikacji?", "Zmien kolor",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, kolory, null);
                if (choice == 0) { // niebieski
                    jpanel.setBackground(Color.CYAN);
                } else if (choice == 1) { // zielony
                    jpanel.setBackground(Color.GREEN);
                } else if (choice == 2) { // pomaranczowy
                    jpanel.setBackground(Color.ORANGE);
                }
            }
        });


        // button4 - przejdz do zadania 3
        button4 = new JButton("Przejdz do zadania 3");
        button4.setFont(font);
        button4.setBounds(470, 580, 200, 50);
        jpanel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpanel.removeAll();
                jpanel.updateUI();

                // ustawienie nowego tytulu JFrame
                jframe.setTitle("Zadanie 3 - Poznajmy sie");

                // label - Podaj swoje imie
                imieTextLabel = new JLabel("Podaj swoje imie:");
                imieTextLabel.setFont(font1);
                imieTextLabel.setBounds(120, 200, 150, 50);
                jpanel.add(imieTextLabel);

                // textField - imie
                imie = new JTextField(20);
                imie.setFont(font1);
                imie.setBounds(270, 200, 200, 50);
                jpanel.add(imie);

                // button - OK
                ok = new JButton("OK");
                ok.setFont(font1);
                ok.setBounds(480, 200, 100, 50);
                jpanel.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(jframe, "Cześć " + imie.getText() + ", milo cie poznac!", "Witaj!", JOptionPane.PLAIN_MESSAGE);
                    }
                });
            }
        });

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

}
