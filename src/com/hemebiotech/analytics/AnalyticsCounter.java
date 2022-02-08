package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/**
 * Program permit to describe the symptom as well as the number of occurrences.
 */
public class AnalyticsCounter {

    private final String filePath;
    private TreeMap<String, Integer> myMapSymptomsToWatch;
    private List<String> listSymptomData;

    public AnalyticsCounter(String theFilePath) {
        filePath = theFilePath;
    }

    /**
     * Run AnalyticsCounter program :
     * <p>
     *     <ul>
     *         <li>01 - initMapSymptomsToWatch</li>
     *         <li>02 - fetchDataFromFile</li>
     *         <li>03 - countSymptom</li>
     *         <li>04 - createReport</li>
     *     </ul>
     * </p>
     */
    public void runAnalyticsCounter() {
        initMapSymptomsToWatch();
        fetchDataFromFile();
        countSymptom();
        createReport();
    }

    /**
     * Initialize list of symptoms to watch
     */
    private void initMapSymptomsToWatch() {
        myMapSymptomsToWatch = new TreeMap<>();
        myMapSymptomsToWatch.put("headache", 0);
        myMapSymptomsToWatch.put("rash", 0);
        myMapSymptomsToWatch.put("dilated pupils", 0);
    }

    /**
     * Get all symptoms from a file
     */
    private void fetchDataFromFile() {
        ReadSymptomDataFromFile listSymptomDataFromFile = new ReadSymptomDataFromFile(filePath);
        listSymptomData = listSymptomDataFromFile.getSymptoms();
    }

    /**
     * Count symptoms as well with the number of occurrences
     */
    private void countSymptom() {
        ISymptomCounter symptomCounter = new CountSymptom(listSymptomData, myMapSymptomsToWatch);
        myMapSymptomsToWatch = symptomCounter.countSymptom();
    }

    /**
     * Generate an output file with list of symptoms with the number of occurrences
     */
    private void createReport() {
        ISymptomWriter symptomWriter = new WriteSymptomDataReport(myMapSymptomsToWatch);
        symptomWriter.writeReport();
    }

}

