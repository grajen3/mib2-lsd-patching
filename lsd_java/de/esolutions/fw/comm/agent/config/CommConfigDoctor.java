/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

public class CommConfigDoctor
implements IConfigValueTracer {
    private boolean enabled = true;
    private String host = "localhost";
    private int port = 21021;
    private boolean infoProviderEnabled = true;

    public CommConfigDoctor(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.enabled = configPathQuery.getBooleanValue("enabled", true);
            this.host = configPathQuery.getStringValue("host", "localhost");
            this.port = configPathQuery.getIntegerValue("port", 21021);
            this.infoProviderEnabled = configPathQuery.getBooleanValue("useInfoProvider", true);
        }
    }

    public boolean isInfoProviderEnabled() {
        return this.infoProviderEnabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    @Override
    public void traceValues() {
        CommAgentTracing.CONFIG.log((short)2, "doctor.enabled     = %1 ms", new Boolean(this.enabled));
        CommAgentTracing.CONFIG.log((short)2, "doctor.host        = %1", (Object)this.host);
        CommAgentTracing.CONFIG.log((short)2, "doctor.port        = %1 ms", new Integer(this.port));
    }
}

