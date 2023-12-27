/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator;

public abstract class AbstractAsiaInputInitializer$AbstractParameterHandler
extends AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator {
    protected final int parameter;
    protected final String parameterName;
    protected final String valueName;
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    protected AbstractAsiaInputInitializer$AbstractParameterHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, String string, int n, String string2, boolean bl) {
        this.this$0 = abstractAsiaInputInitializer;
        super(abstractAsiaInputInitializer, bl);
        this.parameterName = string;
        this.parameter = n;
        this.valueName = string2;
    }

    @Override
    public void asiaSetBooleanParameter(int n) {
        this.checkParameterSet(n);
    }

    @Override
    public void asiaSetIntParameter(int n) {
        this.checkParameterSet(n);
    }

    @Override
    public void asiaSetStringParameter(int n) {
        this.checkParameterSet(n);
    }

    private void checkParameterSet(int n) {
        if (this.parameter == n) {
            this.handleResponse(true);
        } else {
            this.this$0.warn().append("parameter=").append(n).append(" received but parameter=").append(this.parameter).append(" was expected!");
            this.handleResponse(false);
        }
    }

    @Override
    protected void onHandleResponse(boolean bl, long l) {
        if (bl && this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Took ").append(l).append("[ms] to set parameter=").append(this.parameter).append(" [").append(this.parameterName).append("]").log();
        }
    }
}

