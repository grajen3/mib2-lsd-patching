/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.dsimethodcall;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public final class DsiMethodCallProbeConfiguration
extends AbstractDebugProbeConfiguration {
    @Override
    public byte getCodecVersion() {
        return -7;
    }

    @Override
    public String getDebugProbeName() {
        return "DSIEVENTS";
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

