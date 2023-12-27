/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
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

final class EventTracerList
implements EventTracer {
    private final CowArray tracers = new CowArray();

    EventTracerList() {
    }

    @Override
    public void trace(byte by, byte by2, AnimationEvent animationEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, animationEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, BooleanValueEvent booleanValueEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, booleanValueEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, ContextChangeEvent contextChangeEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, contextChangeEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, DatapoolUpdateEvent datapoolUpdateEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, datapoolUpdateEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, DisplayEvent displayEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, displayEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, DynamicStateEvent dynamicStateEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, dynamicStateEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, HMIEvent hMIEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, hMIEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, IntegerValueEvent integerValueEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, integerValueEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, InvocationEvent invocationEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, invocationEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, ListItemControlUpdateEvent listItemControlUpdateEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, listItemControlUpdateEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, ListItemEvent listItemEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, listItemEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, LSChangeEvent lSChangeEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, lSChangeEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, PointEvent pointEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, pointEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, PopupStackChangeEvent popupStackChangeEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, popupStackChangeEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, PopupViewEvent popupViewEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, popupViewEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, PowerStateEvent powerStateEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, powerStateEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, RepaintEvent repaintEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, repaintEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, restoreFactorySettingsEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, RotationEvent rotationEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, rotationEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, SpellerValueEvent spellerValueEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, spellerValueEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, StartupEvent startupEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, startupEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, StringValueEvent stringValueEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, stringValueEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, SystemEvent systemEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, systemEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, TouchEvent touchEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, touchEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, ProximityEvent proximityEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, proximityEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, ViewAnimationEvent viewAnimationEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, viewAnimationEvent);
        }
    }

    @Override
    public void trace(byte by, byte by2, ViewChangeEvent viewChangeEvent) {
        Object[] objectArray = this.tracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EventTracer)objectArray[i2]).trace(by, by2, viewChangeEvent);
        }
    }

    void addEventTracer(EventTracer eventTracer) {
        this.tracers.addIfNotAlreadyIn(eventTracer);
    }

    EventTracer removeEventTracer(EventTracer eventTracer) {
        this.tracers.remove(eventTracer);
        if (this.tracers.size() == 1) {
            EventTracer eventTracer2 = (EventTracer)this.tracers.get(0);
            this.tracers.removeAllElements();
            return eventTracer2;
        }
        return this;
    }
}

