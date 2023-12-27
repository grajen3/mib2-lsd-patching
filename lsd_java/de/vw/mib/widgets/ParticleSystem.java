/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$PropertyAnimation;
import de.vw.mib.widgets.AbstractWidget$PublicPropertyAnimation;
import de.vw.mib.widgets.ParticleSystem$1;
import de.vw.mib.widgets.ParticleSystem$2;
import de.vw.mib.widgets.ParticleSystem$3;
import de.vw.mib.widgets.ParticleSystem$4;
import de.vw.mib.widgets.ParticleSystem$5;
import de.vw.mib.widgets.ParticleSystem$6;
import de.vw.mib.widgets.ParticleSystem$7;
import de.vw.mib.widgets.ParticleSystem$AttributeAnimationHandler;
import de.vw.mib.widgets.models.ParticleSystemModel;
import de.vw.mib.widgets.models.ViewModel;

public final class ParticleSystem
extends AbstractWidget
implements ParticleSystemModel {
    private static final float MAGIC_PARTICLE_SCALE_FACTOR;
    private static final float NORMALIZE_FACTOR_TINT_INTENSITY;
    private static final float NORMALIZE_FACTOR_BLUR_INTENSITY;
    private static final float MAGIC_PARTICLE_GAP;
    private static final float MAGIC_PARTICLE_Y_OFFSET;
    private Image propertymapPrimary;
    private Image propertymapSecondary;
    protected float amplitude;
    private Color tintColor;
    protected float tintIntensity;
    protected float blurIntensity;
    protected float particleAlpha;
    protected float particleScale;
    protected float z;
    protected float gapX;
    protected float gapY;
    protected float rotateX;
    protected float rotateY;
    protected float rotateZ;
    protected float projectionFOV;
    protected float vanishX;
    protected float vanishY;
    private EasingParams easingAmplitude;
    private EasingParams easingTintIntensity;
    private EasingParams easingBlurIntensity;
    private EasingParams easingParticleAlpha;
    private EasingParams easingRotate;
    private EasingParams easingGap;
    private EasingParams easingScale;
    private EasingParams easingProjection;
    private EasingParams easingZ;
    private EasingParams easingX;
    private EasingParams easingY;
    private static final int ATTRIBUTES_COUNT;
    protected final Tuple4f[] attributesStartValues = new Tuple4f[3];
    protected final Tuple4f[] attributesEndValues = new Tuple4f[3];
    protected final Tuple4f[] attributesAnimationValues = new Tuple4f[3];
    protected Image propertyMapPrimaryOld;
    protected Image propertyMapSecondaryOld;
    protected float panX;
    protected float panY;
    private AbstractWidget$PublicPropertyAnimation projectionAnimation;
    private AbstractWidget$PublicPropertyAnimation vanishXAnimation;
    private AbstractWidget$PublicPropertyAnimation vanishYAnimation;
    private AbstractWidget$PublicPropertyAnimation zPropertyAnimation;
    private AbstractWidget$PropertyAnimation panXPropertyAnimation;
    private AbstractWidget$PropertyAnimation panYPropertyAnimation;
    private AbstractWidget$PublicPropertyAnimation rotateXPropertyAnimation;
    private ParticleSystem$AttributeAnimationHandler attributeAnimationHandler;
    private static final boolean ADDITIONAL_ATTRIBUTES;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ParticleSystemUI;

    public ParticleSystem() {
        for (int i2 = 0; i2 < 3; ++i2) {
            this.attributesStartValues[i2] = new Tuple4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.attributesEndValues[i2] = new Tuple4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.attributesAnimationValues[i2] = new Tuple4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        this.attributeAnimationHandler = new ParticleSystem$AttributeAnimationHandler(this);
    }

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, float f2, boolean bl2, float f3, EasingParams[] easingParamsArray, EasingParams easingParams, EasingParams easingParams2, EasingParams easingParams3, EasingParams easingParams4, EasingParams easingParams5, EasingParams easingParams6, EasingParams easingParams7, EasingParams easingParams8, EasingParams easingParams9, EasingParams easingParams10, EasingParams easingParams11, boolean bl3, float f4, float f5, int n2, boolean bl4, String string, float f6, float f7, float f8, Image image, Image image2, float f9, float f10, float f11, int n3, Color color, float f12, Insets insets, float f13, float f14, boolean bl5, int n4, int n5, int n6, float f15) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, n3, insets, bl5, n4, n5, n6);
        this.amplitude = f2;
        this.blurIntensity = f3;
        this.gapX = f4;
        this.gapY = f5;
        this.tintColor = color;
        this.tintIntensity = f12;
        this.blurIntensity = f3;
        this.particleAlpha = f6;
        this.particleScale = f7;
        this.z = f15;
        this.rotateX = f9;
        this.rotateY = 0.0f;
        this.rotateZ = 0.0f;
        this.projectionFOV = f8;
        this.easingAmplitude = easingParams;
        this.easingBlurIntensity = easingParams2;
        this.easingGap = easingParams3;
        this.easingParticleAlpha = easingParams4;
        this.easingProjection = easingParams5;
        this.easingRotate = easingParams6;
        this.easingScale = easingParams7;
        this.easingTintIntensity = easingParams8;
        this.easingX = easingParams9;
        this.easingY = easingParams10;
        this.easingZ = easingParams11;
        this.propertymapPrimary = image;
        this.propertymapSecondary = image2;
        this.propertyMapPrimaryOld = this.propertymapPrimary;
        this.propertyMapSecondaryOld = this.propertymapSecondary;
        this.vanishX = f13;
        this.vanishY = f14;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.panX = this.get_x();
        this.panY = this.get_y();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ParticleSystemUI == null ? (class$de$vw$mib$widgets$ui$ParticleSystemUI = ParticleSystem.class$("de.vw.mib.widgets.ui.ParticleSystemUI")) : class$de$vw$mib$widgets$ui$ParticleSystemUI};
    }

    @Override
    public void set_propertymapPrimary(Image image) {
        Image image2 = this.propertymapPrimary;
        if (this.propertymapPrimary == null || !this.propertymapPrimary.equals(image)) {
            this.propertymapPrimary = image;
            this.propertymapPrimaryChanged(image2);
            this.propertyChanged(15);
        }
    }

    @Override
    public Image get_propertymapPrimary() {
        return this.propertymapPrimary;
    }

    @Override
    public void set_propertymapSecondary(Image image) {
        Image image2 = this.propertymapSecondary;
        if (this.propertymapSecondary == null || !this.propertymapSecondary.equals(image)) {
            this.propertymapSecondary = image;
            this.propertymapSecondaryChanged(image2);
            this.propertyChanged(16);
        }
    }

    @Override
    public Image get_propertymapSecondary() {
        return this.propertymapSecondary;
    }

    @Override
    public float get_amplitude() {
        return this.amplitude;
    }

    @Override
    public void set_amplitude(float f2) {
        float f3 = this.amplitude;
        if (!Util.equalsEpsilon(this.amplitude, f2)) {
            this.amplitude = f2;
            this.amplitudeChanged(f3);
            this.propertyChanged(17);
        }
    }

    @Override
    public Color get_tintColor() {
        return this.tintColor;
    }

    @Override
    public void set_tintColor(Color color) {
        Color color2 = this.tintColor;
        if (this.tintColor == null || !this.tintColor.equals(color)) {
            this.tintColor = color;
            this.tintColorChanged(color2);
            this.propertyChanged(18);
        }
    }

    @Override
    public float get_tintIntensity() {
        return this.tintIntensity;
    }

    @Override
    public void set_tintIntensity(float f2) {
        float f3 = this.tintIntensity;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.tintIntensity = f2;
            this.tintIntensityChanged(f3);
            this.propertyChanged(19);
        }
    }

    @Override
    public float get_blurIntensity() {
        return this.blurIntensity;
    }

    @Override
    public void set_blurIntensity(float f2) {
        float f3 = this.blurIntensity;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.blurIntensity = f2;
            this.blurIntensityChanged(f3);
            this.propertyChanged(20);
        }
    }

    @Override
    public float get_particleAlpha() {
        return this.particleAlpha;
    }

    @Override
    public void set_particleAlpha(float f2) {
        float f3 = this.particleAlpha;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.particleAlpha = f2;
            this.particleAlphaChanged(f3);
            this.propertyChanged(21);
        }
    }

    @Override
    public float get_particleScale() {
        return this.particleScale;
    }

    @Override
    public void set_particleScale(float f2) {
        float f3 = this.particleScale;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.particleScale = f2;
            this.particleScaleChanged(f3);
            this.propertyChanged(22);
        }
    }

    @Override
    public float get_gapX() {
        return this.gapX;
    }

    @Override
    public void set_gapX(float f2) {
        float f3 = this.gapX;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.gapX = f2;
            this.gapXChanged(f3);
            this.propertyChanged(24);
        }
    }

    @Override
    public float get_gapY() {
        return this.gapY;
    }

    @Override
    public void set_gapY(float f2) {
        float f3 = this.gapY;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.gapY = f2;
            this.gapYChanged(f3);
            this.propertyChanged(25);
        }
    }

    @Override
    public float get_rotateX() {
        return this.rotateX;
    }

    @Override
    public void set_rotateX(float f2) {
        float f3 = this.rotateX;
        if (!Util.equalsEpsilon(f3, f2) && !this.startRotateXAnimation(f2)) {
            this.rotateX = f2;
            this.rotateXChanged(f3);
            this.propertyChanged(26);
        }
    }

    @Override
    public float get_rotateY() {
        return this.rotateY;
    }

    @Override
    public void set_rotateY(float f2) {
        float f3 = this.rotateY;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.rotateY = f2;
            this.rotateYChanged(f3);
            this.propertyChanged(27);
        }
    }

    @Override
    public float get_rotateZ() {
        return this.rotateZ;
    }

    @Override
    public void set_rotateZ(float f2) {
        float f3 = this.rotateZ;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.rotateZ = f2;
            this.rotateZChanged(f3);
            this.propertyChanged(28);
        }
    }

    @Override
    public float get_z() {
        return this.z;
    }

    @Override
    public void set_z(float f2) {
        float f3 = this.z;
        if (!Util.equalsEpsilon(f3, f2) && !this.startZAnimation(f2)) {
            this.z = f2;
            this.zChanged(f3);
            this.propertyChanged(23);
        }
    }

    @Override
    public float get_vanishX() {
        return this.vanishX;
    }

    @Override
    public void set_vanishX(float f2) {
        float f3 = this.vanishX;
        if (!Util.equalsEpsilon(f3, f2) && !this.startVanishXAnimation(f2)) {
            this.vanishX = f2;
            this.vanishXChanged(f3);
            this.propertyChanged(30);
        }
    }

    @Override
    public float get_vanishY() {
        return this.vanishY;
    }

    @Override
    public void set_vanishY(float f2) {
        float f3 = this.vanishY;
        if (!Util.equalsEpsilon(f3, f2) && !this.startVanishYAnimation(f2)) {
            this.vanishY = f2;
            this.vanishYChanged(f3);
            this.propertyChanged(30);
        }
    }

    @Override
    public float get_projectionFOV() {
        return this.projectionFOV;
    }

    @Override
    public void set_projectionFOV(float f2) {
        float f3 = this.projectionFOV;
        if (!Util.equalsEpsilon(f3, f2) && !this.startProjectionFOVAnimation(f2)) {
            this.projectionFOV = f2;
            this.projectionFOVChanged(f3);
            this.propertyChanged(29);
        }
    }

    @Override
    public void set_easingAmplitude(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingAmplitude;
        if (easingParams2 == null || !easingParams2.equals(easingParams)) {
            this.easingAmplitude = easingParams;
            this.easingAmplitudeChanged(easingParams2);
            this.propertyChanged(32);
        }
    }

    @Override
    public EasingParams get_easingAmplitude() {
        return this.easingAmplitude;
    }

    @Override
    public void set_easingTintIntensity(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingTintIntensity;
        if (easingParams2 == null || !easingParams2.equals(easingParams)) {
            this.easingTintIntensity = easingParams;
            this.easingTintIntensityChanged(easingParams2);
            this.propertyChanged(33);
        }
    }

    @Override
    public EasingParams get_easingTintIntensity() {
        return this.easingTintIntensity;
    }

    @Override
    public void set_easingBlurIntensity(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingBlurIntensity;
        if (easingParams2 == null || !easingParams2.equals(easingParams)) {
            this.easingBlurIntensity = easingParams;
            this.easingBlurIntensityChanged(easingParams2);
            this.propertyChanged(34);
        }
    }

    @Override
    public EasingParams get_easingBlurIntensity() {
        return this.easingBlurIntensity;
    }

    @Override
    public void set_easingParticleAlpha(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingParticleAlpha;
        if (easingParams2 == null || !easingParams2.equals(easingParams)) {
            this.easingParticleAlpha = easingParams;
            this.easingParticleAlphaChanged(easingParams2);
            this.propertyChanged(32);
        }
    }

    @Override
    public EasingParams get_easingParticleAlpha() {
        return this.easingParticleAlpha;
    }

    @Override
    public void set_easingRotate(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingRotate;
        if (easingParams2 == null || !easingParams2.equals(easingParams)) {
            this.easingRotate = easingParams;
            this.easingRotateChanged(easingParams2);
            this.propertyChanged(36);
        }
    }

    @Override
    public EasingParams get_easingRotate() {
        return this.easingRotate;
    }

    @Override
    public void set_easingGap(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingGap;
        if (easingParams2 == null || !easingParams2.equals(easingParams)) {
            this.easingGap = easingParams;
            this.easingGapChanged(easingParams2);
            this.propertyChanged(37);
        }
    }

    @Override
    public EasingParams get_easingGap() {
        return this.easingGap;
    }

    @Override
    public void set_easingScale(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingScale;
        if (this.easingScale == null || !this.easingScale.equals(easingParams)) {
            this.easingScale = easingParams;
            this.easingScaleChanged(easingParams2);
            this.propertyChanged(38);
        }
    }

    @Override
    public EasingParams get_easingScale() {
        return this.easingScale;
    }

    @Override
    public void set_easingProjection(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingProjection;
        if (this.easingProjection == null || !this.easingProjection.equals(easingParams)) {
            this.easingProjection = easingParams;
            this.easingProjectionChanged(easingParams2);
            this.propertyChanged(39);
        }
    }

    @Override
    public EasingParams get_easingProjection() {
        return this.easingProjection;
    }

    @Override
    public EasingParams get_easingZ() {
        return this.easingZ;
    }

    @Override
    public void set_easingZ(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingZ;
        if (this.easingZ == null || !this.easingZ.equals(easingParams)) {
            this.easingZ = easingParams;
            this.easingZChanged(easingParams2);
            this.propertyChanged(42);
        }
    }

    @Override
    public EasingParams get_easingX() {
        return this.easingX;
    }

    @Override
    public void set_easingX(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingX;
        if (this.easingX == null || !this.easingX.equals(easingParams)) {
            this.easingX = easingParams;
            this.easingXChanged(easingParams2);
            this.propertyChanged(40);
        }
    }

    @Override
    public EasingParams get_easingY() {
        return this.easingY;
    }

    @Override
    public void set_easingY(EasingParams easingParams) {
        EasingParams easingParams2 = this.easingY;
        if (this.easingY == null || !this.easingY.equals(easingParams)) {
            this.easingY = easingParams;
            this.easingYChanged(easingParams2);
            this.propertyChanged(41);
        }
    }

    @Override
    public Tuple4f[] getAttributeStartValues() {
        return this.attributesStartValues;
    }

    @Override
    public Tuple4f[] getAttributesEndValues() {
        return this.attributesEndValues;
    }

    @Override
    public Tuple4f[] getAttributesAnimationValues() {
        return this.attributesAnimationValues;
    }

    @Override
    public Image getPropertyMapPrimaryOld() {
        return this.propertyMapPrimaryOld;
    }

    @Override
    public Image getPropertyMapSecondaryOld() {
        return this.propertyMapSecondaryOld;
    }

    @Override
    public float getPanX() {
        return this.panX;
    }

    @Override
    public float getPanY() {
        return this.panY;
    }

    protected void amplitudeChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("amplitude", f2, this.get_amplitude());
        }
        this.attributeAnimationHandler.startAnimation(0, this.get_easingAmplitude(), this.get_amplitude());
    }

    protected void projectionFOVChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("projectionFOV", f2, this.get_projectionFOV());
        }
    }

    protected void particleAlphaChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("particleAlpha", f2, this.get_particleAlpha());
        }
        this.attributeAnimationHandler.startAnimation(2, this.get_easingParticleAlpha(), this.get_particleAlpha());
    }

    protected void gapXChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("gapX", f2, this.get_gapX());
        }
        this.attributeAnimationHandler.startAnimation(5, this.get_easingGap(), this.get_gapX());
    }

    protected void gapYChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("gapY", f2, this.get_gapY());
        }
        this.attributeAnimationHandler.startAnimation(6, this.get_easingGap(), this.get_gapY());
    }

    protected void tintIntensityChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("tintIntensity", f2, this.get_tintIntensity());
        }
        this.attributeAnimationHandler.startAnimation(1, this.get_easingTintIntensity(), this.get_tintIntensity());
    }

    protected void blurIntensityChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("blurIntensity", f2, this.get_blurIntensity());
        }
        this.attributeAnimationHandler.startAnimation(3, this.get_easingBlurIntensity(), this.get_blurIntensity());
    }

    protected void particleScaleChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("particleScale", f2, this.get_particleScale());
        }
        this.attributeAnimationHandler.startAnimation(4, this.get_easingScale(), this.get_particleScale());
    }

    protected void rotateXChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("rotateX", f2, this.get_rotateX());
        }
        if (LOGGER.isTraceEnabled(512)) {
            LogMessage logMessage = LOGGER.trace(512);
            logMessage.append("ParticleSystem ").append(this).append(": ").append("rotateX changed from:").append(f2).append(" to: ").append(this.get_rotateX());
            logMessage.log();
        }
    }

    protected void rotateYChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("rotateY", f2, this.get_rotateY());
        }
    }

    protected void rotateZChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("rotateZ", f2, this.get_rotateZ());
        }
    }

    @Override
    protected void xChanged(int n) {
        super.xChanged(n);
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("xChanged", n, this.get_x());
        }
        if (!this.startPanXAnimation(this.get_x())) {
            this.panX = this.get_x();
        }
    }

    @Override
    protected void yChanged(int n) {
        super.yChanged(n);
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("yChanged", n, this.get_y());
        }
        if (!this.startPanYAnimation((float)this.get_y() + 57536)) {
            this.panY = this.get_y();
        }
    }

    protected void zChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("vanishYChanged", f2, this.get_z());
        }
    }

    protected void vanishYChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("vanishYChanged", f2, this.get_vanishY());
        }
    }

    protected void vanishXChanged(float f2) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("vanishXChanged", f2, this.get_vanishX());
        }
    }

    protected void propertymapPrimaryChanged(Image image) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("propertymapPrimary", image, this.get_propertymapPrimary());
        }
        if (image == null) {
            this.propertyMapPrimaryOld = this.get_propertymapPrimary();
        }
        if (!this.attributeAnimationHandler.isQueued(0)) {
            this.attributeAnimationHandler.startAnimation(0, this.get_easingAmplitude(), this.get_amplitude());
        }
        if (!this.attributeAnimationHandler.isQueued(1)) {
            this.attributeAnimationHandler.startAnimation(1, this.get_easingTintIntensity(), this.get_tintIntensity());
        }
        if (!this.attributeAnimationHandler.isQueued(2)) {
            this.attributeAnimationHandler.startAnimation(2, this.get_easingParticleAlpha(), this.get_particleAlpha());
        }
        this.attributeAnimationHandler.propertyMapPrimaryChanged(image);
        this.repaint();
    }

    protected void propertymapSecondaryChanged(Image image) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("propertymapSecondary", image, this.get_propertymapSecondary());
        }
        if (image == null) {
            this.propertyMapSecondaryOld = this.get_propertymapSecondary();
        }
        if (!this.attributeAnimationHandler.isQueued(4)) {
            this.attributeAnimationHandler.startAnimation(4, this.get_easingScale(), this.get_particleScale());
        }
        if (!this.attributeAnimationHandler.isQueued(3)) {
            this.attributeAnimationHandler.startAnimation(3, this.get_easingBlurIntensity(), this.get_blurIntensity());
        }
        this.attributeAnimationHandler.propertyMapSecondaryChanged(image);
        this.repaint();
    }

    protected void tintColorChanged(Color color) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("tintColor", color, this.get_tintColor());
        }
    }

    protected void easingAmplitudeChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingAmplitude", easingParams, this.get_easingAmplitude());
        }
        this.attributeAnimationHandler.updateEasingIfQueued(0, this.get_easingAmplitude());
    }

    protected void easingTintIntensityChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingTintIntensity", easingParams, this.get_easingTintIntensity());
        }
        this.attributeAnimationHandler.updateEasingIfQueued(1, this.get_easingTintIntensity());
    }

    protected void easingBlurIntensityChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingBlurIntensity", easingParams, this.get_easingBlurIntensity());
        }
        this.attributeAnimationHandler.updateEasingIfQueued(3, this.get_easingBlurIntensity());
    }

    protected void easingParticleAlphaChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingParticleAlpha", easingParams, this.get_easingParticleAlpha());
        }
        this.attributeAnimationHandler.updateEasingIfQueued(2, this.get_easingParticleAlpha());
    }

    protected void easingRotateChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingRotate", easingParams, this.get_easingRotate());
        }
    }

    protected void easingGapChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingGap", easingParams, this.get_easingGap());
        }
        this.attributeAnimationHandler.updateEasingIfQueued(5, this.get_easingGap());
        this.attributeAnimationHandler.updateEasingIfQueued(6, this.get_easingGap());
    }

    protected void easingScaleChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingScale", easingParams, this.get_easingScale());
        }
        this.attributeAnimationHandler.updateEasingIfQueued(4, this.get_easingScale());
    }

    protected void easingZChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingZ", easingParams, this.get_easingZ());
        }
    }

    protected void easingXChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingX", easingParams, this.get_easingX());
        }
    }

    protected void easingYChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingY", easingParams, this.get_easingY());
        }
    }

    protected void easingProjectionChanged(EasingParams easingParams) {
        if (LOGGER.isTraceEnabled(512)) {
            this.tracePropertyChange("easingProjection", easingParams, this.get_easingProjection());
        }
    }

    private void tracePropertyChange(String string, float f2, float f3) {
        this.tracePropertyChange(string, Float.toString(f2), Float.toString(f3));
    }

    private void tracePropertyChange(String string, Object object, Object object2) {
        LogMessage logMessage = LOGGER.trace(512);
        logMessage.append("ParticleSystem ").append(this).append(": ");
        logMessage.append(string).append(" changed from:").append(object);
        logMessage.append(" to: ").append(object2);
        logMessage.log();
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopInternalAnimation(this.projectionAnimation);
        this.stopInternalAnimation(this.vanishXAnimation);
        this.stopInternalAnimation(this.vanishYAnimation);
        this.attributeAnimationHandler.stopAllAttributeAnimations();
    }

    private boolean startProjectionFOVAnimation(float f2) {
        if (this.projectionAnimation == null && this.easingProjection != null) {
            this.projectionAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, -1, 22, new ParticleSystem$1(this));
        }
        return this.projectionAnimation != null && this.projectionAnimation.startAnimation(f2, this.easingProjection);
    }

    private boolean startVanishYAnimation(float f2) {
        if (this.vanishYAnimation == null && this.easingProjection != null) {
            this.vanishYAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, -1, 31, new ParticleSystem$2(this));
        }
        return this.vanishYAnimation != null && this.vanishYAnimation.startAnimation(f2, this.easingProjection);
    }

    private boolean startVanishXAnimation(float f2) {
        if (this.vanishXAnimation == null && this.easingProjection != null) {
            this.vanishXAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, -1, 30, new ParticleSystem$3(this));
        }
        return this.vanishXAnimation != null && this.vanishXAnimation.startAnimation(f2, this.easingProjection);
    }

    private boolean startZAnimation(float f2) {
        if (this.zPropertyAnimation == null && this.easingZ != null) {
            this.zPropertyAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, -1, 23, new ParticleSystem$4(this));
        }
        return this.zPropertyAnimation != null && this.zPropertyAnimation.startAnimation(f2, this.easingZ);
    }

    private boolean startPanXAnimation(float f2) {
        if (this.panXPropertyAnimation == null && this.easingX != null) {
            this.panXPropertyAnimation = new AbstractWidget$PropertyAnimation((AbstractWidget)this, -1, new ParticleSystem$5(this));
        }
        return this.panXPropertyAnimation != null && this.panXPropertyAnimation.startAnimation(f2, this.easingX);
    }

    private boolean startPanYAnimation(float f2) {
        if (this.panYPropertyAnimation == null && this.easingY != null) {
            this.panYPropertyAnimation = new AbstractWidget$PropertyAnimation((AbstractWidget)this, -1, new ParticleSystem$6(this));
        }
        return this.panYPropertyAnimation != null && this.panYPropertyAnimation.startAnimation(f2, this.easingY);
    }

    private boolean startRotateXAnimation(float f2) {
        if (this.rotateXPropertyAnimation == null && this.easingRotate != null) {
            this.rotateXPropertyAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, -1, 26, new ParticleSystem$7(this));
        }
        return this.rotateXPropertyAnimation != null && this.rotateXPropertyAnimation.startAnimation(f2, this.easingRotate);
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

