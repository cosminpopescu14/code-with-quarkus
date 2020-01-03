package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.service.LevenshteinDistance;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class LevenshteinDistanceTest {

    /*
    Quarkus supports this by allowing you to inject CDI beans into your tests
     via the @Inject annotation (in fact,
     tests in Quarkus are full CDI beans, so you can use all CDI functionality).
     */
    @Inject
    private LevenshteinDistance levenshteinDistance;

    @Test
    public void testNotNull() {
        assertNotNull(levenshteinDistance);
    }

    @Test
    public void testLevenshteinDistance() {
        assertEquals(levenshteinDistance.computeDistance("kitten", "sitting"), 3);
    }
}
