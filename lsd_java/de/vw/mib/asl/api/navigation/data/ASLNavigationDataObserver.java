/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.data;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataContainer;

public interface ASLNavigationDataObserver {
    default public void navigationDataChanged(ASLNavigationDataContainer aSLNavigationDataContainer) {
    }
}

