package com.ddh.jdk8.functioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        GreetingService greetingService1 = message -> System.out.println("Hello" + message);
        greetingService1.sayMessage("World");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //如果存在则返回
        eval(list,n->true);
        // 如果 n%2 为 0 test 方法返回 true

        eval(list,n->n%2==0);

        //输出大于三的数

        System.out.println(
                eval(list,n->n>3));

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filterd =
                strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());

        System.out.println(filterd);
        new Random().ints().limit(10).forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        System.out.println(numbers.stream().map(i->i*i).distinct().collect(Collectors.toList()));

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));

        System.out.println(mergedString);

    }

    public static List<Integer> eval(List<Integer> list, Predicate<Integer> predicate)
    {
        List<Integer> lists  = new ArrayList<>();
        for (Integer n: list)
        {
            if (predicate.test(n)){
                lists.add(n);
            }
        }
        return lists;
    }
}
