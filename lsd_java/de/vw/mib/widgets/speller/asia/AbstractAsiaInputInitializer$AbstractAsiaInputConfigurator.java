/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaAdapter;
import de.vw.mib.asia.AsiaInput;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AsiaInputConfigurator;
import de.vw.mib.widgets.speller.asia.AsiaStatusText;

public abstract class AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator
extends AsiaAdapter
implements AbstractAsiaInputInitializer$AsiaInputConfigurator {
    protected AsiaInput _asiaInput;
    private long configurationStartTime;
    protected final boolean mandatory;
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    protected AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator(AbstractAsiaInputInitializer abstractAsiaInputInitializer, boolean bl) {
        this.this$0 = abstractAsiaInputInitializer;
        this.mandatory = bl;
        this.configurationStartTime = 0L;
    }

    @Override
    public void asiaReceivedErrorStatus(int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("ERROR (").append(n).append(") '").append(AsiaStatusText.getText(n)).append("'").log();
        }
        this.handleResponse(false);
    }

    @Override
    public void asiaReceivedTimeout() {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("operation timed-out").log();
        }
        this.handleResponse(false);
    }

    @Override
    public final void configure(AsiaInput asiaInput) {
        this._asiaInput = asiaInput;
        this._asiaInput.addAsiaListener(this);
        this.configurationStartTime = ServiceManager.timerManager.getSystemTimeMillis();
        this.onConfigure(asiaInput);
    }

    protected final void handleResponse(boolean bl) {
        this._asiaInput.removeAsiaListener(this);
        long l = ServiceManager.timerManager.getSystemTimeMillis() - this.configurationStartTime;
        this.onHandleResponse(bl, l);
        if (!bl && this.mandatory) {
            this.this$0.onParameterSetFailed(this.mandatory);
        } else {
            this.this$0.onParameterSet();
        }
    }

    protected void onConfigure(AsiaInput asiaInput) {
    }

    protected void onHandleResponse(boolean bl, long l) {
    }
}

