/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$BooleanParameterHandler;
import de.vw.mib.widgets.speller.asia.china.ChinaAsiaInputInitializer$Builder;

public final class ChinaAsiaInputInitializer
extends AbstractAsiaInputInitializer {
    private static final String LOG_PREFIX;
    protected boolean firstLetter;
    protected boolean nameInput;
    protected boolean smartPunctuation;

    protected ChinaAsiaInputInitializer(ChinaAsiaInputInitializer$Builder chinaAsiaInputInitializer$Builder) {
        super(chinaAsiaInputInitializer$Builder);
        this.firstLetter = chinaAsiaInputInitializer$Builder.firstLetter;
        this.nameInput = chinaAsiaInputInitializer$Builder.nameInput;
        this.smartPunctuation = chinaAsiaInputInitializer$Builder.smartPunctuation;
    }

    @Override
    protected void initializeInternal(AsiaInput asiaInput) {
        if (this.isTraceEnabled()) {
            this.trace().append("language=").append(0).append(" [CHINESE]").log();
        }
        asiaInput.initialize(0);
    }

    @Override
    protected void onQueueAsiaInputConfigurators() {
        this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$BooleanParameterHandler((AbstractAsiaInputInitializer)this, "FIRSTLETTER", 0, this.firstLetter, false));
        this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$BooleanParameterHandler((AbstractAsiaInputInitializer)this, "NAMEINPUT", 2, this.nameInput, false));
        this.queueAsiaInputConfigurator(new AbstractAsiaInputInitializer$BooleanParameterHandler((AbstractAsiaInputInitializer)this, "SMARTPUNCT", 3, this.smartPunctuation, false));
    }

    @Override
    protected LogMessage trace() {
        return super.trace("[ChinaAsiaInputInitializer]: ");
    }

    @Override
    protected LogMessage warn() {
        return super.warn("[ChinaAsiaInputInitializer]: ");
    }
}

