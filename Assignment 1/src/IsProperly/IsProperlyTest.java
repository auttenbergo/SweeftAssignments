package IsProperly;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class IsProperlyTest extends TestCase {

    public void test1(){
        String sample1 = "(({{[[()]]}}))";
        assertTrue(IsProperly.isProperly(sample1));

        String sample2 = "(({{[[(}]]}}))";
        assertFalse(IsProperly.isProperly(sample2));
    }
    public void test2(){
        String sample1 = "(()";
        assertFalse(IsProperly.isProperly(sample1));

        String sample2 = "({})(";
        assertFalse(IsProperly.isProperly(sample2));

        String sample3 = "(((";
        assertFalse(IsProperly.isProperly(sample3));
    }
    public void test3(){
        String providedSample1 = "(()())";
        assertTrue(IsProperly.isProperly(providedSample1));

        String providedSample2 = "())()";
        assertFalse(IsProperly.isProperly(providedSample2));
    }

    public void test4(){
        String sample1 = "sqrt((x2 - x1)^2 + (y2 - y1)^2)";
        assertTrue(IsProperly.isProperly(sample1));

        String sample2 = "a^2 + 2ab + b^2 = (a+b)(a+b) = (a+b)^2";
        assertTrue(IsProperly.isProperly(sample2));
    }
    public void test5(){
        String sample = "There are no parentheses here!";
        assertTrue(IsProperly.isProperly(sample));
    }
}
