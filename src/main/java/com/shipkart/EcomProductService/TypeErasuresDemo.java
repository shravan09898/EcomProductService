package com.shipkart.EcomProductService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TypeErasuresDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(10);
        arrayList.add(14);

        System.out.println("List Type : "+arrayList.getClass().getName());

        Set<String> set = new HashSet<>();
        set.add("Arun");
        set.add("Shravan");

        System.out.println("Set Type : " +set.getClass().getName());
    }
}
