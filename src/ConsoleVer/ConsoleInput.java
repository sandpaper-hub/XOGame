package ConsoleVer;

class ConsoleInput {

    void invalidChar() {
        System.out.println("Invalid Character");
    }

    void restartQuestion() {
        System.out.println("\nWant to play one more?" +
                "\n1 - YES || 2 - NO");

    }

    void computerRunning() {
        System.out.println("\nConsoleVer.Computer running...");
    }

    void coordinateInput() {
        System.out.println("\nEnter coordinates from 1 to 9");
    }

    void welcome() {
        System.out.println("\nWelcome in XO ConsoleVer.Game\n" +
                "Enter your name");
    }

    void offerToPlay(User user) {
        System.out.println("Let's play " + user.getName());
    }

    void someVoid() {

    }
}
