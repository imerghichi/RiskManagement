package com.management.risk.models.Analysis.MonteCarlo;


import com.management.risk.models.Identification.Activity;

import java.util.List;
import java.util.Random;

public class MonteCarlo {
    private int iteration;
    private List<Activity> tasks;
    private Random random = new Random();

    public void  simulate(){
        double timer = 0;
        for (int i = 0 ; i < this.iteration ; i++){
            for (Activity task:
                 this.tasks) {
                timer = random.nextGaussian();
            }
        }

    }
}
