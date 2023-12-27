/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.AbstractImageModel;

public interface PureAirModel
extends AbstractImageModel {
    public static final int PID_BASE;
    public static final int PID_AIR_MODE;
    public static final int PID_VALUE_CLEAN;
    public static final int PID_COUNT_PURE_AIR;
    public static final int AIR_MODE_CLEAN;
    public static final int AIR_MODE_IONISATION;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_CLEAN_ANIMATION;
    public static final int EASING_INDEX_IONISATION_ANIMATION;
    public static final int EASING_INDEX_COUNT_PURE_AIR;
    public static final int SID_BASE;
    public static final int SID_ANIMATE;
    public static final int SID_COUNT_PURE_AIR;

    default public void set_airMode(int n) {
    }

    default public int get_airMode() {
    }

    default public void set_valueClean(int n) {
    }

    default public int get_valueClean() {
    }

    default public int[] getIonisationStepX() {
    }

    default public void setIonisationStepX(int[] nArray) {
    }

    default public int[] getIonisationStepY() {
    }

    default public int getIonisationStep() {
    }

    default public void setIonisationStep(int n) {
    }

    default public int getIonisationAlphaX() {
    }

    default public void setIonisationAlphaX(int n) {
    }

    default public int getIonisationAlphaY() {
    }

    default public void setIonisationAlphaY(int n) {
    }

    default public float getIonisationAlphaOverlay() {
    }

    default public void setIonisationAlphaOverlay(float f2) {
    }

    default public float getIonisationAlphaForFading() {
    }

    default public void setIonisationAlphaForFading(float f2) {
    }

    default public float getIonisationAlpha() {
    }

    default public void setIonisationAlpha(float f2) {
    }

    default public float getCleanThreshholdAlpha() {
    }

    default public float getCleanThreshholdAlphaBlur() {
    }

    default public float getCleanFgAlpha() {
    }

    default public void setCleanFgAlpha(float f2) {
    }

    default public int getIonisationLoopCount() {
    }

    default public int getIonisationLoop() {
    }

    default public boolean isAnimationRunning() {
    }
}

