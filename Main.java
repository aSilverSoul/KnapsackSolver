import java.util.Scanner;
import java.util.*;
public class Main {
    static int numberVal;
    static int weightThresValue = 0;
    static String VariaObj[] = new String[100];
    static Main knapObj = new Main();
    static Scanner inps = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the max weight to hold: ");
        weightThresValue = inps.nextInt();
        System.out.print("Enter number of objects to consider ");
        numberVal = inps.nextInt();
        int weightArray[] = new int[numberVal + 1];
        int costArray[] = new int[numberVal + 1];
        System.out.println("Enter the variables one at time: ");
        for (int i = 0; i < numberVal; i++) {
            VariaObj[i] = inps.next();
        }
        for (int i = 0; i < numberVal; i++) {
            System.out.print("Enter weight value of the object " + VariaObj[i] + ": ");
            weightArray[i] = inps.nextInt();
        }
        for (int i = 0; i < numberVal; i++) {
            System.out.print("Enter cost value of object " + VariaObj[i] + ": ");
            costArray[i] = inps.nextInt();
        }
        knapObj.combinationChecker(VariaObj, weightArray, costArray, weightThresValue, numberVal);

        System.out.println("----------------------------------------------------------------");
       btknapsack obj = new btknapsack(numberVal,weightThresValue,weightArray,costArray);
        obj.knapsack();
        System.out.println("----------------------------------------------------------------");

        List<Item> itemArr = new ArrayList<Item>(numberVal);
        for(int i=0;i<numberVal;i++)
        {
            itemArr.add(new Item(i, costArray[i], weightArray[i]));
        }
        bnbKnapsack sack=new bnbKnapsack(itemArr,numberVal);
        System.out.println(sack.solve());


    }

    public void combinationChecker(String VariaObj[], int costArray[], int weightArray[], int weightThresValue, int numberVal) {
        int weightVal = 0;
        int costVal = 0;
        int optWeightVal = 0;
        int optCostVal = 0;
        String optimalVarValue = "";
        String newVarVal = "";
        for (int i = 1; i < (1 << numberVal); i++) {
            String newVar = Integer.toBinaryString(i);
            for (int j = newVar.length() - 1, k = numberVal - 1; j >= 0; j--, k--) {
                if (newVar.charAt(j) == '1') {
                    newVarVal = VariaObj[k];
                    weightVal += weightArray[k];
                    costVal += costArray[k];
                    System.out.print(newVarVal);
                }
            }
            System.out.println("\t" + weightVal + "\t" + costVal);
            if (weightVal <= weightThresValue) {
                if (optWeightVal == 0 && optCostVal == 0) {
                    optWeightVal = weightVal;
                    optCostVal = costVal;
                } else if (optWeightVal <= weightVal) {

                    optimalVarValue = newVarVal;
                    optWeightVal = weightVal;
                    optCostVal = costVal;

                }
            }
            weightVal = 0;
            costVal = 0;
        }
        System.out.println("OPTIMAL SOLUTION FOR KNAPSACK(BRUTE FORCE): " + optimalVarValue + " with total profit of " + optWeightVal + " and total weight of " + optCostVal + ".");
    }

    }
