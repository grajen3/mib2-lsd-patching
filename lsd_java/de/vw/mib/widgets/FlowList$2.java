/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.FlowList;

class FlowList$2
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ FlowList this$0;

    FlowList$2(FlowList flowList) {
        this.this$0 = flowList;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.radiusChanged(f2);
    }

    @Override
    public void setValue(float f2) {
        this.this$0.radius = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.radius;
    }
}

