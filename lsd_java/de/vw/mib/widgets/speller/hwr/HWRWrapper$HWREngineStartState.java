/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.hwr;

import de.vw.mib.widgets.speller.hwr.HWRWrapper;
import de.vw.mib.widgets.speller.hwr.HWRWrapper$HWREngineState;

final class HWRWrapper$HWREngineStartState
extends HWRWrapper$HWREngineState {
    private boolean charactersRecognized;
    private final /* synthetic */ HWRWrapper this$0;

    public HWRWrapper$HWREngineStartState(HWRWrapper hWRWrapper) {
        this.this$0 = hWRWrapper;
        super(hWRWrapper);
        this.charactersRecognized = false;
    }

    @Override
    public void charactersRecognized(String[] stringArray) {
        this.charactersRecognized = true;
        if (this.this$0.spellerController != null) {
            this.this$0.spellerController.onHwrCharactersRecognized(stringArray);
        } else {
            this.this$0.warn().append("Unable to notify the speller controller about 'charactersRecognized'.").log();
        }
    }

    @Override
    public void deInit() {
        this.this$0.clearAndRelease();
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
    public void ready() {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append(super.getClass().getName()).append(": ready").log();
        }
        if (this.this$0.spellerController != null) {
            this.this$0.spellerController.fire_hwrEnabled();
        } else {
            this.this$0.warn().append("Unable to notify the speller controller about 'hwrEnabled'.").log();
        }
    }

    @Override
    public void restart() {
        this.this$0.clear();
    }

    @Override
    public void start() {
        if (this.charactersRecognized) {
            this.charactersRecognized = false;
            this.this$0.clear();
        }
    }

    @Override
    public void stop() {
        this.this$0.clear();
        this.this$0.configure(0);
        this.this$0.setState(this.this$0.getState(1));
    }

    @Override
    public void suspend() {
        this.this$0.configure(0);
        this.this$0.setState(this.this$0.getState(3));
    }
}

