/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.TransformContainer;

class TransformContainer$2
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ TransformContainer this$0;

    TransformContainer$2(TransformContainer transformContainer) {
        this.this$0 = transformContainer;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.rotationXChanged(f2);
    }

    @Override
    public void setValue(float f2) {
        this.this$0.rotationX = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.rotationX;
    }
}

