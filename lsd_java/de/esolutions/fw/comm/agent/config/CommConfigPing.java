/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import java.util.ArrayList;

public class CommConfigPing
implements IConfigValueTracer {
    private int send_interval = 5000;
    private int max_recv_interval = 15000;
    private boolean start_send = true;
    private boolean check_enabled = true;
    private boolean auto_reply = false;
    private boolean all_peers = false;
    private boolean dynamic_peers = false;
    private boolean static_peers = false;
    private short[] peer_list;

    public CommConfigPing(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.send_interval = configPathQuery.getIntegerValue("send_interval", this.send_interval);
            this.max_recv_interval = configPathQuery.getIntegerValue("max_recv_interval", this.max_recv_interval);
            this.start_send = configPathQuery.getBooleanValue("start_send", this.start_send);
            this.check_enabled = configPathQuery.getBooleanValue("check_enabled", this.check_enabled);
            this.auto_reply = configPathQuery.getBooleanValue("auto_reply", this.auto_reply);
            this.parsePeerEntry(configPathQuery.getValue("peer_agent"));
        }
        if (this.peer_list != null) {
            for (int i2 = 0; i2 < this.peer_list.length; ++i2) {
                CommAgentTracing.CONFIG.log((short)2, "ping->peer                   = %1", new Short(this.peer_list[i2]));
            }
        }
    }

    private Short parsePeerKey(ConfigValue configValue) {
        Integer n;
        if (configValue.isString()) {
            String string = configValue.getString();
            if ("all".equals(string)) {
                this.all_peers = true;
            } else if ("dynamic".equals(string)) {
                this.dynamic_peers = true;
            } else if ("static".equals(string)) {
                this.static_peers = true;
            }
        } else if (configValue.isInteger() && (n = configValue.getInteger()) != null) {
            return new Short(n.shortValue());
        }
        return null;
    }

    private void parsePeerEntry(ConfigValue configValue) {
        int n;
        int n2;
        if (configValue == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (configValue.isArray()) {
            n2 = configValue.getArraySize();
            if (n2 > 0) {
                for (n = 0; n < n2; ++n) {
                    Short s = this.parsePeerKey(configValue.getArrayValue(n));
                    if (s == null) continue;
                    arrayList.add(s);
                }
            }
        } else {
            Short s = this.parsePeerKey(configValue);
            if (s != null) {
                arrayList.add(s);
            }
        }
        if (!arrayList.isEmpty()) {
            n2 = arrayList.size();
            this.peer_list = new short[n2];
            for (n = 0; n < n2; ++n) {
                this.peer_list[n] = (Short)arrayList.get(n);
            }
        }
    }

    public int getSendInterval() {
        return this.send_interval;
    }

    public int getMaxRecvInterval() {
        return this.max_recv_interval;
    }

    public boolean getStartSend() {
        return this.start_send;
    }

    public boolean getCheckEnabled() {
        return this.check_enabled;
    }

    public boolean getAutoReply() {
        return this.auto_reply;
    }

    public boolean getAllPeers() {
        return this.all_peers;
    }

    public boolean getDynamicPeers() {
        return this.dynamic_peers;
    }

    public boolean getStaticPeers() {
        return this.static_peers;
    }

    public short[] getPeerList() {
        return this.peer_list;
    }

    @Override
    public void traceValues() {
        CommAgentTracing.CONFIG.log((short)2, "ping.send_interval           = %1 ms", new Integer(this.send_interval));
        CommAgentTracing.CONFIG.log((short)2, "ping.max_recv_interval       = %1 ms", new Integer(this.max_recv_interval));
        CommAgentTracing.CONFIG.log((short)2, "ping.start_send              = %1", new Boolean(this.start_send));
        CommAgentTracing.CONFIG.log((short)2, "ping.check_enabled          = %1", new Boolean(this.check_enabled));
        CommAgentTracing.CONFIG.log((short)2, "ping.auto_reply             = %1", new Boolean(this.auto_reply));
        CommAgentTracing.CONFIG.log((short)2, "ping->all_peers             = %1", new Boolean(this.all_peers));
        CommAgentTracing.CONFIG.log((short)2, "ping->dynamic_peers         = %1", new Boolean(this.dynamic_peers));
        CommAgentTracing.CONFIG.log((short)2, "ping->static_peers          = %1", new Boolean(this.static_peers));
    }
}

