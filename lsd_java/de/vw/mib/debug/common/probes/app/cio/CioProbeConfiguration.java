/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.app.cio;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public class CioProbeConfiguration
extends AbstractDebugProbeConfiguration {
    @Override
    public String getDebugProbeName() {
        return "CIO";
    }

    @Override
    public byte getCodecVersion() {
        return -1;
    }

    @Override
    public void load(Properties properties) {
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        return properties;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
    }

    @Override
    protected void writeBinaryConfiguration() {
    }
}

