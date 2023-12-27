/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

public class TemperatureButtonCollector {
    public int tempIncDecModifiableViaHMI;
    public int temperatureValue;
    public int unit;

    public TemperatureButtonCollector(int n, int n2, int n3) {
        this.tempIncDecModifiableViaHMI = n;
        this.temperatureValue = n2;
        this.unit = n3;
    }

    public TemperatureButtonCollector(TemperatureButtonCollector temperatureButtonCollector) {
        this.tempIncDecModifiableViaHMI = temperatureButtonCollector.tempIncDecModifiableViaHMI;
        this.temperatureValue = temperatureButtonCollector.temperatureValue;
        this.unit = temperatureButtonCollector.unit;
    }

    public TemperatureButtonCollector() {
        this.tempIncDecModifiableViaHMI = 1;
        this.temperatureValue = 20;
        this.unit = 1;
    }
}

