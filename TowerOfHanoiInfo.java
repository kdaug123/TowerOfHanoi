/**
 * this stores all the Tower of Hanoi data for each problem
 @author Kaitlyn Daugherty
 */

public class TowerOfHanoiInfo {

    private long time;
    private StringBuilder movementOutput;
    private int discNum;
    private boolean moveDisplay;

    public TowerOfHanoiInfo(int discNum, boolean moveDisplay) {
        setDiscNum(discNum);
        setMovementDisplay(moveDisplay);
    }

    public TowerOfHanoiInfo(int discNum) {
        setDiscNum(discNum);
        setMovementDisplay(true);
        movementOutput = new StringBuilder();
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDiscNum() {
        return discNum;
    }

    public void setDiscNum(int discNum) {
        this.discNum = discNum;
    }

    public String getMovementOutput() {
        return movementOutput.toString();
    }

    public void setMovementOutput(String movementOutput) {
        this.movementOutput.append(movementOutput);
    }

    public boolean isMovementDisplay() {
        return moveDisplay;
    }

    public void setMovementDisplay(boolean moveDisplay) {
        this.moveDisplay = moveDisplay;
    }
}
