package com.management.risk.services.Interfaces;

import com.management.risk.models.Identification.Risk;

import java.util.ArrayList;
import java.util.List;

public interface RiskMatrixServiceI {
    List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks);
    List<ArrayList<ArrayList<Risk>>> getMatrix(int probability_interval_division, ArrayList<Risk> risks, int capacity);
    List<ArrayList<ArrayList<Risk>>> getMatrix(ArrayList<Risk> risks);
}
