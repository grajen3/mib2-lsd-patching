/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.framework;

import de.vw.mib.cio.framework.CioVisualizationChangeListener;

public interface CioVisualizationChangeService {
    default public void registerCioVisualizationChangeListener(CioVisualizationChangeListener cioVisualizationChangeListener) {
    }

    default public void unregisterCioVisualizationChangeListener(CioVisualizationChangeListener cioVisualizationChangeListener) {
    }
}

