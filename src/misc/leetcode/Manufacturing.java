package misc.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;

public class Manufacturing {
    private static DecimalFormat formatter = new DecimalFormat("0.00");

    public static class Product
    {
        public Product(String productName, Double priceToPurchase, HashSet<String> inputProducts)
        {
            ProductName = productName;
            PriceToPurchase = priceToPurchase;
            InputProducts = inputProducts;
        }

        public String ProductName;
        public Double PriceToPurchase;
        public HashSet<String> InputProducts;

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;

            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            Product product = (Product) obj;

            return (product.ProductName == this.ProductName);
        }

        @Override
        public int hashCode()
        {
            return this.ProductName.hashCode();
        }
    }

    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException
    {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        String targetProductName = "";
        HashSet<Product> allProducts = new HashSet<Product>();
        Boolean isFirstLine = true;
        while ((line = in.readLine()) != null) {
            if (isFirstLine)
            {
                targetProductName = line;
                isFirstLine = false;
                continue;
            }

            String[] lineSplit = line.split(",");
            allProducts.add(new Product(lineSplit[0], lineSplit[1].equals("null") ? null : Double.parseDouble(lineSplit[1]),
                    lineSplit.length == 3 ? new HashSet<String>() : new HashSet<String>(Arrays.asList(lineSplit[3].split(";")))));
        }
        System.out.println(formatter.format(mySolution(targetProductName, allProducts)));
    }

    static Double mySolution(String targetProductName, HashSet<Product> allProducts)
    {
        // ADD IMPLEMENTATION HERE
        HashMap<String, Double> minCosts = new HashMap<>();
        HashMap<String, Product> allProductMap = new HashMap<>();
        for (Product p : allProducts){
            allProductMap.put(p.ProductName, p);
        }

        return calculateMinCost(targetProductName, allProductMap, minCosts);
    }

    static Double calculateMinCost(String productName, HashMap<String, Product> productMap, HashMap<String, Double> minCosts){
        if(minCosts.containsKey(productName)){
            return minCosts.get(productName);
        }

        Product product = productMap.get(productName);
        double minCost = 61;  //Double.MAX_VALUE;

        if(product.PriceToPurchase != null){
            minCost = product.PriceToPurchase;
        }

        if(product.InputProducts.isEmpty()){
            double buildCost = 0;
            for(String input : product.InputProducts){
                System.out.println(input +"- $"+ buildCost);
                buildCost += calculateMinCost(input, productMap, minCosts);
            }
            minCost = Math.min(minCost, buildCost);
        }

        if(minCost!=Double.MAX_VALUE){
            minCosts.put(productName, minCost);
        }
        return minCost;
    }
}
