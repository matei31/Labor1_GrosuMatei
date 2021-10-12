package com.company;

import java.util.ArrayList;
import java.util.List;

class A1 {
    private final int[] grades;
    private final int n;

    public A1(int[] gr) {
        grades = gr;
        n = grades.length;
    }


    public int[] failed() {
        int i;
        //we convert to list to use the add method
        List<Integer> temp = new ArrayList<>();
        for (i = 0; i < n; i++)
            if (grades[i] < 40)
                temp.add(grades[i]);
        //conversion back to array
        int[] arr = new int[temp.size()];
        for (i = 0; i < temp.size(); i++) arr[i] = temp.get(i);
        System.out.println("Nicht ausreichende Noten: ");
        return arr;
    }

    //we calculate the sum then divide by the number of grades
    public double avg() {
        int i;
        double sum=0;
        for (i = 0; i < n; i++)
            sum += grades[i];
        System.out.println("Durchschnittswert:");
        return sum / n;
    }

    //the conditions are: number >= 40 and the distance to the next multiple of 5 < 3
    public int round(int x) {
        if (x >= 40 && ((x / 5 + 1) * 5 - x) < 3)
            x = (x / 5 + 1) * 5;
        return x;
    }

    //we use the round method and the same stragegy as the first task (Array -> List -> Array)
    public int[] rounded_gr() {
        int i;
        List<Integer> temp = new ArrayList<>();
        for (i = 0; i < n; i++)
            temp.add(round(grades[i]));
        int[] arr = new int[temp.size()];
        for (i = 0; i < temp.size(); i++) arr[i] = temp.get(i);
        System.out.println("Abgerundete Noten: ");
        return arr;
    }

    //simply returns the maximum of the rounded grades
    public int max_rounded() {
        int[] temp = rounded_gr();
        int max = 0;
        for (int i = 0; i < n; i++)
            if (temp[i] > max)
                max = temp[i];
        return max;
    }
}