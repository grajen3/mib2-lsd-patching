/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Statistics;

class Statistics$ValueUpdateAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private int[] startValues;
    private int deltaValueMax;
    private int[] deltas;
    private int[] currentValues;
    private final /* synthetic */ Statistics this$0;

    public Statistics$ValueUpdateAnimation(Statistics statistics, EasingParams easingParams, int[] nArray, int[] nArray2) {
        this.this$0 = statistics;
        super(statistics, easingParams, 0.0f, 1.0f);
        this.startValues = nArray;
        this.deltaValueMax = 0;
        this.currentValues = new int[nArray != null ? this.startValues.length : 0];
        this.analyzeValues(nArray, nArray2);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.disableAnimations();
        this.this$0.disablePropertyChanged();
        this.calcCurrentValues(f2);
        this.this$0.enablePropertyChanged();
        this.this$0.enableAnimations();
    }

    private void calcCurrentValues(float f2) {
        for (int i2 = this.currentValues.length - 1; i2 >= 0; --i2) {
            this.currentValues[i2] = 0;
            int n = Math.round((float)this.deltaValueMax * f2);
            if (this.deltas[i2] > 0) {
                this.currentValues[i2] = n < this.deltas[i2] ? n : this.deltas[i2];
            } else if (this.deltas[i2] < 0) {
                this.currentValues[i2] = -n > this.deltas[i2] ? -n : this.deltas[i2];
            }
            int n2 = i2;
            this.currentValues[n2] = this.currentValues[n2] + this.startValues[i2];
        }
        this.this$0.updateValuesSeparated(this.currentValues, false);
    }

    private void analyzeValues(int[] nArray, int[] nArray2) {
        if (nArray == null || nArray2 == null || nArray.length != nArray2.length) {
            return;
        }
        this.deltas = new int[nArray.length];
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            this.deltas[i2] = nArray2[i2] - nArray[i2];
            int n = Math.abs(this.deltas[i2]);
            if (n <= this.deltaValueMax) continue;
            this.deltaValueMax = n;
        }
    }
}

