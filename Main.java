import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Write your name:");
        String name = in.nextLine();
        System.out.println("Write map height:");
        int mapSizeX = in.nextInt();
        System.out.println("Write map width:");
        int mapSizeY = in.nextInt();
        System.out.println("_____________________");

        Game myGame = new Game(name, mapSizeY, mapSizeX);
        myGame.startGameLoop();
        in.close();
    }
}