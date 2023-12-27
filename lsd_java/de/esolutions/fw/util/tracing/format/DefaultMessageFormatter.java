/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;

public class DefaultMessageFormatter
implements ITraceMessageFormatter {
    private static final int processNameWidth;
    private static final int threadNameWidth;
    private static final int channelNameWidth;
    private static final int seqNumWidth;
    private boolean noCrop;
    private String padStr = "  ";

    public void setNoCrop(boolean bl) {
        this.noCrop = bl;
    }

    public void setPadString(String string) {
        this.padStr = string;
    }

    @Override
    public void init(TraceConfigFormatter traceConfigFormatter) {
    }

    private String formatText(String string, int n) {
        if (this.noCrop) {
            return string;
        }
        return StringUtils.padString(string, n, 0);
    }

    @Override
    public String[] formatMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
        Object object;
        Object object2;
        String string = null;
        String string2 = null;
        String string3 = null;
        if (iTraceEntityResolver != null) {
            object2 = new TraceEntityURI(2, iTraceMessage.getThreadID());
            object = new TraceEntityURI(3, iTraceMessage.getChannelID());
            string2 = iTraceEntityResolver.resolveName((TraceEntityURI)object2);
            string3 = iTraceEntityResolver.resolvePath((TraceEntityURI)object, true);
            string = iTraceEntityResolver.resolveParentName((TraceEntityURI)object2, (short)1);
        }
        if (string2 == null) {
            string2 = Integer.toString(iTraceMessage.getThreadID());
        }
        if (string3 == null) {
            string3 = Integer.toString(iTraceMessage.getChannelID());
        }
        object2 = new Buffer(512);
        object = new TraceTimeStamp(iTraceMessage.getTimeStamp());
        ((Buffer)object2).append(((TraceTimeStamp)object).toUTCTimeString(false));
        ((Buffer)object2).append(this.padStr);
        if (string != null) {
            ((Buffer)object2).append(this.formatText(string, 10));
            ((Buffer)object2).append(this.padStr);
        }
        ((Buffer)object2).append(this.formatText(string2, 11));
        ((Buffer)object2).append(this.padStr);
        ((Buffer)object2).append(this.formatText(string3, 23));
        ((Buffer)object2).append(this.padStr);
        ((Buffer)object2).append(this.formatText(TraceLevels.levelNames[iTraceMessage.getLevel()], 6));
        ((Buffer)object2).append(this.padStr);
        ((Buffer)object2).append(this.formatText(Long.toString(iTraceMessage.getSeqNum()), 5));
        ((Buffer)object2).append(this.padStr);
        String string4 = ((Buffer)object2).toString();
        String[] stringArray = iTraceMessage.getDecodedMessage();
        String[] stringArray2 = new String[stringArray.length];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray2[i2] = new StringBuffer().append(string4).append(stringArray[i2]).toString();
        }
        return stringArray2;
    }
}

