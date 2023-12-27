/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;

public interface ViewHandlerAppServices {
    default public AppDefinition getAppDefinition() {
    }

    default public AppAdapterListItemControlManager getAppAdapterListItemControlManager() {
    }

    default public ViewEventDispatcher getViewEventDispatcher() {
    }
}

