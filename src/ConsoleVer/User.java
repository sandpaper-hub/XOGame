package ConsoleVer;

import java.util.InputMismatchException;
import java.util.Scanner;

class User extends Player {
    private int userInput;
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    private Scanner sc = new Scanner(System.in);

    void step(Field field, ConsoleInput console) {
        while (true) {
            try {
                setUserInput(field, console);
                break;
            } catch (CellException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setUserInput(Field field, ConsoleInput console) throws CellException {
        while (true) {
            console.coordinateInput();
            try {
                userInput = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                console.invalidChar();
                sc.skip(".*\n");
            }
        }
        if (userInput < 1 || userInput > 9) {
            throw new CellException("Wrong coordinates!");
        } else {
            setCoordinateOnField(field);
        }
        field.showField();
    }

    private void setCoordinateOnField(Field field) throws CellException {
        if (field.getCellValue()[userInput - 1] == '_') {
            field.getCellValue()[userInput - 1] = 'X';
            field.getCellStatus()[userInput - 1] = 1;
        } else throw new CellException("Coordinate busy, try another");
    }
}