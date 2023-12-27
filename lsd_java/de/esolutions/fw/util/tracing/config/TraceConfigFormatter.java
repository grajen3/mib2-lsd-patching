/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigElement;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.format.MessageFormatterRegistry;

public class TraceConfigFormatter
extends TraceConfigElement {
    private static final String chn;

    public TraceConfigFormatter(String string, ConfigValue configValue, TraceConfig traceConfig) {
        super(string, configValue, traceConfig);
    }

    public ITraceMessageFormatter createInstance() {
        String string = this.getDefaultClassName();
        String string2 = this.getPluginClassName();
        if (string != null) {
            ITraceMessageFormatter iTraceMessageFormatter = MessageFormatterRegistry.getInstance().createFormatter(string);
            if (iTraceMessageFormatter == null) {
                TraceMe.msg(TraceMe.WARN, "ConfigFormatter", "can't find default formatter: %1", string);
            } else {
                TraceMe.msg(TraceMe.INFO, "ConfigFormatter", "created default instance of %1 for formatter %2", string, this.getName());
                iTraceMessageFormatter.init(this);
            }
            return iTraceMessageFormatter;
        }
        if (string2 != null) {
            try {
                Class clazz = Class.forName(string2);
                ITraceMessageFormatter iTraceMessageFormatter = (ITraceMessageFormatter)clazz.newInstance();
                TraceMe.msg(TraceMe.INFO, "ConfigFormatter", "created instance of %1 for formatter %2", string2, this.getName());
                iTraceMessageFormatter.init(this);
                return iTraceMessageFormatter;
            }
            catch (ClassNotFoundException classNotFoundException) {
                TraceMe.msg(TraceMe.ERROR, "ConfigFormatter", "formatter class %1 NOT FOUND!", string2);
            }
            catch (Exception exception) {
                TraceMe.msg(TraceMe.ERROR, "ConfigFormatter", "can't instantiate formatter class %1", string2);
            }
        }
        String string3 = this.getName();
        ITraceMessageFormatter iTraceMessageFormatter = MessageFormatterRegistry.getInstance().createFormatter(string3);
        if (iTraceMessageFormatter != null) {
            iTraceMessageFormatter.init(this);
            return iTraceMessageFormatter;
        }
        TraceMe.msg(TraceMe.WARN, "ConfigFormatter", "ignoring formatter %1: neither class nor javaClass given!", this.getName());
        return null;
    }
}

