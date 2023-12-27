/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioIntentChangeListener;
import de.vw.mib.cio.CioPayload;

public interface CioIntent {
    public static final int LAST_RANK;
    public static final String NO_INTENT_CLASS;
    public static final String NO_USAGE;
    public static final long NO_VISUALIZATION;

    default public void addCioIntentChangeListener(CioIntentChangeListener cioIntentChangeListener) {
    }

    default public String getCioIntentClass() {
    }

    default public String getCioIntentName() {
    }

    default public long getCioIntentId() {
    }

    default public CioPayload getPayload() {
    }

    default public Object getPayloadData() {
    }

    default public String getUsage() {
    }

    default public long getVisualizationId() {
    }

    default public boolean isAvailable() {
    }

    default public void removeCioIntentChangeListener(CioIntentChangeListener cioIntentChangeListener) {
    }

    static {
        NO_INTENT_CLASS = null;
        NO_USAGE = null;
    }
}

