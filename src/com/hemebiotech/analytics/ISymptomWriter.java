package com.hemebiotech.analytics;

/**
 * Build an output file, with a list of symptoms with the number of occurrences.
 */
public interface ISymptomWriter {

    /**
     * Create a file which contains a list of symptoms with the number of occurrences
     */
    void writeReport();
}
