/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services;

import de.esolutions.fw.util.config.ConfigProvider;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

public final class ServicesConfigProvider
extends ConfigProvider {
    private boolean killOnError = true;

    public ServicesConfigProvider() {
        super("fwservices", "./config");
        ConfigValue configValue = this.getRoot().getDictValue("errorHandler");
        if (configValue != null && configValue.isDictionary()) {
            this.parseErrorHandlerConfig(configValue);
        }
    }

    private void parseErrorHandlerConfig(ConfigValue configValue) {
        ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
        this.killOnError = configPathQuery.getBooleanValue("killOnError", this.killOnError);
    }

    public boolean getGCTracingEnabled() {
        Boolean bl;
        ConfigValue configValue;
        ConfigValue configValue2 = this.getRoot().getDictValue("gcTracing");
        if (configValue2 != null && (configValue = configValue2.getDictValue("enabled")) != null && (bl = configValue.getBoolean()) != null) {
            return bl;
        }
        return false;
    }

    public boolean getKillOnError() {
        return this.killOnError;
    }

    public ConfigValue getThreadPoolsConfig() {
        return this.getRoot().getDictValue("threadPools");
    }

    public ConfigValue getDispatchersConfig() {
        return this.getRoot().getDictValue("dispatchers");
    }
}

