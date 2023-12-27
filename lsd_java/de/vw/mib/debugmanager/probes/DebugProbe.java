/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.probes;

import java.util.Properties;

public interface DebugProbe {
    default public boolean init() {
    }

    default public boolean cleanUp() {
    }

    default public boolean activate(byte[] byArray) {
    }

    default public boolean activate(Properties properties) {
    }

    default public boolean deactivate() {
    }

    default public boolean isActive() {
    }

    default public boolean isInitialized() {
    }

    default public boolean isInactive() {
    }

    default public void responseConfigurationRequest() {
    }
}

