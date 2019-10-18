package programs.hackerank;

public class FibonacciSeries {

    public static void main(String[] args){

        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        int value = fibonacciSeries.fib(9);
        System.out.println(value);

    }

    private int fib(int n){
        if ( n == 0 )
            return 0;
        else if ( n == 1 )
            return 1;
        return (fib(n-1)+ fib(n-2));
    }
}
