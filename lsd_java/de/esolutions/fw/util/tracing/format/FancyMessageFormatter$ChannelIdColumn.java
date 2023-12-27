/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$Column;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

class FancyMessageFormatter$ChannelIdColumn
extends FancyMessageFormatter$Column {
    private final /* synthetic */ FancyMessageFormatter this$0;

    public FancyMessageFormatter$ChannelIdColumn(FancyMessageFormatter fancyMessageFormatter, IConfigQuery iConfigQuery) {
        this.this$0 = fancyMessageFormatter;
        super(fancyMessageFormatter, iConfigQuery);
    }

    @Override
    public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
        if (this.resolve) {
            return iTraceEntityResolver.resolvePath(new TraceEntityURI(3, iTraceMessage.getChannelID()), true);
        }
        return Integer.toString(iTraceMessage.getChannelID());
    }
}

