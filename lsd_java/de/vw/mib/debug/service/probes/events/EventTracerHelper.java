/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.events;

import de.vw.mib.debug.common.probes.events.EventDispatcherProbeConfiguration;
import de.vw.mib.debug.service.probes.events.EventCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
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
import de.vw.mib.event.internal.diag.EventTracer;

final class EventTracerHelper
implements EventTracer {
    private final ProbeSystemServices codecProvider;
    private final EventDispatcherProbeConfiguration config;

    EventTracerHelper(ProbeSystemServices probeSystemServices) {
        this.config = (EventDispatcherProbeConfiguration)probeSystemServices.getConfiguration();
        this.codecProvider = probeSystemServices;
    }

    @Override
    public void trace(byte by, byte by2, AnimationEvent animationEvent) {
        if (!this.config.isLogRepaintEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, animationEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, BooleanValueEvent booleanValueEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, booleanValueEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, ContextChangeEvent contextChangeEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, contextChangeEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, DatapoolUpdateEvent datapoolUpdateEvent) {
        if (!this.config.isLogDpAndListUpdateEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, datapoolUpdateEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, DisplayEvent displayEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, displayEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, DynamicStateEvent dynamicStateEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, dynamicStateEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, HMIEvent hMIEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, hMIEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, IntegerValueEvent integerValueEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, integerValueEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, InvocationEvent invocationEvent) {
        if (!this.config.isLogInvocationEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, invocationEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, ListItemControlUpdateEvent listItemControlUpdateEvent) {
        if (!this.config.isLogDpAndListUpdateEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, listItemControlUpdateEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, ListItemEvent listItemEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, listItemEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, LSChangeEvent lSChangeEvent) {
        if (!this.config.isLogLSChangeEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, lSChangeEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, PointEvent pointEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, pointEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, PopupStackChangeEvent popupStackChangeEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, popupStackChangeEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, PopupViewEvent popupViewEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, popupViewEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, PowerStateEvent powerStateEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, powerStateEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, RepaintEvent repaintEvent) {
        if (!this.config.isLogRepaintEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, repaintEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, restoreFactorySettingsEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, RotationEvent rotationEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, rotationEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, SpellerValueEvent spellerValueEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, spellerValueEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, StartupEvent startupEvent) {
        if (!this.config.isLogStartupEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, startupEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, StringValueEvent stringValueEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, stringValueEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, SystemEvent systemEvent) {
        if (!this.config.isLogHMIEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, systemEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, TouchEvent touchEvent) {
        if (!this.config.isLogTouchEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, touchEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, ViewAnimationEvent viewAnimationEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, viewAnimationEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, ViewChangeEvent viewChangeEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, viewChangeEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }

    @Override
    public void trace(byte by, byte by2, ProximityEvent proximityEvent) {
        if (!this.config.isLogViewManagerEventsEnabled()) {
            return;
        }
        EventCodec eventCodec = (EventCodec)this.codecProvider.borrowCodec();
        eventCodec.encode(by, by2, proximityEvent);
        this.codecProvider.releaseCodec(eventCodec);
    }
}

