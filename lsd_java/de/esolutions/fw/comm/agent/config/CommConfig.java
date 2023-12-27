/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.config.CommConfigDoctor;
import de.esolutions.fw.comm.agent.config.CommConfigDynamicAgentIDs;
import de.esolutions.fw.comm.agent.config.CommConfigPing;
import de.esolutions.fw.comm.agent.config.CommConfigPriorities;
import de.esolutions.fw.comm.agent.config.CommConfigTracing;
import de.esolutions.fw.comm.agent.config.CommConfigTransport;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.fw.FrameworkConfigProvider;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import java.util.Map;

public class CommConfig
implements IConfigValueTracer {
    private static CommConfig configInstance;
    private String failString;
    private boolean isValid = true;
    protected int cmd_drop_timeout = -527236096;
    protected int cmd_retry_count = 10;
    protected int cmd_time_pulse = 5000;
    protected int cmd_time_alive = 1625948160;
    protected int cmd_queue_size = 1024;
    protected int proxy_pool_size = 256;
    protected int stub_pool_size = 256;
    protected int protocol_version = 5;
    protected int svc_call_queue_size = 32;
    protected int svc_call_timeout = 30000;
    protected int notify_timeout = 30000;
    protected int notify_queue_size = 1024;
    protected boolean svc_lazy_start = false;
    protected boolean ignore_ik = false;
    protected boolean use_broker = true;
    protected int broker_connect_retries = 0;
    protected boolean use_proxy_alive = true;
    protected int proxy_alive_timeout = 10000;
    protected int trace_peer = 0;
    protected int error_log_size = 100;
    protected boolean enableMemWatch = true;
    protected int checkLowMemKiB = 200;
    protected int checkCriticalMemKiB = 50;
    protected int checkMemMinDuration = 10;
    protected int min_connect_interval = 250;
    protected int client_dispatch_wd = 5000;
    protected int client_dispatch_kill_delay = 20000;
    protected boolean killOnFatalError = true;
    protected int fatalErrorOnCriticalMem = 30;
    protected int fatalErrorOnLowMem = 60;
    private CommConfigPriorities prios = new CommConfigPriorities(null);
    private CommConfigDoctor doctor = new CommConfigDoctor(null);
    private CommConfigPing ping = new CommConfigPing(null);
    private CommConfigDynamicAgentIDs dynAgentIds = new CommConfigDynamicAgentIDs(null);
    private CommConfigTransport transport = new CommConfigTransport(null);
    private CommConfigTracing tracing = new CommConfigTracing(null);

    public static synchronized CommConfig getInstance() {
        if (configInstance == null) {
            configInstance = new CommConfig();
            SystemConfig systemConfig = SystemConfig.getInstance();
            if (!systemConfig.isValid()) {
                configInstance.setFailed(new StringBuffer().append("can't get system config: ").append(systemConfig.getFailString()).toString());
            } else if (configInstance.load(systemConfig.getFrameworkConfigProvider())) {
                configInstance.traceValues();
            }
        }
        return configInstance;
    }

    public void setFailed(String string) {
        this.isValid = false;
        this.failString = string;
    }

    public boolean load(FrameworkConfigProvider frameworkConfigProvider) {
        this.isValid = false;
        IConfigQuery iConfigQuery = frameworkConfigProvider.getPathQuery();
        if (iConfigQuery == null) {
            this.failString = new StringBuffer().append("can't get query for fw config: ").append(frameworkConfigProvider.getFailString()).toString();
            return false;
        }
        this.isValid = true;
        ConfigValue configValue = iConfigQuery.getDictionary("comm_settings.java");
        if (configValue != null) {
            this.parseFromDictionary(configValue);
        }
        if ((configValue = iConfigQuery.getDictionary("comm_settings.dyn_agent_ids")) != null) {
            this.dynAgentIds = new CommConfigDynamicAgentIDs(configValue);
        }
        if ((configValue = iConfigQuery.getDictionary("comm_settings.ping")) != null) {
            this.ping = new CommConfigPing(configValue);
        }
        if ((configValue = iConfigQuery.getDictionary("comm_settings.tracing")) != null) {
            this.tracing = new CommConfigTracing(configValue);
        }
        return true;
    }

    public void parseFromDictionary(ConfigValue configValue) {
        ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
        this.cmd_drop_timeout = configPathQuery.getIntegerValue("cmd_drop_timeout", this.cmd_drop_timeout);
        this.cmd_retry_count = configPathQuery.getIntegerValue("cmd_retry_count", this.cmd_retry_count);
        this.cmd_time_pulse = configPathQuery.getIntegerValue("cmd_time_pulse", this.cmd_time_pulse);
        this.cmd_time_alive = configPathQuery.getIntegerValue("cmd_time_alive", this.cmd_time_alive);
        this.cmd_queue_size = configPathQuery.getIntegerValue("cmd_queue_size", this.cmd_queue_size);
        this.proxy_pool_size = configPathQuery.getIntegerValue("proxy_pool_size", this.proxy_pool_size);
        this.stub_pool_size = configPathQuery.getIntegerValue("stub_pool_size", this.stub_pool_size);
        this.protocol_version = configPathQuery.getIntegerValue("protocol_version", this.protocol_version);
        this.svc_call_queue_size = configPathQuery.getIntegerValue("svc_call_queue_size", this.svc_call_queue_size);
        this.svc_call_timeout = configPathQuery.getIntegerValue("svc_call_timeout", this.svc_call_timeout);
        this.svc_lazy_start = configPathQuery.getBooleanValue("svc_lazy_start", this.svc_lazy_start);
        this.notify_timeout = configPathQuery.getIntegerValue("notify_timeout", this.notify_timeout);
        this.notify_queue_size = configPathQuery.getIntegerValue("notify_queue_size", this.notify_queue_size);
        this.ignore_ik = configPathQuery.getBooleanValue("ignore_ik", this.ignore_ik);
        this.use_broker = configPathQuery.getBooleanValue("use_broker", this.use_broker);
        this.broker_connect_retries = configPathQuery.getIntegerValue("broker_connect_retries", this.broker_connect_retries);
        this.use_proxy_alive = configPathQuery.getBooleanValue("use_proxy_alive", this.use_proxy_alive);
        this.proxy_alive_timeout = configPathQuery.getIntegerValue("proxy_alive_timeout", this.proxy_alive_timeout);
        this.trace_peer = configPathQuery.getIntegerValue("trace_peer", this.trace_peer);
        this.error_log_size = configPathQuery.getIntegerValue("error_log_size", this.error_log_size);
        this.enableMemWatch = configPathQuery.getBooleanValue("enableMemWatch", this.enableMemWatch);
        this.checkLowMemKiB = configPathQuery.getIntegerValue("checkLowMemKiB", this.checkLowMemKiB);
        this.checkCriticalMemKiB = configPathQuery.getIntegerValue("checkCriticalMemKiB", this.checkCriticalMemKiB);
        this.checkMemMinDuration = configPathQuery.getIntegerValue("checkMemMinDuration", this.checkMemMinDuration);
        this.min_connect_interval = configPathQuery.getIntegerValue("min_connect_interval", this.min_connect_interval);
        this.client_dispatch_wd = configPathQuery.getIntegerValue("client_dispatch_wd", this.client_dispatch_wd);
        this.client_dispatch_kill_delay = configPathQuery.getIntegerValue("client_dispatch_kill_delay", this.client_dispatch_kill_delay);
        this.killOnFatalError = configPathQuery.getBooleanValue("killOnFatalError", this.killOnFatalError);
        this.fatalErrorOnCriticalMem = configPathQuery.getIntegerValue("fatalErrorOnCriticalMem", this.fatalErrorOnCriticalMem);
        this.fatalErrorOnLowMem = configPathQuery.getIntegerValue("fatalErrorOnLowMem", this.fatalErrorOnLowMem);
        this.prios = new CommConfigPriorities(configPathQuery.getDictionary("priorities"));
        this.doctor = new CommConfigDoctor(configPathQuery.getDictionary("doctor"));
        this.transport = new CommConfigTransport(configPathQuery.getDictionary("transport"));
        this.tracing = new CommConfigTracing(configPathQuery.getDictionary("tracing"));
    }

    @Override
    public void traceValues() {
        CommAgentTracing.CONFIG.log((short)2, "cmd_drop_timeout   = %1 ms", new Integer(this.cmd_drop_timeout));
        CommAgentTracing.CONFIG.log((short)2, "cmd_retry_count    = %1", new Integer(this.cmd_retry_count));
        CommAgentTracing.CONFIG.log((short)2, "cmd_time_pulse     = %1 ms", new Integer(this.cmd_time_pulse));
        CommAgentTracing.CONFIG.log((short)2, "cmd_time_alive     = %1 ms", new Integer(this.cmd_time_alive));
        CommAgentTracing.CONFIG.log((short)2, "cmd_queue_size     = %1 entries", new Integer(this.cmd_queue_size));
        CommAgentTracing.CONFIG.log((short)2, "proxy_pool_size    = %1 entries", new Integer(this.proxy_pool_size));
        CommAgentTracing.CONFIG.log((short)2, "stub_pool_size     = %1 entries", new Integer(this.stub_pool_size));
        CommAgentTracing.CONFIG.log((short)2, "protocol_version   = %1", new Integer(this.protocol_version));
        CommAgentTracing.CONFIG.log((short)2, "svc_call_queue_size= %1", new Integer(this.svc_call_queue_size));
        CommAgentTracing.CONFIG.log((short)2, "svc_call_timeout   = %1", new Integer(this.svc_call_timeout));
        CommAgentTracing.CONFIG.log((short)2, "svc_lazy_start     = %1", new Boolean(this.svc_lazy_start));
        CommAgentTracing.CONFIG.log((short)2, "notify_timeout     = %1", new Integer(this.notify_timeout));
        CommAgentTracing.CONFIG.log((short)2, "notify_queue_size  = %1", new Integer(this.notify_queue_size));
        CommAgentTracing.CONFIG.log((short)2, "ignore_ik          = %1", new Boolean(this.ignore_ik));
        CommAgentTracing.CONFIG.log((short)2, "use_broker         = %1", new Boolean(this.use_broker));
        CommAgentTracing.CONFIG.log((short)2, "broker_connect_retries = %1", new Integer(this.broker_connect_retries));
        CommAgentTracing.CONFIG.log((short)2, "use_proxy_alive    = %1", new Boolean(this.use_proxy_alive));
        CommAgentTracing.CONFIG.log((short)2, "proxy_alive_timeout= %1", new Integer(this.proxy_alive_timeout));
        CommAgentTracing.CONFIG.log((short)2, "trace_peer         = %1", new Integer(this.trace_peer));
        CommAgentTracing.CONFIG.log((short)2, "error_log_size     = %1", new Integer(this.error_log_size));
        CommAgentTracing.CONFIG.log((short)2, "enableMemWatch     = %1", new Boolean(this.enableMemWatch));
        CommAgentTracing.CONFIG.log((short)2, "checkLowMemKiB     = %1", new Integer(this.checkLowMemKiB));
        CommAgentTracing.CONFIG.log((short)2, "checkCriticalMemKiB= %1", new Integer(this.checkCriticalMemKiB));
        CommAgentTracing.CONFIG.log((short)2, "checkMemMinDuration= %1", new Integer(this.checkMemMinDuration));
        CommAgentTracing.CONFIG.log((short)2, "min_connect_interval=%1", new Integer(this.min_connect_interval));
        CommAgentTracing.CONFIG.log((short)2, "client_dispatch_wd  =%1", new Integer(this.client_dispatch_wd));
        CommAgentTracing.CONFIG.log((short)2, "client_dispatch_kill_delay =%1", new Integer(this.client_dispatch_kill_delay));
        CommAgentTracing.CONFIG.log((short)2, "killOnFatalError    =%1", new Boolean(this.killOnFatalError));
        CommAgentTracing.CONFIG.log((short)2, "fatalErrorOnCriticalMem=%1", new Integer(this.fatalErrorOnCriticalMem));
        CommAgentTracing.CONFIG.log((short)2, "fatalErrorOnLowMem  =%1", new Integer(this.fatalErrorOnLowMem));
        this.transport.traceValues();
        this.doctor.traceValues();
        this.prios.traceValues();
        this.dynAgentIds.traceValues();
        this.ping.traceValues();
        this.tracing.traceValues();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getFailString() {
        return this.failString;
    }

    public int getCommandDropTimeout() {
        return this.cmd_drop_timeout;
    }

    public int getCommandRetryCount() {
        return this.cmd_retry_count;
    }

    public int getCommandTimePulse() {
        return this.cmd_time_pulse;
    }

    public int getCommandTimeAlive() {
        return this.cmd_time_alive;
    }

    public int getCommandQueueSize() {
        return this.cmd_queue_size;
    }

    public int getProxyPoolSize() {
        return this.proxy_pool_size;
    }

    public int getStubPoolSize() {
        return this.stub_pool_size;
    }

    public int getProtocolVersion() {
        return this.protocol_version;
    }

    public int getCallQueueSize() {
        return this.svc_call_queue_size;
    }

    public int getCallTimeout() {
        return this.svc_call_timeout;
    }

    public int getNotifyTimeout() {
        return this.notify_timeout;
    }

    public int getNotifyQueueSize() {
        return this.notify_queue_size;
    }

    public boolean getServiceLazyStart() {
        return this.svc_lazy_start;
    }

    public boolean getIgnoreIK() {
        return this.ignore_ik;
    }

    public boolean getUseBroker() {
        return this.use_broker;
    }

    public int getBrokerConnectRetries() {
        return this.broker_connect_retries;
    }

    public Map getAllStaticServices() {
        return null;
    }

    public boolean getUseProxyAlive() {
        return this.use_proxy_alive;
    }

    public int getProxyAliveTimeout() {
        return this.proxy_alive_timeout;
    }

    public CommConfigPriorities getPriorities() {
        return this.prios;
    }

    public int getTracePeer() {
        return this.trace_peer;
    }

    public int getErrorLogSize() {
        return this.error_log_size;
    }

    public boolean getEnableMemWatch() {
        return this.enableMemWatch;
    }

    public int getCheckLowMemKiB() {
        return this.checkLowMemKiB;
    }

    public int getCheckCriticalMemKiB() {
        return this.checkCriticalMemKiB;
    }

    public int getCheckMemMinDuration() {
        return this.checkMemMinDuration;
    }

    public int getMinConnectInterval() {
        return this.min_connect_interval;
    }

    public int getClientDispatchWD() {
        return this.client_dispatch_wd;
    }

    public int getClientDispatchKillDelay() {
        return this.client_dispatch_kill_delay;
    }

    public CommConfigDoctor getDoctorConfig() {
        return this.doctor;
    }

    public CommConfigPing getPingConfig() {
        return this.ping;
    }

    public boolean getKillOnFatalError() {
        return this.killOnFatalError;
    }

    public int getFatalErrorOnCriticalMem() {
        return this.fatalErrorOnCriticalMem;
    }

    public int getFatalErrorOnLowMem() {
        return this.fatalErrorOnLowMem;
    }

    public CommConfigDynamicAgentIDs getDynamicAgentIdsConfig() {
        return this.dynAgentIds;
    }

    public CommConfigTransport getTransport() {
        return this.transport;
    }

    public CommConfigTracing getTracing() {
        return this.tracing;
    }
}

