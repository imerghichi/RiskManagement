package com.management.risk.Analysis.MonteCarlo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Histogram {
    private final List<Double> durations;
    private final int numInterval;
    private List<Interval> intervals;

    public Histogram(List<Double> durations, int numInterval) {
        this.durations = durations;
        this.numInterval = numInterval;
    }

    public List<Double> getDurations() {
        return durations;
    }

    public Interval getInterval (int interval){
        return getIntervals().get(interval);
    }

    public int getNumInterval() {
        return numInterval;
    }

    public List<Interval> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Interval> intervals) {
        this.intervals = intervals;
    }
    private List<Interval> calcIntervals() {
        List<Interval> intervals = new ArrayList<Interval>(numInterval);

        // Gets collection max an min
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double n : durations) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        initIntervals(intervals, min, max);

        for (Double d : durations) {
            boolean found = false;
            final Iterator<Interval> iterator = intervals.iterator();
            while (iterator.hasNext() && !found) {
                final Interval interval = iterator.next();
                final int startCmp = interval.getStart().compareTo(d);
                final int endCmp = interval.getEnd().compareTo(d);
                if ((startCmp == 0 || startCmp < 0) && (endCmp == 0 || endCmp > 0)) {
                    found = true;
                    interval.incremente_height();
                }
            }

            if (!found)
                throw new RuntimeException("Histogram interval not found for value " + d);
        }


        return intervals;
    }
    private void initIntervals(List<Interval> intervals, double min, double max) {
        double intervalStart = min;
        double intervalEnd;
        double width = (max - min) / numInterval;
        for (int i = 0; i < numInterval; i++) {
            intervalEnd = getIntervalEnd(max, intervalStart, width, i);
            intervals.add(new Interval(intervalStart, intervalEnd));
            intervalStart = intervalEnd;
        }
    }

    private double getIntervalEnd(double max, double intervalStart, double width, int i) {
        if (i != (numInterval - 1))
            return intervalStart + width;
        else
            return max;

    }

}
