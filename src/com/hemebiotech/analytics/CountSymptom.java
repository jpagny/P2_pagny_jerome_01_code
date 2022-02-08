package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountSymptom implements ISymptomCounter {

    private static final Logger LOGGER = Logger.getLogger("CountSymptom");

    private final List<String> listSymptomData;
    private final TreeMap<String, Integer> mapSymptomsToWatch;

    public CountSymptom(List<String> theListSymptomData, TreeMap<String, Integer> theMapSymptomsToWatch) {
        listSymptomData = theListSymptomData;
        mapSymptomsToWatch = theMapSymptomsToWatch;
    }

    @Override
    public TreeMap<String, Integer> countSymptom() {
        for (String theSymptom : listSymptomData) {
            LOGGER.log(Level.INFO, "symptom from file : {0} ", theSymptom);
            if (mapSymptomsToWatch.containsKey(theSymptom)) {
                mapSymptomsToWatch.compute(
                        theSymptom, (symptom, countSymptom)
                                -> countSymptom == null ? 0 : countSymptom + 1
                );
                String message = String.format("number of %s : %s", theSymptom, mapSymptomsToWatch.get(theSymptom));
                LOGGER.log(Level.INFO, message);
            }
        }
        return mapSymptomsToWatch;
    }
}
