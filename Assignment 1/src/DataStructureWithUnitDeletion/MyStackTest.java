package DataStructureWithUnitDeletion;

import junit.framework.TestCase;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.assertThrows;

public class MyStackTest extends TestCase {


    public void test1(){
        MyStack<Integer> stack = new MyStack<>();
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());

        for(int i=1; i<= 10; i++){
            stack.push(i);
            assertEquals(i,stack.size());
        }
        for(int i=10; i>=1; i--){
            int value = stack.pop();
            assertEquals(i,value);
            assertEquals(i-1,stack.size());
        }
    }
    public void test2(){
        MyStack<Integer> stack = new MyStack<>();
        assertThrows(RuntimeException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                stack.pop();
            }
        });
        assertThrows(RuntimeException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                stack.peek();
            }
        });
    }
    public void test3(){
        MyStack<Double> stack = new MyStack<>();
        for(double i = 0.5; i <= 9.5; i++){
            stack.push(i);
            assertEquals(i,stack.peek());
            assertEquals(1,stack.size());

            stack.pop();
            assertEquals(0,stack.size());
        }
    }
}
