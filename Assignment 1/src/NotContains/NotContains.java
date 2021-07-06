package NotContains;

import java.util.Arrays;

public class NotContains {


    public static int notContains(int[] array){
        array = Arrays.stream(array).filter(x -> (x > 0)).toArray();
        Arrays.sort(array);
        if(array.length == 0)
            return 1;

        int lowerBound = 0;
        for (int current : array) {
            if(current - 1 != lowerBound)
                return lowerBound+1;
            else
                lowerBound = current;

        }
        return array[array.length-1] + 1;
    }

    public static void main(String[] args) {
        int[] array = {-1,0,-2,1};
        System.out.println(notContains(array));
    }
}
