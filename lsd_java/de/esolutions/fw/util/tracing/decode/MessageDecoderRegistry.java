/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.decode;

import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.util.ObjectFactory;
import java.util.HashMap;

public class MessageDecoderRegistry
extends ObjectFactory {
    protected static MessageDecoderRegistry registry;
    protected HashMap map = new HashMap();

    public static MessageDecoderRegistry getInstance() {
        if (registry == null) {
            registry = new MessageDecoderRegistry();
        }
        return registry;
    }

    public ITraceMessageDecoder createDecoder(String string) {
        return (ITraceMessageDecoder)super.create(string);
    }

    public void registerDecoder(short s, ITraceMessageDecoder iTraceMessageDecoder) {
        this.map.put(new Short(s), iTraceMessageDecoder);
    }

    public void unregisterDecoder(short s) {
        this.map.remove(new Short(s));
    }

    public ITraceMessageDecoder getDecoder(short s) {
        return (ITraceMessageDecoder)this.map.get(new Short(s));
    }
}

