package com.management.risk.Analysis.MonteCarlo;



import org.apache.commons.math3.distribution.*;

import java.util.ArrayList;
import java.util.List;

public class MonteCarlo {

        private static final int INTERVALS = 30;

        private int repetitions;

        //activities
        private List<List<Object>> dataActArray;

        private int[][] matrix;

        private int[][] inNodes;

        private ArrayList<ArrayList<Integer>> inNodesArray;

        private int[] inDegree;

        private int[] outDegree;

        private ArrayList<ArrayList<Integer>> topologicalArray;

        int index_topologicalArray = 0;

        private int n;

        private double[] durations;

        private double[] ending;

        private int[] cpnCount;

        private int[] cpnResult;

        private double[] totalDurations;


        public MonteCarlo(int repet, List<List<Object>> actArray) {

            repetitions = repet;
            dataActArray = actArray;

            n = dataActArray.size();

            topologicalArray = new ArrayList<ArrayList<Integer>>();

            inNodesArray = new ArrayList<ArrayList<Integer>>();

            inDegree = new int[n];

            outDegree = new int[n];

            cpnResult = new int[n];

            matrix = new int[n][n];
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    matrix[i][j] = 0;

            int[] temp;
            for(int i=0; i<n; i++) {
                if(((int[])dataActArray.get(i).get(2))[0] != -1) {
                    temp = new int[((int[])dataActArray.get(i).get(2)).length];
                    temp = (int[])dataActArray.get(i).get(2);
                    for(int j=0; j<temp.length; j++) {
                        matrix[temp[j]-1][i] = 1;
                    }
                }
            }
        }

        public int topologicalSort() {

            int occurrences = 0;
            int no_occurrences = 0;
            int result = 0;

            for(int j=0; j<n; j++) {
                for(int i=0; i<n; i++) {
                    if(matrix[i][j] == 0) {
                        occurrences++;
                    }
                }

                if(occurrences == n) {
                    occurrences = 0;

                    topologicalArray.add(new ArrayList<Integer>());
                    topologicalArray.get(index_topologicalArray).add(j+1);
                    for(int i=0; i<n; i++) {
                        if(matrix[j][i] == 1)
                            topologicalArray.get(index_topologicalArray).add(i+1);
                    }
                    index_topologicalArray++;

                    for(int i=0; i<n; i++) {
                        if(matrix[j][i] == 1)
                            matrix[j][i] = 0;
                    }

                    for(int i=0; i<n; i++) {
                        matrix[i][j] = -1;
                    }

                } else {
                    occurrences = 0;
                    no_occurrences++;
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++ ) {
                    if(matrix[i][j] == -1)
                        result++;
                }
            }
            if(result == n*n) {
                index_topologicalArray = 0;
                return 1;
            }
            else {
                if(no_occurrences != n) {
                    return topologicalSort();
                } else {
                    index_topologicalArray = 0;
                    return 0;
                }
            }

        }


        private SimulationResults computeResults(double[] totalDurs) throws Exception {

            double totMean = 0;
            double totVar = 0;
            double variance = 0;

            SimulationResults result = new SimulationResults();

            result.setMaxDuration( computeMaxTotalDuration(totalDurs) );
            result.setCPN(cpnResult);

            List<Double> duration = new ArrayList<Double>();
            for(int i=0; i<repetitions; i++) {
                result.addDuration(totalDurs[i]);
                totMean = totMean + totalDurs[i];
                duration.add(totalDurs[i]);
            }



            result.setMean(totMean / result.getNumDurations());

            for( Double d : result.getDurations() )
                totVar = totVar + Math.pow(d - result.getMean() , 2);

            variance = totVar / result.getNumDurations();
            result.setSD( Math.pow(variance, (double)1/2) );
            return result;

        }

