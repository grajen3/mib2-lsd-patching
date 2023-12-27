/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.config;

import de.esolutions.fw.dsi.config.AdapterConfig$ServiceInfo;
import de.esolutions.fw.dsi.config.AdapterConfigProvider;
import de.esolutions.fw.dsi.tracing.Channels;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.IConfigQuery;
import java.util.HashMap;

public class AdapterConfig {
    private static final String KEY_THROW_DSIEXCEPTIONS;
    private static final String KEY_SERVICE_MANAGER;
    private static final String KEY_SERVICES;
    private static final String KEY_BLACKLIST_SERVICES;
    private static final String KEY_SERVICE_INTERFACE;
    private static final String KEY_SERVICE_INSTANCE;
    private static final String KEY_SERVICE_EARLY_STARTUP;
    private static final String KEY_SERVICE_EARLY_REGISTRATION;
    private static final String KEY_SERVICE_DISPATCHER_NAME;
    private static final String KEY_MAX_FAST_RECONNECTS;
    private static final String KEY_USE_LOCAL_LISTENER_LIST;
    private static final String KEY_SLOW_RECONNECT_TIMEOUT_START_VAL;
    private static final String KEY_SLOW_RECONNECT_TIMEOUT_END_VAL;
    private static final String KEY_ERROR_SIZE_LOG;
    private static final String KEY_USE_SIMPLE_WORKER;
    public static final String SERVICE_MANAGER_DSIBoot;
    public static final String SERVICE_MANAGER_JDSIAdmin;
    public static final String SERVICE_MANAGER_ServiceAdmin;
    public static final boolean DEFAULT_THROW_DSIEXCEPTIONS;
    public static final String DEFAULT_SERVICE_MANAGER;
    public static final String DEFAULT_SERVICE_INTERFACE;
    public static final int DEFAULT_SERVICE_INSTANCE;
    public static final boolean DEFAULT_SERVICE_EARLY_STARTUP;
    public static final boolean DEFAULT_SERVICE_EARLY_REGISTRATION;
    public static final boolean DEFAULT_USE_LOCAL_LISTENER_LIST;
    public static final String DEFAULT_SERVICE_DISPATCHER_NAME;
    public static final int DEFAULT_ERROR_SIZE_LOG;
    public static final boolean DEFAULT_USE_SIMPLE_WORKER;
    private static final int DEFAULT_MAX_FAST_RECONNECTS;
    private static final int DEFAULT_SLOW_RECONNECT_TIMEOUT_START_VAL;
    private static final int DEFAULT_SLOW_RECONNECT_TIMEOUT_END_VAL;
    private boolean throwDSIExceptions = false;
    private String serviceManager = "ServiceAdmin";
    private AdapterConfig$ServiceInfo[] serviceInfos = null;
    private HashMap dispatcherNames = new HashMap();
    private int maxFastsReconnects = 10;
    private int slowReconnectTimeoutStartVal = 1000;
    private int slowReconnectTimeoutEndVal = 10000;
    private boolean useLocalListenerList = true;
    private int errorLogSize = 100;
    private boolean useSimplerWorker = false;
    private String[] serviceBlacklist = new String[0];
    private static AdapterConfig configInstance;
    private AdapterConfigProvider configProvider;

    public static AdapterConfig getInstance() {
        if (configInstance == null) {
            configInstance = new AdapterConfig();
        }
        return configInstance;
    }

    private AdapterConfig() {
        Channels.CONFIG.log((short)0, "+ AdapterConfig");
        this.configProvider = AdapterConfigProvider.getInstance();
        if (this.configProvider.isValid()) {
            this.loadValues();
        } else {
            Channels.CONFIG.log((short)4, "Couldn't create valid adapter config: %1", (Object)this.configProvider.getFailString());
        }
        Channels.CONFIG.log((short)0, "- AdapterConfig");
    }

