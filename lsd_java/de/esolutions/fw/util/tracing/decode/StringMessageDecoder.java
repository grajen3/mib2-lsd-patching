/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.decode;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public class StringMessageDecoder
implements ITraceMessageDecoder {
    @Override
    public void init(ConfigValue configValue) {
    }

    @Override
    public void decodeMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
        iTraceMessage.setDecodedMessage(StringUtils.splitString(iTraceMessage.getMessageString(), '\n'));
    }
}

