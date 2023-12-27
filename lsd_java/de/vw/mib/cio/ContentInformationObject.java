/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio;

import de.vw.mib.cio.CioPayload;

public interface ContentInformationObject {
    default public int getActionId() {
    }

    default public String getCioName() {
    }

    default public String getCioIntentName() {
    }

    default public CioPayload getPayload() {
    }

    default public Object getPayloadData() {
    }

    default public boolean isRegistered() {
    }

    default public void register() {
    }

    default public void setAvailable(boolean bl) {
    }

    default public void unregister() {
    }

    default public int getActiveVisualizationIndex() {
    }

    default public void setActiveVisualizationIndex(int n) {
    }
}

