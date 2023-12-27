/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.locationinput;

import org.dsi.ifc.global.NavLocation;

public interface IStartupState {
    default public NavLocation getNavLocation() {
    }

    default public int[] getAvailableSelectionCriteria() {
    }

    default public boolean isInputActive() {
    }

    default public boolean isFullPostalCode() {
    }

    default public boolean hasPointLocations() {
    }
}

