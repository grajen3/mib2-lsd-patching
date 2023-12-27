/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.datapool;

import de.vw.mib.debug.common.core.ByteArrayReader;
import de.vw.mib.debug.common.probes.configuration.AbstractDebugProbeConfiguration;
import java.util.Properties;

public class DatapoolProbeConfiguration
extends AbstractDebugProbeConfiguration {
    public static final String KEY_CHANGE_REQUESTS_ENABLED;
    public static final String KEY_CHANGE_REQUESTS_WITHVALUE_ENABLED;
    public static final String KEY_VALUE_CHANGED_ENABLED;
    public static final String KEY_VALUE_CHANGED_WITHVALUE_ENABLED;
    private boolean logChangeRequestsEnabled;
    private boolean logChangeRequestsWithValueAsStringEnabled;
    private boolean logValueChangedEnabled;
    private boolean logValueChangedWithValueAsStringEnabled;

    @Override
    public byte getCodecVersion() {
        return -6;
    }

    @Override
    public String getDebugProbeName() {
        return "DATAPOOL";
    }

    public boolean isLogChangeRequestsEnabled() {
        return this.logChangeRequestsEnabled;
    }

    public boolean isLogChangeRequestsWithValueAsStringEnabled() {
        return this.logChangeRequestsWithValueAsStringEnabled;
    }

    public boolean isLogValueChangedEnabled() {
        return this.logValueChangedEnabled;
    }

    public boolean isLogValueChangedWithValueAsStringEnabled() {
        return this.logValueChangedWithValueAsStringEnabled;
    }

    @Override
    public void load(Properties properties) {
        this.logChangeRequestsEnabled = this.readBoolean(properties.getProperty("log.changerequests.enabled"));
        this.logChangeRequestsWithValueAsStringEnabled = this.readBoolean(properties.getProperty("log.changerequests.withvalue.enabled"));
        this.logValueChangedEnabled = this.readBoolean(properties.getProperty("log.valuechanged.enabled"));
        this.logValueChangedWithValueAsStringEnabled = this.readBoolean(properties.getProperty("log.valuechanged.withvalue.enabled"));
    }

    public void setLogChangeRequestsEnabled(boolean bl, boolean bl2) {
        this.logChangeRequestsEnabled = bl;
        this.logChangeRequestsWithValueAsStringEnabled = bl2;
    }

    public void setLogValueChangedEnabled(boolean bl, boolean bl2) {
        this.logValueChangedEnabled = bl;
        this.logValueChangedWithValueAsStringEnabled = bl2;
    }

    @Override
    public Properties storeToProperties() {
        Properties properties = new Properties();
        properties.setProperty("log.changerequests.enabled", Boolean.toString(this.logChangeRequestsEnabled));
        properties.setProperty("log.changerequests.withvalue.enabled", Boolean.toString(this.logChangeRequestsWithValueAsStringEnabled));
        properties.setProperty("log.valuechanged.enabled", Boolean.toString(this.logValueChangedEnabled));
        properties.setProperty("log.valuechanged.withvalue.enabled", Boolean.toString(this.logValueChangedWithValueAsStringEnabled));
        return properties;
    }

    @Override
    protected void readBinaryConfiguration(ByteArrayReader byteArrayReader) {
        this.logChangeRequestsEnabled = byteArrayReader.readBoolean();
        this.logChangeRequestsWithValueAsStringEnabled = byteArrayReader.readBoolean();
        this.logValueChangedEnabled = byteArrayReader.readBoolean();
        this.logValueChangedWithValueAsStringEnabled = byteArrayReader.readBoolean();
    }

    @Override
    protected void writeBinaryConfiguration() {
        this.writeBoolean(this.logChangeRequestsEnabled);
        this.writeBoolean(this.logChangeRequestsWithValueAsStringEnabled);
        this.writeBoolean(this.logValueChangedEnabled);
        this.writeBoolean(this.logValueChangedWithValueAsStringEnabled);
    }
}

