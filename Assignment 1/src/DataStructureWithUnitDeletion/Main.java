package DataStructureWithUnitDeletion;

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for(int i=1; i<= 10; i++){
            stack.push(i);
        }
        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
