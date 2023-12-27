/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.events;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public class EventDispatcherProbeConfiguration
extends AbstractDebugProbeConfiguration {
    public static final String KEY_DATAPOOL_LIST_UPDATE_EVENTS_ENABLED;
    public static final String KEY_HMI_EVENTS_ENABLED;
    public static final String KEY_INVOCATION_EVENTS_ENABLED;
    public static final String KEY_LSCHANGE_EVENTS_ENABLED;
    public static final String KEY_POWERSTATE_EVENTS_ENABLED;
    public static final String KEY_REPAINT_EVENTS_ENABLED;
    public static final String KEY_SPEECH_EVENTS_ENABLED;
    public static final String KEY_STARTUP_EVENTS_ENABLED;
    public static final String KEY_TOUCH_EVENTS_ENABLED;
    public static final String KEY_VIEWMANAGER_EVENTS_ENABLED;
    private boolean logHMIEventsEnabled;
    private boolean logSpeechEventsEnabled;
    private boolean logViewManagerEventsEnabled;
    private boolean logRepaintEventsEnabled;
    private boolean logDpAndListUpdateEventsEnabled;
    private boolean logInvocationEventsEnabled;
    private boolean logLSChangeEventsEnabled;
    private boolean logPowerStateEventsEnabled;
    private boolean logStartupEventsEnabled;
    private boolean logTouchEventsEnabled;

    @Override
    public byte getCodecVersion() {
        return -10;
    }

    @Override
    public String getDebugProbeName() {
        return "EVENTDISPATCHER";
    }

    public boolean isLogDpAndListUpdateEventsEnabled() {
        return this.logDpAndListUpdateEventsEnabled;
    }

    public boolean isLogHMIEventsEnabled() {
        return this.logHMIEventsEnabled;
    }

    public boolean isLogInvocationEventsEnabled() {
        return this.logInvocationEventsEnabled;
    }

    public boolean isLogLSChangeEventsEnabled() {
        return this.logLSChangeEventsEnabled;
    }

    public boolean isLogPowerStateEventsEnabled() {
        return this.logPowerStateEventsEnabled;
    }

    public boolean isLogRepaintEventsEnabled() {
        return this.logRepaintEventsEnabled;
    }

    public boolean isLogSpeechEventsEnabled() {
        return this.logSpeechEventsEnabled;
    }

    public boolean isLogStartupEventsEnabled() {
        return this.logStartupEventsEnabled;
    }

    public boolean isLogTouchEventsEnabled() {
        return this.logTouchEventsEnabled;
    }

    @Override
    public void load(Properties properties) {
        this.logDpAndListUpdateEventsEnabled = this.readBoolean(properties.getProperty("log.dpandlistupdateevents.enabled"));
        this.logHMIEventsEnabled = this.readBoolean(properties.getProperty("log.hmievents.enabled"));
        this.logInvocationEventsEnabled = this.readBoolean(properties.getProperty("log.invocationevents.enabled"));
        this.logLSChangeEventsEnabled = this.readBoolean(properties.getProperty("log.lschangeevents.enabled"));
        this.logPowerStateEventsEnabled = this.readBoolean(properties.getProperty("log.powerstateevents.enabled"));
        this.logRepaintEventsEnabled = this.readBoolean(properties.getProperty("log.repaintevents.enabled"));
        this.logSpeechEventsEnabled = this.readBoolean(properties.getProperty("log.speechevents.enabled"));
        this.logStartupEventsEnabled = this.readBoolean(properties.getProperty("log.startupevents.enabled"));
        this.logTouchEventsEnabled = this.readBoolean(properties.getProperty("log.touchevents.enabled"));
        this.logViewManagerEventsEnabled = this.readBoolean(properties.getProperty("log.viewmanagerevents.enabled"));
    }

    public void setLogDpAndListUpdateEventsEnabled(boolean bl) {
        this.logDpAndListUpdateEventsEnabled = bl;
    }

    public void setLogHMIEventsEnabled(boolean bl) {
        this.logHMIEventsEnabled = bl;
    }

    public void setLogInvocationEventsEnabled(boolean bl) {
        this.logInvocationEventsEnabled = bl;
    }

    public void setLogLSChangeEventsEnabled(boolean bl) {
        this.logLSChangeEventsEnabled = bl;
    }

    public void setLogPowerStateEventsEnabled(boolean bl) {
        this.logPowerStateEventsEnabled = bl;
    }

    public void setLogRepaintEventsEnabled(boolean bl) {
        this.logRepaintEventsEnabled = bl;
    }

    public void setLogSpeechEventsEnabled(boolean bl) {
        this.logSpeechEventsEnabled = bl;
    }

    public void setLogStartupEventsEnabled(boolean bl) {
        this.logStartupEventsEnabled = bl;
    }

    public void setLogTouchEventsEnabled(boolean bl) {
        this.logTouchEventsEnabled = bl;
    }

    public boolean isLogViewManagerEventsEnabled() {
        return this.logViewManagerEventsEnabled;
    }

    public void setLogViewManagerEventsEnabled(boolean bl) {
        this.logViewManagerEventsEnabled = bl;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        properties.setProperty("log.dpandlistupdateevents.enabled", Boolean.toString(this.logDpAndListUpdateEventsEnabled));
        properties.setProperty("log.hmievents.enabled", Boolean.toString(this.logHMIEventsEnabled));
        properties.setProperty("log.invocationevents.enabled", Boolean.toString(this.logInvocationEventsEnabled));
        properties.setProperty("log.lschangeevents.enabled", Boolean.toString(this.logLSChangeEventsEnabled));
        properties.setProperty("log.powerstateevents.enabled", Boolean.toString(this.logPowerStateEventsEnabled));
        properties.setProperty("log.repaintevents.enabled", Boolean.toString(this.logRepaintEventsEnabled));
        properties.setProperty("log.speechevents.enabled", Boolean.toString(this.logSpeechEventsEnabled));
        properties.setProperty("log.startupevents.enabled", Boolean.toString(this.logStartupEventsEnabled));
        properties.setProperty("log.touchevents.enabled", Boolean.toString(this.logTouchEventsEnabled));
        properties.setProperty("log.viewmanagerevents.enabled", Boolean.toString(this.logViewManagerEventsEnabled));
        return properties;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        this.logDpAndListUpdateEventsEnabled = byteArrayReader.readBoolean();
        this.logHMIEventsEnabled = byteArrayReader.readBoolean();
        this.logInvocationEventsEnabled = byteArrayReader.readBoolean();
        this.logLSChangeEventsEnabled = byteArrayReader.readBoolean();
        this.logPowerStateEventsEnabled = byteArrayReader.readBoolean();
        this.logRepaintEventsEnabled = byteArrayReader.readBoolean();
        this.logSpeechEventsEnabled = byteArrayReader.readBoolean();
        this.logStartupEventsEnabled = byteArrayReader.readBoolean();
        this.logTouchEventsEnabled = byteArrayReader.readBoolean();
        this.logViewManagerEventsEnabled = byteArrayReader.readBoolean();
    }

    @Override
    protected void writeBinaryConfiguration() {
        this.writeBoolean(this.logDpAndListUpdateEventsEnabled);
        this.writeBoolean(this.logHMIEventsEnabled);
        this.writeBoolean(this.logInvocationEventsEnabled);
        this.writeBoolean(this.logLSChangeEventsEnabled);
        this.writeBoolean(this.logPowerStateEventsEnabled);
        this.writeBoolean(this.logRepaintEventsEnabled);
        this.writeBoolean(this.logSpeechEventsEnabled);
        this.writeBoolean(this.logStartupEventsEnabled);
        this.writeBoolean(this.logTouchEventsEnabled);
        this.writeBoolean(this.logViewManagerEventsEnabled);
    }
}

