/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.consumer;

import de.vw.mib.event.DisplayEvent;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.ViewChangeEvent;

public interface ViewManagerEventConsumer {
    default public void consumeEvent(DisplayEvent displayEvent) {
    }

    default public boolean consumeEvent(HMIEvent hMIEvent) {
    }

    default public void consumeEvent(PopupViewEvent popupViewEvent) {
    }

    default public void consumeEvent(StartupEvent startupEvent) {
    }

    default public void consumeEvent(TouchEvent touchEvent) {
    }

    default public void consumeEvent(ViewChangeEvent viewChangeEvent) {
    }
}

