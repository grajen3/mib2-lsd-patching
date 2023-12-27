/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.FlowList;

class FlowList$3
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ FlowList this$0;

    FlowList$3(FlowList flowList) {
        this.this$0 = flowList;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.distanceChanged(f2);
    }

    @Override
    public void setValue(float f2) {
        this.this$0.distance = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.distance;
    }
}

