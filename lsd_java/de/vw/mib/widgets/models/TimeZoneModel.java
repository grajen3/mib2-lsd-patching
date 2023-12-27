/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.WidgetModel;

public interface TimeZoneModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_ACTIVE_TIMEZONE;
    public static final int PID_BACKGROUND_IMAGE;
    public static final int PID_ZONE_IMAGES;
    public static final int PID_COUNT_TIME_ZONE;
    public static final int SID_BASE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_TIMEZONE;

    default public Image get_backgroundImage() {
    }

    default public void set_backgroundImage(Image image) {
    }

    default public Image[] get_zoneImages() {
    }

    default public void set_zoneImages(Image[] imageArray) {
    }

    default public int get_activeTimezone() {
    }

    default public void set_activeTimezone(int n) {
    }
}

