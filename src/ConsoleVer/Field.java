package ConsoleVer;

class Field {
    private static final int FIELD_CONSTANT_3;
    private static final int FIELD_CONSTANT_6;
    static final int FIELD_CONSTANT_9;

    static {
        FIELD_CONSTANT_3 = 3;
        FIELD_CONSTANT_6 = 6;
        FIELD_CONSTANT_9 = 9;
    }

    private char[] cellValue = new char[9];
    private byte[] cellStatus = new byte[9];

    Field() {
        for (int i = 0; i < FIELD_CONSTANT_9; i++) {
            cellValue[i] = '_';
            cellStatus[i] = 0;
        }
    }

    byte[] getCellStatus() {
        return cellStatus;
    }

    char[] getCellValue() {
        return cellValue;
    }

    void showField() {
        System.out.println(" ");
        for (int i = 0; i < FIELD_CONSTANT_9; i++) {
            if (i == FIELD_CONSTANT_3 || i == FIELD_CONSTANT_6) {
                System.out.print("\n");
            }
            System.out.print(cellValue[i] + " ");
        }
        System.out.println(" ");
    }
}