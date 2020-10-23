/**
 * A class to store Tower data
 @author Kaitlyn Daugherty
 */

public class Tower {

    private char name;
    private Stack<Integer> discs;

    public Tower(char name) {
        setName(name);
        discs = new Stack<>();
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public Stack<Integer> getDiscs() {
        return discs;
    }

    public Integer popDisc() {
        return discs.pop();
    }

    public Integer peekDisc() {
        return discs.peek();
    }

    public void pushDisc(int disc) {
        discs.push(disc);
    }

    public boolean isTowerEmpty() {
        return discs.isEmpty();
    }

    public void clearTower() {
        discs.clear();
    }

}
