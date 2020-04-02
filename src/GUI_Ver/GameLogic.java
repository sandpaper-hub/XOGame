package GUI_Ver;

import javax.swing.*;
import java.util.ArrayList;

class GameLogic {
        byte checkGameStatus(ButtonsHelper buttonsHelper) {
        if (buttonsHelper.sumOfCellStatusValues() == 9) {
            return 1; //if field is busy
        } else {
            return 0; //if there are empty fields
        }
    }

    String winnerCheck (ArrayList<JButton> buttons) {
        ArrayList<String> rowOfValues = new ArrayList<>();

        rowOfValues.add(buttons.get(0).getText() + buttons.get(1).getText() + buttons.get(2).getText());
        rowOfValues.add(buttons.get(3).getText() + buttons.get(4).getText() + buttons.get(5).getText());
        rowOfValues.add(buttons.get(6).getText() + buttons.get(7).getText() + buttons.get(8).getText());
        rowOfValues.add(buttons.get(0).getText() + buttons.get(3).getText() + buttons.get(6).getText());
        rowOfValues.add(buttons.get(1).getText() + buttons.get(4).getText() + buttons.get(7).getText());
        rowOfValues.add(buttons.get(2).getText() + buttons.get(5).getText() + buttons.get(8).getText());
        rowOfValues.add(buttons.get(0).getText() + buttons.get(4).getText() + buttons.get(8).getText());
        rowOfValues.add(buttons.get(2).getText() + buttons.get(4).getText() + buttons.get(6).getText());

        for (int i = 0; i < 8; i++) {
            if (rowOfValues.get(i).equals("XXX")) {
                return "You're win!";
            }

            if (rowOfValues.get(i).equals("OOO")) {
                return "You're lose =(";
            }
        }
        return "Wrap";
    }
}
