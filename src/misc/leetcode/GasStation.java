package misc.leetcode;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumCost = 0;
        for (int c : cost) {
            sumCost += c;
        }
        int sumGas = 0;
        for (int g : gas) {
            sumGas += g;
        }
        // Check if it is possible to complete the journey
        if (sumCost > sumGas) {
            return -1;
        }

        int currentGas = 0;
        int startingIndex = 0;

        for (int i=0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startingIndex = i+1;
            }
        }
        return startingIndex;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int[] head = {1,2,3,4,5};
//        System.out.println(firstMissingPositive(nums));
//        System.out.println();
        System.out.println(canCompleteCircuit(nums, head));
    }
}