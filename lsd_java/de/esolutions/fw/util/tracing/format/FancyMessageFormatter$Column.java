/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

abstract class FancyMessageFormatter$Column {
    protected final int width;
    protected final boolean resolve;
    protected final boolean crop;
    private final /* synthetic */ FancyMessageFormatter this$0;

    public FancyMessageFormatter$Column(FancyMessageFormatter fancyMessageFormatter, IConfigQuery iConfigQuery) {
        this.this$0 = fancyMessageFormatter;
        this.width = iConfigQuery.getIntegerValue("width", 10);
        this.resolve = iConfigQuery.getBooleanValue("resolve", true);
        this.crop = iConfigQuery.getBooleanValue("crop", true);
    }

    public abstract String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
    }

    public String eval(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
        String string = this.print(iTraceMessage, iTraceEntityResolver, n);
        return StringUtils.padString(string, this.width, this.crop ? 1 : 4);
    }
}

