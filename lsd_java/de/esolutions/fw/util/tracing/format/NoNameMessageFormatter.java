/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;

public class NoNameMessageFormatter
implements ITraceMessageFormatter {
    private static final int threadNameWidth;
    private static final int channelNameWidth;
    private static final int seqNumWidth;

    @Override
    public void init(TraceConfigFormatter traceConfigFormatter) {
    }

    @Override
    public String[] formatMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
        String string = null;
        String string2 = null;
        string = Integer.toString(iTraceMessage.getThreadID());
        string2 = Integer.toString(iTraceMessage.getChannelID());
        Buffer buffer = new Buffer(512);
        TraceTimeStamp traceTimeStamp = new TraceTimeStamp(iTraceMessage.getTimeStamp());
        buffer.append(traceTimeStamp.toUTCTimeString(false));
        buffer.append("  ");
        buffer.append(StringUtils.padString(string, 11, 0));
        buffer.append(" ");
        buffer.append(StringUtils.padString(string2, 23, 0));
        buffer.append(" ");
        buffer.append(StringUtils.padString(TraceLevels.levelNames[iTraceMessage.getLevel()], 6, 4));
        buffer.append("  ");
        buffer.append(StringUtils.padString(Long.toString(iTraceMessage.getSeqNum()), 5, 4));
        buffer.append(" ");
        String string3 = buffer.toString();
        String[] stringArray = iTraceMessage.getDecodedMessage();
        String[] stringArray2 = new String[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray2[i2] = new StringBuffer().append(string3).append(stringArray[i2]).toString();
        }
        return stringArray2;
    }
}

