/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate.modelclient;

public class SeatHeaterCollector {
    public int seatHeater;

    public SeatHeaterCollector() {
        this.seatHeater = 0;
    }

    public SeatHeaterCollector(int n) {
        this.seatHeater = n;
    }

    public SeatHeaterCollector(SeatHeaterCollector seatHeaterCollector) {
        this.seatHeater = seatHeaterCollector.seatHeater;
    }
}

