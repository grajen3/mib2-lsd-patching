/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;

public interface DriverDistractionPreventionService {
    default public void addDriverDistractionPreventionListener(DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener) {
    }

    default public void removeDriverDistractionPreventionListener(DriverDistractionPreventionThresholdListener driverDistractionPreventionThresholdListener) {
    }

    default public boolean isDriverDistractionPreventionRequired() {
    }
}

