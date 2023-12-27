/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;

public class ClimateSeatVentilationImpl
implements ClimateSeatVentilation {
    private final int seatVentilation;
    private final int zoneMember;

    public ClimateSeatVentilationImpl(int n, int n2) {
        this.seatVentilation = n2;
        this.zoneMember = n;
    }

    @Override
    public int getSeatVentilation() {
        return this.seatVentilation;
    }

    @Override
    public int getSeatVentilationZone() {
        return this.zoneMember;
    }

    @Override
    public ClimateSeatVentilation createSeatVentilation(int n) {
        ClimateSeatVentilationImpl climateSeatVentilationImpl = new ClimateSeatVentilationImpl(this.zoneMember, n);
        return climateSeatVentilationImpl;
    }
}

