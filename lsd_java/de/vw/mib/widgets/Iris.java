/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.Iris$ChangeAccelerationAnimation;
import de.vw.mib.widgets.Iris$ChangeActiveSegmentAnimation;
import de.vw.mib.widgets.Iris$GlowAnimation;
import de.vw.mib.widgets.models.IrisModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public final class Iris
extends Container
implements IrisModel {
    private static final int CURSOR_START_VALE;
    private static final float FULL_CIRCLE_ANGLE;
    private static final float TIME_COLUMN_GROWTH;
    private static final float TIME_ENTER_ANIMATION;
    private static final float SEGMENTS_ROTATION_DURATION;
    private static final int SEGMENTS_MAX_ROTATION;
    private static final float INDICATOR_ROTATION_DURATION;
    private static final float INDICATOR_ROTATION_START;
    private static final int MAX_INDICATOR_ROTATION;
    private static final int ANIMATION_INTERVAL_MIN;
    private int acceleration;
    private Image[] acceleratorImages;
    private int activeSegment;
    private float enterAnimationProgress;
    private Image irisBackgroundImage;
    private int indicatorGlowOffset;
    private Image[] indicatorImages;
    private Color[] irisColors;
    private int[] irisRadiuses;
    private int[] irisRadii;
    private Image[] irisSegmentsImages;
    private int maxAcceleration;
    private int maxAccelerationRotation;
    private int segmentsValueMax;
    private int segmentsValueMin;
    private int[] values;
    private float glowSize;
    private float glowAlpha;
    private boolean glowVisible;
    private float glowAngle;
    private Color4f indicatorColorEnd;
    private Color4f indicatorColorStart;
    private Color4f[] irisColorsUI;
    protected float indicatorRotation;
    private float scaledActiveSegmentSize;
    private float[] scaledValues;
    private float segmentsRotation;
    private Iris$ChangeAccelerationAnimation changeAccelerationAnimation;
    private Iris$ChangeActiveSegmentAnimation changeActiveSegmentAnimation;
    private Iris$GlowAnimation glowAnimation;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$IrisUI;

    @Override
    protected void reset() {
        super.reset();
        this.resetInternalProperties();
    }

    public void init(int n, Image[] imageArray, boolean bl, int n2, int n3, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, float f2, int n4, int n5, Image[] imageArray2, Image image2, Color[] colorArray, int[] nArray, Image[] imageArray3, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, int n6, int n7, String string, int n8, Image image3, int n9, boolean bl6, int n10, int n11, int n12, Insets insets, int[] nArray2, boolean bl7, int n13, int n14, int n15) {
        int[] nArray3 = null;
        this.init(n, imageArray, bl, n2, n3, image, bl2, bl3, easingParamsArray, bl4, f2, n4, n5, imageArray2, image2, colorArray, nArray3, nArray, imageArray3, keyframeAnimationArray, bl5, layoutAttribs, n6, n7, string, n8, image3, n9, bl6, n10, n11, n12, insets, nArray2, bl7, n13, n14, n15);
    }

    public void init(int n, Image[] imageArray, boolean bl, int n2, int n3, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, float f2, int n4, int n5, Image[] imageArray2, Image image2, Color[] colorArray, int[] nArray, int[] nArray2, Image[] imageArray3, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, int n6, int n7, String string, int n8, Image image3, int n9, boolean bl6, int n10, int n11, int n12, Insets insets, int[] nArray3, boolean bl7, int n13, int n14, int n15) {
        super.init(bl, n3, image, bl2, bl3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, n8, image3, n9, bl6, n12, insets, bl7, n13, n14, n15);
        this.acceleration = n;
        this.acceleratorImages = imageArray;
        this.activeSegment = n2;
        this.enterAnimationProgress = f2;
        this.indicatorGlowOffset = n5;
        this.indicatorImages = imageArray2;
        this.irisBackgroundImage = image2;
        this.irisColors = colorArray;
        this.irisRadiuses = nArray2;
        this.irisRadii = nArray;
        this.irisSegmentsImages = imageArray3;
        this.maxAcceleration = n6;
        this.maxAccelerationRotation = n7;
        this.segmentsValueMax = n10;
        this.segmentsValueMin = n11;
        this.values = nArray3;
    }

    @Override
    public void deInit() {
        this.resetInternalProperties();
        super.deInit();
    }

    private void resetInternalProperties() {
        this.glowAlpha = 0.0f;
        this.glowAngle = 0.0f;
        this.glowSize = 0.0f;
        this.glowVisible = false;
        this.indicatorColorEnd = null;
        this.indicatorColorStart = null;
        this.indicatorRotation = 0.0f;
        if (this.irisColorsUI != null) {
            for (int i2 = this.irisColorsUI.length - 1; i2 >= 0; --i2) {
                this.irisColorsUI[i2] = null;
            }
        }
        this.irisColorsUI = null;
        this.scaledActiveSegmentSize = 0.0f;
        this.scaledValues = null;
        this.segmentsRotation = 0.0f;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateIrisColorsUI();
        this.updateIndicatorColors();
        this.updateScaledActiveSegmentSize(this.segmentsValueMax);
        this.updateScaledValues();
        this.setIrisSegmentsInvalid(true);
        this.invalidate();
    }

    @Override
    public void activate() {
        super.activate();
        this.accelerationChanged(0);
    }

    @Override
    public int get_acceleration() {
        return this.acceleration;
    }

    @Override
    public void set_acceleration(int n) {
        int n2 = this.acceleration;
        if (n2 != n) {
            this.acceleration = n;
            this.accelerationChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public Image[] get_acceleratorImages() {
        return this.acceleratorImages;
    }

    @Override
    public void set_acceleratorImages(Image[] imageArray) {
        Object[] objectArray = this.acceleratorImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.acceleratorImages = imageArray;
            this.accelerationImagesChanged((Image[])objectArray);
            this.propertyChanged(24);
        }
    }

    @Override
    public int get_segmentsValueMax() {
        return this.segmentsValueMax;
    }

    @Override
    public void set_segmentsValueMax(int n) {
        int n2 = this.segmentsValueMax;
        if (n2 != n) {
            this.segmentsValueMax = n;
            this.segmentsValueMaxChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public int get_segmentsValueMin() {
        return this.segmentsValueMin;
    }

    @Override
    public void set_segmentsValueMin(int n) {
        int n2 = this.segmentsValueMin;
        if (n2 != n) {
            this.segmentsValueMin = n;
            this.segmentsValueMinChanged(n2);
            this.propertyChanged(36);
        }
    }

    @Override
    public Image get_irisBackgroundImage() {
        return this.irisBackgroundImage;
    }

    @Override
    public void set_irisBackgroundImage(Image image) {
        Image image2 = this.irisBackgroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.irisBackgroundImage = image;
            this.irisBackgroundImageChanged(image2);
            this.propertyChanged(29);
        }
    }

    @Override
    public int get_maxAcceleration() {
        return this.maxAcceleration;
    }

    @Override
    public void set_maxAcceleration(int n) {
        int n2 = this.maxAcceleration;
        if (n2 != n) {
            this.maxAcceleration = n;
            this.maxAccellerationChanged(n2);
            this.propertyChanged(33);
        }
    }

    @Override
    public int get_maxAccelerationRotation() {
        return this.maxAccelerationRotation;
    }

    @Override
    public void set_maxAccelerationRotation(int n) {
        int n2 = this.maxAccelerationRotation;
        if (n2 != n) {
            this.maxAccelerationRotation = n;
            this.maxAccelerationRotationChanged(n2);
            this.propertyChanged(34);
        }
    }

    @Override
    public Color[] get_irisColors() {
        return this.irisColors;
    }

    @Override
    public void set_irisColors(Color[] colorArray) {
        Object[] objectArray = this.irisColors;
        if (objectArray == null || !Arrays.equals(objectArray, colorArray)) {
            this.irisColors = colorArray;
            this.segmentColorsChanged((Color[])objectArray);
            this.propertyChanged(30);
        }
    }

    @Override
    public int get_activeSegment() {
        return this.activeSegment;
    }

    @Override
    public void set_activeSegment(int n) {
        int n2 = this.activeSegment;
        if (n2 != n && !this.startChangeActiveSegmentAnimationPartOne(n)) {
            this.activeSegment = n;
            this.activeSegmentChanged(n2);
            this.propertyChanged(25);
        }
    }

    @Override
    public int[] get_irisRadiuses() {
        return this.irisRadiuses;
    }

    @Override
    public void set_irisRadiuses(int[] nArray) {
    }

    @Override
    public int[] get_irisRadii() {
        return this.irisRadii;
    }

    @Override
    public void set_irisRadii(int[] nArray) {
        int[] nArray2 = this.irisRadii;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.irisRadii = nArray;
            this.irisiRadiiChanged(nArray2);
            this.propertyChanged(32);
        }
    }

    @Override
    public int[] get_values() {
        return this.values;
    }

    @Override
    public void set_values(int[] nArray) {
        int[] nArray2 = this.values;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.values = nArray;
            this.valuesChanged(nArray2);
            this.propertyChanged(37);
        }
    }

    @Override
    public float get_enterAnimationProgress() {
        return this.enterAnimationProgress;
    }

    @Override
    public void set_enterAnimationProgress(float f2) {
        float f3 = this.enterAnimationProgress;
        if (f3 != f2) {
            this.enterAnimationProgress = f2;
            this.enterAnimationProgressChanged(f3);
            this.propertyChanged(26);
        }
    }

    @Override
    public Image[] get_indicatorImages() {
        return this.indicatorImages;
    }

    @Override
    public void set_indicatorImages(Image[] imageArray) {
        Object[] objectArray = this.indicatorImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.indicatorImages = imageArray;
            this.indicatorImagesChanged((Image[])objectArray);
            this.propertyChanged(27);
        }
    }

    @Override
    public int get_indicatorGlowOffset() {
        return this.indicatorGlowOffset;
    }

    @Override
    public void set_indicatorGlowOffset(int n) {
        int n2 = this.indicatorGlowOffset;
        if (n2 != n) {
            this.indicatorGlowOffset = n;
            this.indicatorGlowOffsetChanged(n2);
            this.propertyChanged(28);
        }
    }

    @Override
    public Image[] get_irisSegmentsImages() {
        return this.irisSegmentsImages;
    }

    @Override
    public void set_irisSegmentsImages(Image[] imageArray) {
        Object[] objectArray = this.irisSegmentsImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.irisSegmentsImages = imageArray;
            this.irisSegmentsImagesChanged((Image[])objectArray);
            this.propertyChanged(38);
        }
    }

    @Override
    public Color4f getStartColorSegment() {
        if (this.irisColorsUI != null) {
            return this.irisColorsUI[0];
        }
        return Color4f.WHITE;
    }

    @Override
    public Color4f getEndColorSegment() {
        if (this.irisColorsUI != null) {
            return this.irisColorsUI[1];
        }
        return Color4f.WHITE;
    }

    @Override
    public Color4f getStartColorActiveSegment() {
        if (this.irisColorsUI != null) {
            return this.irisColorsUI[6];
        }
        return Color4f.WHITE;
    }

    @Override
    public Color4f getStartColorIndicator() {
        if (this.irisColorsUI != null) {
            return this.indicatorColorStart;
        }
        return Color4f.WHITE;
    }

    @Override
    public Color4f getEndColorIndicator() {
        if (this.irisColorsUI != null) {
            return this.indicatorColorEnd;
        }
        return Color4f.WHITE;
    }

    @Override
    public int getActiveSegmentChecked() {
        if (this.values == null || this.activeSegment < -1 || this.activeSegment >= this.values.length) {
            return -1;
        }
        return this.activeSegment;
    }

    @Override
    public float getSpanAngleForOneSegment() {
        if (this.values != null && this.values.length > 0) {
            return 46147 / (float)this.values.length;
        }
        return 0.0f;
    }

    @Override
    public void setIrisSegmentsInvalid(boolean bl) {
        this.setInternalStateFlag(18, bl);
    }

    @Override
    public boolean areIrisSegmentsInvalid() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public void setActiveSegmentInvalid(boolean bl) {
        this.setInternalStateFlag(19, bl);
    }

    @Override
    public boolean isActiveSegmentInvalid() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public float getScaledActiveSegmentSize() {
        return this.scaledActiveSegmentSize;
    }

    @Override
    public float getGlowAlpha() {
        return this.glowAlpha;
    }

    @Override
    public void setGlowAlpha(float f2) {
        float f3 = this.glowAlpha;
        if (f3 != f2) {
            this.glowAlpha = f2;
        }
    }

    @Override
    public float getGlowAngle() {
        return this.glowAngle;
    }

    @Override
    public void setGlowAngle(float f2) {
        float f3 = this.glowAngle;
        if (f3 != f2) {
            this.glowAngle = f2;
        }
    }

    @Override
    public float getGlowSize() {
        return this.glowSize;
    }

    @Override
    public void setGlowSize(float f2) {
        float f3 = this.glowSize;
        if (f3 != f2) {
            this.glowSize = f2;
        }
    }

    @Override
    public boolean getGlowVisible() {
        return this.glowVisible;
    }

    @Override
    public void setGlowVisible(boolean bl) {
        boolean bl2 = this.glowVisible;
        if (bl2 != bl) {
            this.glowVisible = bl;
        }
    }

    @Override
    public float[] getScaledValues() {
        return this.scaledValues;
    }

    @Override
    public boolean isEnterAnimationRunning() {
        return this.enterAnimationProgress < 1.0f;
    }

    @Override
    public float getSegmentsRotation() {
        return this.segmentsRotation;
    }

    protected void setIndicatorRotation(float f2) {
        if (!Util.equalsEpsilon(this.indicatorRotation, f2)) {
            this.indicatorRotation = f2;
            this.repaint();
        }
    }

    @Override
    public float getIndicatorRotation() {
        return this.indicatorRotation;
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$IrisUI == null ? (class$de$vw$mib$widgets$ui$IrisUI = Iris.class$("de.vw.mib.widgets.ui.IrisUI")) : class$de$vw$mib$widgets$ui$IrisUI};
    }

    private void accelerationChanged(int n) {
        if (!this.startChangeAccelerationAnimation(n)) {
            this.updateIndicatorRotation();
            this.updateIndicatorColors();
            this.repaint();
        }
    }

    private void accelerationImagesChanged(Image[] imageArray) {
        this.repaint();
    }

    private void activeSegmentChanged(int n) {
        if (LOGGER.isTraceEnabled(128)) {
            LOGGER.trace(128).append("Iris '").append(this.getQualifiedName()).append("': active segment changed - newValue=").append(this.activeSegment).log();
        }
        this.setIrisSegmentsInvalid(true);
        this.setActiveSegmentInvalid(true);
        this.updateScaledValues();
        this.repaint();
    }

    private void enterAnimationProgressChanged(float f2) {
        this.setIrisSegmentsInvalid(true);
        this.setActiveSegmentInvalid(true);
        this.updateScaledValues();
        this.updateScaledActiveSegmentSize(this.segmentsValueMax);
        this.updateSegmentsRotation();
        this.updateIndicatorRotation();
        this.repaint();
    }

    private void indicatorGlowOffsetChanged(int n) {
        this.repaint();
    }

    private void indicatorImagesChanged(Image[] imageArray) {
        this.repaint();
    }

    private void irisBackgroundImageChanged(Image image) {
        this.repaint();
    }

    private void irisiRadiusesChanged(int[] nArray) {
    }

    private void irisiRadiiChanged(int[] nArray) {
        this.setIrisSegmentsInvalid(true);
        this.updateScaledValues();
        this.repaint();
    }

    private void irisSegmentsImagesChanged(Image[] imageArray) {
        this.repaint();
    }

    private void maxAccellerationChanged(int n) {
        this.updateIndicatorColors();
        this.updateIndicatorRotation();
    }

    private void maxAccelerationRotationChanged(int n) {
        this.updateIndicatorRotation();
        this.repaint();
    }

    private void segmentColorsChanged(Color[] colorArray) {
        if (this.irisColors != null && this.irisColors.length >= 10) {
            this.updateIrisColorsUI();
            this.updateIndicatorColors();
        }
        this.repaint();
    }

    private void segmentsValueMaxChanged(int n) {
        this.setIrisSegmentsInvalid(true);
        this.updateScaledValues();
        this.updateScaledActiveSegmentSize(this.segmentsValueMax);
        this.repaint();
    }

    private void segmentsValueMinChanged(int n) {
        this.setIrisSegmentsInvalid(true);
        this.updateScaledValues();
        this.repaint();
    }

    private void valuesChanged(int[] nArray) {
        this.setIrisSegmentsInvalid(true);
        this.updateScaledValues();
        this.repaint();
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopChangeAccelerationAnimation();
        this.stopChangeActiveSegmentAnimation();
        this.stopGlowAnimation();
    }

    private void updateIndicatorRotation() {
        if (this.isEnterAnimationRunning()) {
            float f2 = 0.0f;
            if (this.enterAnimationProgress > 0.0f && this.enterAnimationProgress < 1.0f) {
                f2 = (this.enterAnimationProgress - 0.0f) / 1.0f;
                int n = 8257 - f2 * 8257;
                this.setIndicatorRotation(n);
            } else {
                this.setIndicatorRotation(0.0f);
            }
        } else if (!this.is_activated()) {
            float f3 = this.calcIndicatorRotation(this.acceleration);
            this.setIndicatorRotation(f3);
        }
    }

    protected float calcIndicatorRotation(float f2) {
        if (Math.abs(f2) > (float)this.maxAcceleration) {
            f2 = f2 >= 0.0f ? (float)this.maxAcceleration : (float)(-this.maxAcceleration);
        }
        if (this.maxAcceleration > 0) {
            return (float)(-this.maxAccelerationRotation) / (float)this.maxAcceleration * f2;
        }
        return 0.0f;
    }

    protected void updateScaledActiveSegmentSize(int n) {
        if (this.values == null) {
            return;
        }
        float f2 = (float)this.activeSegment * 16447 / (float)this.values.length;
        this.scaledActiveSegmentSize = this.calcValueSizeInPixel(n, f2);
        if (LOGGER.isTraceEnabled(512)) {
            LOGGER.trace(512).append("Iris '").append(this.getQualifiedName()).append("': update active segment size - activeSegmentSize=").append(n).log();
        }
    }

    private void updateScaledValues() {
        if (LOGGER.isTraceEnabled(128)) {
            LOGGER.trace(128).append("Iris '").append(this.getQualifiedName()).append("': update scaled values - activeSegment= ").append(this.activeSegment).log();
        }
        if (this.values == null) {
            return;
        }
        if (this.scaledValues == null || this.scaledValues.length != this.values.length) {
            this.scaledValues = new float[this.values.length];
        }
        for (int i2 = this.scaledValues.length - 1; i2 >= 0; --i2) {
            float f2 = (float)i2 * 16447 / (float)this.values.length;
            this.scaledValues[i2] = i2 == this.activeSegment ? 0.0f : (float)this.calcValueSizeInPixel(this.values[i2], f2);
        }
    }

    private int calcValueSizeInPixel(int n, float f2) {
        int n2 = this.segmentsValueMax;
        int n3 = this.segmentsValueMin;
        int[] nArray = this.irisRadii;
        if (nArray == null || nArray.length < 2) {
            return 0;
        }
        int n4 = nArray[1] - nArray[0];
        float f3 = (float)n4 / (float)(n2 - n3);
        float f4 = 0.0f;
        if (this.isEnterAnimationRunning()) {
            f4 = this.enterAnimationProgress < f2 ? (float)n2 * f3 : (this.enterAnimationProgress >= f2 + 32830 ? (float)(n2 - n) * f3 : ((float)n2 - (this.enterAnimationProgress - f2) / 32830 * (float)n) * f3);
            f4 += (float)nArray[0];
        } else {
            f4 = (float)nArray[0] + (float)(n2 - n) * f3;
        }
        return Math.round(f4);
    }

    private void updateSegmentsRotation() {
        float f2 = 0.0f;
        if (this.enterAnimationProgress < -1701209794) {
            f2 = this.enterAnimationProgress / -1701209794;
            this.segmentsRotation = 8385 + f2 * 8257;
        } else {
            this.segmentsRotation = 0.0f;
        }
    }

    private void updateIrisColorsUI() {
        if (this.irisColors != null && this.irisColors.length >= 10) {
            this.irisColorsUI = new Color4f[10];
            for (int i2 = 9; i2 >= 0; --i2) {
                if (i2 >= this.irisColors.length) {
                    this.irisColorsUI[i2] = Color4f.WHITE;
                    continue;
                }
                Color4b color4b = this.irisColors[i2].getCurrentColor();
                this.irisColorsUI[i2] = new Color4f(color4b.getRed(), color4b.getGreen(), color4b.getBlue(), color4b.getAlpha());
            }
        } else {
            this.irisColorsUI = null;
        }
    }

    protected void updateIndicatorColors() {
        if (this.irisColorsUI != null) {
            if (this.indicatorColorStart == null) {
                this.indicatorColorStart = new Color4f(Color4f.WHITE);
            }
            if (this.indicatorColorEnd == null) {
                this.indicatorColorEnd = new Color4f(Color4f.WHITE);
            }
            this.calcColor(this.irisColorsUI[2], this.irisColorsUI[4], this.indicatorColorStart);
            this.calcColor(this.irisColorsUI[3], this.irisColorsUI[5], this.indicatorColorEnd);
        }
    }

    private void calcColor(Color4f color4f, Color4f color4f2, Color4f color4f3) {
        float f2;
        float f3 = 0.0f;
        float f4 = f2 = Math.abs(this.indicatorRotation) < (float)this.maxAcceleration ? Math.abs(this.indicatorRotation) : (float)this.maxAcceleration;
        if (this.maxAcceleration > 0) {
            f3 = f2 / (float)this.maxAcceleration;
        }
        color4f3.setRed(color4f.getRed() + (color4f2.getRed() - color4f.getRed()) * f3);
        color4f3.setGreen(color4f.getGreen() + (color4f2.getGreen() - color4f.getGreen()) * f3);
        color4f3.setBlue(color4f.getBlue() + (color4f2.getBlue() - color4f.getBlue()) * f3);
        color4f3.setAlpha(color4f.getAlpha() + (color4f2.getAlpha() - color4f.getAlpha()) * f3);
    }

    private boolean startChangeAccelerationAnimation(int n) {
        float f2 = this.calcIndicatorRotation(this.acceleration);
        if (this.changeAccelerationAnimation != null && this.changeAccelerationAnimation.isActive() && Util.equalsEpsilon(f2, this.changeAccelerationAnimation.getStartValue() + this.changeAccelerationAnimation.getDeltaValue())) {
            return true;
        }
        EasingParams easingParams = this.getEasing(7);
        if (easingParams == null) {
            return false;
        }
        float f3 = this.changeAccelerationAnimation != null ? this.changeAccelerationAnimation.getCurrentValue() : this.calcIndicatorRotation(n);
        this.stopChangeAccelerationAnimation();
        this.changeAccelerationAnimation = new Iris$ChangeAccelerationAnimation(this, easingParams, f3, f2);
        return this.startInternalAnimation(this.changeAccelerationAnimation);
    }

    private void stopChangeAccelerationAnimation() {
        if (this.changeAccelerationAnimation != null) {
            this.stopInternalAnimation(this.changeAccelerationAnimation);
            this.changeAccelerationAnimation = null;
        }
    }

    private boolean startChangeActiveSegmentAnimationPartOne(int n) {
        if (this.changeActiveSegmentAnimation != null && this.changeActiveSegmentAnimation.isActive() && this.changeActiveSegmentAnimation.getNewActiveSegment() == n) {
            return true;
        }
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null || n < 0 || this.activeSegment < 0 || this.activeSegment >= this.values.length) {
            return false;
        }
        this.stopChangeActiveSegmentAnimation();
        this.changeActiveSegmentAnimation = new Iris$ChangeActiveSegmentAnimation(this, easingParams, this.segmentsValueMax, this.values[this.activeSegment], n);
        boolean bl = this.startInternalAnimation(this.changeActiveSegmentAnimation);
        if (bl && LOGGER.isTraceEnabled(128)) {
            LOGGER.trace(128).append("Iris '").append(this.getQualifiedName()).append("': ChangeSegmentAnimation - part one started; newActiveSegment=").append(n).log();
        }
        this.startGlowAnimation();
        return bl;
    }

    protected void startChangeActiveSegmentAnimationPartTwo(int n) {
        if (this.changeActiveSegmentAnimation != null && this.changeActiveSegmentAnimation.isActive() && this.changeActiveSegmentAnimation.getNewActiveSegment() == n) {
            return;
        }
        EasingParams easingParams = this.getEasing(9);
        if (easingParams == null) {
            return;
        }
        this.stopChangeActiveSegmentAnimation();
        this.changeActiveSegmentAnimation = new Iris$ChangeActiveSegmentAnimation(this, easingParams, 33346, this.get_segmentsValueMax(), n);
        boolean bl = this.startInternalAnimation(this.changeActiveSegmentAnimation);
        if (bl && LOGGER.isTraceEnabled(128)) {
            LOGGER.trace(128).append("Iris '").append(this.getQualifiedName()).append("': ChangeSegmentAnimation - part two started").log();
        }
    }

    private void stopChangeActiveSegmentAnimation() {
        if (this.changeActiveSegmentAnimation != null) {
            this.stopInternalAnimation(this.changeActiveSegmentAnimation);
            if (this.changeActiveSegmentAnimation.isActive()) {
                this.stopInternalAnimation(this.changeActiveSegmentAnimation);
            }
            this.changeActiveSegmentAnimation = null;
        }
    }

    private boolean startGlowAnimation() {
        if (this.glowAnimation != null && this.glowAnimation.isActive()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(10);
        if (easingParams == null) {
            return false;
        }
        this.glowAnimation = new Iris$GlowAnimation(this, easingParams, 0.0f, 1.0f, this.activeSegment);
        return this.startInternalAnimation(this.glowAnimation);
    }

    private void stopGlowAnimation() {
        if (this.glowAnimation != null) {
            this.stopInternalAnimation(this.glowAnimation);
            this.glowAnimation = null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

