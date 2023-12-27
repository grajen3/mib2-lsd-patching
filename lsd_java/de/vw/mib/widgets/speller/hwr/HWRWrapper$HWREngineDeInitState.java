/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.hwr;

import de.vw.mib.widgets.speller.hwr.HWRWrapper;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineHandler;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineState;

final class HWRWrapper$HWREngineDeInitState
extends HWRWrapper$HWREngineState {
    private final /* synthetic */ HWRWrapper this$0;

    public HWRWrapper$HWREngineDeInitState(HWRWrapper hWRWrapper) {
        this.this$0 = hWRWrapper;
        super(hWRWrapper);
    }

    @Override
    public void init() {
        if (this.this$0.spellerService != null) {
            this.this$0.hwrEngine = this.this$0.spellerService.initHWREngine(this.this$0.speller.get_filterId(), new HWRWrapper$HWREngineHandler(this.this$0));
            if (this.this$0.hwrEngine != null) {
                this.this$0.setState(this.this$0.getState(1));
            } else {
                this.this$0.warn().append("Hwr engine initialization failed!").log();
            }
        } else {
            this.this$0.warn().append("Unable to initialze hwr engine, because of the missing service!").log();
        }
    }

    @Override
    public void onEnter() {
        super.onEnter();
        if (this.this$0.isAlreadyInUse) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("'").append(this.this$0.speller).append("' releases hwr engine control").log();
            }
            this.this$0.isAlreadyInUse = false;
        }
    }

    @Override
    public void onLeave() {
        if (!this.this$0.isAlreadyInUse) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace().append("'").append(this.this$0.speller).append("' takes over hwr engine control").log();
            }
            this.this$0.isAlreadyInUse = true;
        }
        super.onLeave();
    }
}

