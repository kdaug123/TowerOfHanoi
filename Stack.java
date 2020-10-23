/**
 * A basic implementation of a Stack
 @author Kaitlyn Daugherty
 */

public class Stack<E> {

        private final ArrayList<E> data;


        public Stack() {
            data = new ArrayList<>();
        }

        // Copy Constructor
        public Stack(Stack oldStack) {
            this.data = new ArrayList<>(oldStack.data);
        }

        private void insertAtBottom(E top) {
            if (isEmpty()) {
                this.push(top);
            } else {
                E newTop = this.pop();
                insertAtBottom(top);

                this.push(newTop);
            }
        }

        public void reverse() {
            if (!isEmpty()) {
                E top = this.pop();
                reverse();

                insertAtBottom(top);
            }
        }

        public void push(E element) {
            data.add(element);
        }

        public E pop() {
            // If the List is empty, nothing can be returned, so
            // return null
            if (isEmpty()) return null;

            int lastIndex = getSize() - 1;
            E lastElement = data.get(lastIndex);
            data.remove(lastIndex);
            return lastElement;
        }

        public void clear() {
            data.clear();
        }

        public E peek() {
            // If the List is empty, nothing can be returned, so
            // return null
            if (isEmpty()) return null;
            return data.get(getSize() - 1);
        }

        public boolean isEmpty() {
            return getSize() == 0;
        }

        public int getSize() {
            return data.getSize();
        }
}

