/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.TouchEvent;
import java.util.ArrayList;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public interface PopupStackManager
extends ServiceTrackerCustomizer {
    public static final String CONTEXT_WITHOUT_POPUPS;

    default public boolean consumeEvent(HMIEvent hMIEvent) {
    }

    default public void consumeEvent(PopupViewEvent popupViewEvent) {
    }

    default public boolean consumeEvent(TouchEvent touchEvent) {
    }

    default public ArrayList getPopupViewHandlers(SmartViewHandler smartViewHandler) {
    }

    default public String getNameOfUpmostPopupViewHandler() {
    }

    default public boolean isOpaque() {
    }

    default public SmartViewHandler getOpaqueViewHandler() {
    }

    default public boolean isVipPresent() {
    }

    default public boolean isTouchThrough() {
    }

    default public void propagateSkinMode() {
    }

    default public void releaseResourcesForSkinChange() {
    }

    default public void restoreResourcesForSkinChange(SmartViewHandler smartViewHandler) {
    }

    default public void hideAll() {
    }

    default public void showAll() {
    }

    default public void updatePopupInfo() {
    }
}

