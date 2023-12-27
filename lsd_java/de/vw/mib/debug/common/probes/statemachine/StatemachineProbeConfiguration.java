/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.statemachine;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public final class StatemachineProbeConfiguration
extends AbstractDebugProbeConfiguration {
    public static final String KEY_STATEMACHINE_INFOS_ENABLED;
    public static final String KEY_STATEMACHINE_TRACES_ENABLED;
    private boolean infoEnabled = false;
    private boolean traceEnabled = false;

    @Override
    public byte getCodecVersion() {
        return -6;
    }

    @Override
    public String getDebugProbeName() {
        return "STATEMACHINE";
    }

    public boolean isInfoEnabled() {
        return this.infoEnabled;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    @Override
    public void load(Properties properties) {
        this.infoEnabled = this.readBoolean(properties.getProperty("statemachine.infos.enabled"));
        this.traceEnabled = this.readBoolean(properties.getProperty("statemachine.traces.enabled"));
    }

    public void setInfoEnabled(boolean bl) {
        this.infoEnabled = bl;
    }

    public void setTraceEnabled(boolean bl) {
        this.traceEnabled = bl;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        properties.setProperty("statemachine.infos.enabled", Boolean.toString(this.infoEnabled));
        properties.setProperty("statemachine.traces.enabled", Boolean.toString(this.traceEnabled));
        return properties;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        this.infoEnabled = byteArrayReader.readBoolean();
        this.traceEnabled = byteArrayReader.readBoolean();
    }

    @Override
    protected void writeBinaryConfiguration() {
        this.writeBoolean(this.infoEnabled);
        this.writeBoolean(this.traceEnabled);
    }
}

