/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.models.WidgetModel;

public interface WidgetController {
    public static final int TOUCH_FORWARDING_MODE_EXCLUSIVE;
    public static final int TOUCH_FORWARDING_MODE_ALWAYS;
    public static final int TOUCH_FORWARDING_MODE_NEVER;
    public static final int TOUCH_FORWARDING_MODE_CONCURRENT;

    default public void init() {
    }

    default public void deInit() {
    }

    default public void activate() {
    }

    default public void deActivate() {
    }

    default public void setOutEventMapping(String string, int n) {
    }

    default public int getOutEventMapping(String string) {
    }

    default public void addOutEventListener(OutEventListener outEventListener) {
    }

    default public void removeOutEventListener(OutEventListener outEventListener) {
    }

    default public void removeAllOutEventListeners() {
    }

    default public WidgetModel getWidget() {
    }

    default public void setWidget(WidgetModel widgetModel) {
    }

    default public int getTouchForwardingMode() {
    }

    default public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
    }

    default public boolean consumeTouchEvent(TouchEvent touchEvent) {
    }

    default public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
    }
}

