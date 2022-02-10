package com.hemebiotech.analytics;

/**
 * The main program.
 */
public class PAnalyticSymptoms {

    /**
     * The main program
     * @param args none
     */
    public static void main(String[] args) {
        AnalyticsCounter analyticSymptoms = new AnalyticsCounter("symptoms.txt");
        analyticSymptoms.runAnalyticsCounter();
    }

}
