/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigElement;
import de.esolutions.fw.util.tracing.plugin.ITracePlugin;
import de.esolutions.fw.util.tracing.plugin.PluginRegistry;

public class TraceConfigPlugin
extends TraceConfigElement {
    private static final String chn;

    public TraceConfigPlugin(String string, ConfigValue configValue, TraceConfig traceConfig) {
        super(string, configValue, traceConfig);
    }

    public ITracePlugin createInstance() {
        String string = this.getPluginClassName();
        if (string != null) {
            try {
                Class clazz = Class.forName(string);
                ITracePlugin iTracePlugin = (ITracePlugin)clazz.newInstance();
                TraceMe.msg(TraceMe.INFO, "ConfigPlugin", "created plugin instance of %1 for %2", string, this.getName());
                return iTracePlugin;
            }
            catch (ClassNotFoundException classNotFoundException) {
                TraceMe.msg(TraceMe.ERROR, "ConfigPlugin", "plugin class %1 NOT FOUND!", string);
                return null;
            }
            catch (Exception exception) {
                TraceMe.msg(TraceMe.ERROR, "ConfigPlugin", "can't instantiate plugin class %1: %2", string, exception);
                return null;
            }
        }
        String string2 = this.getDefaultClassName();
        if (string2 != null) {
            ITracePlugin iTracePlugin = PluginRegistry.getInstance().createPlugin(string2);
            if (iTracePlugin == null) {
                TraceMe.msg(TraceMe.ERROR, "ConfigPlugin", "can't create default plugin: %1", string2);
                return null;
            }
            TraceMe.msg(TraceMe.INFO, "ConfigPlugin", "created plugin instance of %1 for %2", string2, this.getName());
            return iTracePlugin;
        }
        String string3 = this.getName();
        ITracePlugin iTracePlugin = PluginRegistry.getInstance().createPlugin(string3);
        if (iTracePlugin != null) {
            TraceMe.msg(TraceMe.INFO, "ConfigPlugin", "created plugin instance of %1 for %2", string3, this.getName());
            return iTracePlugin;
        }
        TraceMe.msg(TraceMe.WARN, "ConfigPlugin", "ignoring plugin %1: neither class nor javaClass given!", this.getName());
        return null;
    }
}

