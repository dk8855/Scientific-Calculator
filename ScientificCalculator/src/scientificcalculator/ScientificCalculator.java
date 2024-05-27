
package scientificcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private JTextArea inputField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton, squareButton, squareRootButton, cubeButton, sinButton, cosButton, tanButton, logButton, cubeRootButton; // Added cubeRootButton
    private double num1, num2, result;
    private char operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 400);
        setLayout(new BorderLayout());

        inputField = new JTextArea();
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 5));
        add(buttonPanel, BorderLayout.CENTER);

        numberButtons = new JButton[10];
        for (int i = 9; i >= 0; i--) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }


        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        squareButton = new JButton("^2");
        squareRootButton = new JButton("√");
        cubeButton = new JButton("^3");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        cubeRootButton = new JButton("∛");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
        squareButton.addActionListener(this);
        squareRootButton.addActionListener(this);
        cubeButton.addActionListener(this);
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);
        tanButton.addActionListener(this);
        logButton.addActionListener(this);
        cubeRootButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(squareRootButton);
        buttonPanel.add(cubeButton);
        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);
        buttonPanel.add(tanButton);
        buttonPanel.add(logButton);
        buttonPanel.add(cubeRootButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Character.isDigit(command.charAt(0))) {
            inputField.setText(inputField.getText() + command);
        } else if (command.charAt(0) == 'C') {
            inputField.setText("");
            num1 = num2 = result = 0;
            operator = ' ';
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        inputField.setText("Error");
                    break;
            }
            inputField.setText(String.valueOf(result));
            num1 = result;
            operator = ' ';
        } else if (command.equals("^2")) {
            num1 = Double.parseDouble(inputField.getText());
            result = num1 * num1;
            inputField.setText(String.valueOf(result));
        } else if (command.equals("√")) {
            num1 = Double.parseDouble(inputField.getText());
            if (num1 >= 0) {
                result = Math.sqrt(num1);
                inputField.setText(String.valueOf(result));
            } else {
                inputField.setText("Error");
            }
        } else if (command.equals("^3")) {
            num1 = Double.parseDouble(inputField.getText());
            result = num1 * num1 * num1;
            inputField.setText(String.valueOf(result));
        } else if (command.equals("sin")) {
            num1 = Double.parseDouble(inputField.getText());
            result = Math.sin(Math.toRadians(num1));
            inputField.setText(String.valueOf(result));
        } else if (command.equals("cos")) {
            num1 = Double.parseDouble(inputField.getText());
            result = Math.cos(Math.toRadians(num1));
            inputField.setText(String.valueOf(result));
        } else if (command.equals("tan")) {
            num1 = Double.parseDouble(inputField.getText());
            result = Math.tan(Math.toRadians(num1));
            inputField.setText(String.valueOf(result));
        } else if (command.equals("log")) {
            num1 = Double.parseDouble(inputField.getText());
            result = Math.log10(num1);
            inputField.setText(String.valueOf(result));
        } else if (command.equals("∛")) {
            num1 = Double.parseDouble(inputField.getText());
            result = Math.cbrt(num1);
            inputField.setText(String.valueOf(result));
        } else {
            num1 = Double.parseDouble(inputField.getText());
            operator = command.charAt(0);
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
