package com.example.demojson.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.example.demojson.bean.Student;

public class Lambda {
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
        Demo4Interface demo4Interface = x -> System.out.println(x);

        demo4Interface.m1(2022);
    }

    private static void demo3() {
        Collections.sort(list, (s1, s2) -> -s1.getMarks().compareTo(s2.getMarks()));
        list.forEach(sv -> {
            System.out.println(">>Name: " + sv.getName());
            System.out.println(">>Gender: " + (sv.getGender() ? "Male" : "Female"));
            System.out.println(">>Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    private static void demo2() {
        list.forEach(sv -> {
            System.out.println(">>Name: " + sv.getName());
            System.out.println(">>Gender: " + (sv.getGender() ? "Male" : "Female"));
            System.out.println(">>Marks: " + sv.getMarks());
            System.out.println();
        });
    }

    public static void demo1() {
        List<Integer> list = Arrays.asList(1, 9, 4, 2, 7, 5);
        list.forEach(e -> System.out.println(e));
    }
}

/**
 * InnerLambda
 */
@FunctionalInterface
interface Demo4Interface {
    void m1(int x);

    default void m2() {
    };

    public static void m3() {
    };

}
