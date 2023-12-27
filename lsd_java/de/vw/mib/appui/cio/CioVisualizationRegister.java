/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appui.cio;

import de.vw.mib.cio.framework.CioVisualizationService;

public interface CioVisualizationRegister {
    default public void registerRelayService(String string, String string2, CioVisualizationService cioVisualizationService) {
    }

    default public void unregisterRelayService(String string, String string2) {
    }
}

