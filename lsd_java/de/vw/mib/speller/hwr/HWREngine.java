/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.hwr;

import de.vw.mib.speller.hwr.HWRConfiguration;

public interface HWREngine {
    default public void clear() {
    }

    default public HWRConfiguration getConfiguration() {
    }

    default public boolean isConfigured() {
    }

    default public boolean isReady() {
    }

    default public void release() {
    }

    default public void sendConfiguration() {
    }

    default public void setConfiguration(HWRConfiguration hWRConfiguration) {
    }
}

