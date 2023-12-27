/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMobilityHorizonVW;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class MobilityHorizonSetupNotifierDSI {
    private DSIMobilityHorizonVW mobilityHorizon;

    public DSIMobilityHorizonVW getMobilityHorizon() {
        return this.mobilityHorizon;
    }

    public void setConsideredLocationTypes(int[] nArray) {
        this.mobilityHorizon.setConsideredLocationTypes(nArray);
    }

    public void setDriveTrainMode(int n) {
        this.mobilityHorizon.setDriveTrainMode(n);
    }

    public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        this.mobilityHorizon.setLocations(mobilityHorizonLocationArray);
    }

    public void setMobilityHorizon(DSIMobilityHorizonVW dSIMobilityHorizonVW) {
        this.mobilityHorizon = dSIMobilityHorizonVW;
    }
}

