/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.viewmanager;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public class ViewManagerProbeConfiguration
extends AbstractDebugProbeConfiguration {
    @Override
    public byte getCodecVersion() {
        return -4;
    }

    @Override
    public String getDebugProbeName() {
        return "VIEWMANAGER";
    }

    @Override
    public void load(Properties properties) {
    }

    @Override
    public Properties storeToProperties() {
        return new Properties();
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
    }

    @Override
    protected void writeBinaryConfiguration() {
    }
}

