/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;

public class ClimateSeatHeaterImpl
implements ClimateSeatHeater {
    private final int seatHeater;
    private final int zoneMember;

    public ClimateSeatHeaterImpl(int n, int n2) {
        this.seatHeater = n2;
        this.zoneMember = n;
    }

    @Override
    public int getSeatHeater() {
        return this.seatHeater;
    }

    @Override
    public int getSeatHeaterZone() {
        return this.zoneMember;
    }

    @Override
    public ClimateSeatHeater createSeatHeater(int n) {
        ClimateSeatHeaterImpl climateSeatHeaterImpl = new ClimateSeatHeaterImpl(this.zoneMember, n);
        return climateSeatHeaterImpl;
    }
}

