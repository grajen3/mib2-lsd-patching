/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigElement;
import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.decode.MessageDecoderRegistry;

public class TraceConfigDecoder
extends TraceConfigElement {
    private static final String chn;
    private final short id;

    public TraceConfigDecoder(short s, ConfigValue configValue, TraceConfig traceConfig) {
        super(Short.toString(s), configValue, traceConfig);
        this.id = s;
    }

    public short getId() {
        return this.id;
    }

    public ITraceMessageDecoder createInstance() {
        String string = this.getDefaultClassName();
        String string2 = this.getPluginClassName();
        if (string != null) {
            ITraceMessageDecoder iTraceMessageDecoder = MessageDecoderRegistry.getInstance().createDecoder(string);
            if (iTraceMessageDecoder == null) {
                TraceMe.msg(TraceMe.ERROR, "ConfigDecoder", "can't find default decoder: %1", string);
            } else {
                TraceMe.msg(TraceMe.INFO, "ConfigDecoder", "created default decoder: %1 for message type %2", string, new Short(this.id));
                iTraceMessageDecoder.init(this.getConfig());
            }
            return iTraceMessageDecoder;
        }
        if (string2 != null) {
            try {
                Class clazz = Class.forName(string2);
                ITraceMessageDecoder iTraceMessageDecoder = (ITraceMessageDecoder)clazz.newInstance();
                TraceMe.msg(TraceMe.INFO, "ConfigDecoder", "created decoder %1 for message type %2", string2, new Integer(this.id));
                iTraceMessageDecoder.init(this.getConfig());
                return iTraceMessageDecoder;
            }
            catch (ClassNotFoundException classNotFoundException) {
                TraceMe.msg(TraceMe.ERROR, "ConfigDecoder", "decoder class %1 NOT FOUND!", string2);
            }
            catch (Exception exception) {
                TraceMe.msg(TraceMe.ERROR, "ConfigDecoder", "can't instantiate class %1", string2);
            }
        }
        TraceMe.msg(TraceMe.WARN, "ConfigDecoder", "ignoring decoder for message type %1: neither class nor javaClass given!", new Integer(this.id));
        return null;
    }
}

