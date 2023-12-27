/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.util.ObjectFactory;

public class MessageFormatterRegistry
extends ObjectFactory {
    private static MessageFormatterRegistry registry;

    public static MessageFormatterRegistry getInstance() {
        if (registry == null) {
            registry = new MessageFormatterRegistry();
        }
        return registry;
    }

    public ITraceMessageFormatter createFormatter(String string) {
        return (ITraceMessageFormatter)super.create(string);
    }
}

