/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Instruments$GMeterChangeAnimation;
import de.vw.mib.widgets.Instruments$GMeterPhaseOneEnterAnimation;
import de.vw.mib.widgets.Instruments$GMeterPhaseThreeEnterAnimation;
import de.vw.mib.widgets.Instruments$GMeterPhaseTwoEnterAnimation;
import de.vw.mib.widgets.Instruments$HaloKind;
import de.vw.mib.widgets.Instruments$HaloKindManager;
import de.vw.mib.widgets.Instruments$PointerAlphaAnimation;
import de.vw.mib.widgets.Instruments$PointerEnterAnimation;
import de.vw.mib.widgets.Instruments$ValueAnimation;
import de.vw.mib.widgets.TransformContainer;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.models.InstrumentsModel;
import de.vw.mib.widgets.models.InstrumentsModel$Interval;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public final class Instruments
extends TransformContainer
implements InstrumentsModel {
    private static final InstrumentsModel$Interval EMPTY_INTERVAL = new InstrumentsModel$Interval(0, 0);
    private static final InstrumentsModel$Interval FULL_CIRCLE_INTERVAL = new InstrumentsModel$Interval(0, 360);
    private static final int PHASE_1;
    private static final int PHASE_2;
    private static final int[] HALO_ALPHAS;
    private static final int ANIMATION_INTERVAL_MIN;
    private Image backgroundImage;
    private Color backgroundColor;
    private Image foregroundImage;
    private Color foregroundColor;
    private int pointerIdx;
    private Image[] pointerImages;
    private Color[] pointerColors;
    private int[] scaleAngles;
    private int[] scaleStrokeAngles;
    private Color[] scaleStrokeColors;
    private Image[] scaleStrokeImages;
    private int[] scaleStrokeTypes;
    private int[] scaleValues;
    private int value;
    private int valueMax;
    private int valueMin;
    private int valueOut;
    private Image warningZoneImage;
    private int[] warningZoneAngles;
    private int valueAngle;
    private int mode;
    private int[] haloAlphas;
    private int radiusDrawingArea;
    private float internalAngle;
    private InstrumentsModel$Interval[] scaleAnglesIntervals;
    private InstrumentsModel$Interval[] scaleValuesIntervals;
    private Instruments$ValueAnimation valueAnimation;
    private Instruments$PointerEnterAnimation pointerEnterAnimation;
    private Instruments$GMeterPhaseOneEnterAnimation[] gMeterPhaseOneEnterAnimations;
    private Instruments$GMeterPhaseTwoEnterAnimation[] gMeterPhaseTwoEnterAnimations;
    private Instruments$GMeterPhaseThreeEnterAnimation[] gMeterPhaseThreeEnterAnimations;
    private Instruments$PointerAlphaAnimation[] pointerAlphaAnimations;
    protected Instruments$GMeterChangeAnimation gMeterChangeAnimation;
    protected Instruments$HaloKind haloCreator;
    private boolean enterAnimationFinished;
    private int[] haloAlphasInternal;
    private boolean newValue;
    private boolean newValueAngle;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$InstrumentsPointerUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$InstrumentsGMeterUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$InstrumentsTiltIndicatorUI;

    @Override
    protected void reset() {
        super.reset();
        this.internalAngle = 0.0f;
        this.newValue = false;
        this.newValueAngle = false;
    }

    @Override
    public void deInit() {
        int n;
        this.pointerEnterAnimation = null;
        this.valueAnimation = null;
        this.gMeterChangeAnimation = null;
        if (this.gMeterPhaseOneEnterAnimations != null) {
            for (n = this.gMeterPhaseOneEnterAnimations.length - 1; n >= 0; --n) {
                this.gMeterPhaseOneEnterAnimations[n] = null;
            }
            this.gMeterPhaseOneEnterAnimations = null;
        }
        if (this.gMeterPhaseTwoEnterAnimations != null) {
            for (n = this.gMeterPhaseTwoEnterAnimations.length - 1; n >= 0; --n) {
                this.gMeterPhaseTwoEnterAnimations[n] = null;
            }
            this.gMeterPhaseTwoEnterAnimations = null;
        }
        if (this.gMeterPhaseThreeEnterAnimations != null) {
            for (n = this.gMeterPhaseThreeEnterAnimations.length - 1; n >= 0; --n) {
                this.gMeterPhaseThreeEnterAnimations[n] = null;
            }
            this.gMeterPhaseThreeEnterAnimations = null;
        }
        if (this.pointerAlphaAnimations != null) {
            for (n = this.pointerAlphaAnimations.length - 1; n >= 0; --n) {
                this.pointerAlphaAnimations[n] = null;
            }
            this.pointerAlphaAnimations = null;
        }
        if (this.scaleAnglesIntervals != null) {
            for (n = this.scaleAnglesIntervals.length - 1; n >= 0; --n) {
                this.scaleAnglesIntervals[n] = null;
            }
            this.scaleAnglesIntervals = null;
        }
        if (this.scaleValuesIntervals != null) {
            for (n = this.scaleValuesIntervals.length - 1; n >= 0; --n) {
                this.scaleValuesIntervals[n] = null;
            }
            this.scaleValuesIntervals = null;
        }
        this.haloCreator = null;
        this.enterAnimationFinished = false;
        super.deInit();
    }

    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, Image image2, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, Color color2, Image image3, int[] nArray, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, int n5, String string, boolean bl6, float f3, float f4, float f5, Color[] colorArray, int n6, Image[] imageArray, float f6, float f7, float f8, int n7, int n8, int n9, Image image4, int n10, boolean bl7, float f9, float f10, float f11, int[] nArray2, int[] nArray3, Color[] colorArray2, Image[] imageArray2, int[] nArray4, int[] nArray5, float f12, float f13, float f14, int n11, Insets insets, int n12, int n13, int n14, int n15, int n16, boolean bl8, int[] nArray6, Image image5, int n17, int n18, int n19, int n20) {
        super.init(bl, n, image, bl2, f2, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n7, n9, image4, n10, bl7, f9, f10, f11, f12, f13, f14, n11, insets, bl8, n17, n18, n19, n20);
        this.backgroundColor = color;
        this.backgroundImage = image2;
        this.foregroundColor = color2;
        this.foregroundImage = image3;
        this.haloAlphas = nArray;
        this.mode = n5;
        this.setInternalStateFlag(19, bl6);
        this.pointerColors = colorArray;
        this.pointerIdx = n6;
        this.pointerImages = imageArray;
        this.radiusDrawingArea = n8;
        this.scaleAngles = nArray2;
        this.scaleStrokeAngles = nArray3;
        this.scaleStrokeColors = colorArray2;
        this.scaleStrokeImages = imageArray2;
        this.scaleStrokeTypes = nArray4;
        this.scaleValues = nArray5;
        this.value = n12;
        this.valueAngle = n13;
        this.valueMax = n14;
        this.valueMin = n15;
        this.warningZoneAngles = nArray6;
        this.warningZoneImage = image5;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color color, Image image2, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, Color color2, Image image3, int[] nArray, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, int n5, String string, boolean bl6, float f2, float f3, float f4, Color[] colorArray, int n6, Image[] imageArray, float f5, float f6, float f7, int n7, int n8, int n9, Image image4, int n10, boolean bl7, float f8, float f9, float f10, int[] nArray2, int[] nArray3, Color[] colorArray2, Image[] imageArray2, int[] nArray4, int[] nArray5, float f11, float f12, float f13, int n11, Insets insets, int n12, int n13, int n14, int n15, int n16, boolean bl8, int[] nArray6, Image image5, int n17, int n18, int n19, int n20) {
        this.init(bl, n, image, bl2, 0.0f, bl3, color, image2, n2, n3, easingParamsArray, bl4, color2, image3, nArray, n4, keyframeAnimationArray, bl5, layoutAttribs, n5, string, bl6, f2, f3, f4, colorArray, n6, imageArray, f5, f6, f7, n7, n8, n9, image4, n10, bl7, f8, f9, f10, nArray2, nArray3, colorArray2, imageArray2, nArray4, nArray5, f11, f12, f13, n11, insets, n12, n13, n14, n15, n16, bl8, nArray6, image5, n17, n18, n19, n20);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.initializeInternalProperties();
        this.updateHaloAlphasAndHaloCreator();
    }

    private void initializeInternalProperties() {
        if (this.is_performEnterAnimation() && this.isEnterAnimationConfigured()) {
            this.set_valueOut(0);
            this.internalAngle = this.calcAngleForValue(0.0f);
        } else {
            this.set_valueOut(this.value);
            this.internalAngle = this.calcAngleForValue(this.value);
        }
        this.updateGMeterPhaseTwoEnterAnimations();
        this.updateGMeterPhaseOneEnterAnimations();
        this.updateGMeterPhaseThreeEnterAnimations();
        this.updatePointerAlphaAnimations();
        this.scaleValuesChanged(null);
        this.scaleAnglesChanged(null);
    }

    @Override
    public void activate() {
        super.activate();
        if (this.is_performEnterAnimation()) {
            this.startEnterAnimation();
        }
    }

    @Override
    public Image get_backgroundImage() {
        return this.backgroundImage;
    }

    @Override
    public void set_backgroundImage(Image image) {
        Image image2 = this.backgroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.backgroundImage = image;
            this.backgroungImageChanged(image2);
            this.propertyChanged(40);
        }
    }

    @Override
    public Color get_backgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public void set_backgroundColor(Color color) {
        Color color2 = this.backgroundColor;
        if (color2 == null || !color2.equals(color)) {
            this.backgroundColor = color;
            this.backgroundColorChanged(color2);
            this.propertyChanged(41);
        }
    }

    @Override
    public Image get_foregroundImage() {
        return this.foregroundImage;
    }

    @Override
    public void set_foregroundImage(Image image) {
        Image image2 = this.foregroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.foregroundImage = image;
            this.foregroundImageChanged(image2);
            this.propertyChanged(42);
        }
    }

    @Override
    public Color get_foregroundColor() {
        return this.foregroundColor;
    }

    @Override
    public void set_foregroundColor(Color color) {
        Color color2 = this.foregroundColor;
        if (color2 == null || !color2.equals(color)) {
            this.foregroundColor = color;
            this.foregroundColorChanged(color2);
            this.propertyChanged(43);
        }
    }

    @Override
    public boolean is_performEnterAnimation() {
        return this.getInternalStateFlag(19) && this.getValueMax() != this.getValueMin();
    }

    @Override
    public void set_performEnterAnimation(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.performEnterAnimationChanged(bl2);
            this.propertyChanged(59);
        }
    }

    @Override
    public int get_pointerIdx() {
        return this.pointerIdx;
    }

    @Override
    public void set_pointerIdx(int n) {
        int n2 = this.pointerIdx;
        if (n2 != n) {
            this.pointerIdx = n;
            this.pointerIdxChanged(n2);
            this.propertyChanged(44);
        }
    }

    @Override
    public Image[] get_pointerImages() {
        return this.pointerImages;
    }

    @Override
    public void set_pointerImages(Image[] imageArray) {
        Object[] objectArray = this.pointerImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.pointerImages = imageArray;
            this.pointerImagesChanged((Image[])objectArray);
            this.propertyChanged(45);
        }
    }

    @Override
    public Color[] get_pointerColors() {
        return this.pointerColors;
    }

    @Override
    public void set_pointerColors(Color[] colorArray) {
        Object[] objectArray = this.pointerColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.pointerColors = colorArray;
            this.pointerColorsChanged((Color[])objectArray);
            this.propertyChanged(46);
        }
    }

    @Override
    public int[] get_scaleParams() {
        return this.scaleAngles;
    }

    @Override
    public void set_scaleParams(int[] nArray) {
        int[] nArray2 = this.scaleAngles;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.scaleAngles = nArray;
            this.scaleAnglesChanged(nArray2);
            this.propertyChanged(47);
        }
    }

    @Override
    public int[] get_scaleStrokeAngles() {
        return this.scaleStrokeAngles;
    }

    @Override
    public void set_scaleStrokeAngles(int[] nArray) {
        int[] nArray2 = this.scaleStrokeAngles;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.scaleStrokeAngles = nArray;
            this.scaleStrokeAnglesChanged(nArray2);
            this.propertyChanged(48);
        }
    }

    @Override
    public Color[] get_scaleStrokeColors() {
        return this.scaleStrokeColors;
    }

    @Override
    public void set_scaleStrokeColors(Color[] colorArray) {
        Object[] objectArray = this.scaleStrokeColors;
        if (objectArray == null || !Arrays.equals(objectArray, colorArray)) {
            this.scaleStrokeColors = colorArray;
            this.scaleStrokeColorsChanged((Color[])objectArray);
            this.propertyChanged(49);
        }
    }

    @Override
    public Image[] get_scaleStrokeImages() {
        return this.scaleStrokeImages;
    }

    @Override
    public void set_scaleStrokeImages(Image[] imageArray) {
        Object[] objectArray = this.scaleStrokeImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.scaleStrokeImages = imageArray;
            this.scaleStrokeImagesChanged((Image[])objectArray);
            this.propertyChanged(50);
        }
    }

    @Override
    public int[] get_scaleStrokeTypes() {
        return this.scaleStrokeTypes;
    }

    @Override
    public void set_scaleStrokeTypes(int[] nArray) {
        int[] nArray2 = this.scaleStrokeTypes;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.scaleStrokeTypes = nArray;
            this.scaleStrokeTypesChanged(nArray2);
            this.propertyChanged(51);
        }
    }

    @Override
    public int[] get_scaleValues() {
        return this.scaleValues;
    }

    @Override
    public void set_scaleValues(int[] nArray) {
        int[] nArray2 = this.scaleValues;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.scaleValues = nArray;
            this.scaleValuesChanged(nArray2);
            this.propertyChanged(52);
        }
    }

    @Override
    public int get_value() {
        return this.value;
    }

    @Override
    public void set_value(int n) {
        int n2 = this.value;
        if (n2 != n) {
            this.value = n;
            this.valueChanged(n2);
            this.propertyChanged(53);
        }
        this.valuePropagated();
    }

    @Override
    public int get_valueMax() {
        return this.valueMax;
    }

    @Override
    public void set_valueMax(int n) {
        int n2 = this.valueMax;
        if (n2 != n) {
            this.valueMax = n;
            this.valueMaxChanged(n2);
            this.propertyChanged(54);
        }
    }

    @Override
    public int get_valueMin() {
        return this.valueMin;
    }

    @Override
    public void set_valueMin(int n) {
        int n2 = this.valueMin;
        if (n2 != n) {
            this.valueMin = n;
            this.valueMinChanged(n2);
            this.propertyChanged(55);
        }
    }

    @Override
    public int get_valueOut() {
        return this.valueOut;
    }

    @Override
    public void set_valueOut(int n) {
        int n2 = this.valueOut;
        if (n2 != n) {
            this.valueOut = n;
            this.valueOutChanged(n2);
            this.propertyChanged(58);
        }
    }

    @Override
    public int[] get_warningZoneAngles() {
        return this.warningZoneAngles;
    }

    @Override
    public void set_warningZoneAngles(int[] nArray) {
        int[] nArray2 = this.warningZoneAngles;
        if (!Arrays.equals(nArray2, nArray)) {
            this.warningZoneAngles = nArray;
            this.warningZoneAnglesChanged(nArray2);
            this.propertyChanged(56);
        }
    }

    @Override
    public Image get_warningZoneImage() {
        return this.warningZoneImage;
    }

    @Override
    public void set_warningZoneImage(Image image) {
        Image image2 = this.warningZoneImage;
        if (image2 == null || !image2.equals(image)) {
            this.warningZoneImage = image;
            this.warningZoneImageChanged(image2);
            this.propertyChanged(57);
        }
    }

    @Override
    public int get_valueAngle() {
        return this.valueAngle;
    }

    @Override
    public void set_valueAngle(int n) {
        int n2 = this.valueAngle;
        if (n2 != n) {
            this.valueAngle = n;
            this.valueAngleChanged(n2);
            this.propertyChanged(63);
        }
        this.valueAnglePropagated();
    }

    @Override
    public int get_radiusDrawingArea() {
        return this.radiusDrawingArea;
    }

    @Override
    public void set_radiusDrawingArea(int n) {
        int n2 = this.radiusDrawingArea;
        if (n2 != n) {
            this.radiusDrawingArea = n;
            this.radiusDrawingAreaChanged(n2);
            this.propertyChanged(62);
        }
    }

    @Override
    public int get_mode() {
        return this.mode;
    }

    @Override
    public void set_mode(int n) {
        int n2 = this.mode;
        if (n2 != n) {
            this.mode = n;
            this.modeChanged(n2);
            this.propertyChanged(61);
        }
    }

    @Override
    public int[] get_haloAlphas() {
        return this.haloAlphas;
    }

    @Override
    public void set_haloAlphas(int[] nArray) {
        int[] nArray2 = this.haloAlphas;
        if (!Arrays.equals(nArray2, nArray)) {
            this.haloAlphas = nArray;
            this.haloAlphasChanged(nArray2);
            this.propertyChanged(60);
        }
    }

    protected void setInternalAngle(float f2) {
        float f3 = this.getInternalAngle();
        if (!Util.equalsEpsilon(f3, f2)) {
            this.internalAngle = f2 % 46147;
            this.internalAngleChanged(f3);
        }
    }

    protected void setPointerIdx(int n) {
        int n2 = this.pointerIdx;
        if (n2 != n) {
            this.pointerIdx = n;
        }
    }

    @Override
    public float getInternalAngle() {
        return this.internalAngle;
    }

    @Override
    public InstrumentsModel$Interval getValueInterval(int n) {
        if (this.scaleValuesIntervals == null) {
            return FULL_CIRCLE_INTERVAL;
        }
        for (int i2 = this.scaleValuesIntervals.length - 1; i2 >= 0; --i2) {
            if (this.scaleValuesIntervals[i2].begin > n || n > this.scaleValuesIntervals[i2].end) continue;
            return this.scaleValuesIntervals[i2];
        }
        return EMPTY_INTERVAL;
    }

    public InstrumentsModel$Interval getMinMaxAngleAsInterval() {
        if (this.scaleAnglesIntervals == null || this.scaleAnglesIntervals.length == 0) {
            return FULL_CIRCLE_INTERVAL;
        }
        return new InstrumentsModel$Interval(this.scaleAnglesIntervals[0].begin, this.scaleAnglesIntervals[this.scaleAnglesIntervals.length - 1].end);
    }

    @Override
    public InstrumentsModel$Interval getAngleInterval(int n) {
        if (this.scaleAnglesIntervals == null) {
            return FULL_CIRCLE_INTERVAL;
        }
        if (this.scaleValues == null || this.scaleValues.length == 0 || this.scaleValues.length != this.scaleAngles.length) {
            return FULL_CIRCLE_INTERVAL;
        }
        for (int i2 = this.scaleValuesIntervals.length - 1; i2 >= 0; --i2) {
            if (this.scaleValuesIntervals[i2].begin > n || n > this.scaleValuesIntervals[i2].end) continue;
            return this.scaleAnglesIntervals[i2];
        }
        return EMPTY_INTERVAL;
    }

    @Override
    public Image getScaleStrokeImage(int n) {
        if (n >= 0 && n < 3 && this.scaleStrokeImages.length == 3) {
            return this.scaleStrokeImages[n];
        }
        return null;
    }

    @Override
    public boolean isValueChangeAnimationRunning() {
        return this.valueAnimation != null && this.valueAnimation.isActive();
    }

    @Override
    public void setScaleInvalid(boolean bl) {
        this.setInternalStateFlag(18, bl);
    }

    @Override
    public boolean isScaleInvalid() {
        return this.getInternalStateFlag(18);
    }

    protected int getValueMax() {
        if (this.valueMin == this.valueMax && this.scaleValues != null && this.scaleValues.length > 0) {
            return this.scaleValues[this.scaleValues.length - 1];
        }
        return this.valueMax;
    }

    protected int getValueMin() {
        if (this.valueMin == this.valueMax && this.scaleValues != null && this.scaleValues.length > 0) {
            return this.scaleValues[0];
        }
        return this.valueMin;
    }

    void setHaloAlphasInternal(int[] nArray) {
        this.haloAlphasInternal = nArray;
    }

    @Override
    public int[] getHaloAlphasInternal() {
        return this.haloAlphasInternal;
    }

    public void startEnterAnimation() {
        if (!this.isEnterAnimationConfigured()) {
            this.setEnterAnimationFinished(true);
            return;
        }
        if (this.mode == 1) {
            this.setEnterAnimationFinished(false);
            this.startGMeterPhaseOneEnterAnimation(0);
        } else if (this.mode == 0) {
            this.setEnterAnimationFinished(false);
            this.startPointerEnterAnimation(0);
        } else if (this.mode == 2) {
            this.setEnterAnimationFinished(true);
        }
    }

    @Override
    public boolean isEnterAnimationPhaseOneRunning() {
        return this.areGMeterPhaseOneEnterAnimationsActive();
    }

    @Override
    public boolean areGMeterEnterAnimationsRunning() {
        return this.areGMeterPhaseOneEnterAnimationsActive() || this.areGMeterPhaseTwoEnterAnimationsActive() || this.areGMeterPhaseThreeAnimationsActive();
    }

    protected int getPointerImageCount() {
        if (this.pointerImages == null) {
            return 0;
        }
        return this.pointerImages.length;
    }

    private boolean isBounded() {
        return this.valueMin != this.valueMax;
    }

    @Override
    public int getHaloAdditionalParam() {
        return this.haloCreator.getHaloAdditionalParam();
    }

    @Override
    public Point2f[] getHaloPositions() {
        return this.haloCreator.getHaloPositions();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$InstrumentsPointerUI == null ? (class$de$vw$mib$widgets$ui$InstrumentsPointerUI = Instruments.class$("de.vw.mib.widgets.ui.InstrumentsPointerUI")) : class$de$vw$mib$widgets$ui$InstrumentsPointerUI, class$de$vw$mib$widgets$ui$InstrumentsGMeterUI == null ? (class$de$vw$mib$widgets$ui$InstrumentsGMeterUI = Instruments.class$("de.vw.mib.widgets.ui.InstrumentsGMeterUI")) : class$de$vw$mib$widgets$ui$InstrumentsGMeterUI, class$de$vw$mib$widgets$ui$InstrumentsTiltIndicatorUI == null ? (class$de$vw$mib$widgets$ui$InstrumentsTiltIndicatorUI = Instruments.class$("de.vw.mib.widgets.ui.InstrumentsTiltIndicatorUI")) : class$de$vw$mib$widgets$ui$InstrumentsTiltIndicatorUI};
    }

    void setHaloAlphaInternal(int n, int n2) {
        int n3;
        int n4;
        if (n >= 0 && this.pointerImages.length > 0 && this.haloAlphasInternal[n4 = (n3 = this.haloAlphasInternal.length / this.pointerImages.length) * n] != n2) {
            this.haloAlphasInternal[n4] = n2;
            this.repaint();
        }
    }

    private void foregroundImageChanged(Image image) {
        this.repaint();
    }

    private void foregroundColorChanged(Color color) {
        this.repaint();
    }

    private void backgroungImageChanged(Image image) {
        this.repaint();
    }

    private void backgroundColorChanged(Color color) {
        this.repaint();
    }

    private void pointerImagesChanged(Image[] imageArray) {
        this.updateGMeterPhaseOneEnterAnimations();
        this.updateGMeterPhaseTwoEnterAnimations();
        this.updateGMeterPhaseThreeEnterAnimations();
        this.updatePointerAlphaAnimations();
        this.haloCreator = Instruments$HaloKindManager.createHaloKind(this);
        this.repaint();
    }

    private void pointerColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    private void scaleAnglesChanged(int[] nArray) {
        this.scaleAnglesIntervals = null;
        if (this.scaleAngles != null && this.scaleAngles.length > 1) {
            this.scaleAnglesIntervals = new InstrumentsModel$Interval[this.scaleAngles.length - 1];
            for (int i2 = this.scaleAngles.length - 1; i2 >= 1; --i2) {
                this.scaleAnglesIntervals[i2 - 1] = new InstrumentsModel$Interval(this.scaleAngles[i2 - 1], this.scaleAngles[i2]);
            }
        }
        this.repaint();
    }

    private void scaleStrokeAnglesChanged(int[] nArray) {
        this.setScaleInvalid(true);
        this.repaint();
    }

    private void scaleStrokeColorsChanged(Color[] colorArray) {
        this.setScaleInvalid(true);
        this.repaint();
    }

    private void scaleStrokeImagesChanged(Image[] imageArray) {
        this.setScaleInvalid(true);
        this.repaint();
    }

    private void scaleStrokeTypesChanged(int[] nArray) {
        this.setScaleInvalid(true);
        this.repaint();
    }

    private void scaleValuesChanged(int[] nArray) {
        this.scaleValuesIntervals = null;
        if (this.scaleValues != null && this.scaleValues.length > 1) {
            this.scaleValuesIntervals = new InstrumentsModel$Interval[this.scaleValues.length - 1];
            for (int i2 = this.scaleValues.length - 1; i2 >= 1; --i2) {
                this.scaleValuesIntervals[i2 - 1] = new InstrumentsModel$Interval(this.scaleValues[i2 - 1], this.scaleValues[i2]);
            }
        }
        this.repaint();
    }

    private void valueOutChanged(int n) {
    }

    private void warningZoneAnglesChanged(int[] nArray) {
        this.setScaleInvalid(true);
        this.repaint();
    }

    private void warningZoneImageChanged(Image image) {
        this.setScaleInvalid(true);
        this.repaint();
    }

    private void performEnterAnimationChanged(boolean bl) {
    }

    protected void pointerIdxChanged(int n) {
        if (this.pointerImages == null) {
            return;
        }
        this.repaint();
    }

    void valueChanged(int n) {
        if (this.is_performEnterAnimation() && !this.isEnterAnimationFinished()) {
            this.updateCurrentAngleAndRepaint();
            return;
        }
        if (this.mode == 0 && !this.startValueAnimation(n, this.value)) {
            this.updateCurrentAngleAndRepaint();
            this.set_valueOut(this.value);
        }
    }

    private void valueMaxChanged(int n) {
        if (this.mode == 0) {
            this.updateCurrentAngleAndRepaint();
        }
    }

    private void valueMinChanged(int n) {
        if (this.mode == 0) {
            this.updateCurrentAngleAndRepaint();
        }
    }

    protected void internalAngleChanged(float f2) {
        this.repaint();
    }

    private void haloAlphasChanged(int[] nArray) {
        if (this.mode == 2) {
            this.haloCreator.reinit();
        }
        this.repaint();
    }

    private void modeChanged(int n) {
        this.updateHaloAlphasAndHaloCreator();
        this.repaint();
    }

    private void radiusDrawingAreaChanged(int n) {
        this.repaint();
    }

    void valueAngleChanged(int n) {
    }

    private void updateHaloAlphasAndHaloCreator() {
        if (this.mode == 2) {
            this.setHaloAlphasInternal(HALO_ALPHAS);
        } else {
            this.setHaloAlphasInternal(null);
        }
        this.haloCreator = Instruments$HaloKindManager.createHaloKind(this);
        this.addHaloInput();
    }

    private void clearAlphasInternal() {
        for (int i2 = this.haloAlphasInternal.length - 1; i2 >= 0; --i2) {
            this.haloAlphasInternal[i2] = 0;
        }
    }

    private void valueAnglePropagated() {
        this.newValueAngle = true;
        if (this.newValue && this.newValueAngle) {
            this.addHaloInput();
        }
    }

    private void valuePropagated() {
        this.newValue = true;
        if (this.newValue && this.newValueAngle) {
            this.addHaloInput();
        }
    }

    protected void addHaloInput() {
        if (this.mode == 1 && (!this.is_performEnterAnimation() || this.isEnterAnimationFinished())) {
            this.haloCreator.addHaloInput(this.value, this.valueAngle);
        }
        if (this.mode == 2) {
            this.haloCreator.addHaloInput(this.value, this.valueAngle);
        }
        this.newValue = false;
        this.newValueAngle = false;
    }

    private void updateGMeterPhaseOneEnterAnimations() {
        if (this.pointerImages != null && (this.gMeterPhaseOneEnterAnimations == null || this.gMeterPhaseOneEnterAnimations.length != this.pointerImages.length)) {
            this.gMeterPhaseOneEnterAnimations = new Instruments$GMeterPhaseOneEnterAnimation[this.pointerImages.length];
        }
    }

    private void updateGMeterPhaseTwoEnterAnimations() {
        if (this.pointerImages != null && (this.gMeterPhaseTwoEnterAnimations == null || this.gMeterPhaseTwoEnterAnimations.length != this.pointerImages.length)) {
            this.gMeterPhaseTwoEnterAnimations = new Instruments$GMeterPhaseTwoEnterAnimation[this.pointerImages.length];
        }
    }

    private void updateGMeterPhaseThreeEnterAnimations() {
        if (this.pointerImages != null && (this.gMeterPhaseThreeEnterAnimations == null || this.gMeterPhaseThreeEnterAnimations.length != this.pointerImages.length)) {
            this.gMeterPhaseThreeEnterAnimations = new Instruments$GMeterPhaseThreeEnterAnimation[this.pointerImages.length];
        }
    }

    private void updatePointerAlphaAnimations() {
        if (this.pointerImages != null && (this.pointerAlphaAnimations == null || this.pointerAlphaAnimations.length != this.pointerImages.length)) {
            this.pointerAlphaAnimations = new Instruments$PointerAlphaAnimation[this.pointerImages.length];
        }
    }

    private void updateCurrentAngleAndRepaint() {
        this.setInternalAngle(this.calcAngleForValue(this.value));
        this.repaint();
    }

    private boolean startValueAnimation(int n, int n2) {
        if (this.valueAnimation != null && this.valueAnimation.isActive() && (float)n2 == this.valueAnimation.getEndValue()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(15);
        if (easingParams == null) {
            return false;
        }
        this.stopValueAnimation();
        this.valueAnimation = new Instruments$ValueAnimation(this, easingParams, (float)n, (float)(n2 - n));
        return this.startInternalAnimation(this.valueAnimation);
    }

    protected boolean startPointerEnterAnimation(int n) {
        if (this.pointerEnterAnimation != null && this.pointerEnterAnimation.isActive() && this.pointerEnterAnimation.getStartValue() == this.calcAngleForValue(this.getValueMin()) && this.pointerEnterAnimation.getEndValue() == this.calcAngleForValue(this.getValueMax())) {
            return true;
        }
        EasingParams easingParams = null;
        if (n == 0) {
            easingParams = this.getEasing(17);
        } else if (n == 1) {
            easingParams = this.getEasing(18);
        }
        if (easingParams == null) {
            return false;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (this.getValueMin() == this.getValueMax()) {
            InstrumentsModel$Interval instrumentsModel$Interval = this.getMinMaxAngleAsInterval();
            f2 = instrumentsModel$Interval.begin;
            f3 = instrumentsModel$Interval.end;
        } else {
            f2 = this.calcAngleForValue(this.getValueMin());
            f3 = this.calcAngleForValue(this.getValueMax());
        }
        if (n == 0) {
            if (f3 < f2) {
                f3 += 46147;
            }
            this.pointerEnterAnimation = new Instruments$PointerEnterAnimation(this, easingParams, f2, f3, n);
        } else if (n == 1) {
            if (f3 < f2) {
                f2 -= 46147;
            }
            this.pointerEnterAnimation = new Instruments$PointerEnterAnimation(this, easingParams, f3, f2, n);
        }
        return this.startInternalAnimation(this.pointerEnterAnimation);
    }

    protected boolean startGMeterPhaseOneEnterAnimation(int n) {
        if (n < 0 || this.pointerImages != null && n >= this.pointerImages.length) {
            return false;
        }
        if (this.gMeterPhaseOneEnterAnimations[n] != null && this.gMeterPhaseOneEnterAnimations[n].isActive() || this.areGMeterPhaseTwoEnterAnimationsActive() || this.areGMeterPhaseThreeAnimationsActive()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(19);
        if (easingParams == null) {
            return false;
        }
        if (n == 0) {
            this.clearAlphasInternal();
        }
        this.gMeterPhaseOneEnterAnimations[n] = new Instruments$GMeterPhaseOneEnterAnimation(this, easingParams, n);
        return this.startInternalAnimation(this.gMeterPhaseOneEnterAnimations[n]);
    }

    protected boolean startGMeterPhaseTwoEnterAnimation(int n) {
        if (n < 0 || this.pointerImages != null && n >= this.pointerImages.length) {
            return false;
        }
        if (this.gMeterPhaseTwoEnterAnimations[n] != null && this.gMeterPhaseTwoEnterAnimations[n].isActive() || this.areGMeterPhaseOneEnterAnimationsActive() || this.areGMeterPhaseThreeAnimationsActive()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(20);
        if (easingParams == null) {
            return false;
        }
        this.gMeterPhaseTwoEnterAnimations[n] = new Instruments$GMeterPhaseTwoEnterAnimation(this, easingParams, n);
        return this.startInternalAnimation(this.gMeterPhaseTwoEnterAnimations[n]);
    }

    protected boolean startGMeterPhaseThreeEnterAnimation(int n) {
        if (this.gMeterPhaseThreeEnterAnimations == null || n < 0 || this.gMeterPhaseThreeEnterAnimations != null && n >= this.gMeterPhaseThreeEnterAnimations.length) {
            return false;
        }
        if (this.gMeterPhaseThreeEnterAnimations[n] != null && this.gMeterPhaseThreeEnterAnimations[n].isActive() || this.areGMeterPhaseOneEnterAnimationsActive() || this.areGMeterPhaseTwoEnterAnimationsActive()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(21);
        if (easingParams == null) {
            return false;
        }
        this.gMeterPhaseThreeEnterAnimations[n] = new Instruments$GMeterPhaseThreeEnterAnimation(this, easingParams, n);
        return this.startInternalAnimation(this.gMeterPhaseThreeEnterAnimations[n]);
    }

    protected boolean startPointerAlphaAnimation(int n, int n2) {
        if (n == -1) {
            return false;
        }
        if (this.pointerAlphaAnimations[n] != null && this.pointerAlphaAnimations[n].isActive() && Util.equalsEpsilon(this.pointerAlphaAnimations[n].getStartValue() + this.pointerAlphaAnimations[n].getDeltaValue(), n2)) {
            return true;
        }
        EasingParams easingParams = this.getEasing(16);
        if (easingParams == null) {
            return false;
        }
        int n3 = this.getHaloAlphasInternal()[n];
        this.stopPointerAlphaAnimation(n);
        this.pointerAlphaAnimations[n] = new Instruments$PointerAlphaAnimation(this, easingParams, n, n3, n2);
        return this.startInternalAnimation(this.pointerAlphaAnimations[n]);
    }

    protected void stopGMeterChangeAnimation() {
        if (this.gMeterChangeAnimation != null) {
            this.stopInternalAnimation(this.gMeterChangeAnimation);
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopValueAnimation();
        this.stopGMeterChangeAnimation();
        this.stopInternalAnimations(this.pointerAlphaAnimations);
        this.stopInternalAnimations(this.gMeterPhaseOneEnterAnimations);
        this.stopInternalAnimations(this.gMeterPhaseTwoEnterAnimations);
        this.stopInternalAnimations(this.gMeterPhaseThreeEnterAnimations);
        this.updateCurrentAngleAndRepaint();
    }

    private void stopInternalAnimations(AbstractWidget$WidgetInternalAnimation[] abstractWidget$WidgetInternalAnimationArray) {
        if (abstractWidget$WidgetInternalAnimationArray != null) {
            for (int i2 = abstractWidget$WidgetInternalAnimationArray.length - 1; i2 >= 0; --i2) {
                this.stopInternalAnimation(abstractWidget$WidgetInternalAnimationArray[i2]);
                abstractWidget$WidgetInternalAnimationArray[i2] = null;
            }
        }
    }

    private void stopValueAnimation() {
        if (this.valueAnimation != null) {
            this.stopInternalAnimation(this.valueAnimation);
            this.valueAnimation = null;
        }
    }

    private void stopPointerAlphaAnimation(int n) {
        this.stopInternalAnimation(this.pointerAlphaAnimations[n]);
    }

    protected float calcAngleForValue(float f2) {
        float f3 = this.adjustValueToBounds(f2);
        InstrumentsModel$Interval instrumentsModel$Interval = this.getValueInterval(Math.round(f3));
        InstrumentsModel$Interval instrumentsModel$Interval2 = this.getAngleInterval(Math.round(f3));
        int n = instrumentsModel$Interval.begin;
        int n2 = instrumentsModel$Interval.end;
        int n3 = instrumentsModel$Interval2.begin;
        int n4 = instrumentsModel$Interval2.end;
        if (n == n2) {
            return n3;
        }
        float f4 = n2 - n;
        float f5 = 0.0f;
        f5 = n4 > n3 ? (float)(n4 - n3) : (float)(n4 - n3 + 360);
        float f6 = (float)n3 + f5 / f4 * (f3 - (float)n);
        if (f6 > 46147) {
            f6 -= 46147;
        } else if (f6 < 0.0f) {
            f6 += 46147;
        }
        return f6;
    }

    private float adjustValueToBounds(float f2) {
        int n = this.getValueMax() - this.getValueMin();
        if (n == 0) {
            return 0.0f;
        }
        if (f2 < (float)this.getValueMin()) {
            f2 = this.isBounded() ? (float)this.getValueMin() : f2 % (float)n - (float)this.getValueMin();
        } else if (f2 > (float)this.getValueMax()) {
            f2 = this.isBounded() ? (float)this.getValueMax() : f2 % (float)n - (float)this.getValueMin();
        }
        return f2;
    }

    private boolean areGMeterPhaseOneEnterAnimationsActive() {
        return this.areAnimationsActive(this.gMeterPhaseOneEnterAnimations);
    }

    protected boolean areGMeterPhaseTwoEnterAnimationsActive() {
        return this.areAnimationsActive(this.gMeterPhaseTwoEnterAnimations);
    }

    private boolean areGMeterPhaseThreeAnimationsActive() {
        return this.areAnimationsActive(this.gMeterPhaseThreeEnterAnimations);
    }

    private boolean areAnimationsActive(AbstractWidget$WidgetInternalAnimation[] abstractWidget$WidgetInternalAnimationArray) {
        if (abstractWidget$WidgetInternalAnimationArray == null || abstractWidget$WidgetInternalAnimationArray.length == 0) {
            return false;
        }
        for (int i2 = abstractWidget$WidgetInternalAnimationArray.length - 1; i2 >= 0; --i2) {
            if (abstractWidget$WidgetInternalAnimationArray[i2] == null || !abstractWidget$WidgetInternalAnimationArray[i2].isActive()) continue;
            return true;
        }
        return false;
    }

    protected void setEnterAnimationFinished(boolean bl) {
        this.enterAnimationFinished = bl;
    }

    @Override
    public boolean isEnterAnimationFinished() {
        return this.enterAnimationFinished;
    }

    private boolean isEnterAnimationConfigured() {
        switch (this.mode) {
            case 1: 
            case 2: {
                return this.isEasingAvailable(19);
            }
        }
        return this.isEasingAvailable(17);
    }

    @Override
    public void setMinimum(int n) {
    }

    @Override
    public int getMinimum() {
        return 0;
    }

    @Override
    public void setMaximum(int n) {
    }

    @Override
    public int getMaximum() {
        return 0;
    }

    @Override
    public void setUnitIncrement(int n) {
    }

    @Override
    public int getUnitIncrement() {
        return 0;
    }

    @Override
    public void setBlockIncrement(int n) {
    }

    @Override
    public int getBlockIncrement() {
        return 0;
    }

    @Override
    public void setValue(int n) {
        this.set_value(n);
    }

    @Override
    public int getValue() {
        return this.get_value();
    }

    @Override
    public void disableAdjustmentChanged() {
    }

    @Override
    public void enableAdjustmentChanged() {
    }

    @Override
    public boolean isAdjustmentEnabled() {
        return false;
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
    }

    protected void trace(String string) {
        if (LOGGER.isTraceEnabled(512)) {
            String string2 = this.getQualifiedName();
            LOGGER.trace(512).append(new StringBuffer().append(string2).append(" - ").toString()).append(string).log();
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

    static {
        HALO_ALPHAS = new int[]{255, 224, 208, 192, 176, 160, 144, 128, 112, 96, 80, 64, 48, 32, 16};
    }
}

