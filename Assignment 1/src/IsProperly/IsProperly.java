package IsProperly;

import java.util.Stack;

public class IsProperly {

    public static boolean isOpeningPair(char c){
        return c == '(' || c == '{' || c == '[';
    }
    public static boolean isClosingPair(char c){
        return c == ')' || c == '}' || c == ']';
    }

    public static boolean doPairsMatch(char c1, char c2){
        if(c1 == '(' && c2 == ')') return true;
        if(c1 == '{' && c2 == '}') return true;
        if(c1 == '[' && c2 == ']') return true;
        return false;
    }

    public static boolean isProperly(String sequence){
        Stack<Character> openingPairs = new Stack<>();
        for(int i=0; i<sequence.length(); i++){
            char currentChar = sequence.charAt(i);

            if(isOpeningPair(currentChar))
                openingPairs.push( currentChar );

            if(isClosingPair(currentChar)){
                if(openingPairs.size() == 0)
                    return false;

                Character openingPair = openingPairs.peek();
                openingPairs.pop();

                if(!doPairsMatch(openingPair,currentChar))
                    return false;

            }
        }
        return openingPairs.isEmpty();
    }

    public static void main(String[] args) {
        String sample1 = "(({{[[()]]}}))";
        String sample2 = "(({{[[()}]}}))";
        System.out.println(isProperly(sample1));
        System.out.println(isProperly(sample2));
    }
}
