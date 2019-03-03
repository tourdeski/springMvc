package com.love2code.testDb;

import com.love2code.springdemo.entity.CapacityItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws Exception {

     /*   Collection<Collection<Integer>> result = new ArrayList<>();
        Collection<Integer> machines = new ArrayList<>();
        machines.add(1);
        machines.add(5);
        machines.add(6);
        int size = machines.size();
        Object[] array = machines.toArray();

        int combinations = (int) Math.pow(2, size);
        for (int i = 1; i < combinations; i++) {
            List<Integer> combo = new ArrayList<>();

            String s = Integer.toBinaryString(i);
            while (s.length() != size) {
                s = 0 + s;
            }
            int arrayIndex = machines.size() - 1;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    combo.add((Integer) array[arrayIndex]);
                }
                arrayIndex--;
            }
            result.add(combo);
        }
        System.out.println(result);*/

        Collection<CapacityItem> items = new ArrayList<>();
        items.add(new CapacityItem(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        items.add(new CapacityItem(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        items.add(new CapacityItem(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        items.add(new CapacityItem(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE));
        System.out.println(items.stream()
                .map(i -> String.format("<map r=\"%s\" angle=\"%s\" mass=\"%s\" />",
                        i.getRadius(), i.getAngle(), i.getMass()))
                .collect(Collectors.joining("\n\r", "<maps>\n\r", "\n\r</maps>")));
    }
}