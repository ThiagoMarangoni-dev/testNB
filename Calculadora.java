import javax.swing.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame {
    private JTextField display;
    private String operador;
    private double num1, num2, resultado;

    public CalculadoraGUI() {
        initComponents();
    }

    private void initComponents() {
        display = new JTextField();
        display.setEditable(false);
        add(display, "North");

        JPanel panel = new JPanel();
        panel.setLayout(new java.awt.GridLayout(5, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel);

        setTitle("Calculadora");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("");
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(display.getText());
                switch (operador) {
                    case "+" -> resultado = num1 + num2;
                    case "-" -> resultado = num1 - num2;
                    case "*" -> resultado = num1 * num2;
                    case "/" -> resultado = num1 / num2;
                }
                display.setText(String.valueOf(resultado));
            } else {
                if (!display.getText().isEmpty()) {
                    num1 = Double.parseDouble(display.getText());
                    operador = command;
                    display.setText("");
                }
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new CalculadoraGUI().setVisible(true);
        });
    }
}

    
    
    
    
    
    
    
    
    