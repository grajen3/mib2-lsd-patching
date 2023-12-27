/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

public class CommConfigTracing
implements IConfigValueTracer {
    private boolean enabled = true;
    private byte version = 1;
    private byte flags = 0;
    private int truncatePayloadSize = 1024;

    public CommConfigTracing(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.enabled = configPathQuery.getBooleanValue("enabled", this.enabled);
            this.version = (byte)configPathQuery.getIntegerValue("version", this.version);
            this.flags = (byte)configPathQuery.getIntegerValue("flags", this.flags);
            this.truncatePayloadSize = configPathQuery.getIntegerValue("truncateSize", this.truncatePayloadSize);
        }
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public byte getVersion() {
        return this.version;
    }

    public byte getFlags() {
        return this.flags;
    }

    public int getTruncatePayloadSize() {
        return this.truncatePayloadSize;
    }

    @Override
    public void traceValues() {
        CommAgentTracing.CONFIG.log((short)2, "tracing.version     = %1 ms", new Byte(this.version));
        CommAgentTracing.CONFIG.log((short)2, "tracing.flags       = %1", new Byte(this.flags));
        CommAgentTracing.CONFIG.log((short)2, "tracing.truncateSize= %1", new Integer(this.truncatePayloadSize));
    }
}

