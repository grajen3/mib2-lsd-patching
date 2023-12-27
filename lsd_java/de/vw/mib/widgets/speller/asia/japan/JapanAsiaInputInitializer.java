/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.japan.JapanAsiaInputInitializer$Builder;

public final class JapanAsiaInputInitializer
extends AbstractAsiaInputInitializer {
    private static final String LOG_PREFIX;

    protected JapanAsiaInputInitializer(JapanAsiaInputInitializer$Builder japanAsiaInputInitializer$Builder) {
        super(japanAsiaInputInitializer$Builder);
    }

    @Override
    protected void initializeInternal(AsiaInput asiaInput) {
        if (this.isTraceEnabled()) {
            this.trace().append("language=").append(1).append(" [JAPANESE]").log();
        }
        asiaInput.initialize(1);
    }

    @Override
    protected LogMessage trace() {
        return super.trace("[JapanAsiaInputInitializer]: ");
    }

    @Override
    protected LogMessage warn() {
        return super.warn("[JapanAsiaInputInitializer]: ");
    }
}

