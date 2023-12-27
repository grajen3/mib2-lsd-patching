/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaAdapter;
import de.vw.mib.asia.AsiaInput;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AsiaStatusText;

final class AbstractAsiaInputInitializer$InitializeHandler
extends AsiaAdapter {
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    public AbstractAsiaInputInitializer$InitializeHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer) {
        this.this$0 = abstractAsiaInputInitializer;
    }

    @Override
    public void asiaInitialized() {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("AsiaInput initialized").log();
        }
        this.removeHandler();
        this.this$0.onInitialized();
    }

    @Override
    public void asiaReceivedErrorStatus(int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("ERROR (").append(n).append(") '").append(AsiaStatusText.getText(n)).append("'").log();
        }
        this.removeHandler();
        this.this$0.setInitialized(false);
        this.this$0.dropQueuedCallbacks();
    }

    @Override
    public void asiaReceivedTimeout() {
        this.removeHandler();
        this.this$0.setInitialized(false);
        this.this$0.dropQueuedCallbacks();
    }

    private void removeHandler() {
        AsiaInput asiaInput = this.this$0.getAsiaInput();
        if (asiaInput != null) {
            asiaInput.removeAsiaListener(this);
        }
    }
}

