/*
 *  ALDS1_15_B: Fractional Knapsack Problem
 *  URL: https://onlinejudge.u-aizu.ac.jp/courses/lesson/1/ALDS1/all/ALDS1_15_B
 */

package ALDS1.ALDS1_15.ALDS1_15_C;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double W = sc.nextInt();

        Item[] items = new Item[N];
        for(int i = 0; i < N; i++){
            int value = sc.nextInt();
            int weight = sc.nextInt();

            items[i] = new Item(value, weight);
        }

        Arrays.sort(items);

        double result = 0;
        for(int i = 0; i < N && W > 0 ; i++){
            double w1 = Math.min(items[i].weight, W);
            result += w1 * items[i].valuePerWeight;
            W -= w1;
        }

        System.out.printf("%.8f\n", result);
    }

}

class Item implements Comparable<Item>{
    int value;
    int weight;
    double valuePerWeight;

    Item(int v, int w){
        value = v;
        weight = w;
        valuePerWeight = (double)value/weight;
    }

    @Override
    public int compareTo(Item item1) {
        if(this.valuePerWeight < item1.valuePerWeight){
            return 1;
        }
        else if(this.valuePerWeight > item1.valuePerWeight){
            return -1;
        }
        else {
            return 0;
        }
    }

}
