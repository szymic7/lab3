package pl.pwr.smichalowski.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3Kalkulator {
    private JFrame frame;
    private JPanel panel;
    private JTextField wynik;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, mnozenie, dzielenie, rownaSie, button;
    public Font font = new Font("Arial", Font.BOLD, 24);
    public Font fontWynik = new Font("Arial", Font.BOLD, 30);
    Color lightGreen = new Color(155, 199, 159);
    Color green = new Color(92, 156, 98);
    Color darkGreen = new Color(32, 115, 40);
    public long l1 = 0L, l2 = 0L;
    public int operatorPressed = 0, counted = 0;
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
    };
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
    };


    public Lab3Kalkulator() {

        // JFrame
        frame = new JFrame("Zadanie 3 - Prosty kalkulator (liczb calkowitych)");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
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


        // b1 - '1'
        b1 = new JButton("1");
        b1.setBounds(115, 150, 60, 60);
        b1.setFont(font);
        b1.setBackground(lightGreen);
        panel.add(b1);
        b1.addActionListener(przyciskCyfry);


        // b2 - '2'
        b2 = new JButton("2");
        b2.setBounds(185, 150, 60, 60);
        b2.setFont(font);
        b2.setBackground(lightGreen);
        panel.add(b2);
        b2.addActionListener(przyciskCyfry);


        // b3 - '3'
        b3 = new JButton("3");
        b3.setBounds(255, 150, 60, 60);
        b3.setFont(font);
        b3.setBackground(lightGreen);
        panel.add(b3);
        b3.addActionListener(przyciskCyfry);


        // b4 - '4'
        b4 = new JButton("4");
        b4.setBounds(115, 220, 60, 60);
        b4.setFont(font);
        b4.setBackground(lightGreen);
        panel.add(b4);
        b4.addActionListener(przyciskCyfry);


        // b5 - '5'
        b5 = new JButton("5");
        b5.setBounds(185, 220, 60, 60);
        b5.setFont(font);
        b5.setBackground(lightGreen);
        panel.add(b5);
        b5.addActionListener(przyciskCyfry);


        // b6 - '6'
        b6 = new JButton("6");
        b6.setBounds(255, 220, 60, 60);
        b6.setFont(font);
        b6.setBackground(lightGreen);
        panel.add(b6);
        b6.addActionListener(przyciskCyfry);


        // b7 - '7'
        b7 = new JButton("7");
        b7.setBounds(115, 290, 60, 60);
        b7.setFont(font);
        b7.setBackground(lightGreen);
        panel.add(b7);
        b7.addActionListener(przyciskCyfry);


        // b8 - '8'
        b8 = new JButton("8");
        b8.setBounds(185, 290, 60, 60);
        b8.setFont(font);
        b8.setBackground(lightGreen);
        panel.add(b8);
        b8.addActionListener(przyciskCyfry);


        // b9 - '9'
        b9 = new JButton("9");
        b9.setBounds(255, 290, 60, 60);
        b9.setFont(font);
        b9.setBackground(lightGreen);
        panel.add(b9);
        b9.addActionListener(przyciskCyfry);


        // b0 - '0'
        b0 = new JButton("0");
        b0.setBounds(115, 360, 130, 60);
        b0.setFont(font);
        b0.setBackground(lightGreen);
        panel.add(b0);
        b0.addActionListener(przyciskCyfry);


        // plus - '+'
        plus = new JButton("+");
        plus.setBounds(325, 150, 60, 60);
        plus.setFont(font);
        plus.setBackground(green);
        panel.add(plus);
        plus.addActionListener(przyciskOperatory);


        // minus - '-'
        minus = new JButton("-");
        minus.setBounds(325, 220, 60, 60);
        minus.setFont(font);
        minus.setBackground(green);
        panel.add(minus);
        minus.addActionListener(przyciskOperatory);


        // mnozenie - '*'
        mnozenie = new JButton("*");
        mnozenie.setBounds(325, 290, 60, 60);
        mnozenie.setFont(font);
        mnozenie.setBackground(green);
        panel.add(mnozenie);
        mnozenie.addActionListener(przyciskOperatory);


        // dzielenie - '/'
        dzielenie = new JButton("/");
        dzielenie.setBounds(325, 360, 60, 60);
        dzielenie.setFont(font);
        dzielenie.setBackground(green);
        panel.add(dzielenie);
        dzielenie.addActionListener(przyciskOperatory);


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

    }

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
