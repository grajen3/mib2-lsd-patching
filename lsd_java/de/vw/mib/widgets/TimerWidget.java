/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.models.TimerWidgetModel;
import de.vw.mib.widgets.models.ViewModel;

public class TimerWidget
extends AbstractWidget
implements TimerWidgetModel {
    private int durationStart;
    private int durationRestart;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, boolean bl5, String string, int n5, boolean bl6, Insets insets, boolean bl7, int n6, int n7, int n8) {
        super.init(bl, n, bl3, easingParamsArray, bl4, n4, bl5, string, n5, insets, bl7, n6, n7, n8);
        this.durationStart = n3;
        this.durationRestart = n2;
        this.setInternalStateFlag(9, bl2);
        this.setInternalStateFlag(10, bl6);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public boolean is_autoStart() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final void set_autoStart(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.autoStartChanged(bl2);
            this.propertyChanged(17);
        }
    }

    @Override
    public final int get_durationStart() {
        return this.durationStart;
    }

    @Override
    public final void set_durationStart(int n) {
        int n2 = this.durationStart;
        if (n2 != n) {
            this.durationStart = n;
            this.durationStartChanged(n2);
            this.propertyChanged(15);
        }
    }

    @Override
    public final int get_durationRestart() {
        return this.durationRestart;
    }

    @Override
    public final void set_durationRestart(int n) {
        int n2 = this.durationRestart;
        if (n2 != n) {
            this.durationRestart = n;
            this.durationRestartChanged(n2);
            this.propertyChanged(16);
        }
    }

    @Override
    public final boolean is_timerRunning() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public final void set_timerRunning(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(10);
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.autoStartChanged(bl2);
            this.propertyChanged(18);
        }
    }

    protected void autoStartChanged(boolean bl) {
    }

    protected void durationStartChanged(int n) {
    }

    protected void durationRestartChanged(int n) {
    }
}

