package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listing of symptoms given by a file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private static final Logger LOGGER = Logger.getLogger("ReadSymptomDataFromFile");

    private final String filepath;

    public ReadSymptomDataFromFile(String theFilePath){
        filepath = theFilePath;
    }

    @Override
    public List<String> getSymptoms() {

        List<String> listSymptoms = new ArrayList<>();
        Path path;

        Objects.requireNonNull(filepath, "FilePath must not be null !");
        path = Paths.get(filepath);

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                listSymptoms.add(line);
            }

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "There is a problem with this file : ");
            ex.printStackTrace();
            System.exit(1);

        }

        return listSymptoms;
    }

}
