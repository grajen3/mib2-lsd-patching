/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractButton;
import de.vw.mib.widgets.AbstractSlider$ValueCache;
import de.vw.mib.widgets.models.AbstractSliderModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;

public abstract class AbstractSlider
extends AbstractButton
implements AbstractSliderModel {
    protected static final int DEFAULT_OFFSET;
    private int value;
    private int valueMin;
    private int valueMax;
    private int paddingMin;
    private int paddingMax;
    private int step;
    private int orientation;
    protected int positionOnScrollbarButton;
    private float scaleRatio;
    private int scalePositionValue;
    private boolean wrapFlag;
    private AbstractSlider$ValueCache valueCache;

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n3, int n4, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, int n8, int n9, int n10, Insets insets, int n11, int n12, int n13, boolean bl9, int n14, boolean bl10, int n15, int n16) {
        super.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray3, n2, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl6, layoutAttribs, string, n6, image2, n7, bl7, bl8, n8, n10, insets, bl9, n14, n15, n16);
        this.value = n11;
        this.valueMin = n13;
        this.valueMax = n12;
        this.paddingMin = n5;
        this.paddingMax = n4;
        this.wrapFlag = bl10;
        this.step = n9;
        this.orientation = n3;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n3, int n4, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, int n8, int n9, int n10, Insets insets, int n11, int n12, int n13, boolean bl10, int n14, boolean bl11, int n15, int n16) {
        this.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray3, n2, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl6, layoutAttribs, string, n3, n4, n5, n6, image2, n7, bl7, bl8, n8, n9, n10, insets, n11, n12, n13, bl10, n14, bl11, n15, n16);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.calculateScaleRatio(0);
        this.setScalePosition(Math.round((float)(this.get_value() - this.get_valueMin()) * this.getScaleRatio()));
    }

    @Override
    protected void reset() {
        super.reset();
        this.valueCache = new AbstractSlider$ValueCache(this);
    }

    @Override
    public final int get_value() {
        return this.value;
    }

    @Override
    public final void set_value(int n) {
        int n2 = this.value;
        this.valueCache.setValue(n);
        this.trace(new StringBuffer().append(".set_value(), isValueCacheShadow: ").append(this.valueCache.isShadowEnabled()).append(", newValue: ").append(n).append(", (oldValue: ").append(n2).append(")").toString());
        if (!this.valueCache.isShadowEnabled() && n2 != n) {
            this.value = n;
            this.valueChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final int get_valueMax() {
        return this.valueMax;
    }

    @Override
    public final void set_valueMax(int n) {
        int n2 = this.valueMax;
        if (n2 != n) {
            this.valueMax = n;
            this.valueMaxChanged(n2);
            this.propertyChanged(37);
        }
    }

    @Override
    public final int get_valueMin() {
        return this.valueMin;
    }

    @Override
    public final void set_valueMin(int n) {
        int n2 = this.valueMin;
        if (n2 != n) {
            this.valueMin = n;
            this.valueMinChanged(n2);
            this.propertyChanged(36);
        }
    }

    @Override
    public final int get_paddingMin() {
        return this.paddingMin;
    }

    @Override
    public final void set_paddingMin(int n) {
        int n2 = this.paddingMin;
        if (n2 != n) {
            this.paddingMin = n;
            this.paddingMinChanged(n2);
            this.propertyChanged(38);
        }
    }

    @Override
    public final int get_paddingMax() {
        return this.paddingMax;
    }

    @Override
    public final void set_paddingMax(int n) {
        int n2 = this.paddingMax;
        if (n2 != n) {
            this.paddingMax = n;
            this.paddingMaxChanged(n2);
            this.propertyChanged(39);
        }
    }

    @Override
    public final int get_step() {
        return this.step;
    }

    @Override
    public final void set_step(int n) {
        int n2 = this.step;
        if (n2 != n) {
            this.step = n;
            this.stepChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public final int get_orientation() {
        return this.orientation;
    }

    @Override
    public final void set_orientation(int n) {
        int n2 = this.orientation;
        if (n2 != n) {
            this.orientation = n;
            this.orientationChanged(n2);
            this.propertyChanged(41);
        }
    }

    @Override
    public float getScaleRatio() {
        return this.scaleRatio;
    }

    @Override
    public void setScaleRatio(float f2) {
        this.scaleRatio = f2;
    }

    @Override
    public void setScalePosition(int n) {
        this.scalePositionValue = n;
    }

    @Override
    public int getScalePosition() {
        return this.scalePositionValue;
    }

    @Override
    public final boolean is_wrapFlag() {
        return this.wrapFlag;
    }

    @Override
    public final void set_wrapFlag(boolean bl) {
        boolean bl2 = this.wrapFlag;
        if (bl2 != bl) {
            this.wrapFlag = bl;
            this.wrapFlagChanged(bl2);
            this.propertyChanged(42);
        }
    }

    @Override
    public abstract void setPositionOnScrollbarButton(int n, int n2) {
    }

    @Override
    public int getPositionOnScrollbarButton() {
        return this.positionOnScrollbarButton;
    }

    protected abstract int getValueChangeTimer() {
    }

    protected abstract void valueChanged(int n) {
    }

    protected void valueMinChanged(int n) {
        this.calculateScaleRatio(0);
    }

    protected void valueMaxChanged(int n) {
        this.calculateScaleRatio(0);
    }

    protected void paddingMinChanged(int n) {
        this.calculateScaleRatio(0);
    }

    protected void paddingMaxChanged(int n) {
        this.calculateScaleRatio(0);
    }

    protected void stepChanged(int n) {
    }

    protected void orientationChanged(int n) {
        this.calculateScaleRatio(0);
    }

    protected void fireEventTimerChanged(int n) {
    }

    protected void wrapFlagChanged(boolean bl) {
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.calculateScaleRatio(0);
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.calculateScaleRatio(0);
    }

    protected void calculateScaleRatio(int n) {
        float f2;
        int n2;
        int n3 = this.get_valueMax();
        if (n3 > (n2 = this.get_valueMin())) {
            float f3 = 0 == this.get_orientation() || 1 == this.get_orientation() ? (float)this.get_width() : (float)this.get_height();
            f2 = (f3 - (float)this.get_paddingMin() - (float)this.get_paddingMax() - (float)n) / (float)(n3 - n2);
        } else {
            f2 = 1.0f;
        }
        this.setScaleRatio(f2);
    }

    @Override
    public void startValueChangeShadowTimer() {
        this.valueCache.startValueChangeShadowTimer();
    }

    @Override
    public void stopValueChangeShadowTimer(boolean bl) {
        this.valueCache.stopValueChangeShadowTimer(bl);
    }

    protected void trace(String string) {
        if (LOGGER.isTraceEnabled(16)) {
            String string2 = this.getQualifiedName();
            LOGGER.trace(16).append(string2).append(string).log();
        }
    }
}

