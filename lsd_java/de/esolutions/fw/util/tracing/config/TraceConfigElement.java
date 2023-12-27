/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.config.TraceConfig;

public class TraceConfigElement {
    private final String name;
    private final ConfigValue config;
    private final TraceConfig traceConfig;
    private final IConfigQuery query;
    private final boolean enabled;
    private final String defaultClassName;
    private final String pluginClassName;

    public TraceConfigElement(String string, ConfigValue configValue, TraceConfig traceConfig) {
        if (configValue == null) {
            configValue = new ConfigDictionary();
        }
        this.name = string;
        this.config = configValue;
        this.traceConfig = traceConfig;
        this.query = new ConfigPathQuery(configValue);
        this.enabled = this.query.getBooleanValue("enabled", true);
        this.defaultClassName = this.query.getStringValue("class", null);
        this.pluginClassName = this.query.getStringValue("javaClass", null);
    }

    public String getName() {
        return this.name;
    }

    public ConfigValue getConfig() {
        return this.config;
    }

    public TraceConfig getTraceConfig() {
        return this.traceConfig;
    }

    public IConfigQuery getQuery() {
        return this.query;
    }

    public String getDefaultClassName() {
        return this.defaultClassName;
    }

    public String getPluginClassName() {
        return this.pluginClassName;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String toString() {
        return new StringBuffer().append("[name=").append(this.name).append(",defaultClass=").append(this.defaultClassName).append(",pluginClass=").append(this.pluginClassName).append(",enabled=").append(this.enabled).append("]").toString();
    }
}

