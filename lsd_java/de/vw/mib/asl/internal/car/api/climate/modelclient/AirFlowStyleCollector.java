/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate.modelclient;

public class AirFlowStyleCollector {
    public int airFlowStyleCollector;

    public AirFlowStyleCollector() {
        this.airFlowStyleCollector = 1;
    }

    public AirFlowStyleCollector(int n) {
        this.airFlowStyleCollector = n;
    }

    public AirFlowStyleCollector(AirFlowStyleCollector airFlowStyleCollector) {
        this.airFlowStyleCollector = airFlowStyleCollector.airFlowStyleCollector;
    }
}

