package misc.leetcode;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.nio.charset.StandardCharsets;
        import java.util.*;

public class WeightedMovingAverage {
    // Use this function when printing output
    public static void printKeyAndWMA(int key, double weightedMovingAverage)
    {
        System.out.printf("%d: %.2f\n", key, weightedMovingAverage);
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        Map<Integer, Double> keyAndAverage = new HashMap<>();
        Map<Integer, Integer> keyAndQuantity = new HashMap<>();
        ArrayList<Integer> seqNos = new ArrayList<>();

        while ((line = in.readLine()) != null) {
            // System.out.println(line);
            String[] trades = line.split(";");

            for(String trade : trades){
                String[] params = trade.split(",");

                Integer key = Integer.parseInt(params[0]);
                double value = Double.parseDouble(params[1]);  //v
                int quantity = Integer.parseInt(params[2]);    //q
                int sequenceNo = Integer.parseInt(params[3]);
                //If the sequence number for any trade is less than the sequence number for any previous trade, throw out T.
                //Do not print anything for T or factor it into your WMA.
                if(seqNos.size()!=0 && sequenceNo<seqNos.get(seqNos.size()-1)){
                    continue;
                }
                seqNos.add(sequenceNo);

                double average = keyAndAverage.getOrDefault(key, 0.0);  //M = weighted moving average
                int totalQuantity = keyAndQuantity.getOrDefault(key, 0);

                double newAverage = ( (average*totalQuantity)+(value*quantity) )
                        /(totalQuantity+quantity);

                keyAndAverage.put(key, newAverage);
                keyAndQuantity.put(key, totalQuantity+quantity);

                printKeyAndWMA(key, newAverage);
            }

        }
    }
}