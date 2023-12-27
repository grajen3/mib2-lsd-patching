/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.PersistedTrafficSetup;

public class TrafficMapSetupDatapool {
    private boolean isSDARSTrafficLicenseValid;
    private boolean onlineTrafficLicenseValid;
    private boolean onlineTrafficServiceAvailable;
    protected final PersistedMapSetup persistedMapSetup;
    private final PersistedTrafficSetup persistedTrafficSetup = PersistedTrafficSetup.getInstance();

    TrafficMapSetupDatapool() {
        this.persistedMapSetup = PersistedMapSetup.getInstance();
    }

    public int getMainMapMapTypeLast() {
        return this.persistedMapSetup.getMainMapMapTypeLast();
    }

    public int getSpeedAndFlowRoadClass() {
        return this.persistedTrafficSetup.getSpeedAndFlowRoadClass();
    }

    public int getSpeedAndFlowRoadClassDSI() {
        return this.persistedTrafficSetup.getSpeedAndFlowRoadClassDSI();
    }

    boolean isMainMapShowSpeedAndFlow() {
        return this.persistedTrafficSetup.isMainMapShowSpeedAndFlow();
    }

    boolean isOnlineTrafficLicenseValid() {
        return this.onlineTrafficLicenseValid;
    }

    boolean isOnlineTrafficServiceAvailable() {
        return this.onlineTrafficServiceAvailable;
    }

    boolean isSDARSTrafficLicenseValid() {
        return this.isSDARSTrafficLicenseValid;
    }

    boolean isTrafficShowCongestion() {
        return this.persistedTrafficSetup.getTrafficShowCongestion();
    }

    boolean isTrafficShowFreeFlow() {
        return this.persistedTrafficSetup.getTrafficShowFreeFlow();
    }

    boolean isTrafficShowIncidents() {
        return this.persistedTrafficSetup.getTrafficShowIncidents();
    }

    void setMainMapShowSpeedAndFlow(boolean bl) {
        this.persistedTrafficSetup.setMainMapShowSpeedAndFlow(bl);
    }

    void setOnlineTrafficLicenseValid(boolean bl) {
        this.onlineTrafficLicenseValid = bl;
    }

    void setOnlineTrafficServiceAvailable(boolean bl) {
        this.onlineTrafficServiceAvailable = bl;
    }

    void setSDARSTrafficLicenseValid(boolean bl) {
        this.isSDARSTrafficLicenseValid = bl;
    }

    void setSpeedAndFlowRoadClass(int n) {
        this.persistedTrafficSetup.setSpeedAndFlowRoadClass(n);
    }

    void setTrafficShowCongestion(boolean bl) {
        this.persistedTrafficSetup.setTrafficShowCongestion(bl);
    }

    void setTrafficShowFreeFlow(boolean bl) {
        this.persistedTrafficSetup.setTrafficShowFreeFlow(bl);
    }

    void setTrafficShowIncidents(boolean bl) {
        this.persistedTrafficSetup.setTrafficShowIncidents(bl);
    }
}

