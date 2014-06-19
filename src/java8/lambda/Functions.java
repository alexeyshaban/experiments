package java8.lambda;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class Functions {
    public static void main(String[] args) {
        IntBinaryOperator add = (a, b) -> a + b;
        System.out.println(add.applyAsInt(4, 5));
        
        IntUnaryOperator inc = a -> a + 1;
        System.out.println(inc.applyAsInt(4));
        
        Function<Integer, IntUnaryOperator> addf = a -> b -> a + b;
        System.out.println(addf.apply(9).applyAsInt(2));
        
        Function<IntBinaryOperator, Function<Integer, IntUnaryOperator>> applyf
                = f -> a -> b -> f.applyAsInt(a, b);
        System.out.println(applyf.apply(add).apply(33).applyAsInt(44));
    }
}
