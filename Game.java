import java.util.Scanner;

public class Game {
    private Player runner;

    private final GameMap map;

    public Game(String playerName, int mapSizeY, int mapSizeX) {
        runner = new Runner(playerName, new int[] {0, 0});

        this.map = new GameMap(mapSizeY, mapSizeX, runner.getCoordinates()[0], runner.getCoordinates()[1]);
    }

    public void startGameLoop() {
        String playerDirection;
        Scanner menuIn = new Scanner(System.in);

        System.out.println("You can choose: to stop game - write \"stop\" or to begin - write \"start\"");
        playerDirection = menuIn.nextLine();

        while(!playerDirection.equalsIgnoreCase("stop")) {
            if(!playerDirection.equalsIgnoreCase("start") && !playerDirection.equalsIgnoreCase("continue")) {
                System.out.println("You can choose: to stop game - write \"stop\" or to begin - write \"start\"");
                playerDirection = menuIn.nextLine();
                continue;
            }

            startTurnsLoop();

            System.out.println("You can choose: to stop game - write \"stop\" or to continue - write \"continue\"");
            playerDirection = menuIn.nextLine();
            runner = new Runner(runner.getName(), new int[] {0, 0});
        }
    }

    private void startTurnsLoop() {
        map.setPlayerPosition(runner.getCoordinates()[0], runner.getCoordinates()[1]);
        map.show();

        Scanner gameIn = new Scanner(System.in);
        while(stop()) {
            String inLine = gameIn.nextLine();

            if(inLine.length() != 0) {
                runner.processDirection(inLine.charAt(0), map.sizeY, map.sizeX);
            } else {
                System.out.println("Please, write direction.");
            }

            map.setPlayerPosition(runner.getCoordinates()[0], runner.getCoordinates()[1]);
            map.show();
        }
    }

    private boolean stop() {
        if(runner.getCoordinates()[0] == map.sizeY - 1 && runner.getCoordinates()[1] == map.sizeX - 1) {
            System.out.println(runner.getName() + ", you won!");
            return false;
        }

        return true;
    }
}
