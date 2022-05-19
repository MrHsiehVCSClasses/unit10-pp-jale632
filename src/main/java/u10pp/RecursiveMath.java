package u10pp;
import java.math.*;

class RecursiveMath
{
    public static double pow(double base, int exponent) {
        if (exponent >= 0) {

            if (exponent == 0 ) {
                return 1;

            } else 
            return pow(base, exponent-1)*base;
        } 
        return 0;
    }

    
    public static BigInteger getFactorial(int n) {
        BigInteger ret = BigInteger.valueOf(n);
        BigInteger one = BigInteger.ONE;

        if (n >= 0) {
            if (n == 0) {
                return one;
            } else 
                return ret.multiply(getFactorial(n-1)); 
        }
        return BigInteger.ZERO;
    }


    public static long getFibonacciNumber(int n)
    {

        long ret = 1;

        // recursion
        if ( n==1 || n==2 )
        {
            ret=1;
        }
        else
        {
            ret=getFibonacciNumber(n-1)+getFibonacciNumber(n-2);
        }

        return ret;
    }

}