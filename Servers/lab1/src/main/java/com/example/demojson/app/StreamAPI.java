package com.example.demojson.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demojson.bean.Student;

public class StreamAPI {
    static List<Student> list = Arrays.asList(
            new Student("jack1", true, 10d),
            new Student("jack2", true, 3d),
            new Student("jack3", false, 7d),
            new Student("jack4", true, 4d),
            new Student("jack5", false, 9d));

    public static void main(String[] args) {
        // demo1();
        // demo2();
        // demo3();
        demo4();
    }

    private static void demo4() {
        double average = list.stream()
                .mapToDouble(n -> n.getMarks())
                .average().getAsDouble();
        System.out.println("Average: " + average);

        double sum = list.stream()
                .mapToDouble(n -> n.getMarks()).sum();
        System.out.println("Sum: " + sum);

        double minMark = list.stream()
                .mapToDouble(n -> n.getMarks())
                .min().getAsDouble();
        System.out.println("Min Mark: " + minMark);

        boolean allPassed = list.stream().allMatch(sv -> sv.getMarks() >= 5);
        System.out.println("All passed: " + allPassed);

        Student minSv = list.stream().reduce(list.get(0), (min, sv) -> sv.getMarks() < min.getMarks() ? sv : min);
        System.out.println("Min sv: " + minSv.toString());
    }

    private static void demo3() {
        List<Student> res = list.stream()
                .filter(sv -> sv.getMarks() >= 7)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void demo2() {
        List<Integer> list = Arrays.asList(1, 2, 5, 3, 56, 2);
        List<Double> res = list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> Math.sqrt(n))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    private static void demo1() {
        Stream<Integer> stream1 = Stream.of(8, 5, 3, 5, 9, 5, 1, 0);
        stream1.forEach(n -> {
            System.out.println(n);
        });

        List<Integer> list = Arrays.asList(1, 6, 2, 5, 7, 8);
        list.stream().forEach(n -> {
            System.out.println(n);
        });
    }

}
