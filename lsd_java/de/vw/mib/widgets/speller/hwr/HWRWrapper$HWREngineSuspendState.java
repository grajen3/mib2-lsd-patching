/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.hwr;

import de.vw.mib.widgets.speller.hwr.HWRWrapper;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineState;

final class HWRWrapper$HWREngineSuspendState
extends HWRWrapper$HWREngineState {
    private final /* synthetic */ HWRWrapper this$0;

    public HWRWrapper$HWREngineSuspendState(HWRWrapper hWRWrapper) {
        this.this$0 = hWRWrapper;
        super(hWRWrapper);
    }

    @Override
    public void deInit() {
        this.this$0.clearAndRelease();
        this.this$0.setState(this.this$0.getState(0));
    }

    @Override
    public void restart() {
        this.this$0.configure(this.this$0.speller.get_hwrMode());
        this.this$0.clear();
        this.this$0.setState(this.this$0.getState(2));
    }

    @Override
    public void resume() {
        this.this$0.configure(this.this$0.speller.get_hwrMode());
        this.this$0.setState(this.this$0.getState(2));
    }

    @Override
    public void start() {
        this.resume();
    }

    @Override
    public void stop() {
        this.this$0.clear();
        this.this$0.setState(this.this$0.getState(1));
    }
}

