/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateFunctionsAvailability;

public class ClimateFuntionsAvailabilityImpl
implements ClimateFunctionsAvailability {
    private final int temperatureAvailabilityZone1;
    private final int temperatureAvailabilityZone2;
    private final int temperatureAvailabilityZone3;
    private final int temperatureAvailabilityZone4;
    private final int seatHeaterAvailabilityZone1;
    private final int seatHeaterAvailabilityZone2;
    private final int seatHeaterAvailabilityZone3;
    private final int seatHeaterAvailabilityZone4;
    private final int seatVentilationAvailabilityZone1;
    private final int seatVentilationAvailabilityZone2;
    private final int seatVentilationAvailabilityZone3;
    private final int seatVentilationAvailabilityZone4;

    public ClimateFuntionsAvailabilityImpl(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        this.temperatureAvailabilityZone1 = n;
        this.temperatureAvailabilityZone2 = n2;
        this.temperatureAvailabilityZone3 = n3;
        this.temperatureAvailabilityZone4 = n4;
        this.seatHeaterAvailabilityZone1 = n5;
        this.seatHeaterAvailabilityZone2 = n6;
        this.seatHeaterAvailabilityZone3 = n7;
        this.seatHeaterAvailabilityZone4 = n8;
        this.seatVentilationAvailabilityZone1 = n9;
        this.seatVentilationAvailabilityZone2 = n10;
        this.seatVentilationAvailabilityZone3 = n11;
        this.seatVentilationAvailabilityZone4 = n12;
    }

    @Override
    public ClimateFunctionsAvailability createClimateFunctionsAvailability() {
        return new ClimateFuntionsAvailabilityImpl(this.temperatureAvailabilityZone1, this.temperatureAvailabilityZone2, this.temperatureAvailabilityZone3, this.temperatureAvailabilityZone4, this.seatHeaterAvailabilityZone1, this.seatHeaterAvailabilityZone2, this.seatHeaterAvailabilityZone3, this.seatHeaterAvailabilityZone4, this.seatVentilationAvailabilityZone1, this.seatVentilationAvailabilityZone2, this.seatVentilationAvailabilityZone3, this.seatVentilationAvailabilityZone4);
    }

    @Override
    public int getTemperatureAvailabilityZone1() {
        return this.temperatureAvailabilityZone1;
    }

    @Override
    public int getTemperatureAvailabilityZone2() {
        return this.temperatureAvailabilityZone2;
    }

    @Override
    public int getTemperatureAvailabilityZone3() {
        return this.temperatureAvailabilityZone3;
    }

    @Override
    public int getTemperatureAvailabilityZone4() {
        return this.temperatureAvailabilityZone4;
    }

    @Override
    public int getSeatHeaterAvailabilityZone1() {
        return this.seatHeaterAvailabilityZone1;
    }

    @Override
    public int getSeatHeaterAvailabilityZone2() {
        return this.seatHeaterAvailabilityZone2;
    }

    @Override
    public int getSeatVentilationAvailabilityZone1() {
        return this.seatVentilationAvailabilityZone1;
    }

    @Override
    public int getSeatVentilationAvailabilityZone2() {
        return this.seatVentilationAvailabilityZone2;
    }
}

