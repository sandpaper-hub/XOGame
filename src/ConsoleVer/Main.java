package ConsoleVer;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.go(new User(), new Computer(), new Field(), new ConsoleInput());
    }
}