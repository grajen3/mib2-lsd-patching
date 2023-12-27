/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AbstractParameterHandler;

public final class AbstractAsiaInputInitializer$BooleanParameterHandler
extends AbstractAsiaInputInitializer$AbstractParameterHandler {
    private final boolean value;
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    public AbstractAsiaInputInitializer$BooleanParameterHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, String string, int n, boolean bl) {
        this(abstractAsiaInputInitializer, string, n, bl, true);
    }

    public AbstractAsiaInputInitializer$BooleanParameterHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, String string, int n, boolean bl, boolean bl2) {
        this.this$0 = abstractAsiaInputInitializer;
        super(abstractAsiaInputInitializer, string, n, "", bl2);
        this.value = bl;
    }

    @Override
    protected void onConfigure(AsiaInput asiaInput) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("parameter=").append(this.parameter).append(" [").append(this.parameterName).append("] value=").append(this.value).log();
        }
        asiaInput.setBooleanParameter(this.parameter, this.value);
    }
}

