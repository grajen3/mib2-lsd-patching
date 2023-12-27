/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.backend.BackendRegistry;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigElement;
import de.esolutions.fw.util.tracing.config.TraceConfigLevels;
import java.util.Date;

public class TraceConfigBackend
extends TraceConfigElement {
    private static final String chn;
    private final TraceConfigLevels levels;

    public TraceConfigBackend(String string, ConfigValue configValue, TraceConfig traceConfig) {
        super(string, configValue, traceConfig);
        ConfigValue configValue2 = this.getQuery().getDictionary("levels");
        this.levels = configValue2 != null ? new TraceConfigLevels(configValue2) : null;
    }

    public TraceConfigLevels getLevels() {
        return this.levels;
    }

    public ITraceBackend createInstance() {
        String string = this.getPluginClassName();
        if (string != null) {
            try {
                Class clazz = Class.forName(string);
                ITraceBackend iTraceBackend = (ITraceBackend)clazz.newInstance();
                TraceMe.msg(TraceMe.INFO, "ConfigBackend", "created backend instance of %1 for %2", string, this.getName());
                return iTraceBackend;
            }
            catch (ClassNotFoundException classNotFoundException) {
                TraceMe.msg(TraceMe.ERROR, "ConfigBackend", "backend class %1 NOT FOUND!", string);
                return null;
            }
            catch (Exception exception) {
                TraceMe.msg(TraceMe.ERROR, "ConfigBackend", "can't instantiate backend class %1: %2", string, exception);
                return null;
            }
        }
        String string2 = this.getDefaultClassName();
        if (string2 != null) {
            ITraceBackend iTraceBackend = BackendRegistry.getInstance().createBackend(string2);
            if (iTraceBackend == null) {
                TraceMe.msg(TraceMe.ERROR, "ConfigBackend", "can't create default backend: %1", string2);
                return null;
            }
            TraceMe.msg(TraceMe.INFO, "ConfigBackend", "created backend instance of %1 for %2", string2, this.getName());
            return iTraceBackend;
        }
        String string3 = this.getName();
        ITraceBackend iTraceBackend = BackendRegistry.getInstance().createBackend(string3);
        if (iTraceBackend != null) {
            TraceMe.msg(TraceMe.INFO, "ConfigBackend", "created backend instance of %1 for %2", string3, this.getName());
            return iTraceBackend;
        }
        TraceMe.msg(TraceMe.ERROR, "ConfigBackend", "ignoring backend %1: neither class nor javaClass given!", this.getName());
        return null;
    }

    public String getOutputDirectory(String string) {
        IConfigQuery iConfigQuery = this.getQuery();
        String string2 = iConfigQuery.getStringValue("outputDirectory", string);
        if (string2 == null) {
            string2 = "esotrace_#yyyyMMdd_HHmmss#";
        }
        string2 = StringUtils.expandDateString(string2, new Date());
        return string2;
    }

    public String getFileName(String string, String string2) {
        IConfigQuery iConfigQuery = this.getQuery();
        String string3 = iConfigQuery.getStringValue("fileName", string);
        if (string3 == null) {
            boolean bl = iConfigQuery.getBooleanValue("useClientName", false);
            string3 = bl ? this.getTraceConfig().getId() : "log";
        }
        string3 = StringUtils.addSuffix(string3, string2);
        return string3;
    }
}

