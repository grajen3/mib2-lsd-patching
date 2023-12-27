/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate.modelclient;

public class SeatVentilationCollector {
    public int seatVentilation;

    public SeatVentilationCollector() {
        this.seatVentilation = 0;
    }

    public SeatVentilationCollector(int n) {
        this.seatVentilation = n;
    }

    public SeatVentilationCollector(SeatVentilationCollector seatVentilationCollector) {
        this.seatVentilation = seatVentilationCollector.seatVentilation;
    }
}

