/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.framework;

import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;

public interface CioVisualizationService {
    public static final int DEFAULT_ID;

    default public CioIntentVisualization getVisualization(long l) {
    }

    default public void load(CioIdService cioIdService) {
    }

    default public void loadDone() {
    }
}

