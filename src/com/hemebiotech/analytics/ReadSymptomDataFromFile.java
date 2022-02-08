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


public record ReadSymptomDataFromFile(String filepath) implements ISymptomReader {

    static Logger logger = Logger.getLogger("ReadSymptomDataFromFile");

    @Override
    public List<String> getSymptoms() {

        List<String> listSymptoms = new ArrayList<>();
        Path path;

        Objects.requireNonNull(filepath, "FilePath is empty");
        path = Paths.get(filepath);

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                listSymptoms.add(line);
            }

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "There is a problem with this file : ");
            ex.printStackTrace();
            System.exit(1);

        }

        return listSymptoms;
    }

}
