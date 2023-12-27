/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon;

import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class DSIMobilityHorizonDatapool {
    private int[] consideredLocationTypes;
    private ConsumptionInfo[] consumptionInfo;
    private int driveTrainMode;
    private MobilityHorizonLocation[] locations;

    public int[] getConsideredLocationTypes() {
        return this.consideredLocationTypes;
    }

    public ConsumptionInfo[] getConsumptionInfo() {
        return this.consumptionInfo;
    }

    public int getDriveTrainMode() {
        return this.driveTrainMode;
    }

    public MobilityHorizonLocation[] getLocations() {
        return this.locations;
    }

    public void setConsideredLocationTypes(int[] nArray) {
        this.consideredLocationTypes = nArray;
    }

    public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
        this.consumptionInfo = consumptionInfoArray;
    }

    public void setDriveTrainMode(int n) {
        this.driveTrainMode = n;
    }

    public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        this.locations = mobilityHorizonLocationArray;
    }
}

