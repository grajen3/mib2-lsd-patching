/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.ParticleSystem;

final class ParticleSystem$AttributeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    public static final int ACCESS_INDEX_X;
    public static final int ACCESS_INDEX_Y;
    public static final int ACCESS_INDEX_Z;
    public static final int ACCESS_INDEX_W;
    private float newAttributeEndValue;
    private final Tuple4f attributeStartValues;
    private final Tuple4f attributeEndValues;
    private final Tuple4f attributeAnimationValues;
    private final int accessIndex;
    private final float factor;
    private final /* synthetic */ ParticleSystem this$0;

    public ParticleSystem$AttributeAnimation(ParticleSystem particleSystem, int n, Tuple4f tuple4f, Tuple4f tuple4f2, Tuple4f tuple4f3, float f2) {
        this.this$0 = particleSystem;
        super(particleSystem);
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
        this.factor = f2;
        this.accessIndex = n;
        this.attributeStartValues = tuple4f;
        this.attributeEndValues = tuple4f2;
        this.attributeAnimationValues = tuple4f3;
    }

    public void init(EasingParams easingParams, float f2) {
        if (this.isActive()) {
            this.this$0.stopInternalAnimation(this);
        }
        this.setEasingParams(easingParams);
        this.newAttributeEndValue = f2 * this.factor;
    }

    @Override
    public void start(long l) {
        super.start(l);
        this.attributeStartValues.set(this.accessIndex, this.attributeEndValues.get(this.accessIndex));
        this.attributeEndValues.set(this.accessIndex, this.newAttributeEndValue);
    }

    @Override
    public void stop() {
        super.stop();
        if (this.getCurrentValue() > 0.0f) {
            this.setAnimationEndValue();
        } else {
            this.revertToStartValue();
        }
    }

    public void setAnimationEndValue() {
        this.attributeAnimationValues.set(this.accessIndex, 1.0f);
        this.attributeEndValues.set(this.accessIndex, this.newAttributeEndValue);
        this.attributeStartValues.set(this.accessIndex, this.newAttributeEndValue);
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.attributeAnimationValues.set(this.accessIndex, f2);
    }

    private void revertToStartValue() {
        this.attributeEndValues.set(this.accessIndex, this.attributeStartValues.get(this.accessIndex));
    }
}

