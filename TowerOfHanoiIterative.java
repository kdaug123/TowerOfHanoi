/**
 *  A iterative implementation of the Tower of Hanoi problem
 @author Kaitlyn Daugherty
 */

public class TowerOfHanoiIterative extends TowerOfHanoi {

    public TowerOfHanoiIterative() {
        super();
    }

    @Override
    protected void runSingleSimulation(int disc) {
        // initialize tower A to contain all discs in the correct order

        int minimumMoves = (int) Math.pow(2, disc) - 1;

        int source = 0;
        int spare = 1;
        int destination = 2;

        // if the number of discs are even then switch destination with spare
        if (disc % 2 == 0) {
            destination = 1;
            spare = 2;
        }

        for (int i = 1; i <= minimumMoves; i++) {
            if (i % 3 == 1) {
                // a legal move from the source tower to the destination tower
                move(source, destination);
            } else if (i % 3 == 2) {
                // a legal move from the source tower to the spare tower
                move(source, spare);
            } else if (i % 3 == 0) {
                // a legal move from the spare tower to the destination tower
                move(spare, destination);
            }
        }
    }

    private void move(int firstTowerIndex, int secondTowerIndex) {

        Tower firstTower = towers[firstTowerIndex];
        Tower secondTower = towers[secondTowerIndex];

        if (firstTower.isTowerEmpty()) {
            // if first tower is empty then move second tower top disk to first tower
            int secondTowerTopDisc = secondTower.popDisc();
            firstTower.pushDisc(secondTowerTopDisc);
            printMove(secondTowerTopDisc, secondTowerIndex, firstTowerIndex);
        } else if (secondTower.isTowerEmpty()) {
            // if second tower is empty then move first tower top disk to second tower
            int firstTowerTopDisc = firstTower.popDisc();
            secondTower.pushDisc(firstTowerTopDisc);
            printMove(firstTowerTopDisc, firstTowerIndex, secondTowerIndex);
        } else if (firstTower.peekDisc() > secondTower.peekDisc()) {
            // if first tower top disk is greater than second tower top disk, then move
            // second tower top disk to first tower
            int secondTowerTopDisc = secondTower.popDisc();
            firstTower.pushDisc(secondTowerTopDisc);
            printMove(secondTowerTopDisc, secondTowerIndex, firstTowerIndex);
        } else {
            // if first tower top disk is less than second tower top disk move first tower
            // top disk to second tower.
            int firstTowerTopDisc = firstTower.popDisc();
            secondTower.pushDisc(firstTowerTopDisc);
            printMove(firstTowerTopDisc, firstTowerIndex, secondTowerIndex);
        }
    }
}
