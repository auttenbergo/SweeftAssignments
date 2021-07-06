package NotContains;

import junit.framework.TestCase;

public class NotContainsTest extends TestCase {

    // Empty Test
    public void test0(){
        int[] array = new int[0];
        assertEquals(1,NotContains.notContains(array));
    }
    // Only Zero
    public void test1(){
        int[] array = {0};
        assertEquals(1,NotContains.notContains(array));
    }
    // Only Negative Integers Test
    public void test2(){
        int[] array = {-1,-5,-20};
        assertEquals(1,NotContains.notContains(array));
    }
    // Only Positive Integers (Unit Plus Sequence) Test
    public void test3(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(11,NotContains.notContains(array));
    }
    // Only Positive Integers (Random Plus) Test
    public void test4(){
        int[] array1 = {3,2};
        int[] array2 = {3,7,1};
        int[] array3 = {26,10,25};
        int[] array4 = {1,6,3,2};
        int[] array5 = {1,2,5,4,7,6,10};

        assertEquals(1,NotContains.notContains(array1));
        assertEquals(2,NotContains.notContains(array2));
        assertEquals(1,NotContains.notContains(array3));
        assertEquals(4,NotContains.notContains(array4));
        assertEquals(3,NotContains.notContains(array5));
    }
    // Hybrid Integers Test
    public void test5(){
        int[] array1 = {-1,0,1};
        assertEquals(2,NotContains.notContains(array1));

        int[] array2 = {-5,6,-2,1,0,3,-7,2};
        assertEquals(4,NotContains.notContains(array2));

        int[] array3 = {-1,0,-2,5,3,1,6,2,0,4,0,6,-2};
        assertEquals(7,NotContains.notContains(array3));
    }
}
