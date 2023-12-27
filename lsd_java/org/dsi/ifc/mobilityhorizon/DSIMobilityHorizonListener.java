/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mobilityhorizon;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizonListener
extends DSIListener {
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
}

