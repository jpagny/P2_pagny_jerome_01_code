package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * The implementation does not need to order the list
 */
public interface ISymptomReader {

    /**
     * Get list of symptoms
     *
     * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
     * If no data is available, return an empty List
     */
    List<String> getSymptoms();
}
