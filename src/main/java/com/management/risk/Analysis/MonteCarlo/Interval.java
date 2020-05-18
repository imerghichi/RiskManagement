package com.management.risk.Analysis.MonteCarlo;

public class Interval {
    private Double end;
    private Double start;
    private int height;

    public Interval(double end, double start) {
        this.end = end;
        this.start = start;
        this.height = 0;
    }

    public void incremente_height(){
        height++;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
