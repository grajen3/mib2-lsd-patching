/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.TouchAreaModel;

public interface CanvasModel
extends TouchAreaModel {
    public static final int PID_BASE;
    public static final int PID_DISPLAYABLE;
    public static final int PID_SCALEMODE;
    public static final int PID_SCREENSHOTMODE;
    public static final int PID_SCREENSHOT_VISIBLE;
    public static final int PID_ASPECTRATIO;
    public static final int PID_DISPLAYABLE_WIDTH;
    public static final int PID_DISPLAYABLE_HEIGHT;
    public static final int PID_COUNT_CANVAS;
    public static final int DISPLAYABLE_REAR_VIEW_CAM;
    public static final int DISPLAYABLE_BROWSER;
    public static final int DISPLAYABLE_MAPVIEWER;
    public static final int DISPLAYABLE_MAP_ROUTE_GUIDANCE;
    public static final int DISPLAYABLE_MAP_INTERSECTION_VIEW;
    public static final int DISPLAYABLE_MAP_3D_INTERSECTION_VIEW;
    public static final int DISPLAYABLE_MAP_JUNCTION_VIEW;
    public static final int DISPLAYABLE_MAP_LANDMARK_VIEW;
    public static final int DISPLAYABLE_DVD_VIDEO;
    public static final int DISPLAYABLE_TV_TUNER;
    public static final int DISPLAYABLE_AMI;
    public static final int DISPLAYABLE_OPS;
    public static final int DISPLAYABLE_TV_AUX1;
    public static final int DISPLAYABLE_TV_AUX2;
    public static final int DISPLAYABLE_TV_VIDEOTEXT;
    public static final int DISPLAYABLE_SIDE_VIEW_CAM;
    public static final int DISPLAYABLE_KOMBI_MAP_VIEW;
    public static final int DISPLAYABLE_EXTERNAL_DVD_VIDEO;
    public static final int DISPLAYABLE_COVERFLOW;
    public static final int DISPLAYABLE_HMI2;
    public static final int DISPLAYABLE_FILE_VIDEO;
    public static final int DISPLAYABLE_COVERFLOW2;
    public static final int DISPLAYABLE_GOOGLE_EARTH;
    public static final int DISPLAYABLE_PUBLIC_SPLASHSCREEN;
    public static final int DISPLAYABLE_3D;
    public static final int DISPLAYABLE_DIGITAL_VIDEOPLAYER_1;
    public static final int DISPLAYABLE_DIGITAL_VIDEOPLAYER_2;
    public static final int DISPLAYABLE_REMOTE_HMI;
    public static final int DISPLAYABLE_JAPANMAP;
    public static final int DISPLAYABLE_FBAS_1;
    public static final int DISPLAYABLE_FBAS_2;
    public static final int DISPLAYABLE_FBAS_3;
    public static final int DISPLAYABLE_MAP_IN_MAP;
    public static final int DISPLAYABLE_STREETVIEW;
    public static final int DISPLAYABLE_CRUISING_RANGE;
    public static final int DISPLAYABLE_TRAFFIC_INFORMATION;
    public static final int DISPLAYABLE_REALISTIC_PICTURE;
    public static final int DISPLAYABLE_KANBAN;
    public static final int DISPLAYABLE_MIRRORLINK;
    public static final int DISPLAYABLE_SFA;
    public static final int DISPLAYABLE_GOOGLE_EARTH_KOMBI_MAP_VIEW;
    public static final int DISPLAYABLE_EXTERNAL_SMARTPHONE;
    public static final int SCALEMODE_ASPECT_RATIO;
    public static final int SCALEMODE_FIT_HORIZONTAL;
    public static final int SCALEMODE_FIT_VERTICAL;
    public static final int SCALEMODE_CLIP_TOP_LEFT;
    public static final int SCALEMODE_CLIP_MIDDLE;
    public static final int SCALEMODE_FIT;
    public static final int SCALEMODE_STRETCH;
    public static final int SCALEMODE_DEFAULT;
    public static final int SCREENSHOTMODE_DISABLED;
    public static final int SCREENSHOTMODE_HANDSHAKE;
    public static final int SCREENSHOTMODE_ENABLED;
    public static final int SID_BASE;
    public static final int SID_VIEW_SWITCHED;
    public static final int SID_SCREENSHOT_VISIBLE;
    public static final int SID_SCREENSHOT_BLOCKED;
    public static final int SID_SCREENSHOT_REQUESTED;
    public static final int SID_SCREENSHOT_PREPARED;
    public static final int SID_SCREENSHOT_PREPARATION;
    public static final int SID_VALIDATE_DISPLAYABLE;
    public static final int SID_DISPLAYABLE_ENABLED;
    public static final int SID_COUNT_CANVAS;
    public static final int DISPLAYABLEWIDTH_AUTO;
    public static final int DISPLAYABLEHEIGHT_AUTO;
    public static final float ASPECT_RATIO_AUTO;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_CANVAS;

    default public int get_displayable() {
    }

    default public void set_displayable(int n) {
    }

    default public void set_screenshotmode(int n) {
    }

    default public int get_screenshotmode() {
    }

    default public void set_screenshotVisible(boolean bl) {
    }

    default public boolean is_screenshotVisible() {
    }

    default public int get_scalemode() {
    }

    default public void set_scalemode(int n) {
    }

    default public float get_aspectratio() {
    }

    default public void set_aspectratio(float f2) {
    }

    default public int get_displayableWidth() {
    }

    default public void set_displayableWidth(int n) {
    }

    default public int get_displayableHeight() {
    }

    default public void set_displayableHeight(int n) {
    }

    default public void requestScreenshotUpdate() {
    }

    default public void setScreenshotCreated() {
    }

    default public void setScreenshotDisposed() {
    }

    default public boolean validateScreenshot() {
    }

    default public void screenshotPreparationFinished() {
    }

    default public Rectangle validateDisplayableViewport(Rectangle rectangle, float f2) {
    }

    default public Rectangle getSourceRectangle() {
    }

    default public Rectangle getDestinationRectangle() {
    }
}

