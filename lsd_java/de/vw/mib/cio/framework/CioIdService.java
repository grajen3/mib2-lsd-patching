/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.framework;

import de.vw.mib.cio.CioIntent;

public interface CioIdService {
    default public long getCioIntentId(String string, String string2, String string3, String string4, String string5) {
    }

    default public long getCioVisualizationId(String string, String string2, String string3, String string4) {
    }

    default public long getUniqueCioIntentId(CioIntent cioIntent) {
    }
}

