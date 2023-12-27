/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display;

import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.display.DisplayPerformanceMetrics;
import de.vw.mib.graphics.image.BufferImage;

public interface DisplayManager
extends ResourceManager {
    public static final int DISPLAYABLE_INVALID;
    public static final int DISPLAYABLE_HMI;
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
    public static final int DISPLAYID_PRIMARY_DEFAULT;
    public static final int DISPLAYID_SECONDARY;
    public static final int DISPLAYID_RSE_LEFT;
    public static final int DISPLAYID_RSE_RIGHT;

    default public DisplayPerformanceMetrics getPerformanceMetrics() {
    }

    default public IntSet getActiveDisplayables(int n) {
    }

    default public void updateDisplay(int n) {
    }

    default public void enableDisplayable(int n, int n2) {
    }

    default public void disableDisplayable(int n, int n2) {
    }

    default public Dimension getDisplayableExtents(int n, int n2) {
    }

    default public void setDisplayable(int n, int n2, Rectangle rectangle, Rectangle rectangle2) {
    }

    default public void setDisplayableAlpha(int n, int n2, int n3) {
    }

    default public Object getNativeDisplayableHandle(int n, int n2) {
    }

    default public BufferImage getDisplayableContent(int n, int n2) {
    }

    default public BufferImage getDisplayableContent(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public BufferImage getDisplayContent(int n) {
    }

    default public void releaseContent(BufferImage bufferImage) {
    }

    default public boolean isGetDisplayableContentSupported(int n) {
    }
}

