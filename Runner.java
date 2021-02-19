public class Runner extends Player {
    Runner(String name, int[] coordinates) {
        super(name, coordinates);
    }

    public void processDirection(char direction, int mapSizeY, int mapSizeX) {
        switch (direction) {
            case 'w' -> {
                if (getCoordinates()[0] - 1 < 0) {
                    setCoordinates(new int[] { mapSizeY - 1, getCoordinates()[1] });
                } else {
                    setCoordinates(new int[] { getCoordinates()[0] - 1, getCoordinates()[1] });
                }
            }
            case 'a' -> {
                if (getCoordinates()[1] - 1 < 0) {
                    setCoordinates(new int[] { getCoordinates()[0], mapSizeX - 1 });
                } else {
                    setCoordinates(new int[] { getCoordinates()[0], getCoordinates()[1] - 1 });
                }
            }
            case 's' -> {
                if (getCoordinates()[0] + 1 > mapSizeY - 1) {
                    setCoordinates(new int[] { 0, getCoordinates()[1] });
                } else {
                    setCoordinates(new int[] { getCoordinates()[0] + 1, getCoordinates()[1] });
                }
            }
            case 'd' -> {
                if (getCoordinates()[1] + 1 > mapSizeX - 1) {
                    setCoordinates(new int[] { getCoordinates()[0], 0 });
                } else {
                    setCoordinates(new int[] { getCoordinates()[0], getCoordinates()[1] + 1 });
                }
            }
            default -> {
                System.out.println("Unknown direction!");
            }
        }
    }
}
