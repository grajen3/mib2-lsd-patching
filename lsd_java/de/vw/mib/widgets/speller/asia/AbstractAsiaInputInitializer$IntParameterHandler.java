/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AbstractParameterHandler;

public final class AbstractAsiaInputInitializer$IntParameterHandler
extends AbstractAsiaInputInitializer$AbstractParameterHandler {
    private final int value;
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    public AbstractAsiaInputInitializer$IntParameterHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, String string, int n, String string2, int n2) {
        this(abstractAsiaInputInitializer, string, n, string2, n2, true);
    }

    public AbstractAsiaInputInitializer$IntParameterHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, String string, int n, String string2, int n2, boolean bl) {
        this.this$0 = abstractAsiaInputInitializer;
        super(abstractAsiaInputInitializer, string, n, string2, bl);
        this.value = n2;
    }

    @Override
    protected void onConfigure(AsiaInput asiaInput) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("parameter=").append(this.parameter).append(" [").append(this.parameterName).append("] value=").append(this.value).append(" [").append(this.valueName).append("]").log();
        }
        asiaInput.setIntParameter(this.parameter, this.value);
    }
}

