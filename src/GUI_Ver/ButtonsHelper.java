package GUI_Ver;

import java.util.ArrayList;

class ButtonsHelper {
    private ArrayList<Integer> cellStatusValues = new ArrayList<>();

    ArrayList<Integer> getCellStatusValues() {
        return cellStatusValues;
    }

    int sumOfCellStatusValues() {
        int result = 0;
        for (int a : cellStatusValues) {
            result += a;
        }
        return result;
    }

    void fillCellStatusValuesList() {
        for (int i = 0; i < 9; i++) {
            cellStatusValues.add(0);
        }
    }

    void removeCellStatusValues() {
        int arrayListSize = 8;
        for (int j = 0; j < 9; j++) {
            cellStatusValues.remove(arrayListSize);
            arrayListSize--;
        }
    }
}
