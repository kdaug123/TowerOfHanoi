import junit.framework.TestCase;
import org.junit.Test;


public class StackTest extends TestCase {

        protected Stack<String> stack;
        protected Stack<Object> stackO;
        protected void setUp() {
            stack = new Stack<>();
            stackO  = new Stack<>();
        }


        //testing the Push() function using junit
        @Test
        public void testPush() {
            stack.push("test 1");
            assertEquals("test 1", stack.pop());
        }
        @Test
        public void testPushWithObjects(){
            Object o = new Object();
            stackO.push(o);
            assertEquals(o, stackO.pop());
        }

        @Test
        public void testPushMultipleElements() {
            stack.push("a");
            stack.push("b");
            stack.push("c");
            assertEquals("c", stack.pop());
        }

        @Test
        public void testPop() {
            stack.push("test 2");
            assertTrue("test 2" == stack.pop());
        }

        @Test
        public void testPopIfEmpty() {
            assertNull(stack.pop());
        }

        @Test
        public void testGetSize() {
            stack.push("a");
            stack.push("b");
            stack.push("c");
            stack.push("d");
            assertEquals(4, stack.getSize());
            stack.pop();
            assertEquals(3, stack.getSize());
        }

        @Test
        public void testIsEmptyWithElements() {
            stack.push("a");
            stack.push("b");
            assertFalse(stack.isEmpty());
        }

        @Test
        public void testIsEmptyWithoutElements() {
            assertTrue(stack.isEmpty());
        }

        @Test
        public void testClear() {
            stack.push("a");
            stack.push("b");
            assertEquals(2, stack.getSize());
            stack.clear();
            assertEquals(0, stack.getSize());
        }

        @Test
        public void testPeekIsEmpty() {
            assertNull(stack.peek());
        }

        @Test
        public void testPeekIsNotEmpty() {
            stack.push("a");
            stack.push("b");
            assertEquals("b", stack.peek());
        }


}


