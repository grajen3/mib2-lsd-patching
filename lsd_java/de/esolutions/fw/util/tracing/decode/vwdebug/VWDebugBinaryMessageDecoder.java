/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.decode.vwdebug;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.config.TraceConfigDecoder;
import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import java.io.UnsupportedEncodingException;

public class VWDebugBinaryMessageDecoder
implements ITraceMessageDecoder {
    public void init(TraceConfigDecoder traceConfigDecoder) {
    }

    @Override
    public void decodeMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
        byte[] byArray = iTraceMessage.getMessageData();
        int n = byArray[18] * 256 + byArray[17];
        int n2 = byArray[20] * 256 + byArray[19];
        if (n == 257) {
            try {
                iTraceMessage.setDecodedMessage(new String[]{new String(byArray, 12, n2, "UTF-8")});
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                iTraceMessage.setDecodedMessage(new String[]{"UTF-8 Encoding not supported "});
            }
        } else {
            iTraceMessage.setDecodedMessage(new String[]{new StringBuffer().append("unsupported message type ").append(Integer.toString(n)).append(" (should be 0x0101)").toString()});
        }
    }

    @Override
    public void init(ConfigValue configValue) {
    }
}

