package MinSplit;

public class MinSplit {

    public static int coins[] = {1, 5, 10, 20, 50};

    public static int minSplit(int amount){
        if (amount < 0)
            throw new IllegalArgumentException("Amount must be non negative integer");

        int quantity = 0;
        for(int i = coins.length - 1; i >= 0; i --){
            int coin = coins[i];
            if(coin > amount)
                continue;

            int coinQuantity = amount / coin;
            quantity += coinQuantity;
            amount -= (coinQuantity * coin);
        }
        return quantity;
    }

    public static void main(String[] args) {
        int amount = 0;
        System.out.println(minSplit(amount));
    }
}
