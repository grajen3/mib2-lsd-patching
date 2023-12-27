/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractImageModel;

public interface ClockModel
extends AbstractImageModel {
    public static final int PID_BASE;
    public static final int PID_HOUR;
    public static final int PID_MINUTE;
    public static final int PID_SECOND;
    public static final int PID_SHOW_SECONDS;
    public static final int PID_CLOCK_BACKGROUND_IMAGE;
    public static final int PID_CLOCK_BACKGROUND_COLOR;
    public static final int PID_CLOCK_FOREGROUND_IMAGE;
    public static final int PID_CLOCK_FOREGROUND_COLOR;
    public static final int PID_CLOCK_HOUR_IMAGE;
    public static final int PID_CLOCK_HOUR_COLOR;
    public static final int PID_CLOCK_MINUTE_IMAGE;
    public static final int PID_CLOCK_MINUTE_COLOR;
    public static final int PID_CLOCK_SECOND_IMAGE;
    public static final int PID_CLOCK_SECOND_COLOR;
    public static final int PID_COUNT_CLOCK;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_CLOCK;
    public static final int SID_BASE;
    public static final int SID_COUNT_CLOCK;

    default public int get_hour() {
    }

    default public void set_hour(int n) {
    }

    default public int get_minute() {
    }

    default public void set_minute(int n) {
    }

    default public int get_second() {
    }

    default public void set_second(int n) {
    }

    default public boolean is_showSeconds() {
    }

    default public void set_showSeconds(boolean bl) {
    }

    default public Image get_clockBackgroundImage() {
    }

    default public void set_clockBackgroundImage(Image image) {
    }

    default public Color get_clockBackgroundColor() {
    }

    default public void set_clockBackgroundColor(Color color) {
    }

    default public Image get_clockForegroundImage() {
    }

    default public void set_clockForegroundImage(Image image) {
    }

    default public Color get_clockForegroundColor() {
    }

    default public void set_clockForegroundColor(Color color) {
    }

    default public Image get_clockHourImage() {
    }

    default public void set_clockHourImage(Image image) {
    }

    default public Color get_clockHourColor() {
    }

    default public void set_clockHourColor(Color color) {
    }

    default public Image get_clockMinuteImage() {
    }

    default public void set_clockMinuteImage(Image image) {
    }

    default public Color get_clockMinuteColor() {
    }

    default public void set_clockMinuteColor(Color color) {
    }

    default public Image get_clockSecondImage() {
    }

    default public void set_clockSecondImage(Image image) {
    }

    default public Color get_clockSecondColor() {
    }

    default public void set_clockSecondColor(Color color) {
    }

    default public float getCenterPositionX() {
    }

    default public float getCenterPositionY() {
    }
}

