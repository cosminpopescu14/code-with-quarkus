package org.acme;

import javax.enterprise.context.ApplicationScoped;

import static java.lang.Math.min;

@ApplicationScoped
public class LevenshteinDistance {

    public int computeDistance(String string1, String string2) {

        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        int[] costs = new int[string2.length() + 1];

        for(int j = 0; j < costs.length; j++)
            costs[j] = j;

        for (int i = 1; i <= string1.length(); i++) {
            costs[0] = 1;
            int nw = i - 1;

            for (int j = 1; j <= string2.length(); j++) {
                int cj = min(1 + min(costs[j], costs[j - 1]),
                                     string1.charAt(i - 1) == string2.charAt(j - 1)
                                     ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[string2.length()];
    }
}
