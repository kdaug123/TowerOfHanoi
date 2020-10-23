/**
 * A recursive implementation of the Tower of Hanoi problem
 @author Kaitlyn Daugherty
 */

public class TowerOfHanoiRecursive extends TowerOfHanoi {

    public TowerOfHanoiRecursive() {
        super();
    }

    @Override
    protected void runSingleSimulation(int disc) {
        int source = 0;
        int spare = 1;
        int destination = 2;

        // first call to move
        move(disc, source, destination, spare);
    }

    private void singleMove(int discs, int source, int destination) {
        int sourceTopDisc = towers[source].getDiscs().pop();
        towers[destination].getDiscs().push(sourceTopDisc);
        printMove(discs, source, destination);
    }


    private void move(int discs, int source, int destination, int spare) {
        // if base case when disc size is zero
        if (discs == 1) {
            singleMove(discs, source, destination);
        } else {
            move(discs-1, source, spare, destination);
            // move once
            singleMove(discs, source, destination);
            move(discs-1, spare, destination, source);
        }
    }
}
