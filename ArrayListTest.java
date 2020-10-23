import junit.framework.TestCase;
import org.junit.Test;


public class ArrayListTest extends TestCase {

    protected ArrayList<String> arr;
    protected ArrayList<Object> arrO;

    protected void setUp() {
        arr = new ArrayList<>();
        arrO = new ArrayList<>();
    }


    //testing the Push() function using junit
    @Test
    public void testAdd() {
        arr.add("test 1");
        assertEquals("test 1", arr.get(0));
    }
    @Test
    public void testClear(){
        arr.add("a");
        arr.add("b");
        assertEquals(2, arr.getSize());
        arr.clear();
        assertEquals(0, arr.getSize());

    }
}