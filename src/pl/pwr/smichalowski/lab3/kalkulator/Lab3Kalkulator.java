package pl.pwr.smichalowski.lab3.kalkulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3Kalkulator {
    private JFrame frame;
    private JPanel panel;
    private JTextField wynik;
    private JButton[] buttons = new JButton[10], operators = new JButton[4];
    private JButton rownaSie, button;
    public Font font = new Font("Arial", Font.BOLD, 24);
    public Font fontWynik = new Font("Arial", Font.BOLD, 30);
    Color lightGreen = new Color(155, 199, 159);
    Color green = new Color(92, 156, 98);
    Color darkGreen = new Color(32, 115, 40);
    public long l1 = 0L, l2 = 0L;
    public int operatorPressed = 0, counted = 0;
    public int[] xCords = {115, 115, 185, 255, 115, 185, 255, 115, 185, 255};
    public char[] operatory = {'+', '-', '*', '/'};
    public String operator;


    ActionListener przyciskCyfry = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton) {
                button = (JButton)e.getSource();
                if (wynik.getText().equals("0") || wynik.getText().equals("+") || wynik.getText().equals("-") ||
                        wynik.getText().equals("*") || wynik.getText().equals("/") || counted == 1) {
                    wynik.setText(button.getText());
                    counted = 0;
                } else {
                    if (wynik.getText().length() < 15)
                        wynik.setText(wynik.getText() + button.getText());
                }
            }
        }
    }; // ActionListener dla wszystkich przyciskow cyfr


    ActionListener przyciskOperatory = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton) {
                button = (JButton) e.getSource();
                if (!wynik.getText().equals("0")) {
                    l1 = Long.parseLong(wynik.getText());
                    operator = button.getText();
                    operatorPressed = 1;
                    wynik.setText(operator);
                }
            }
        }
    }; // ActionListener dla wszystkich przyciskow operatorow


    public Lab3Kalkulator() {

        // JFrame
        frame = new JFrame("Zadanie 3 - Prosty kalkulator (liczb calkowitych)");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JPanel
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);


        // textField - wynik
        wynik = new JTextField("0", 15);
        wynik.setBounds(110, 40, 280, 60);
        wynik.setFont(fontWynik);
        wynik.setBackground(Color.WHITE);
        wynik.setEditable(false);
        panel.add(wynik);


        // buttons[] - przyciski cyfr
        for(int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].setFont(font);
            buttons[i].setBackground(lightGreen);
            buttons[i].addActionListener(przyciskCyfry);

            switch(i) {
                case 0:
                    buttons[i].setBounds(xCords[i], 360, 130, 60);
                    break;
                case 1, 2, 3:
                    buttons[i].setBounds(xCords[i], 150, 60, 60);
                    break;
                case 4, 5, 6:
                    buttons[i].setBounds(xCords[i], 220, 60, 60);
                    break;
                case 7, 8, 9:
                    buttons[i].setBounds(xCords[i], 290, 60, 60);
                    break;
                default:
                    JOptionPane.showMessageDialog(frame, "Cos poszlo nie tak", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }

            panel.add(buttons[i]);
        }


        // operators[] - przyciski operatorow
        for(int i = 0; i < 4; i++) {
            operators[i] = new JButton(String.valueOf(operatory[i]));
            operators[i].setFont(font);
            operators[i].setBackground(green);
            operators[i].setBounds(325, 150+(i*70), 60, 60);
            operators[i].addActionListener(przyciskOperatory);
            panel.add(operators[i]);
        }


        // rownaSie - '='
        rownaSie = new JButton("=");
        rownaSie.setBounds(255, 360, 60, 60);
        rownaSie.setFont(font);
        rownaSie.setBackground(darkGreen);
        panel.add(rownaSie);
        rownaSie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(operatorPressed == 1) {
                    l2 = Long.parseLong(wynik.getText());
                    switch(operator) {
                        case "+":
                            wynik.setText(Long.toString(l1 + l2));
                            break;
                        case "-":
                            wynik.setText(Long.toString(l1 - l2));
                            break;
                        case "*":
                            wynik.setText(Long.toString(l1 * l2));
                            break;
                        case "/":
                            wynik.setText(Long.toString(l1 / l2));
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, "Cos poszlo nie tak, wprowadz dzialanie ponownie", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                    operatorPressed = 0;
                    counted = 1;
                }
            }
        });

    } // koniec konstruktora obiektu klasy Lab3Kalkulator


    public JFrame getFrame() {
        return this.frame;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab3Kalkulator().getFrame().setVisible(true);
            }
        });
    }

}
