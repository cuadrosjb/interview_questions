package com.jcuadros.c2;

import java.util.Arrays;
import java.util.List;

class Rope {
    static List<Integer> NominialValues = Arrays.asList(1, 2, 3, 4);

    public static void main(String args[]){
        System.out.println(my_func(2));
        System.out.println(my_func(3));
        System.out.println(my_func(4));
        System.out.println(my_func(5));
        System.out.println(my_func(10));
    }


    public static Integer my_func(int ropeSize){
        //Get edge cases
        if(ropeSize < 0){
            return null;
        } else if (ropeSize == 0 ){
            return 0;
        } else if (ropeSize < 5 ){
            return ropeSize;
        } else {
            return reducer(ropeSize);
        }
    }

    public static int reducer(int ropeSize){

        int remainder = ropeSize/2;
        int complement = ropeSize - remainder;

        if (!NominialValues.contains(complement) && !NominialValues.contains(remainder)) {
            return reducer(complement) * reducer(remainder);
        } else if (NominialValues.contains(complement) && !NominialValues.contains(remainder)) {
            return complement * reducer(remainder);
        } else if (!NominialValues.contains(complement) && NominialValues.contains(remainder)) {
            return remainder * reducer(complement);
        }

        return complement * remainder;

    }


}
