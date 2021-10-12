package com.company;

class A4 {
    private final int[] keyboard;
    private final int[] usb;

    public A4(int[] key, int[] u) {
        keyboard = key;
        usb = u;
    }

    public int cheap() {
        int minimal = Integer.MAX_VALUE;
        for (int j : keyboard)
            if (j < minimal)
                minimal = j;
        System.out.println("Billigste Tastatur:");
        return minimal;
    }

    public int expensive() {
        int max = 0;
        for (int j : keyboard)
            if (j > max)
                max = j;
        for (int i : usb)
            if (i > max)
                max = i;
        System.out.println("Teuerster Gegenstand:");
        return max;
    }

    public int budget_usb(int x) {
        int max = 0;
        for (int j : usb)
            if (j > max && j <= x)
                max = j;
        System.out.println("USB mit Budget:");
        return max;
    }

    public int budget_item(int x) {
        System.out.println("Setup with Budget:");
        int i, j, k = 0, l1 = keyboard.length, l2 = usb.length, max = 0;
        int[] temp = new int[l1 * l2];
        //we create an array with all the possible pairs of keyboards and usbs
        for (i = 0; i < l1; i++)
            for (j = 0; j < l2; j++)
                temp[k++] = keyboard[i] + usb[j];
        //we then check which pair is the most expensive pair
        for (int val : temp)
            if (val > max && val <= x)
                max = val;
        if (max > 0)
            return max;
        else return -1;
    }
}