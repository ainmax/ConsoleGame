public class GameMap {
    char[][] map;
    int sizeX;
    int sizeY;

    private int[] playerPosition;

    public GameMap(int sizeX, int sizeY, int playerPositionY, int playerPositionX) {
        this.map = new char[sizeY][sizeX];
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        this.playerPosition = new int[] {playerPositionY, playerPositionX};

        this.fill();
    }

    public void show() {
        for(int y = 0; y < sizeY; y++) {
            for(int x = 0; x < sizeX; x++) {
                System.out.print(this.map[y][x]);
                System.out.print(" ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public void setPlayerPosition(int playerPositionY, int playerPositionX) {
        this.playerPosition = new int[] {playerPositionY, playerPositionX};
        this.fill();
    }

    private void fill() {
        for(int y = 0; y < sizeY; y++) {
            for(int x = 0; x < sizeX; x++) {
                this.map[y][x] = '-';
            }
        }

        this.map[sizeY - 1][sizeX - 1] = '!';
        this.map[this.playerPosition[0]][this.playerPosition[1]] = 'Q';
    }
}