package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        A1 obj = new A1(new int[]{45, 91, 23, 67, 87, 63, 78, 89, 40});
        System.out.println("Aufgabe1:");
        System.out.println(Arrays.toString(obj.failed()));
        System.out.println(obj.avg());
        System.out.println(Arrays.toString(obj.rounded_gr()));
        System.out.println(obj.max_rounded());

        A2 obj2 = new A2(new int[]{12, 2, 50, 86, 100, 15, 92, 49, 50});
        System.out.println("Aufgabe2:");
        System.out.println(obj2.max());
        System.out.println(obj2.min());
        System.out.println(obj2.max_sum());
        System.out.println(obj2.min_sum());

        A3 obj3 = new A3();
        System.out.println("Aufgabe3:");
        System.out.println(Arrays.toString(obj3.sum(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(obj3.diff(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(obj3.mul(new int[]{2, 3, 6, 0, 0, 0, 0, 0, 0}, 2)));
        System.out.println(Arrays.toString(obj3.div(new int[]{2, 3, 6, 0, 0}, 5)));

        A4 obj4 = new A4(new int[]{40, 35, 70, 15}, new int[]{20, 10, 45, 60});
        System.out.println("Aufgabe4:");
        System.out.println(obj4.cheap());
        System.out.println(obj4.expensive());
        System.out.println(obj4.budget_usb(50));
        System.out.println(obj4.budget_item(100));
    }
}