package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteSymptomDataReport implements ISymptomWriter {

    private static final Logger LOGGER = Logger.getLogger("WriteSymptomDataReport");

    private final SortedMap<String, Integer> mapSymptomsToWatch;

    public WriteSymptomDataReport(SortedMap<String, Integer> theMapSymptomsToWatch) {
        mapSymptomsToWatch = theMapSymptomsToWatch;
    }

    @Override
    public void writeReport() {
        try (FileWriter writer = new FileWriter("result.out")) {
            for (Map.Entry<String, Integer> entry : mapSymptomsToWatch.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception : {0}", ex.getMessage());
            System.exit(1);
        } finally {
            LOGGER.log(Level.INFO, "Report is created !");
        }
    }
}
