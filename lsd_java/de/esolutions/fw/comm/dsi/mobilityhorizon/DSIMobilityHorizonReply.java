/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon;

import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizonReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray, int n) {
    }

    default public void updateConsideredLocationTypes(int[] nArray, int n) {
    }

    default public void updateDriveTrainMode(int n, int n2) {
    }

    default public void updateMobilityHorizonStatus(int n, int n2) {
    }

    default public void requestLocationRangeLevelResult(int n, int n2) {
    }

    default public void locationRangeLevelChanged(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