    private void loadValues() {
        ConfigValue configValue;
        int n;
        IConfigQuery iConfigQuery = this.configProvider.getPathQuery();
        this.useLocalListenerList = iConfigQuery.getBooleanValue("useLocalListenerList", true);
        this.maxFastsReconnects = iConfigQuery.getIntegerValue("maxFastReconnects", 10);
        this.slowReconnectTimeoutEndVal = iConfigQuery.getIntegerValue("slowReconnectTimeoutEndVal", 10000);
        this.slowReconnectTimeoutStartVal = iConfigQuery.getIntegerValue("slowReconnectTimeoutStartVal", 1000);
        this.throwDSIExceptions = iConfigQuery.getBooleanValue("throwDSIExceptions", false);
        this.serviceManager = iConfigQuery.getStringValue("serviceManager", "ServiceAdmin");
        this.errorLogSize = iConfigQuery.getIntegerValue("errorSizeLog", 100);
        this.useSimplerWorker = iConfigQuery.getBooleanValue("useSimpleWorker", false);
        ConfigValue configValue2 = iConfigQuery.getArray("blacklist_services");
        if (configValue2 != null) {
            int n2 = configValue2.getArraySize();
            this.serviceBlacklist = new String[n2];
            for (n = 0; n < n2; ++n) {
                ConfigValue configValue3 = configValue2.getArrayValue(n);
                this.serviceBlacklist[n] = configValue3.getString();
            }
        }
        if ((configValue = iConfigQuery.getArray("services")) != null) {
            n = configValue.getArraySize();
            this.serviceInfos = new AdapterConfig$ServiceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ConfigValue configValue4 = configValue.getArrayValue(i2);
                if (configValue4 != null) {
                    Object object;
                    Object object2;
                    ConfigValue configValue5 = configValue4.getDictValue("interface");
                    String string = DEFAULT_SERVICE_INTERFACE;
                    if (configValue5 != null) {
                        string = configValue5.getString();
                    }
                    ConfigValue configValue6 = configValue4.getDictValue("instance");
                    int n3 = 0;
                    if (configValue6 != null) {
                        n3 = configValue6.getInteger();
                    }
                    ConfigValue configValue7 = configValue4.getDictValue("earlyStartup");
                    boolean bl = false;
                    if (configValue7 != null && (object2 = configValue7.getBoolean()) != null) {
                        bl = (Boolean)object2;
                    }
                    object2 = configValue4.getDictValue("earlyRegistration");
                    boolean bl2 = false;
                    if (object2 != null && (object = ((ConfigValue)object2).getBoolean()) != null) {
                        bl2 = (Boolean)object;
                    }
                    object = configValue4.getDictValue("dispatcher");
                    String string2 = DEFAULT_SERVICE_DISPATCHER_NAME;
                    if (object != null && (string2 = ((ConfigValue)object).getString()).length() != 0) {
                        this.dispatcherNames.put(new StringBuffer().append(string).append(String.valueOf(n3)).toString(), string2);
                    }
                    this.serviceInfos[i2] = new AdapterConfig$ServiceInfo(string, n3, bl, bl2);
                    continue;
                }
                Channels.CONFIG.log((short)4, "Wrong service workers configuration in adapter config: serviceDict=null");
            }
        }
    }

    public boolean useLocalListenerList() {
        return this.useLocalListenerList;
    }

    public int maxFastsReconnects() {
        return this.maxFastsReconnects;
    }

    public int slowReconnectTimeoutStartVal() {
        return this.slowReconnectTimeoutStartVal;
    }

    public int slowReconnectTimeoutEndVal() {
        return this.slowReconnectTimeoutEndVal;
    }

    public int errorLogSize() {
        return this.errorLogSize;
    }

    public boolean getUseSimplerWorker() {
        return this.useSimplerWorker;
    }

    public boolean throwDSIExceptions() {
        return this.throwDSIExceptions;
    }

    public String getServiceManager() {
        return this.serviceManager;
    }

    public String[] getServiceBlacklist() {
        return this.serviceBlacklist;
    }

    public AdapterConfig$ServiceInfo[] getServiceInfos() {
        return this.serviceInfos;
    }

    public AdapterConfig$ServiceInfo getServiceInfo(String string, int n) {
        AdapterConfig$ServiceInfo adapterConfig$ServiceInfo = null;
        if (this.serviceInfos != null) {
            for (int i2 = 0; i2 < this.serviceInfos.length; ++i2) {
                if (!this.serviceInfos[i2].getInterfaceName().equals(string) || this.serviceInfos[i2].getInstance() != n) continue;
                adapterConfig$ServiceInfo = this.serviceInfos[i2];
                break;
            }
        }
        return adapterConfig$ServiceInfo;
    }

    public String getDispatcherName(String string, int n) {
        return (String)this.dispatcherNames.get(new StringBuffer().append(string).append(String.valueOf(n)).toString());
    }

    public boolean isEarlyRegistrationService(String string, int n) {
        boolean bl = false;
        AdapterConfig$ServiceInfo adapterConfig$ServiceInfo = this.getServiceInfo(string, n);
        if (adapterConfig$ServiceInfo != null) {
            bl = adapterConfig$ServiceInfo.isEarlyRegistration();
        }
        return bl;
    }

    static {
        DEFAULT_SERVICE_INTERFACE = null;
        DEFAULT_SERVICE_DISPATCHER_NAME = null;
    }
}

