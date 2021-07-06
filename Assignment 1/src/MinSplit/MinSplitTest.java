package MinSplit;


import junit.framework.TestCase;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.assertThrows;

public class MinSplitTest extends TestCase {

    private static final int NO_MONEY = 0;

    public void test1(){
        for(int i=0; i<MinSplit.coins.length; i++){
            int amount = MinSplit.coins[i];
            int answer = MinSplit.minSplit(amount);
            assertEquals(1,answer);
        }
        assertEquals(0,MinSplit.minSplit(NO_MONEY));
    }
    public void test2(){
        assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                int amount = -500;
                MinSplit.minSplit(amount);
            }
        });
    }
    public void test3(){
        int amount1 = 87;
        assertEquals(6,MinSplit.minSplit(amount1));

        int amount2 = 80;
        assertEquals(3,MinSplit.minSplit(amount2));

        int amount3 = 67;
        assertEquals(5,MinSplit.minSplit(amount3));

        int amount4 = 27;
        assertEquals(4,MinSplit.minSplit(amount4));

        int amount5 = 4;
        assertEquals(4,MinSplit.minSplit(amount5));

        int amount6 = 2021;
        int expected = amount6 / 50 + 2;
        assertEquals(expected,MinSplit.minSplit(amount6));
    }
    public void test4(){
        int amount = 50087;
        int expected = amount / 50 + 5;
        assertEquals(expected,MinSplit.minSplit(amount));
    }
}
