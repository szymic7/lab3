package pl.pwr.smichalowski.lab3;

import javax.swing.*;
import java.awt.*;

public class Lab3Kalkulator {
    private JFrame frame;
    private JPanel panel;
    private JTextField wynik;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, mnozenie, dzielenie, rownaSie;
    public Font font = new Font("Arial", Font.BOLD, 24);
    Color lightGreen = new Color(155, 199, 159);
    Color green = new Color(92, 156, 98);
    Color darkGreen = new Color(32, 115, 40);

    public Lab3Kalkulator() {

        // JFrame
        frame = new JFrame("Zadanie 3 - Prosty kalkulator");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // JPanel
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        // textField - wynik
        wynik = new JTextField("0", 15);
        wynik.setBounds(100, 30, 280, 50);
        wynik.setFont(font);
        wynik.setEditable(false);
        panel.add(wynik);

        // b1 - '1'
        b1 = new JButton("1");
        b1.setBounds(115, 150, 60, 60);
        b1.setFont(font);
        b1.setBackground(lightGreen);
        panel.add(b1);

        // b2 - '2'
        b2 = new JButton("2");
        b2.setBounds(185, 150, 60, 60);
        b2.setFont(font);
        b2.setBackground(lightGreen);
        panel.add(b2);

        // b3 - '3'
        b3 = new JButton("3");
        b3.setBounds(255, 150, 60, 60);
        b3.setFont(font);
        b3.setBackground(lightGreen);
        panel.add(b3);

        // b4 - '4'
        b4 = new JButton("4");
        b4.setBounds(115, 220, 60, 60);
        b4.setFont(font);
        b4.setBackground(lightGreen);
        panel.add(b4);

        // b5 - '5'
        b5 = new JButton("5");
        b5.setBounds(185, 220, 60, 60);
        b5.setFont(font);
        b5.setBackground(lightGreen);
        panel.add(b5);

        // b6 - '6'
        b6 = new JButton("6");
        b6.setBounds(255, 220, 60, 60);
        b6.setFont(font);
        b6.setBackground(lightGreen);
        panel.add(b6);

        // b7 - '7'
        b7 = new JButton("7");
        b7.setBounds(115, 290, 60, 60);
        b7.setFont(font);
        b7.setBackground(lightGreen);
        panel.add(b7);

        // b8 - '8'
        b8 = new JButton("8");
        b8.setBounds(185, 290, 60, 60);
        b8.setFont(font);
        b8.setBackground(lightGreen);
        panel.add(b8);

        // b9 - '9'
        b9 = new JButton("9");
        b9.setBounds(255, 290, 60, 60);
        b9.setFont(font);
        b9.setBackground(lightGreen);
        panel.add(b9);

        // b0 - '0'
        b0 = new JButton("0");
        b0.setBounds(115, 360, 130, 60);
        b0.setFont(font);
        b0.setBackground(lightGreen);
        panel.add(b0);

        // rownaSie - '='
        rownaSie = new JButton("=");
        rownaSie.setBounds(255, 360, 60, 60);
        rownaSie.setFont(font);
        rownaSie.setBackground(darkGreen);
        panel.add(rownaSie);

        // plus - '+'
        plus = new JButton("+");
        plus.setBounds(325, 150, 60, 60);
        plus.setFont(font);
        plus.setBackground(green);
        panel.add(plus);

        // minus - '-'
        minus = new JButton("-");
        minus.setBounds(325, 220, 60, 60);
        minus.setFont(font);
        minus.setBackground(green);
        panel.add(minus);

        // mnozenie - '*'
        mnozenie = new JButton("*");
        mnozenie.setBounds(325, 290, 60, 60);
        mnozenie.setFont(font);
        mnozenie.setBackground(green);
        panel.add(mnozenie);

        // dzielenie - '/'
        dzielenie = new JButton("/");
        dzielenie.setBounds(325, 360, 60, 60);
        dzielenie.setFont(font);
        dzielenie.setBackground(green);
        panel.add(dzielenie);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Lab3Kalkulator().getFrame().setVisible(true);
            }
        });
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
