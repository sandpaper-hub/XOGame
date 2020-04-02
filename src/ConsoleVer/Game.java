package ConsoleVer;

import java.util.InputMismatchException;
import java.util.Scanner;

class Game {
    private Scanner sc = new Scanner(System.in);

    void go(Player user, Player computer, Field field, ConsoleInput console) {
        introduction((User) user, console);
        while (gameIsOver(field)) {
            user.step(field, console);
            if (!gameIsOver(field)) break;
            computer.step(field, console);
        }

        while (true) {
            try {
                restart(console);
                break;
            } catch (CellException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean gameIsOver(Field field) {
        String[] charToString = new String[9];
        String line = null;

        for (int i = 0; i < Field.FIELD_CONSTANT_9; i++) {
            charToString[i] = String.valueOf(field.getCellValue()[i]);
        }

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    line = charToString[0] + charToString[1] + charToString[2];
                    break;
                case 1:
                    line = charToString[3] + charToString[4] + charToString[5];
                    break;
                case 2:
                    line = charToString[6] + charToString[7] + charToString[8];
                    break;
                case 3:
                    line = charToString[0] + charToString[3] + charToString[6];
                    break;
                case 4:
                    line = charToString[1] + charToString[4] + charToString[7];
                    break;
                case 5:
                    line = charToString[2] + charToString[5] + charToString[8];
                    break;
                case 6:
                    line = charToString[0] + charToString[4] + charToString[8];
                    break;
                case 7:
                    line = charToString[2] + charToString[4] + charToString[6];
                    break;
            }
            if (line.equals("XXX")) {
                System.out.println("\nYou're win!");
                return false;
            }
            if (line.equals("OOO")) {
                System.out.println("\nYou're lose...");
                return false;
            }
        }

        int sumOfCells = 0;
        for (int i = 0; i < Field.FIELD_CONSTANT_9; i++) {
            sumOfCells += field.getCellStatus()[i];
        }
        return sumOfCells != Field.FIELD_CONSTANT_9;

    }

    private void introduction(User user, ConsoleInput console) {
        console.welcome();
        user.setName(sc.nextLine());
        console.offerToPlay(user);
    }


    private void restart(ConsoleInput console) throws CellException {
        console.restartQuestion();
        byte answer = 0;
        try {
            answer = sc.nextByte();
        } catch (InputMismatchException e) {
            console.invalidChar();
            sc.skip(".*\n");
        }
        switch (answer) {
            case 1:
                sc.skip(".*\n");
                go(new User(), new Computer(), new Field(), new ConsoleInput());
                break;
            case 2:
                break;
            default:
                throw new CellException("Wrong Answer");
        }
    }
}