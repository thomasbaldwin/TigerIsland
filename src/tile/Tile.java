package tile;

public class Tile {
    private Hex[] hexes;
    private int MAX_HEXES_PER_TILE = 3;


    Tile(Terrain terrainOne, Terrain terrainTwo) {
        hexes = new Hex[MAX_HEXES_PER_TILE];
        hexes[0] = new Hex(Terrain.VOLCANO);
        hexes[1] = new Hex(terrainOne);
        hexes[2] = new Hex(terrainTwo);

        setupAdjacencies();
    }

    private void setupAdjacencies() {
        Side[] sidesOfHexZero = hexes[0].getSides();
        Side[] sidesOfHexOne = hexes[1].getSides();
        Side[] sidesOfHexTwo = hexes[2].getSides();

        sidesOfHexZero[4].setSidesAdjacentToEachOther(sidesOfHexOne[5]);
        sidesOfHexZero[5].setSidesAdjacentToEachOther(sidesOfHexTwo[4]);
        sidesOfHexOne[4].setSidesAdjacentToEachOther(sidesOfHexTwo[5]);
    }

    public Hex[] getHexes() {
        return this.hexes;
    }
}