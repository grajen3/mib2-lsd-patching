/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.models.AbstractCarSpecificModel;
import de.vw.mib.widgets.models.ButtonModel;

public interface GenericCarAdjusterModel
extends AbstractCarSpecificModel {
    public static final int PID_BASE;
    public static final int PID_BUTTON_REFS;
    public static final int PID_CONFIG_IDENTIFIER;
    public static final int PID_CONFIG_SUB_TYPE;
    public static final int PID_FEATURE_STATES;
    public static final int PID_FEATURE_COLORS;
    public static final int PID_FEATURE_EFFECT_TYPE;
    public static final int PID_FEATURE_VALUES;
    public static final int PID_FEATURE_BUTTON_MAPPING;
    public static final int PID_FEATURE_AMBIENT_INTERIOR_COLORED;
    public static final int PID_COUNT_GENERIC_CAR_ADJUSTER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_VALUE_SLOPE;
    public static final int EASING_INDEX_VALUE_DEGRESSION;
    public static final int EASING_INDEX_COUNT_GENERIC_CAR_ADJUSTER;
    public static final int SID_BASE;
    public static final int SID_COUNT_GENERIC_CAR_ADJUSTER;
    public static final int FEATURE_STATE_INACTIVE;
    public static final int FEATURE_STATE_ACTIVE;
    public static final int FEATURE_EFFECT_TYPE_NONE;
    public static final int FEATURE_EFFECT_TYPE_ADD;
    public static final int FEATURE_EFFECT_TYPE_ADD_AND_MULTIPLY;
    public static final int CONFIG_SUB_TYPE_LEFT_HAND_DRIVE;
    public static final int CONFIG_SUB_TYPE_RIGHT_HAND_DRIVE;
    public static final String[] CONFIG_SUB_TYPE_NAMES;

    default public ButtonModel[] get_buttonRefs() {
    }

    default public void set_buttonRefs(ButtonModel[] buttonModelArray) {
    }

    default public String get_configIdentifier() {
    }

    default public void set_configIdentifier(String string) {
    }

    default public int get_configSubType() {
    }

    default public void set_configSubType(int n) {
    }

    default public int[] get_featureButtonMapping() {
    }

    default public void set_featureButtonMapping(int[] nArray) {
    }

    default public Color[] get_featureColors() {
    }

    default public void set_featureColors(Color[] colorArray) {
    }

    default public boolean[] get_featureAmbientInteriorColored() {
    }

    default public void set_featureAmbientInteriorColored(boolean[] blArray) {
    }

    default public int get_featureEffectType() {
    }

    default public void set_featureEffectType(int n) {
    }

    default public int[] get_featureStates() {
    }

    default public void set_featureStates(int[] nArray) {
    }

    default public int[] get_featureValues() {
    }

    default public void set_featureValues(int[] nArray) {
    }

    default public void setActiveButtonIdx(int n) {
    }

    default public boolean isFeatureActive(int n) {
    }

    default public String getConfigSubTypeName() {
    }

    default public int getAnimationFeatureValue(int n) {
    }

    default public Color getFeatureColor(int n) {
    }

    static {
        CONFIG_SUB_TYPE_NAMES = new String[]{"LHD", "RHD"};
    }
}

