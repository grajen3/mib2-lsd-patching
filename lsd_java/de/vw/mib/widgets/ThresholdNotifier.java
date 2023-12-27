/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.models.ThresholdNotifierModel;

public final class ThresholdNotifier
extends AbstractWidget
implements ThresholdNotifierModel {
    private int value;
    private int valueMin;
    private int valueMax;
    private int lastValue;

    @Override
    protected void reset() {
        super.reset();
        this.value = 0;
        this.valueMin = 0;
        this.valueMax = 0;
        this.lastValue = 0;
    }

    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, String string, int n3, Insets insets, int n4, int n5, int n6, boolean bl5, int n7, int n8, int n9) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, n3, insets, bl5, n7, n8, n9);
        this.valueMax = n5;
        this.valueMin = n6;
        this.value = n4;
    }

    @Override
    public int get_value() {
        return this.value;
    }

    @Override
    public void set_value(int n) {
        int n2 = this.value;
        if (n2 != n) {
            this.value = n;
            this.valueChanged(n2);
            this.propertyChanged(15);
        }
    }

    @Override
    public int get_valueMin() {
        return this.valueMin;
    }

    @Override
    public void set_valueMin(int n) {
        int n2 = this.valueMin;
        if (n2 != n) {
            this.valueMin = n;
            this.propertyChanged(16);
        }
    }

    @Override
    public int get_valueMax() {
        return this.valueMax;
    }

    @Override
    public void set_valueMax(int n) {
        int n2 = this.valueMax;
        if (n2 != n) {
            this.valueMax = n;
            this.propertyChanged(17);
        }
    }

    @Override
    public int getLastValue() {
        return this.lastValue;
    }

    protected void valueChanged(int n) {
        this.lastValue = n;
    }
}

