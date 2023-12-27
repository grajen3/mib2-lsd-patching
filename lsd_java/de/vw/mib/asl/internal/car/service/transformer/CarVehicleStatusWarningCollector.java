/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.transformer;

public class CarVehicleStatusWarningCollector {
    public int warningId;
    public int posValue;
    public String warningText;
    public String alternativeText;

    public CarVehicleStatusWarningCollector(int n, int n2, String string, String string2) {
        this.posValue = n;
        this.warningId = n2;
        this.warningText = string;
        this.alternativeText = string2;
    }

    public CarVehicleStatusWarningCollector() {
    }
}

