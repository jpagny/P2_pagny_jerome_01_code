package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyticsCounter {

    private static final int HEADACHE_COUNT = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String[] args) throws Exception {

        Logger log = Logger.getLogger("AnalyticsCounter");
        Path path = Paths.get("symptoms.txt");

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String line = reader.readLine();
            int headCount = 0;

            while (line != null) {

                log.log(Level.INFO, "symptom from file: {0}", line);

                if (line.equals("headache")) {
                    headCount++;
                    log.log(Level.INFO, "number of headaches: {0}", headCount);

                } else if (line.equals("rush")) {
                    rashCount++;

                } else if (line.contains("pupils")) {
                    pupilCount++;

                }

                line = reader.readLine();
            }

            try (FileWriter writer = new FileWriter("result.out")) {
                writer.write("headache: " + HEADACHE_COUNT + "\n");
                writer.write("rash: " + rashCount + "\n");
                writer.write("dilated pupils: " + pupilCount + "\n");
            }


        }


    }

    // initialize list of symptoms to watch
    private void initMapSymptomToWatch(){

    }

    // fetch all data from file
    private void fetchDataFromFile(String file){

    }

    // count symptom with all data from file / symptoms to watch
    private void countSymptom(){

    }

    // build result.out
    private void createReport(){

    }


}

