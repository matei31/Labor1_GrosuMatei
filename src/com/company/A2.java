package com.company;

class A2 {
    private final int[] arr;
    private final int n;

    public A2(int[] array) {
        arr = array;
        n = arr.length;
    }

    //returns the maximal value
    public int max() {
        int maximal = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] > maximal)
                maximal = arr[i];
        System.out.println("Max Zahl:");
        return maximal;
    }

    //returns the minimal value
    public int min() {
        int minimal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] < minimal)
                minimal = arr[i];
        System.out.println("Min Zahl:");
        return minimal;
    }

    //we subtract the smallest number to get the maximal sum
    public int max_sum() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        System.out.println("Max Summe:");
        return sum - min();
    }

    //we subtract the greatest number to get the minimal sum
    public int min_sum() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        System.out.println("Min Summe:");
        return sum - max();
    }
}
