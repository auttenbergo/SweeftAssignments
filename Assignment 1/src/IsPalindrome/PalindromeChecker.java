package IsPalindrome;

public class PalindromeChecker {

    public static boolean isPalindrome(String text){
        for(int i=0; i<text.length() / 2; i++){
            int symmetricIndex = text.length() - 1 - i;
            if(text.charAt(i) != text.charAt(symmetricIndex))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String sample = "palindrome";
        System.out.println(isPalindrome(sample));
    }
}
