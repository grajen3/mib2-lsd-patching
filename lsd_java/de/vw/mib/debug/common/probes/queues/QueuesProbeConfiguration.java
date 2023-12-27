/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.queues;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public final class QueuesProbeConfiguration
extends AbstractDebugProbeConfiguration {
    public static final String KEY_STATEMACHINEEVENTQUEUE_ENABLED;
    public static final String KEY_SYSTEMEVENTQUEUE_ENABLED;
    public static final String KEY_VIEWEVENTQUEUE_ENABLED;
    private boolean monitorStatemachineEventQueueEnabled = true;
    private boolean monitorSystemEventQueueEnabled = true;
    private boolean monitorViewEventQueueEnabled = true;

    @Override
    public byte getCodecVersion() {
        return -4;
    }

    @Override
    public String getDebugProbeName() {
        return "QUEUES";
    }

    public boolean isMonitorStatemachineEventQueueEnabled() {
        return this.monitorStatemachineEventQueueEnabled;
    }

    public boolean isMonitorSystemEventQueueEnabled() {
        return this.monitorSystemEventQueueEnabled;
    }

    public boolean isMonitorViewEventQueueEnabled() {
        return this.monitorViewEventQueueEnabled;
    }

    @Override
    public void load(Properties properties) {
        this.monitorStatemachineEventQueueEnabled = this.readBoolean(properties.getProperty("monitor.statemachineeventqueue.enabled"));
        this.monitorSystemEventQueueEnabled = this.readBoolean(properties.getProperty("monitor.systemeventqueue.enabled"));
        this.monitorViewEventQueueEnabled = this.readBoolean(properties.getProperty("monitor.vieweventqueue.enabled"));
    }

    public void setMonitorStatemachineEventQueueEnabled(boolean bl) {
        this.monitorStatemachineEventQueueEnabled = bl;
    }

    public void setMonitorSystemEventQueueEnabled(boolean bl) {
        this.monitorSystemEventQueueEnabled = bl;
    }

    public void setMonitorViewEventQueueEnabled(boolean bl) {
        this.monitorViewEventQueueEnabled = bl;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        properties.setProperty("monitor.statemachineeventqueue.enabled", Boolean.toString(this.monitorStatemachineEventQueueEnabled));
        properties.setProperty("monitor.systemeventqueue.enabled", Boolean.toString(this.monitorSystemEventQueueEnabled));
        properties.setProperty("monitor.vieweventqueue.enabled", Boolean.toString(this.monitorViewEventQueueEnabled));
        return properties;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        this.monitorStatemachineEventQueueEnabled = byteArrayReader.readBoolean();
        this.monitorSystemEventQueueEnabled = byteArrayReader.readBoolean();
        this.monitorViewEventQueueEnabled = byteArrayReader.readBoolean();
    }

    @Override
    protected void writeBinaryConfiguration() {
        this.writeBoolean(this.monitorStatemachineEventQueueEnabled);
        this.writeBoolean(this.monitorSystemEventQueueEnabled);
        this.writeBoolean(this.monitorViewEventQueueEnabled);
    }
}

