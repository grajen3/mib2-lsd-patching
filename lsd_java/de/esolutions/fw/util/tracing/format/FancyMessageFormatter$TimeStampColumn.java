/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$Column;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class FancyMessageFormatter$TimeStampColumn
extends FancyMessageFormatter$Column {
    private final SimpleDateFormat sdf;
    private final /* synthetic */ FancyMessageFormatter this$0;

    public FancyMessageFormatter$TimeStampColumn(FancyMessageFormatter fancyMessageFormatter, IConfigQuery iConfigQuery) {
        this.this$0 = fancyMessageFormatter;
        super(fancyMessageFormatter, iConfigQuery);
        String string = iConfigQuery.getStringValue("format", "HH:mm:ss.SSS");
        this.sdf = new SimpleDateFormat(string);
        this.sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
        return this.sdf.format(new Date(iTraceMessage.getTimeStamp()));
    }
}

