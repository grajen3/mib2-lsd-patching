/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

import java.util.Properties;

public interface DebugProbeConfiguration {
    default public String getDebugProbeName() {
    }

    default public void load(byte[] byArray) {
    }

    default public void load(Properties properties) {
    }

    default public byte[] storeToByteArray() {
    }

    default public Properties storeToProperties() {
    }
}

