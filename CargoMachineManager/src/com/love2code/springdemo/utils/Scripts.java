package com.love2code.springdemo.utils;

import com.love2code.springdemo.entity.CargoMachine;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Scripts {

    public static void addCapacityMap(Collection<CargoMachine> machines) {
        for (CargoMachine machine : machines) {
            if (machine.getName().equals("Liebherr 1050")) {

                NavigableMap<BigDecimal, NavigableMap<BigDecimal, BigDecimal>> result = new TreeMap<>();
                NavigableMap<BigDecimal, BigDecimal> angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(16.8));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(24.5));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(34.0));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(50.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(50.0));
                result.put(BigDecimal.valueOf(11.4), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(10.0));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(10.0));
                angeleMass.put(BigDecimal.valueOf(24.0), BigDecimal.valueOf(11.0));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(15.5));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(24.7));
                angeleMass.put(BigDecimal.valueOf(65.0), BigDecimal.valueOf(26.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(26.0));

                result.put(BigDecimal.valueOf(16.7), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(5.2));
                angeleMass.put(BigDecimal.valueOf(6.0), BigDecimal.valueOf(5.2));
                angeleMass.put(BigDecimal.valueOf(20.0), BigDecimal.valueOf(6.3));
                angeleMass.put(BigDecimal.valueOf(32.0), BigDecimal.valueOf(7.8));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(10.1));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(15.6));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(22.7));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(24.6));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(24.6));

                result.put(BigDecimal.valueOf(22.0), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(3.0));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(3.6));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(5.3));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(6.4));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(7.8));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(11.6));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(15.3));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(17.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(17.0));

                result.put(BigDecimal.valueOf(27.0), angeleMass);

            } else if (machine.getName().equals("Liebherr 1120")) {

                NavigableMap<BigDecimal, NavigableMap<BigDecimal, BigDecimal>> result = new TreeMap<>();
                NavigableMap<BigDecimal, BigDecimal> angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(24.8));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(29.1));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(36.5));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(48.0));
                angeleMass.put(BigDecimal.valueOf(65.0), BigDecimal.valueOf(66.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(92.0));

                result.put(BigDecimal.valueOf(12.6), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(15.9));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(15.9));
                angeleMass.put(BigDecimal.valueOf(24.0), BigDecimal.valueOf(18.3));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(28.5));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(47.7));
                angeleMass.put(BigDecimal.valueOf(65.0), BigDecimal.valueOf(62.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(81.0));

                result.put(BigDecimal.valueOf(16.6), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(9.2));
                angeleMass.put(BigDecimal.valueOf(6.0), BigDecimal.valueOf(9.3));
                angeleMass.put(BigDecimal.valueOf(20.0), BigDecimal.valueOf(10.7));
                angeleMass.put(BigDecimal.valueOf(32.0), BigDecimal.valueOf(13.8));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(18.4));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(27.8));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(40.0));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(51.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(51.0));

                result.put(BigDecimal.valueOf(24.5), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(5.5));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(5.5));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(6.3));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(8.0));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(10.4));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(14.2));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(19.1));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(24.5));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(32.0));

                result.put(BigDecimal.valueOf(32.5), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(4.2));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(4.8));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(5.6));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(7.4));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(9.9));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(12.2));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(15.1));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(18.7));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(20.1));

                result.put(BigDecimal.valueOf(40.5), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(1.2));
                angeleMass.put(BigDecimal.valueOf(5.0), BigDecimal.valueOf(2.0));
                angeleMass.put(BigDecimal.valueOf(10.0), BigDecimal.valueOf(2.7));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(3.5));
                angeleMass.put(BigDecimal.valueOf(25.0), BigDecimal.valueOf(4.5));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(5.8));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(6.7));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(7.7));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(8.9));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(10.3));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(11.8));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(12.6));

                result.put(BigDecimal.valueOf(56.0), angeleMass);

            } else {
                // Liebherr 1250
                NavigableMap<BigDecimal, NavigableMap<BigDecimal, BigDecimal>> result = new TreeMap<>();
                NavigableMap<BigDecimal, BigDecimal> angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(63.0));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(63.1));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(102.5));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(157.0));
                angeleMass.put(BigDecimal.valueOf(65.0), BigDecimal.valueOf(250.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(250.0));

                result.put(BigDecimal.valueOf(15.5), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(25.8));
                angeleMass.put(BigDecimal.valueOf(24.0), BigDecimal.valueOf(25.8));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(49.5));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(69.0));
                angeleMass.put(BigDecimal.valueOf(65.0), BigDecimal.valueOf(96.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(135.0));

                result.put(BigDecimal.valueOf(20.7), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(32.5));
                angeleMass.put(BigDecimal.valueOf(20.0), BigDecimal.valueOf(32.5));
                angeleMass.put(BigDecimal.valueOf(32.0), BigDecimal.valueOf(37.5));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(49.4));
                angeleMass.put(BigDecimal.valueOf(50.0), BigDecimal.valueOf(69.8));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(92.0));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(117.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(117.0));

                result.put(BigDecimal.valueOf(25.9), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(21.5));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(21.5));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(25.7));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(31.0));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(38.4));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(46.5));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(58.0));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(69.5));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(71.0));

                result.put(BigDecimal.valueOf(36.3), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(6.3));
                angeleMass.put(BigDecimal.valueOf(10.0), BigDecimal.valueOf(15.4));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(16.8));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(18.7));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(20.0));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(22.4));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(25.2));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(29.9));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(37.0));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(43.0));

                result.put(BigDecimal.valueOf(46.7), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(6.1));
                angeleMass.put(BigDecimal.valueOf(5.0), BigDecimal.valueOf(6.7));
                angeleMass.put(BigDecimal.valueOf(10.0), BigDecimal.valueOf(7.4));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(8.1));
                angeleMass.put(BigDecimal.valueOf(25.0), BigDecimal.valueOf(9.0));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(10.2));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(11.7));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(13.4));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(15.4));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(17.7));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(19.9));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(20.7));

                result.put(BigDecimal.valueOf(62.3), angeleMass);

                angeleMass = new TreeMap<>();
                angeleMass.put(BigDecimal.valueOf(0.0), BigDecimal.valueOf(4.0));
                angeleMass.put(BigDecimal.valueOf(5.0), BigDecimal.valueOf(4.3));
                angeleMass.put(BigDecimal.valueOf(10.0), BigDecimal.valueOf(5.0));
                angeleMass.put(BigDecimal.valueOf(15.0), BigDecimal.valueOf(5.7));
                angeleMass.put(BigDecimal.valueOf(25.0), BigDecimal.valueOf(6.4));
                angeleMass.put(BigDecimal.valueOf(35.0), BigDecimal.valueOf(7.4));
                angeleMass.put(BigDecimal.valueOf(40.0), BigDecimal.valueOf(8.5));
                angeleMass.put(BigDecimal.valueOf(45.0), BigDecimal.valueOf(9.7));
                angeleMass.put(BigDecimal.valueOf(55.0), BigDecimal.valueOf(11.0));
                angeleMass.put(BigDecimal.valueOf(60.0), BigDecimal.valueOf(12.4));
                angeleMass.put(BigDecimal.valueOf(70.0), BigDecimal.valueOf(13.5));
                angeleMass.put(BigDecimal.valueOf(82.0), BigDecimal.valueOf(14.0));

                result.put(BigDecimal.valueOf(72.0), angeleMass);
            }
        }
    }
}
