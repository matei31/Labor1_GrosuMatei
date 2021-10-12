package com.company;

import java.util.Arrays;

class A3 {

    public int[] sum(int[] nr1, int[] nr2) {
        System.out.println("Summe:");
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
        System.out.println("Differenz:");
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
        System.out.println("Multiplikation:");
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
        System.out.println("Division:");
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