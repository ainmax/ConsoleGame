public abstract class Player {
    private String name;
    public String getName() {
        return name;
    }

    private int[] coordinates;
    public int[] getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(int[] coordinates) { this.coordinates = coordinates; }

    Player(String name, int[] coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    abstract void processDirection(char direction, int mapSizeY, int mapSizeX);
}
