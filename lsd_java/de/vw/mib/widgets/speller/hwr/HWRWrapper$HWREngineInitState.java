/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.hwr;

import de.vw.mib.widgets.speller.hwr.HWRWrapper;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineState;

final class HWRWrapper$HWREngineInitState
extends HWRWrapper$HWREngineState {
    private final /* synthetic */ HWRWrapper this$0;

    public HWRWrapper$HWREngineInitState(HWRWrapper hWRWrapper) {
        this.this$0 = hWRWrapper;
        super(hWRWrapper);
    }

    @Override
    public void deInit() {
        this.this$0.release();
        this.this$0.setState(this.this$0.getState(0));
    }

    @Override
    public void notReady() {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append(super.getClass().getName()).append(": notReady").log();
        }
        if (this.this$0.spellerController != null) {
            this.this$0.spellerController.fire_hwrDisabled();
        } else {
            this.this$0.warn().append("Unable to notify the speller controller about 'hwrDisabled'.").log();
        }
    }

    @Override
    public void start() {
        this.this$0.clear();
        this.this$0.configure(this.this$0.speller.get_hwrMode());
        this.this$0.setState(this.this$0.getState(2));
    }
}

