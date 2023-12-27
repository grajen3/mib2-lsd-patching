/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;

public interface TimeZoneController
extends WidgetController {
    public static final int STEPSIZE;
    public static final String OUT_NEXTTIMEZONE_NAME;
    public static final String OUT_PREVTIMEZONE_NAME;
    public static final String IN_SETNEXTTIMEZONE_NAME;
    public static final String IN_SETPREVTIMEZONE_NAME;

    default public void fire_setNextTimeZone() {
    }

    default public void fire_setPrevTimeZone() {
    }

    default public void fire_nextTimeZone() {
    }

    default public void fire_prevTimeZone() {
    }
}

