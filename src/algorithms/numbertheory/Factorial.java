package algorithms.numbertheory;

public class Factorial {
    public static int factorial (int n) {
//        System.out.println(n);
//        if(n<0){
//            throw new RuntimeException();
////            return 0;
//        }
//        if(n<=1){
//            return n;
//        }
//        return (n*factorial(n-1));
        int ans = n;
        while(n>1){
            ans = ans*(n-1);
            n--;
        }
        return ans;
    }

    public static void main(String args[]){
        int n=5;
//        n=10000000;
//        n=02;
//        n=55;
//        n=0;
//        n=-5;
        try{
            if(n<0){
                System.out.println("n is a negative value");
            } else {
                System.out.println(factorial(n));
            }
        }
        catch(StackOverflowError e){
            System.out.println(e);
        }
    }
}


//class HelloWorld {
//    public static void main(String args[]) {
//        System.out.println("Hello world - Java!");
//    }
//}