/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.ParticleSystem;

class ParticleSystem$3
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ ParticleSystem this$0;

    ParticleSystem$3(ParticleSystem particleSystem) {
        this.this$0 = particleSystem;
    }

    @Override
    public void valueChanged(float f2) {
    }

    @Override
    public void setValue(float f2) {
        this.this$0.vanishX = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.vanishX;
    }
}

