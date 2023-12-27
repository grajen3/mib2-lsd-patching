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

class FancyMessageFormatter$ThreadIdColumn
extends FancyMessageFormatter$Column {
    private final /* synthetic */ FancyMessageFormatter this$0;

    public FancyMessageFormatter$ThreadIdColumn(FancyMessageFormatter fancyMessageFormatter, IConfigQuery iConfigQuery) {
        this.this$0 = fancyMessageFormatter;
        super(fancyMessageFormatter, iConfigQuery);
    }

    @Override
    public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
        if (this.resolve) {
            return iTraceEntityResolver.resolveName(new TraceEntityURI(2, iTraceMessage.getThreadID()));
        }
        return Integer.toString(iTraceMessage.getThreadID());
    }
}

