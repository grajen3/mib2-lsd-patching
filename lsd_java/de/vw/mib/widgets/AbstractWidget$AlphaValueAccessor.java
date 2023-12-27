/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$ValueAccessor;

public final class AbstractWidget$AlphaValueAccessor
implements AbstractWidget$ValueAccessor,
AnimationListener {
    private short originalValue;
    private final /* synthetic */ AbstractWidget this$0;

    protected AbstractWidget$AlphaValueAccessor(AbstractWidget abstractWidget) {
        this.this$0 = abstractWidget;
    }

    public void setOriginalValue(short s) {
        this.originalValue = s;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.alphaChanged(Math.round(f2));
    }

    @Override
    public void setValue(float f2) {
        this.this$0.alpha = (short)Math.round(f2);
    }

    @Override
    public float getValue() {
        return this.this$0.alpha;
    }

    private void restoreOriginalValue() {
        if (this.this$0.alpha != this.originalValue) {
            this.this$0.alpha = this.originalValue;
            this.valueChanged(this.this$0.alpha);
        }
    }

    @Override
    public void animationStopped(Animation animation) {
        this.restoreOriginalValue();
    }

    @Override
    public void animationStarted(Animation animation) {
    }

    @Override
    public void animationRunning(Animation animation) {
    }

    @Override
    public void animationProgress(Animation animation, int n) {
    }
}

