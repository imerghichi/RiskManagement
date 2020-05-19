package com.management.risk.Analysis.MonteCarlo;



import com.management.risk.models.Identification.Activity;
import org.apache.commons.math3.distribution.*;

import java.util.ArrayList;
import java.util.List;

import static com.management.risk.models.Identification.DistributionEnum.*;

public class MonteCarlo {

        private static final int INTERVALS = 30;

        private int repetitions;

        //activities
        private List<Activity> dataActArray;

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


        public MonteCarlo(int repet, List<Activity> actArray) {

            repetitions = repet;
            dataActArray = actArray;

            n = dataActArray.size();

            topologicalArray = new ArrayList<>();

            inNodesArray = new ArrayList<>();

            inDegree = new int[n];

            outDegree = new int[n];

            cpnResult = new int[n];

            matrix = new int[n][n];
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    matrix[i][j] = 0;

            for(int i=0; i<n; i++) {
                if(dataActArray.get(i).getPredecesors() != null){
                    List<Activity> temp ;
                    temp = dataActArray.get(i).getPredecesors();
                    for (Activity activity:
                         temp) {
                        matrix[(int)activity.getId_task_project()][i] = 1 ;
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

                    topologicalArray.add(new ArrayList<>());
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


        private SimulationResults computeResults(double[] totalDurs) {

            double totMean = 0;
            double totVar = 0;
            double variance ;

            SimulationResults result = new SimulationResults();

            result.setMaxDuration( computeMaxTotalDuration(totalDurs) );
            result.setCPN(cpnResult);

            List<Double> duration = new ArrayList<>();
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

        private void computeDurations() {

            durations = new double[n];

            for(int i=0; i<n; i++) {
                if(dataActArray.get(i).getDistribution() == Uniform){
                    UniformRealDistribution uniform = new UniformRealDistribution(dataActArray.get(i).getParametre1(), dataActArray.get(i).getParametre2());
                    durations[i] = uniform.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                } else
                if(dataActArray.get(i).getDistribution() == Triangular) {
                    TriangularDistribution triangular = new TriangularDistribution(dataActArray.get(i).getParametre1(), dataActArray.get(i).getParametre2(), dataActArray.get(i).getParametre3());
                    durations[i] = triangular.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                } else

                if(dataActArray.get(i).getDistribution() == Beta) {

                    durations[i] = calcBetaDuration(i);

                } else

                if(dataActArray.get(i).getDistribution() == Gaussian) {

                    NormalDistribution normal = new NormalDistribution(dataActArray.get(i).getParametre1(), dataActArray.get(i).getParametre2());
                    durations[i] = normal.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                } else

                if(dataActArray.get(i).getDistribution() == Exponential) {
                    ExponentialDistribution exponential = new ExponentialDistribution(dataActArray.get(i).getParametre1());
                    durations[i] = exponential.sample();
                    if(durations[i]<0)
                        durations[i] = 0;

                }
            }

        }
        private double calcBetaDuration(int i){

             BetaCalculate betaCalculator = new BetaCalculate(dataActArray.get(i).getParametre1(), dataActArray.get(i).getParametre2(), dataActArray.get(i).getParametre3());

                BetaDistribution beta = new BetaDistribution(betaCalculator.getAlpha(),
                        betaCalculator.getBeta());
                return betaCalculator.scaleValue(beta.sample());
            }


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
                inNodesArray.add(new ArrayList<>());
                if (dataActArray.get(i).getPredecesors() != null) {
                    for (int k = 0; k < dataActArray.get(i).getPredecesors().size(); k++) {
                        inNodesArray.get(i).add((int) dataActArray.get(i).getPredecesors().get(k).getId_task_project());
                    }
                } else {
                    inNodesArray.get(i).add(0);
                }
            }

            for (ArrayList<Integer> innode:
                 inNodesArray) {
                if(innode.size() > maxNumPrecedences)
                    maxNumPrecedences = innode.size();
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
            double max ;
            double maxending = 0.0;
            ending = new double[n];
            cpnCount = new int[n];
            ArrayList<ArrayList<Object>> durFinalNodes = new ArrayList<>();

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
                        durFinalNodes.add(new ArrayList<>());
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
                for (ArrayList<Object> dufinal:
                     durFinalNodes) {
                    if ((Double) dufinal.get(1) == maxending)
                        finalNode = (Integer)dufinal.get(0);
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


        private double computeMaxTotalDuration(double[] totalDurs){

            double maxTotalEnding = 0;

            for(int i=0; i<repetitions; i++) {

                computeDurations();
                totalDurs[i] = computePERT_CPN();


                if(totalDurs[i] > maxTotalEnding)
                    maxTotalEnding = totalDurs[i];

            }

            return maxTotalEnding;
        }


        public SimulationResults results() {
            totalDurations = new double[repetitions];
            return computeResults(totalDurations);
        }
    }

