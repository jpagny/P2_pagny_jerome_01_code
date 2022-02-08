package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyticsCounter {

    private final String filePath;
    private TreeMap<String, Integer> myMapSymptomsToWatch;
    private List<String> listSymptomData;
    private static final Logger LOGGER = Logger.getLogger("AnalyticsCounter");

    public AnalyticsCounter(String theFilePath) {
        filePath = theFilePath;
    }

    public void runAnalyticsCounter() {
        initMapSymptomsToWatch();
        fetchDataFromFile();
        countSymptom();
    }

    // initialize list of symptoms to watch
    private void initMapSymptomsToWatch() {
        myMapSymptomsToWatch = new TreeMap<>();
        myMapSymptomsToWatch.put("headache", 0);
        myMapSymptomsToWatch.put("rash", 0);
        myMapSymptomsToWatch.put("dilated pupils", 0);
    }

    // fetch all data from file
    private void fetchDataFromFile() {
        ReadSymptomDataFromFile listSymptomDataFromFile = new ReadSymptomDataFromFile(filePath);
        listSymptomData = listSymptomDataFromFile.getSymptoms();
    }

    // count symptom with all data from file / symptoms to watch
    private void countSymptom(){
        for (String theSymptom : listSymptomData) {
            LOGGER.log(Level.INFO, "symptom from file : {0} ", theSymptom);
            if (myMapSymptomsToWatch.containsKey(theSymptom)) {
                myMapSymptomsToWatch.compute(theSymptom, (symptom, countSymptom) -> countSymptom + 1);
                String message = String.format("number of %s : %s", theSymptom, myMapSymptomsToWatch.get(theSymptom));
                LOGGER.log(Level.INFO, message);
            }
        }
    }

    // build result.out
    private void createReport() {

    }


}

