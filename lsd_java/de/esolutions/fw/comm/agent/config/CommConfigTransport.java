/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.config.CommConfigTransport$CommConfigTransportDictionary;
import de.esolutions.fw.comm.agent.config.CommConfigTransportParams;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

public class CommConfigTransport
implements IConfigValueTracer {
    private CommConfigTransport$CommConfigTransportDictionary txTransport;
    private CommConfigTransport$CommConfigTransportDictionary rxTransport;

    public CommConfigTransport(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.rxTransport = new CommConfigTransport$CommConfigTransportDictionary(this, configPathQuery.getDictionary("rx"), "rx");
            this.txTransport = new CommConfigTransport$CommConfigTransportDictionary(this, configPathQuery.getDictionary("tx"), "tx");
        } else {
            this.rxTransport = new CommConfigTransport$CommConfigTransportDictionary(this, null, "rx");
            this.txTransport = new CommConfigTransport$CommConfigTransportDictionary(this, null, "tx");
        }
    }

    public Short[] getConfiguredTxWorker() {
        return this.txTransport.getStatic().getIds();
    }

    public Short[] getConfiguredRxWorker() {
        return this.rxTransport.getStatic().getIds();
    }

    public CommConfigTransportParams getRxDefault() {
        return this.rxTransport.getDefault();
    }

    public CommConfigTransportParams getTxDefault() {
        return this.txTransport.getDefault();
    }

    public CommConfigTransportParams getRxTransportConfig(short s, boolean bl) {
        return this.getAgentTransportConfig(s, bl, this.rxTransport);
    }

    public CommConfigTransportParams getTxTransportConfig(short s, boolean bl) {
        return this.getAgentTransportConfig(s, bl, this.txTransport);
    }

    private CommConfigTransportParams getAgentTransportConfig(short s, boolean bl, CommConfigTransport$CommConfigTransportDictionary commConfigTransport$CommConfigTransportDictionary) {
        if (bl) {
            CommConfigTransportParams commConfigTransportParams = commConfigTransport$CommConfigTransportDictionary.getDynamic();
            return commConfigTransportParams;
        }
        if (commConfigTransport$CommConfigTransportDictionary.getStatic() == null) {
            return commConfigTransport$CommConfigTransportDictionary.getDefault();
        }
        CommConfigTransportParams commConfigTransportParams = commConfigTransport$CommConfigTransportDictionary.getStatic().getTransportConfigForAgent(s);
        if (commConfigTransportParams == null) {
            return commConfigTransport$CommConfigTransportDictionary.getDefault();
        }
        return commConfigTransportParams;
    }

    @Override
    public void traceValues() {
        this.rxTransport.traceValues();
        this.txTransport.traceValues();
    }
}

