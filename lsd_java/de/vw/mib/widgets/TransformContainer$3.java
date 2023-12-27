/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.TransformContainer;

class TransformContainer$3
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ TransformContainer this$0;

    TransformContainer$3(TransformContainer transformContainer) {
        this.this$0 = transformContainer;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.rotationYChanged(f2);
    }

    @Override
    public void setValue(float f2) {
        this.this$0.rotationY = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.rotationY;
    }
}

