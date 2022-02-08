package com.hemebiotech.analytics;

import java.util.SortedMap;

/**
 * Count symptom, given by a list of all symptoms and a list of symptoms to catch.
 */
public interface ISymptomCounter {

    /**
     * Count symptom with the number of occurrences
     *
     * @return a map of symptoms watched with the number of occurrences
     */
    SortedMap<String, Integer> countSymptom();

}
