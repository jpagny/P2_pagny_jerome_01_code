package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple brute force implementation
 */
public record ReadSymptomDataFromFile(String filepath) implements ISymptomReader {

    static Logger logger = Logger.getLogger("AnalyticsCounter");

    @Override
    public List<String> getSymptoms() {

        ArrayList<String> listSymptoms = new ArrayList<>();
        Path path;

        if (filepath != null) {

            path = Paths.get(filepath);

            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

                String line;

                while ((line = reader.readLine()) != null) {
                    listSymptoms.add(line);
                }

            } catch (IOException ex) {
                logger.log(Level.SEVERE, ex.getMessage());

            }
        }

        return listSymptoms;
    }

}
