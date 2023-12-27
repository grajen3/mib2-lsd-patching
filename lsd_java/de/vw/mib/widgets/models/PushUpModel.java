/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.models.BackgroundContainerModel;

public interface PushUpModel
extends BackgroundContainerModel {
    public static final int PID_BASE;
    public static final int PID_CLOSE_MODE;
    public static final int PID_COMPOSITE_BACKGROUND_IMAGES;
    public static final int PID_COMPOSITE_BACKGROUND_MODE;
    public static final int PID_COMPOSITE_BACKGROUND_ARROW_OFFSET_X;
    public static final int PID_COMPOSITE_BACKGROUND_ARROW_OFFSET_Y;
    public static final int PID_SCALING_PIVOT;
    public static final int PID_COUNT_PUSH_UP;
    public static final int CLOSEMODE_IMMEDIATE;
    public static final int CLOSEMODE_BY_EVENT;
    public static final int SID_BASE;
    public static final int SID_COUNT_PUSH_UP;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_OPEN;
    public static final int EASING_INDEX_CLOSE;
    public static final int EASING_INDEX_CONTENT_FADE_IN;
    public static final int EASING_INDEX_CONTENT_FADE_OUT;
    public static final int EASING_INDEX_FADE_IN;
    public static final int EASING_INDEX_FADE_OUT;
    public static final int EASING_INDEX_COUNT_PUSHUP;
    public static final int SCALINGPIVOT_RESIZE;
    public static final int SCALINGPIVOT_BASE;
    public static final int SCALINGPIVOT_NORTH;
    public static final int SCALINGPIVOT_EAST;
    public static final int SCALINGPIVOT_SOUTH;
    public static final int SCALINGPIVOT_WEST;
    public static final int SCALINGPIVOT_NE;
    public static final int SCALINGPIVOT_NW;
    public static final int SCALINGPIVOT_SE;
    public static final int SCALINGPIVOT_SW;
    public static final int SCALINGPIVOT_PUSHUP_COUNT;

    default public int get_closeMode() {
    }

    default public void set_closeMode(int n) {
    }

    default public void set_scalingPivot(int n) {
    }

    default public int get_scalingPivot() {
    }

    default public PushUpHandler getPushUpHandler() {
    }

    default public void setPushUpHandler(PushUpHandler pushUpHandler) {
    }

    default public Rectangle getArrowDestinationArea() {
    }
}

