package IsPalindrome;

import junit.framework.TestCase;

public class PalindromeCheckerTest extends TestCase {

    private String reverseString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--)
            stringBuilder.append(str.charAt(i));
        return stringBuilder.toString();
    }

    public void test1(){
        String sample = "palindrome";
        assertFalse(PalindromeChecker.isPalindrome(sample));
    }
    public void test2(){
        String sample = "abcdcba";
        assertTrue(PalindromeChecker.isPalindrome(sample));
    }
    public void test3(){
        String sample = "1991";
        assertTrue(PalindromeChecker.isPalindrome(sample));
    }
    public void test4(){
        String sample = "-!500!_";
        assertFalse(PalindromeChecker.isPalindrome(sample));
    }
    public void test5(){
        String sample = "/%*9009*%/";
        assertTrue(PalindromeChecker.isPalindrome(sample));
    }
    public void test6(){
        String halfSample = "I assume no more tests are needed";
        String sample1 = halfSample.concat(reverseString(halfSample));
        String sample2 = halfSample.concat(halfSample);

        assertTrue(PalindromeChecker.isPalindrome(sample1));
        assertFalse(PalindromeChecker.isPalindrome(sample2));
    }
}