        private void computeDurations() throws Exception {

            durations = new double[n];

            for(int i=0; i<n; i++) {

                if(dataActArray.get(topologicalArray.get(i).get(0)-1).get(3) == "Uniform") {

                    UniformRealDistribution uniform = new UniformRealDistribution(((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[0],
                            ((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[1]);
                    durations[i] = uniform.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                } else

                if(dataActArray.get(topologicalArray.get(i).get(0)-1).get(3) == "Triangular") {
                    TriangularDistribution triangular = new TriangularDistribution(
                            ((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[0],
                            ((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[2],
                            ((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[1]);
                    durations[i] = triangular.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                } else

                if(dataActArray.get(topologicalArray.get(i).get(0)-1).get(3) == "Beta") {
/*@todo
                    durations[i] = calcBetaDuration(i);
*/
                } else

                if(dataActArray.get(topologicalArray.get(i).get(0)-1).get(3) == "Gaussian") {

                    NormalDistribution normal = new NormalDistribution(((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[0],
                            ((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[1]);
                    durations[i] = normal.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                } else

                if(dataActArray.get(topologicalArray.get(i).get(0)-1).get(3) == "Exponential") {

                    ExponentialDistribution exponential = new ExponentialDistribution(((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(4))[0]);
                    durations[i] = exponential.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                }
            }

        }
/*@todo
        private double calcBetaDuration(int i){

             BetaCalculate betaCalculator = new BetaCalculate(((int[]) dataActArray.get(topologicalArray.get(i).get(0) - 1).get(4))[0],
                        ((int[]) dataActArray.get(topologicalArray.get(i).get(0) - 1).get(4))[1],
                        ((int[]) dataActArray.get(topologicalArray.get(i).get(0) - 1).get(4))[2]);

                BetaDistribution beta = new BetaDistribution(betaCalculator.getAlpha(),
                        betaCalculator.getBeta());
                return betaCalculator.scaleValue(beta.random());
            }

*/
        private void makeInDegree() {

            for(int i=0; i<n; i++) {
                if(inNodesArray.get(i).get(0) != 0) {
                    inDegree[i] = inNodesArray.get(i).size();
                } else {
                    inDegree[0] = 0;
                }
            }
        }


        private void makeOutDegree() {

            for(int i=0; i<n; i++) {
                outDegree[i] = topologicalArray.get(i).size()-1;
            }

        }


        public void makeInNodes() {
            int maxNumPrecedences = 0;

            for(int i=0; i<topologicalArray.size(); i++) {
                if(((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(2))[0] != -1) {
                    inNodesArray.add(new ArrayList<Integer>());
                    for(int k=0; k<((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(2)).length; k++) {
                        inNodesArray.get(i).add(((int[])dataActArray.get(topologicalArray.get(i).get(0)-1).get(2))[k]);
                    }
                } else {
                    inNodesArray.add(new ArrayList<Integer>());
                    inNodesArray.get(i).add(0);
                }
            }

            for(int i=0; i<inNodesArray.size(); i++) {
                if(inNodesArray.get(i).size() > maxNumPrecedences)
                    maxNumPrecedences = inNodesArray.get(i).size();
            }

            inNodes = new int[n][maxNumPrecedences];
            for(int i=0; i<n; i++) {
                for(int j=0; j<maxNumPrecedences; j++) {
                    inNodes[i][j] = 0;
                }
            }

            for(int i=0; i<inNodesArray.size(); i++) {
                for(int j=0; j<inNodesArray.get(i).size(); j++) {
                    inNodes[i][j] = inNodesArray.get(i).get(j);
                }
            }

            makeInDegree();
            makeOutDegree();
        }


        private double computePERT_CPN() {

            int colCheck = 0;
            int index_array = 0;
            int finalNode = 0;
            int occurrences = 0;
            int[] predSelect = new int[n];
            double max = 0.0;
            double maxending = 0.0;
            ending = new double[n];
            cpnCount = new int[n];
            ArrayList<ArrayList<Object>> durFinalNodes = new ArrayList<ArrayList<Object>>();

            for(int i=0; i<n; i++) {
                if(inDegree[i] > 0) {
                    //inNodes[i][0]-1
                    max = ending[inNodes[i][0]-1];
                    for(int j=0; j<inDegree[i]; j++){

                        if(ending[inNodes[i][j]-1] > max) {
                            max = ending[inNodes[i][j]-1];
                            colCheck = j;
                        }
                    }
                    if(colCheck != 0) {
                        cpnCount[inNodes[i][colCheck]-1]++;
                        predSelect[topologicalArray.get(i).get(0)-1] = inNodes[i][colCheck];
                        colCheck = 0;
                    } else {
                        cpnCount[inNodes[i][0]-1]++;
                        predSelect[topologicalArray.get(i).get(0)-1] = inNodes[i][0];
                    }

                    ending[topologicalArray.get(i).get(0)-1] = durations[i] + max;

                    if(outDegree[i] == 0) {
                        durFinalNodes.add(new ArrayList<Object>());
                        durFinalNodes.get(index_array).add(topologicalArray.get(i).get(0));
                        durFinalNodes.get(index_array).add(ending[topologicalArray.get(i).get(0)-1]);
                        index_array++;
                    }
                }

                else {
                    ending[topologicalArray.get(i).get(0)-1] = durations[i];
                    predSelect[topologicalArray.get(i).get(0)-1] = 0;
                }
                if (ending[topologicalArray.get(i).get(0)-1] > maxending)
                    maxending = ending[topologicalArray.get(i).get(0)-1];

            }
            if(durFinalNodes.size() > 0) {
                for(int z=0; z<durFinalNodes.size(); z++) {
                    if((Double)durFinalNodes.get(z).get(1) == maxending)
                        finalNode = (Integer)durFinalNodes.get(z).get(0);
                }

                if(finalNode != 0)
                    cpnCount[finalNode-1]++;
            }

            for(int i=n-1; i>=0; i--) {
                if(outDegree[i] > 0) {
                    for(int j=1; j<topologicalArray.get(i).size(); j++) {
                        if(cpnCount[topologicalArray.get(i).get(j)-1] == 0 ||
                                predSelect[topologicalArray.get(i).get(j)-1] != topologicalArray.get(i).get(0))
                            occurrences++;
                    }

                    if(occurrences == topologicalArray.get(i).size()-1)
                        cpnCount[topologicalArray.get(i).get(0)-1] = 0;

                    occurrences = 0;
                }
            }
            for(int i=0; i<n; i++) {
                if(cpnCount[i] > 0)
                    cpnResult[i]++;
            }

            return maxending;

        }


        private double computeMaxTotalDuration(double[] totalDurs) throws Exception {

            double maxTotalEnding = 0;

            for(int i=0; i<repetitions; i++) {

                computeDurations();
                totalDurs[i] = computePERT_CPN();


                if(totalDurs[i] > maxTotalEnding)
                    maxTotalEnding = totalDurs[i];

            }

            return maxTotalEnding;
        }


        public SimulationResults results() throws Exception {
            totalDurations = new double[repetitions];
            return computeResults(totalDurations);
        }
    }

