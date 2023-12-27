/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal.diag;

import de.vw.mib.event.AnimationEvent;
import de.vw.mib.event.BooleanValueEvent;
import de.vw.mib.event.ContextChangeEvent;
import de.vw.mib.event.DatapoolUpdateEvent;
import de.vw.mib.event.DisplayEvent;
import de.vw.mib.event.DynamicStateEvent;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.IntegerValueEvent;
import de.vw.mib.event.InvocationEvent;
import de.vw.mib.event.LSChangeEvent;
import de.vw.mib.event.ListItemControlUpdateEvent;
import de.vw.mib.event.ListItemEvent;
import de.vw.mib.event.PointEvent;
import de.vw.mib.event.PopupStackChangeEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.PowerStateEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.RepaintEvent;
import de.vw.mib.event.RestoreFactorySettingsEvent;
import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.SpellerValueEvent;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.StringValueEvent;
import de.vw.mib.event.SystemEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.ViewAnimationEvent;
import de.vw.mib.event.ViewChangeEvent;
import de.vw.mib.event.internal.diag.EventTracer$1;

public interface EventTracer {
    public static final EventTracer EMPTY_EVENT_TRACER = new EventTracer$1();
    public static final byte ENQUEUE;
    public static final byte DEQUEUE;
    public static final byte BYPASS;
    public static final byte NOT_QUEUED;
    public static final byte STARTUP_EVENT_QUEUE;
    public static final byte SYSTEM_EVENT_QUEUE;
    public static final byte STATEMACHINE_EVENT_QUEUE;
    public static final byte VIEW_EVENT_QUEUE;

    default public void trace(byte by, byte by2, AnimationEvent animationEvent) {
    }

    default public void trace(byte by, byte by2, BooleanValueEvent booleanValueEvent) {
    }

    default public void trace(byte by, byte by2, ContextChangeEvent contextChangeEvent) {
    }

    default public void trace(byte by, byte by2, DatapoolUpdateEvent datapoolUpdateEvent) {
    }

    default public void trace(byte by, byte by2, DisplayEvent displayEvent) {
    }

    default public void trace(byte by, byte by2, DynamicStateEvent dynamicStateEvent) {
    }

    default public void trace(byte by, byte by2, HMIEvent hMIEvent) {
    }

    default public void trace(byte by, byte by2, IntegerValueEvent integerValueEvent) {
    }

    default public void trace(byte by, byte by2, InvocationEvent invocationEvent) {
    }

    default public void trace(byte by, byte by2, ListItemControlUpdateEvent listItemControlUpdateEvent) {
    }

    default public void trace(byte by, byte by2, ListItemEvent listItemEvent) {
    }

    default public void trace(byte by, byte by2, LSChangeEvent lSChangeEvent) {
    }

    default public void trace(byte by, byte by2, PointEvent pointEvent) {
    }

    default public void trace(byte by, byte by2, PopupStackChangeEvent popupStackChangeEvent) {
    }

    default public void trace(byte by, byte by2, PopupViewEvent popupViewEvent) {
    }

    default public void trace(byte by, byte by2, PowerStateEvent powerStateEvent) {
    }

    default public void trace(byte by, byte by2, RepaintEvent repaintEvent) {
    }

    default public void trace(byte by, byte by2, RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
    }

    default public void trace(byte by, byte by2, RotationEvent rotationEvent) {
    }

    default public void trace(byte by, byte by2, SpellerValueEvent spellerValueEvent) {
    }

    default public void trace(byte by, byte by2, StartupEvent startupEvent) {
    }

    default public void trace(byte by, byte by2, StringValueEvent stringValueEvent) {
    }

    default public void trace(byte by, byte by2, SystemEvent systemEvent) {
    }

    default public void trace(byte by, byte by2, TouchEvent touchEvent) {
    }

    default public void trace(byte by, byte by2, ProximityEvent proximityEvent) {
    }

    default public void trace(byte by, byte by2, ViewAnimationEvent viewAnimationEvent) {
    }

    default public void trace(byte by, byte by2, ViewChangeEvent viewChangeEvent) {
    }
}

