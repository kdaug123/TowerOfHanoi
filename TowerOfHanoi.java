/**
 * This class solves one Tower of Hanoi problem and utilizes
 * the abstract class functionality to definte the implementations
 * later (i.e. TowerOfHanoi tower = new TowerOfHanoiRecursive())
 *
 @author Kaitlyn Daugherty
 */

public abstract class TowerOfHanoi {

    protected final int NUM_OF_TOWERS = 3;
    protected Tower[] towers;
    protected TowerOfHanoiInfo info;


    public TowerOfHanoi() {
        towers = new Tower[NUM_OF_TOWERS];
    }

    //runs simulation starting at disk 1 to numOfDiscs
    public void runSimulation() {
        initializeTowers();
        int numOfDiscs = info.getDiscNum();
        if (info.isMovementDisplay()) {
            info.setMovementOutput(String.format("\nDisc %d:\n", numOfDiscs));
        }
        long startTime = System.currentTimeMillis();
        runSingleSimulation(numOfDiscs);
        long endTime = System.currentTimeMillis();
        // add the total time it took the solve the problem to the correct TowerOfHanoiInfo object
        info.setTime(endTime - startTime);
    }

    public TowerOfHanoiInfo getInfo() {
        return info;
    }

    public void setInfo(TowerOfHanoiInfo info) {
        this.info = info;
    }

    protected void printMove(int disc, int firstIndex, int secondIndex) {
        char firstTower = towers[firstIndex].getName();
        char secondTower = towers[secondIndex].getName();
        if (info.isMovementDisplay()) {
            String output = String.format("\tMove disk %d from tower %c to tower %c\n", disc, firstTower, secondTower);
            info.setMovementOutput(output);
        }
    }

    abstract protected void runSingleSimulation(int disc);

    private void initializeTowers() {
        final char[] labels = {'A', 'B', 'C'};
        for (int tower = 0; tower < NUM_OF_TOWERS; tower++) {
            towers[tower] = new Tower(labels[tower]);
        }
        int numOfDiscs = info.getDiscNum();
        // select tower A
        Tower towerA = towers[0];
        //adds discs in tower A in order
        for (int disc = numOfDiscs; disc > 0; disc--) {
            towerA.pushDisc(disc);
        }
    }
}
