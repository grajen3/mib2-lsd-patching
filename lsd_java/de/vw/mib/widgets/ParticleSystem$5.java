/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.ParticleSystem;

class ParticleSystem$5
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ ParticleSystem this$0;

    ParticleSystem$5(ParticleSystem particleSystem) {
        this.this$0 = particleSystem;
    }

    @Override
    public void valueChanged(float f2) {
    }

    @Override
    public void setValue(float f2) {
        this.this$0.panX = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.panX;
    }
}

