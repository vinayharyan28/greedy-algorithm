import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static int fractionalKnapsack(int[] value, int[] weight, int totalBagWeight){

        double[][]  ratio = new double[value.length][2];
        for(int i=0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));


        int capacity = totalBagWeight, finalValue = 0;
        for (int i=ratio.length-1; i>=0; i--){
            int index = (int) ratio[i][0];
            if (capacity >= weight[index]){ // Include full item
                finalValue += value[index];
                capacity -= weight[index];
            }else {
                // Include fractional item
                finalValue += (int) (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        return finalValue;
    }
    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int totalBagWeight = 50;
        System.out.println(fractionalKnapsack(value, weight, totalBagWeight));
    }
}
