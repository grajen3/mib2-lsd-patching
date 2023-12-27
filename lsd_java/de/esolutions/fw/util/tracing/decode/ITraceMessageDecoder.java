/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.decode;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface ITraceMessageDecoder {
    default public void init(ConfigValue configValue) {
    }

    default public void decodeMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
    }
}

