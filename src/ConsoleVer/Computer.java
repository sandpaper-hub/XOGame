package ConsoleVer;

import java.util.Random;

class Computer extends Player {
    private Random randomNum = new Random();

    void step(Field field, ConsoleInput console) {
        boolean stepComplete = false;
        console.computerRunning();
        while (!stepComplete) {
            int compInput = (randomNum.nextInt(9) + 1);
            if (field.getCellValue()[compInput - 1] == '_') {
                field.getCellValue()[compInput - 1] = 'O';
                field.getCellStatus()[compInput - 1] = 1;
                stepComplete = true;
            }
        }
        field.showField();
    }
}
