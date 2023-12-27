/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.timer;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public class TimerProbeConfiguration
extends AbstractDebugProbeConfiguration {
    public static final String KEY_TRACE_TIMER_CONFIGURATION;
    public static final String KEY_TRACE_TIMER_CONTROLLING;
    public static final String KEY_TRACE_TIMER_CREATION;
    public static final String KEY_TRACE_TIMER_EXECUTION;
    public static final String KEY_TRACE_TIMER_THREAD_UPDATES;
    private boolean traceTimerConfiguration = false;
    private boolean traceTimerControlling = false;
    private boolean traceTimerCreation = false;
    private boolean traceTimerExecution = false;
    private boolean traceTimerThreadUpdates = false;

    @Override
    public byte getCodecVersion() {
        return -3;
    }

    @Override
    public String getDebugProbeName() {
        return "TIMER";
    }

    public boolean isTraceTimerConfiguration() {
        return this.traceTimerConfiguration;
    }

    public boolean isTraceTimerControlling() {
        return this.traceTimerControlling;
    }

    public boolean isTraceTimerCreation() {
        return this.traceTimerCreation;
    }

    public boolean isTraceTimerExecution() {
        return this.traceTimerExecution;
    }

    public boolean isTraceTimerThreadUpdates() {
        return this.traceTimerThreadUpdates;
    }

    @Override
    public void load(Properties properties) {
        this.traceTimerConfiguration = this.readBoolean(properties.getProperty("trace.timer.configuration"));
        this.traceTimerControlling = this.readBoolean(properties.getProperty("trace.timer.controlling"));
        this.traceTimerCreation = this.readBoolean(properties.getProperty("trace.timer.creation"));
        this.traceTimerExecution = this.readBoolean(properties.getProperty("trace.timer.execution"));
        this.traceTimerThreadUpdates = this.readBoolean(properties.getProperty("trace.timer.updates"));
    }

    public void setTraceTimerConfiguration(boolean bl) {
        this.traceTimerConfiguration = bl;
    }

    public void setTraceTimerControlling(boolean bl) {
        this.traceTimerControlling = bl;
    }

    public void setTraceTimerCreation(boolean bl) {
        this.traceTimerCreation = bl;
    }

    public void setTraceTimerExecution(boolean bl) {
        this.traceTimerExecution = bl;
    }

    public void setTraceTimerThreadUpdates(boolean bl) {
        this.traceTimerThreadUpdates = bl;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        properties.setProperty("trace.timer.configuration", Boolean.toString(this.traceTimerConfiguration));
        properties.setProperty("trace.timer.controlling", Boolean.toString(this.traceTimerControlling));
        properties.setProperty("trace.timer.creation", Boolean.toString(this.traceTimerCreation));
        properties.setProperty("trace.timer.execution", Boolean.toString(this.traceTimerExecution));
        properties.setProperty("trace.timer.updates", Boolean.toString(this.traceTimerThreadUpdates));
        return properties;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        this.traceTimerConfiguration = byteArrayReader.readBoolean();
        this.traceTimerControlling = byteArrayReader.readBoolean();
        this.traceTimerCreation = byteArrayReader.readBoolean();
        this.traceTimerExecution = byteArrayReader.readBoolean();
        this.traceTimerThreadUpdates = byteArrayReader.readBoolean();
    }

    @Override
    protected void writeBinaryConfiguration() {
        this.writeBoolean(this.traceTimerConfiguration);
        this.writeBoolean(this.traceTimerControlling);
        this.writeBoolean(this.traceTimerCreation);
        this.writeBoolean(this.traceTimerExecution);
        this.writeBoolean(this.traceTimerThreadUpdates);
    }
}

