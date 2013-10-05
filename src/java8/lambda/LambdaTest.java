package java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LambdaTest {
    
    static Random r = new Random();

    class Person {
        int age;
        String name;
        public int getAge() {
            return age;
        }
    }
    
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        int age = Integer.valueOf(args[0]);
        people.removeIf(e -> e.getAge() < age);
    }
}
