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
        return arr;
    }

    //we calculate the sum then divide by the number of grades
    public int avg() {
        int i, sum = 0;
        for (i = 0; i < n; i++)
            sum += grades[i];
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
        return maximal;
    }

    //returns the minimal value
    public int min() {
        int minimal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] < minimal)
                minimal = arr[i];
        return minimal;
    }

    //we subtract the smallest number to get the maximal sum
    public int max_sum() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum - min();
    }

    //we subtract the greatest number to get the minimal sum
    public int min_sum() {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
        return sum - max();
    }
}

class A3 {

    public int[] sum(int[] nr1, int[] nr2) {
        int l1 = nr1.length;
        int[] sumarr = new int[l1]; //array where we store the answer
        int i = l1 - 1; //index
        int carry = 0, s; //s is the sum of every two digits
        while (i >= 0) { //we go from the last digit to the first
            s = nr1[i] + nr2[i] + carry;
            sumarr[i] = s % 10; //we can only have one digit in a slot
            carry = s / 10; //if the sum had two digits, the carry is now 1 or 0 otherwise
            i--;
        }
        if (carry == 1) //we need to insert 1 at the beginning of the final array
        {
            int[] sumarr2 = new int[l1 + 1]; //create new array, copy the old one and add 1 to the beginning
            for (i = 0; i < l1; i++)
                sumarr2[i + 1] = sumarr[i];
            sumarr2[0] = 1;
            return sumarr2;
        } else
            return sumarr;
    }

    public int[] diff(int[] nr1, int[] nr2) {
        int l1 = nr1.length;
        int[] diffarr = new int[l1];
        int[] temp1;
        int[] temp2;
        //we make sure to subtract the smaller nr from the greater one
        if (Arrays.toString(nr1).compareTo(Arrays.toString(nr2)) > 0) {
            temp1 = nr1;
            temp2 = nr2;
        } else {
            temp1 = nr2;
            temp2 = nr1;
        }

        int i = l1 - 1;
        int carry = 0, s;
        while (i >= 0) {
            s = temp1[i] - temp2[i] - carry;
            //we cannot have negative digits in a number, so we add 10 and subtract 1 from the next digit (carry)
            if (s < 0) {
                s = 10 + s;
                carry = 1;
            } else carry = 0;
            diffarr[i] = s % 10;
            i--;
        }
        //if the carry is 1 at the end, we need to cut a digit from the front
        if (carry == 1) {
            //we create a new array, then copy the digits from the old answer from 2 to n
            int[] diffarr2 = new int[l1 - 1];
            for (i = l1 - 1; i > 0; i--)
                diffarr2[i - 1] = diffarr[i];
            return diffarr2;
        } else return diffarr;
    }

    public int[] mul(int[] nr, int x) {
        int l1 = nr.length;
        int[] mularr = new int[l1];
        int i = nr.length - 1; //index
        int carry = 0, s;
        while (i >= 0) { //we go from the last digit to the first
            s = nr[i] * x + carry;
            mularr[i] = s % 10; //we can only have one digit in a slot
            carry = s / 10; //if the sum had two digits, the carry is now the first or 0 otherwise
            i--;
        }
        if (carry > 0) {
            //we create a new array, then add a new digit in front
            int[] mularr2 = new int[l1 - 1];
            for (i = 0; i < l1; i++)
                mularr2[i + 1] = mularr[i];
            mularr2[0] = carry;
            return mularr2;
        } else return mularr;
    }

    public int[] div(int[] nr, int x) {
        int l1 = nr.length, i = 0, r = 0;
        int[] divarr = new int[l1];
        //r is the remainder, the operation is done just like on paper
        while (i < l1 - 1) {
            divarr[i] = (r * 10 + nr[i]) / x;
            r = nr[i] % x;
            i++;
        }
        //if the array starts with 0 we create a new one with one less digit
        if (divarr[0] == 0) {
            int[] divarr2 = new int[l1 - 1];
            for (i = l1 - 1; i > 0; i--)
                divarr2[i - 1] = divarr[i];
            return divarr2;
        }
        return divarr;
    }

}

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
        return max;
    }

    public int budget_usb(int x) {
        int max = 0;
        for (int j : usb)
            if (j > max && j <= x)
                max = j;
        return max;
    }

    public int budget_item(int x) {
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