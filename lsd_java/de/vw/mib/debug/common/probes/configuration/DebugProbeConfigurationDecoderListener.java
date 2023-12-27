/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

public interface DebugProbeConfigurationDecoderListener {
    default public void probeConfigurationBinaryDecoded(String string, byte[] byArray) {
    }

    default public void probeConfigurationPropertiesDecoded(byte[] byArray) {
    }

    default public void requestConfigurationDecoded(String string) {
    }

    default public void probeManagerConfigurationDecoded(byte[] byArray) {
    }

    default public void probeRequestProbemanagerActiveDecoded() {
    }
}

