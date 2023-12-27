/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager.internal;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ViewModel;

public interface ViewHandler {
    default public String getName() {
    }

    default public ViewModel getView() {
    }

    default public void create() {
    }

    default public void setup() {
    }

    default public void init(boolean bl) {
    }

    default public void activate() {
    }

    default public void deactivate() {
    }

    default public void deinit() {
    }

    default public void teardown() {
    }

    default public void destroy() {
    }

    default public boolean consumeEvent(HMIEvent hMIEvent) {
    }

    default public boolean consumeEvent(TouchEvent touchEvent) {
    }

    default public void reInit(boolean bl) {
    }

    default public void loseFocus() {
    }

    default public void gainFocus() {
    }

    default public ScreenAreaModel[] getScreenAreas() {
    }
}

