package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();
        IntArrayList list = new IntArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100) + 1);
        }
        System.out.println(Arrays.toString(list.toArray()));
        list.add(5,100000000);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(3);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.get(5));
        System.out.println(list.size());
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.isEmpty());
       for(int i = 0; i < 10; i++){
           list.add(r.nextInt(100) + 1);
       }
        System.out.println(Arrays.toString(list.toArray()));
        IntList sublist = list.subList(5, 10);
        System.out.println(Arrays.toString(list.toArray()));


    }
}
