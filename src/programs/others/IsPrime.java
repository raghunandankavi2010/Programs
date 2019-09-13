package programs.others;

public class IsPrime {

    public static void main(String[] args) {

        System.out.println(" Number is prime or not "+isPrime(15));

    }

    static boolean isPrime(int num){
        for(int i=2;i<=(num/2);i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;
    }
}
