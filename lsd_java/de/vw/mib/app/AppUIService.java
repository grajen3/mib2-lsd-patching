/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app;

import de.vw.mib.app.esam.EsamServiceForViews;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;

public interface AppUIService {
    default public void assignUsedScreenArea(String string, String string2) {
    }

    default public void enterView(String string, String string2, boolean bl, int n) {
    }

    default public void leaveView(String string, String string2) {
    }

    default public void leaveView(String string, String string2, int n) {
    }

    default public void openPopup(String string, String string2) {
    }

    default public void closePopup(String string, String string2) {
    }

    default public EsamServiceForViews getEsamServiceForViews() {
    }

    default public Logger getLogger(int n) {
    }

    default public ModelApiDownEventService getModelApiDownEventService() {
    }

    default public ViewEventDispatcher getViewEventDispatcher() {
    }

    default public void requestVisibility(String string) {
    }

    default public void updateProvidedScreenAreaVisibility(String string, String string2, boolean bl) {
    }
}

