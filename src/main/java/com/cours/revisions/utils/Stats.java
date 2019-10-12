package com.cours.revisions.utils;

import java.util.List;

public class Stats {
    public static Double getMean(List<Double> values){
        return  values.stream().reduce(0.0, (a, b) -> a + b)/values.size();
    }
    public static Double getStandardDeviaion(List<Double> values){
        return getStandardDeviation(values, getMean(values));
    }
    public static Double getStandardDeviation(List<Double> values, Double mean) {
    Double standardDeviation = 0.0;
    for(double value: values){ standardDeviation += Math.pow(value - mean, 2); }
    return Math.sqrt(standardDeviation/values.size());
    }
}
