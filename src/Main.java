import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите целое число для 1-ой задачи:");
        int number1 = sc1.nextInt();
        Predicate<Integer> chekNumber1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer a) {
                if (a > 0) {
                    return true;
                }
                return false;
            }
        };

        Predicate<Integer> chekNumber2 = a -> {
            if (a > 0) {
                return true;
            }
            return false;
        };

        System.out.println(chekNumber1.test(number1));
        System.out.println(chekNumber2.test(number1));
        System.out.println("---------------------------------");

        Scanner sc2 = new Scanner(System.in);
        System.out.println("Введите имя для 2-й задачи:");
        String name = sc2.nextLine();

        Consumer<String> helloMan1 = new Consumer<String>() {
            @Override
            public void accept(String s) {

                System.out.println("Приветствую! " + s);

            }
        };

        Consumer<String> helloMan2 = i -> System.out.println("Приветствую! " + i);

        helloMan1.accept(name);
        helloMan2.accept(name);
        System.out.println("---------------------------------");

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Введите число типа Double для 3-й задачи:");
        double number2 = sc3.nextDouble();

        Function<Double, Long> transformNumber1 = aDouble -> Math.round(aDouble);
        Function<Double, Long> transformNumber2 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        System.out.println(transformNumber1.apply(number2));
        System.out.println(transformNumber2.apply(number2));
        System.out.println("---------------------------------");

        Supplier supplier1 = new Supplier() {
            @Override
            public Object get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };

        Supplier supplier2 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };

        System.out.println("Рандомные числа");
        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
        System.out.println("---------------------------------");

        String a = "ДлинноеСлово";
        String b = "КороткоеСлово";
        int aLength = a.length();
        int bLength = b.length();

        Predicate<Object> condition = p -> aLength > bLength;
        Function<Object, Integer> ifTrue = s -> 3;
        Function<Object, Integer> ifFalse = s -> 1;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply(a));


    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }
}