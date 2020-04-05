package GUI_Ver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class MainFrame {
    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel textFieldPanel;
    private JPanel restartExitPanel;
    private JPanel mainPanel;
    private ArrayList<JButton> buttons;
    private JTextArea textArea;
    private JTextField textField;
    private Computer computer;
    private TextAreaOutput console;
    private ButtonsHelper buttonsHelper;
    private GameLogic gameLogic;
    private String restartLabelText = " ";

    void run() {
        console = new TextAreaOutput();
        frame = new JFrame(console.frameTitle());
        buttons = new ArrayList<>();
        computer = new Computer();
        gameLogic = new GameLogic();
        buttonsHelper = new ButtonsHelper();
        buttonsHelper.fillCellStatusValuesList();

        JLabel instructionLabel = new JLabel(console.labelTitle());
        textField = new JTextField(10);

        buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));

        JPanel textAreaPanel = new JPanel();
        textArea = new JTextArea(23, 15);
        textArea.setEditable(false);
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);
        textAreaPanel.add(textAreaScrollPane);
        textAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        textAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        textFieldPanel = new JPanel();
        textFieldPanel.add(instructionLabel);
        textFieldPanel.add(textField);

        buttonPanel.setBackground(Color.BLACK);
        textAreaPanel.setBackground(Color.WHITE);

        textField.addActionListener(new TextFieldListener());

        mainPanel = new JPanel(new BorderLayout());

        frame.getContentPane().add(mainPanel);
        mainPanel.add(BorderLayout.NORTH, textFieldPanel);
        mainPanel.add(BorderLayout.CENTER, buttonPanel);
        mainPanel.add(BorderLayout.EAST, textAreaPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 450);
        frame.setVisible(true);
    }

    private void restart_exit_panel() {
        restartExitPanel = new JPanel();
        JLabel gameOverStatusLabel = new JLabel(restartLabelText);
        JButton restartButton = new JButton("Restart");
        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(new ButtonExitListener());
        restartButton.addActionListener(new ButtonRestartListener());

        restartExitPanel.add(gameOverStatusLabel);
        restartExitPanel.add(restartButton);
        restartExitPanel.add(exitButton);

        for (int i = 0; i < 9; i++) {
            buttons.get(i).setEnabled(false);
        }

        mainPanel.add(BorderLayout.NORTH, restartExitPanel);
    }

    private void winnerCheck() {
        if (gameLogic.winnerCheck(buttons).equals("You're win!")) {
            restartLabelText = "You're win!";
            restart_exit_panel();
        } else if (gameLogic.winnerCheck(buttons).equals("You're lose =(")) {
            restartLabelText = "You're lose =(";
            restart_exit_panel();
        }
    }

    private void wrapCheck() {
        if (gameLogic.checkGameStatus(buttonsHelper) == 1) {
            if (gameLogic.winnerCheck(buttons).equals("Wrap")) {
                restartLabelText = "It's a wrap";
                restart_exit_panel();
            }
        }
    }

    class TextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append(console.start() + textField.getText() + "\n");
            textArea.append(console.firstMove());
            textField.setText(null);
            for (int i = 0; i < 9; i++) {
                buttons.add(new JButton(" "));
                buttonPanel.add(buttons.get(i));
            }

            buttons.get(0).addActionListener(new Button1Listener());
            buttons.get(1).addActionListener(new Button2Listener());
            buttons.get(2).addActionListener(new Button3Listener());
            buttons.get(3).addActionListener(new Button4Listener());
            buttons.get(4).addActionListener(new Button5Listener());
            buttons.get(5).addActionListener(new Button6Listener());
            buttons.get(6).addActionListener(new Button7Listener());
            buttons.get(7).addActionListener(new Button8Listener());
            buttons.get(8).addActionListener(new Button9Listener());

            mainPanel.remove(textFieldPanel);
            frame.setSize(550, 420);

            mainPanel.validate();
            mainPanel.repaint();
            buttonPanel.validate();
            buttonPanel.repaint();
        }
    }

    class ButtonExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    class ButtonRestartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int arraySize = 8;
            for (int i = 0; i < 9; i++) {
                buttonPanel.remove(buttons.get(arraySize));
                buttons.remove(arraySize);
                arraySize--;
            }

            buttonPanel.validate();
            buttonPanel.repaint();
            buttonsHelper.removeCellStatusValues();
            buttonsHelper.fillCellStatusValuesList();
            mainPanel.remove(restartExitPanel);
            mainPanel.add(BorderLayout.NORTH, textFieldPanel);
            mainPanel.validate();
            mainPanel.repaint();
        }
    }

    class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(0).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(0).setText("X");
                buttonsHelper.getCellStatusValues().set(0, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(1).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(1).setText("X");
                buttonsHelper.getCellStatusValues().set(1, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(2).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(2).setText("X");
                buttonsHelper.getCellStatusValues().set(2, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(3).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(3).setText("X");
                buttonsHelper.getCellStatusValues().set(3, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button5Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(4).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(4).setText("X");
                buttonsHelper.getCellStatusValues().set(4, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button6Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(5).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(5).setText("X");
                buttonsHelper.getCellStatusValues().set(5, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button7Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(6).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(6).setText("X");
                buttonsHelper.getCellStatusValues().set(6, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button8Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(7).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(7).setText("X");
                buttonsHelper.getCellStatusValues().set(7, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }

    class Button9Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons.get(8).getText().equals(" ")) {
                textArea.append("Nice move...\n");
                buttons.get(8).setText("X");
                buttonsHelper.getCellStatusValues().set(8, 1);
                winnerCheck();
                computer.move(buttonsHelper, buttons, textArea);
                winnerCheck();
                wrapCheck();
            } else {
                textArea.append("This field is busy. Try another\n");
            }
        }
    }
}