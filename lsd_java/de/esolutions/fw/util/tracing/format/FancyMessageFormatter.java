/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$ChannelIdColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$Column;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$LevelColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$MsgModColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$MsgStringColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$MsgTypeColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$ProcessIdColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$SeqNumColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$ThreadIdColumn;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$TimeStampColumn;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public class FancyMessageFormatter
implements ITraceMessageFormatter {
    private FancyMessageFormatter$Column[] columns;

    @Override
    public void init(TraceConfigFormatter traceConfigFormatter) {
        ConfigValue configValue = traceConfigFormatter.getQuery().getArray("columns");
        if (configValue != null) {
            int n = configValue.getArraySize();
            this.columns = new FancyMessageFormatter$Column[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ConfigValue configValue2 = configValue.getArrayValue(i2);
                ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue2);
                String string = configPathQuery.getStringValue("field", "none");
                FancyMessageFormatter$Column fancyMessageFormatter$Column = null;
                if (string.equals("timestamp")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$TimeStampColumn(this, configPathQuery);
                } else if (string.equals("threadId")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$ThreadIdColumn(this, configPathQuery);
                } else if (string.equals("channelId")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$ChannelIdColumn(this, configPathQuery);
                } else if (string.equals("sequenceNumber")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$SeqNumColumn(this, configPathQuery);
                } else if (string.equals("messageType")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$MsgTypeColumn(this, configPathQuery);
                } else if (string.equals("messageModifier")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$MsgModColumn(this, configPathQuery);
                } else if (string.equals("messageLevel")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$LevelColumn(this, configPathQuery);
                } else if (string.equals("messageString")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$MsgStringColumn(this, configPathQuery);
                } else if (string.equals("processId")) {
                    fancyMessageFormatter$Column = new FancyMessageFormatter$ProcessIdColumn(this, configPathQuery);
                }
                this.columns[i2] = fancyMessageFormatter$Column;
            }
        }
    }

    @Override
    public String[] formatMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
        int n = iTraceMessage.getDecodedMessage().length;
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            Buffer buffer = new Buffer();
            for (int i3 = 0; i3 < this.columns.length; ++i3) {
                FancyMessageFormatter$Column fancyMessageFormatter$Column = this.columns[i3];
                if (fancyMessageFormatter$Column != null) {
                    buffer.append(fancyMessageFormatter$Column.eval(iTraceMessage, iTraceEntityResolver, i2));
                } else {
                    buffer.append("<INVALID>");
                }
                buffer.append(" ");
            }
            stringArray[i2] = buffer.toString();
        }
        return stringArray;
    }
}

