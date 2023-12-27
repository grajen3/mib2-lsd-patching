/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import org.dsi.ifc.global.NavLocation;

public interface IPersistedDestInputSetup {
    default public NavLocation getHomeDest() {
    }

    default public NavLocation getHomeLocation() {
    }

    default public void setHomeDest(NavLocation navLocation, boolean bl) {
    }

    default public NavLocation getLastDest() {
    }

    default public int getLastInputMode() {
    }

    default public void setLastDest(NavLocation navLocation) {
    }

    default public NavLocation getDemoDest() {
    }

    default public void setDemoDest(NavLocation navLocation) {
    }

    default public void setPersistenceRestoredPublicTemp(boolean bl) {
    }

    default public void updateProperties() {
    }

    default public void updatePropertyIsHomeLocationSet(boolean bl) {
    }

    default public boolean getShowSLDEHelp() {
    }

    default public void setLastInputMode(int n) {
    }
}

