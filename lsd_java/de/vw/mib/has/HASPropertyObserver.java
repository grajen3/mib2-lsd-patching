/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import org.dsi.ifc.has.HASDataContainer;

public interface HASPropertyObserver {
    default public void propertyUpdated(int n, HASDataContainer[] hASDataContainerArray) {
    }

    default public boolean isPropertyRequested(int n) {
    }
}

