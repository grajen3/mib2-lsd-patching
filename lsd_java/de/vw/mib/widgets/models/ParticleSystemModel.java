/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.widgets.models.WidgetModel;

public interface ParticleSystemModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_PROPERTYMAP_PRIMARY;
    public static final int PID_PROPERTYMAP_SECONDARY;
    public static final int PID_AMPLITUDE;
    public static final int PID_TINT_COLOR;
    public static final int PID_TINT_INTENSITY;
    public static final int PID_BLUR_INTENSITY;
    public static final int PID_PARTICLE_ALPHA;
    public static final int PID_PARTICLE_SCALE;
    public static final int PID_Z;
    public static final int PID_GAP_X;
    public static final int PID_GAP_Y;
    public static final int PID_ROTATE_X;
    public static final int PID_ROTATE_Y;
    public static final int PID_ROTATE_Z;
    public static final int PID_PROJECTION_FOV;
    public static final int PID_VANISH_X;
    public static final int PID_VANISH_Y;
    public static final int PID_EASING_AMPLITUDE;
    public static final int PID_EASING_TINT_INTENSITY;
    public static final int PID_EASING_BLUR_INTENSITY;
    public static final int PID_EASING_PARTICLE_ALPHA;
    public static final int PID_EASING_ROTATE;
    public static final int PID_EASING_GAP;
    public static final int PID_EASING_SCALE;
    public static final int PID_EASING_PROJECTION;
    public static final int PID_EASING_X;
    public static final int PID_EASING_Y;
    public static final int PID_EASING_Z;
    public static final int PID_COUNT_PARTICLE_SYSTEM;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_AMPLITUDE;
    public static final int EASING_INDEX_COUNT_PARTICLE_SYSTEM;
    public static final int SID_BASE;
    public static final int SID_COUNT_PARTICLE_SYSTEM;

    default public void set_propertymapPrimary(Image image) {
    }

    default public Image get_propertymapPrimary() {
    }

    default public void set_propertymapSecondary(Image image) {
    }

    default public Image get_propertymapSecondary() {
    }

    default public float get_amplitude() {
    }

    default public void set_amplitude(float f2) {
    }

    default public Color get_tintColor() {
    }

    default public void set_tintColor(Color color) {
    }

    default public float get_tintIntensity() {
    }

    default public void set_tintIntensity(float f2) {
    }

    default public float get_blurIntensity() {
    }

    default public void set_blurIntensity(float f2) {
    }

    default public float get_particleAlpha() {
    }

    default public void set_particleAlpha(float f2) {
    }

    default public float get_particleScale() {
    }

    default public void set_particleScale(float f2) {
    }

    default public float get_gapX() {
    }

    default public void set_gapX(float f2) {
    }

    default public float get_gapY() {
    }

    default public void set_gapY(float f2) {
    }

    default public float get_rotateX() {
    }

    default public void set_rotateX(float f2) {
    }

    default public float get_rotateY() {
    }

    default public void set_rotateY(float f2) {
    }

    default public float get_rotateZ() {
    }

    default public void set_rotateZ(float f2) {
    }

    default public float get_z() {
    }

    default public void set_z(float f2) {
    }

    default public float get_vanishX() {
    }

    default public void set_vanishX(float f2) {
    }

    default public float get_vanishY() {
    }

    default public void set_vanishY(float f2) {
    }

    default public void set_projectionFOV(float f2) {
    }

    default public float get_projectionFOV() {
    }

    default public void set_easingAmplitude(EasingParams easingParams) {
    }

    default public EasingParams get_easingAmplitude() {
    }

    default public void set_easingTintIntensity(EasingParams easingParams) {
    }

    default public EasingParams get_easingTintIntensity() {
    }

    default public void set_easingBlurIntensity(EasingParams easingParams) {
    }

    default public EasingParams get_easingBlurIntensity() {
    }

    default public void set_easingParticleAlpha(EasingParams easingParams) {
    }

    default public EasingParams get_easingParticleAlpha() {
    }

    default public void set_easingRotate(EasingParams easingParams) {
    }

    default public EasingParams get_easingRotate() {
    }

    default public void set_easingGap(EasingParams easingParams) {
    }

    default public EasingParams get_easingGap() {
    }

    default public void set_easingScale(EasingParams easingParams) {
    }

    default public EasingParams get_easingScale() {
    }

    default public void set_easingProjection(EasingParams easingParams) {
    }

    default public EasingParams get_easingProjection() {
    }

    default public void set_easingX(EasingParams easingParams) {
    }

    default public EasingParams get_easingX() {
    }

    default public void set_easingY(EasingParams easingParams) {
    }

    default public void set_easingZ(EasingParams easingParams) {
    }

    default public EasingParams get_easingZ() {
    }

    default public EasingParams get_easingY() {
    }

    default public Image getPropertyMapPrimaryOld() {
    }

    default public Image getPropertyMapSecondaryOld() {
    }

    default public float getPanX() {
    }

    default public float getPanY() {
    }

    default public Tuple4f[] getAttributeStartValues() {
    }

    default public Tuple4f[] getAttributesEndValues() {
    }

    default public Tuple4f[] getAttributesAnimationValues() {
    }
}

