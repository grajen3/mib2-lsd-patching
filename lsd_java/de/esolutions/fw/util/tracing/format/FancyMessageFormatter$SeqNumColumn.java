/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$Column;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

class FancyMessageFormatter$SeqNumColumn
extends FancyMessageFormatter$Column {
    private final /* synthetic */ FancyMessageFormatter this$0;

    public FancyMessageFormatter$SeqNumColumn(FancyMessageFormatter fancyMessageFormatter, IConfigQuery iConfigQuery) {
        this.this$0 = fancyMessageFormatter;
        super(fancyMessageFormatter, iConfigQuery);
    }

    @Override
    public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
        return Integer.toString(iTraceMessage.getSeqNum());
    }
}

