package org.example;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int count = 0;
        for (Integer value : numbers){
            count += value;
        }
        System.out.println(count);
    }
}
