/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.TransformContainer;

class TransformContainer$4
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ TransformContainer this$0;

    TransformContainer$4(TransformContainer transformContainer) {
        this.this$0 = transformContainer;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.rotationZChanged(f2);
    }

    @Override
    public void setValue(float f2) {
        this.this$0.rotationZ = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.rotationZ;
    }
}

