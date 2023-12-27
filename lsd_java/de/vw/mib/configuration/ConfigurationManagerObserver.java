/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

public interface ConfigurationManagerObserver {
    default public void receiveFeatureFlagUpdate(int n, String string) {
    }
}

