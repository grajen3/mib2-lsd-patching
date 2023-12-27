/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter;
import de.esolutions.fw.util.tracing.format.FancyMessageFormatter$Column;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

class FancyMessageFormatter$LevelColumn
extends FancyMessageFormatter$Column {
    private final /* synthetic */ FancyMessageFormatter this$0;

    public FancyMessageFormatter$LevelColumn(FancyMessageFormatter fancyMessageFormatter, IConfigQuery iConfigQuery) {
        this.this$0 = fancyMessageFormatter;
        super(fancyMessageFormatter, iConfigQuery);
    }

    @Override
    public String print(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver, int n) {
        if (this.resolve) {
            return TraceLevels.levelNames[iTraceMessage.getLevel()];
        }
        return Short.toString(iTraceMessage.getLevel());
    }
}

