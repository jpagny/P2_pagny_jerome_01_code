package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Program permit to describe the symptom as well as the number of occurrences.
 */
public class AnalyticsCounter {

    private final String filePath;
    private SortedMap<String, Integer> myMapSymptomsToWatch;
    private List<String> listSymptomData;
    private ISymptomReader listSymptomDataFromFile;

    public AnalyticsCounter(String theFilePath) {
        filePath = theFilePath;
    }

    /**
     * Run AnalyticsCounter program :
     * <p>
     *     <ul>
     *         <li>01 - fetchDataFromFile</li>
     *         <li>02 - loadMapSymptomsToWatch</li>
     *         <li>03 - countSymptom</li>
     *         <li>04 - createReport</li>
     *     </ul>
     * </p>
     */
    public void runAnalyticsCounter() {
        fetchDataFromFile();
        loadDataToMapSymptomsToWatch();
        countSymptom();
        createReport();
    }

    /**
     * Get all symptoms from a file
     */
    private void fetchDataFromFile() {
        listSymptomDataFromFile = new ReadSymptomDataFromFile(filePath);
        listSymptomData = listSymptomDataFromFile.getSymptoms();
    }

    /**
     * Load list of symptoms to watch
     */
    private void loadDataToMapSymptomsToWatch() {
        myMapSymptomsToWatch = new TreeMap<>();
        listSymptomDataFromFile.getSymptoms().forEach(symptom -> myMapSymptomsToWatch.put(symptom, 0));
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

