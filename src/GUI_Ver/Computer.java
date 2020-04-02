package GUI_Ver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

class Computer {
    private int buttonIndex;

    private int getButtonIndex() {
        return buttonIndex;
    }

    private void random(ButtonsHelper buttonsHelper) {
        boolean stepComplete = false;
        if (buttonsHelper.sumOfCellStatusValues() != 9) {
            while (!stepComplete) {
                buttonIndex = new Random().nextInt(9);
                if (buttonsHelper.getCellStatusValues().get(buttonIndex) != 1) {
                    buttonsHelper.getCellStatusValues().set(buttonIndex, 1);
                    stepComplete = true;
                }
            }
        }
    }

    void move(ButtonsHelper buttonsHelper, ArrayList<JButton> buttons, JTextArea textArea) {
        random(buttonsHelper);
        buttons.get(getButtonIndex()).setText("O");
        textArea.append("Computer made a move...");
    }
}