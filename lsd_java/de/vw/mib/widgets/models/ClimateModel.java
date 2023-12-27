/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.models.AbstractCarSpecificModel;
import de.vw.mib.widgets.models.TemplateListModel;

public interface ClimateModel
extends AbstractCarSpecificModel {
    public static final int PID_BASE;
    public static final int PID_ASPECT;
    public static final int PID_AUTOMATIC_AIRFLOW;
    public static final int PID_BLEND_COLOR_AUTOMATIC;
    public static final int PID_BLEND_COLOR_COLD;
    public static final int PID_BLEND_COLOR_WARM;
    public static final int PID_EXHAUST_COLORS;
    public static final int PID_EXHAUST_STATES;
    public static final int PID_EXHAUSTS_ACTIVE;
    public static final int PID_EXHAUSTS_ALPHA;
    public static final int PID_EXHAUSTS_COLD;
    public static final int PID_LIST_REF;
    public static final int PID_RIGHT_HAND_DRIVE;
    public static final int PID_COUNT_CLIMATE;
    public static final int SID_BASE;
    public static final int SID_AUTOMATIC_AIRFLOW;
    public static final int SID_RIGHT_HAND_DRIVE;
    public static final int SID_COUNT_CLIMATE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_TRANSLATE_BACKGROUND_Y;
    public static final int EASING_INDEX_SCALE_BACKGROUND_XY;
    public static final int EASING_INDEX_COUNT_CLIMATE;
    public static final int ASPECT_NONE;
    public static final int ASPECT_FRONT;
    public static final int ASPECT_REAR;
    public static final int BUTTON_TYPE_COUNT_PRESET;
    public static final int BUTTON_TYPE_COUNT_PROFILE;
    public static final int BUTTON_TYPE_COUNT_TEMP;
    public static final int BUTTON_TYPE_COUNT_DOT;
    public static final int BUTTON_TYPE_COUNT_ALL;
    public static final int BUTTON_TYPE_INDEX_OFFSET_PRESET;
    public static final int BUTTON_TYPE_INDEX_OFFSET_PROFILE;
    public static final int BUTTON_TYPE_INDEX_OFFSET_TEMP;
    public static final int BUTTON_TYPE_INDEX_OFFSET_DOT;
    public static final int BUTTON_TYPE_ID_PRESET_START;
    public static final int BUTTON_TYPE_ID_PRESET_END;
    public static final int BUTTON_TYPE_ID_PROFILE_START;
    public static final int BUTTON_TYPE_ID_PROFILE_END;
    public static final int BUTTON_TYPE_ID_TEMP_START;
    public static final int BUTTON_TYPE_ID_TEMP_END;
    public static final int BUTTON_TYPE_ID_DOT_START;
    public static final int BUTTON_TYPE_ID_DOT_END;
    public static final String CONFIG_IDENTIFIER;
    public static final int CONFIG_SUBTYPE_IDENTIFIER_LHD;
    public static final int CONFIG_SUBTYPE_IDENTIFIER_RHD;
    public static final int EXHAUST_COLOR_INDEX_BASE;
    public static final int EXHAUST_COLOR_INDEX_COLD;
    public static final int EXHAUST_COLOR_INDEX_COLD_AUTO;
    public static final int EXHAUST_COLOR_INDEX_WARM;
    public static final int EXHAUST_COLOR_INDEX_WARM_AUTO;
    public static final int EXHAUST_COLOR_INDEX_NEUTRAL;
    public static final int EXHAUST_COLOR_INDEX_NEUTRAL_AUTO;
    public static final int EXHAUST_COLOR_INDEX_COUNT_CLIMATE;
    public static final int EXHAUST_INDEX_COUNT;
    public static final int EXHAUST_INDEX_FRONT_TOP_LEFT;
    public static final int EXHAUST_INDEX_FRONT_MID_LEFT;
    public static final int EXHAUST_INDEX_FRONT_BOTTOM_LEFT;
    public static final int EXHAUST_INDEX_FRONT_TOP_RIGHT;
    public static final int EXHAUST_INDEX_FRONT_MID_RIGHT;
    public static final int EXHAUST_INDEX_FRONT_BOTTOM_RIGHT;
    public static final int EXHAUST_INDEX_REAR_OUTER_LEFT;
    public static final int EXHAUST_INDEX_REAR_MID_LEFT;
    public static final int EXHAUST_INDEX_REAR_BOTTOM_LEFT;
    public static final int EXHAUST_INDEX_REAR_OUTER_RIGHT;
    public static final int EXHAUST_INDEX_REAR_MID_RIGHT;
    public static final int EXHAUST_INDEX_REAR_BOTTOM_RIGHT;
    public static final int EXHAUST_STATE_ON;
    public static final int EXHAUST_STATE_COOLING;
    public static final int EXHAUST_STATE_VENTING;
    public static final int EXHAUST_STATE_HEATING;
    public static final int EXHAUST_MODE_AUTO;
    public static final int EXHAUST_MODE_PASSIVE;

    default public int get_aspect() {
    }

    default public void set_aspect(int n) {
    }

    default public boolean is_automaticAirflow() {
    }

    default public void set_automaticAirflow(boolean bl) {
    }

    default public Color get_blendColorAutomatic() {
    }

    default public void set_blendColorAutomatic(Color color) {
    }

    default public Color get_blendColorCold() {
    }

    default public void set_blendColorCold(Color color) {
    }

    default public Color get_blendColorWarm() {
    }

    default public void set_blendColorWarm(Color color) {
    }

    default public Color[] get_exhaustColors() {
    }

    default public void set_exhaustColors(Color[] colorArray) {
    }

    default public int[] get_exhaustStates() {
    }

    default public void set_exhaustStates(int[] nArray) {
    }

    default public boolean[] get_exhaustsActive() {
    }

    default public void set_exhaustsActive(boolean[] blArray) {
    }

    default public int get_exhaustsAlpha() {
    }

    default public void set_exhaustsAlpha(int n) {
    }

    default public boolean[] get_exhaustsCold() {
    }

    default public void set_exhaustsCold(boolean[] blArray) {
    }

    default public TemplateListModel get_listRef() {
    }

    default public void set_listRef(TemplateListModel templateListModel) {
    }

    default public boolean is_rightHandDrive() {
    }

    default public void set_rightHandDrive(boolean bl) {
    }

    default public int getInteriorPositionY() {
    }

    default public int getInteriorScale() {
    }
}

