/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.lcu;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import org.dsi.ifc.bap.DSIBAP;
import org.dsi.ifc.bap.DSIBAPListener;

public interface BAPLogicalControlUnit {
    default public void initialize() {
    }

    default public boolean isInitialized() {
    }

    default public void setService(DSIBAP dSIBAP) {
    }

    default public DSIBAP getService() {
    }

    default public DSIBAPListener getServiceListener() {
    }

    default public BAPObserverRegistry getBapObserverRegistry() {
    }

    default public int getLogicalControlUnitID() {
    }

    default public boolean isDisplayControlUnit() {
    }

    default public String getLogicalControlUnitName() {
    }
}

