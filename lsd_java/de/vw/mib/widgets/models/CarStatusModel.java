/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.models.AbstractCarSpecificModel;

public interface CarStatusModel
extends AbstractCarSpecificModel {
    public static final int PID_BASE;
    public static final int PID_FEATURE_STATE_COLORS;
    public static final int PID_FEATURE_STATES;
    public static final int PID_SHOW_CAR_TRANSPARENT;
    public static final int PID_RIGHT_HAND_DRIVE;
    public static final int PID_COUNT_CARSTATUS;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_CAR_STATUS;
    public static final int SID_BASE;
    public static final int SID_SHOW_CAR_TRANSPARENT;
    public static final int SID_RIGHT_HAND_DRIVE;
    public static final int SID_COUNT_CARSTATUS;

    default public Color[] get_featureStateColors() {
    }

    default public void set_featureStateColors(Color[] colorArray) {
    }

    default public int[] get_featureStates() {
    }

    default public void set_featureStates(int[] nArray) {
    }

    default public boolean is_showCarTransparent() {
    }

    default public void set_showCarTransparent(boolean bl) {
    }

    default public boolean is_rightHandDrive() {
    }

    default public void set_rightHandDrive(boolean bl) {
    }
}

