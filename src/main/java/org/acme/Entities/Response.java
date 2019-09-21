package org.acme.Entities;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.inject.Singleton;

@Singleton
public class Response {
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    private int distance;
}
