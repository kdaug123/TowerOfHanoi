import java.util.Arrays;

/**
 * A basic implementation of an ArrayList
 @author Kaitlyn Daugherty
 */

public class ArrayList<E> {

    private int size;
    private Object[] data;
    private final int DEFAULT_SIZE = 2;

    public ArrayList() {
        clear();
    }

    public ArrayList(ArrayList<E> copy) {
        data = new Object[copy.getSize()];
        for (int i  = 0; i< data.length; i++) {
            data[i] = copy.get(i);
        }
    }
    private void resize() {
        int newSize = 2 * data.length;
        data = Arrays.copyOf(data,newSize);
    }
    public void add(E input) {
        if (size >= data.length) {
            resize();
        }
        data[size] = input;
        size++;
    }

    public void clear() {
        size  = 0;
        data = new Object[DEFAULT_SIZE];
    }

    public int getSize() {
        return size;
    }
    public E get(int index) {
        return (E) data[index];
    }

    public void remove(E element) {
        //gets location of element to remove
        int loc;
        for (loc=0; loc< data.length; loc++) {
            if (element.equals(data[loc])) {
               break;
            }
        }
        //removes the element
        remove(loc);
    }
    public void remove(int index){
        //removes the element
        if (index < data.length) {
            // remove element by overwriting the content at the given index
            if (data.length - 1 - index >= 0) {
                System.arraycopy(data, index + 1, data, index, data.length - 1 - index);
            }
            size--;
        }
    }
}
