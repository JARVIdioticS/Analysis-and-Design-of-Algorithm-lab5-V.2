import java.util.Scanner;
import java.util.Arrays;

public class knapsack {

    private static void knapsackSort(int amount, double[] value, double[] weight, double sackCap)
    {
        double[] valueByWeight = new double[amount];
        for(int i = 0; i < amount; i++){
            valueByWeight[i] = value[i] / weight[i];
        }
        
        //System.out.println("\n" + Arrays.toString(valueByWeight));
        double total = 0;
        for (int i = 0; i < amount - 1; i++) {
            for (int j = i + 1; j < amount; j++) {
                if (valueByWeight[i] < valueByWeight[j]) {
                    swap(value, i, j);
                    swap(weight, i, j);
                    swap(valueByWeight, i, j);
                }
            }
            
            //put in bag
            if (sackCap <= weight[i])
            {
                total += value[i] * sackCap / weight[i];
                System.out.printf("\n%-15s %-15s %-15s %-15s\n", "Order", "Value", "Weight", "Quantity");
                for (int n = 0; n < i ; n++)
                {
                    System.out.printf("%-15d %-15.2f %-15.2f %-15s\n", n+1, value[n], weight[n], "1");
                }
                System.out.printf("%-15d %-15.2f %-15.2f %-15s\n", i+1, value[i], weight[i], sackCap + "/" + weight[i]);
                System.out.println("Total value is " + total);
                return;
            }
            sackCap -= weight[i];
            total += value[i];
        }
        //System.out.println("\n" + Arrays.toString(valueByWeight) + "\n" + total);
    }
    private static void swap(double[] arr, int i, int j)
    {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int amount = sc.nextInt();

        double[] value = new double[amount];
        double[] weight = new double[amount];

        System.out.print("\nEnter the value of each item: ");
        for(int i = 0; i < amount; i++){
            value[i] = sc.nextDouble();
        }
        
        System.out.print("\nEnter the weight of each item: ");
        for(int i = 0; i < amount; i++){
            weight[i] = sc.nextDouble();
        }

        System.out.print("\nEnter the capacity of the backpack: ");
        double sackCap = sc.nextDouble();
        sc.close();

        knapsackSort(amount, value, weight , sackCap);
    }
    
}