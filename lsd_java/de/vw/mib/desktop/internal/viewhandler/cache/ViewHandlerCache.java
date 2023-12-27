/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler.cache;

import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;

public interface ViewHandlerCache {
    default public void clear() {
    }

    default public boolean isCachedViewHandler(String string) {
    }

    default public SmartViewHandler getViewHandler(ViewHandlerProvider viewHandlerProvider, String string) {
    }

    default public void reloadViewHandler(SmartViewHandler smartViewHandler) {
    }

    default public SmartViewHandler getPopupViewHandler(String string) {
    }

    default public SmartViewHandler getDarkFaderIndicatorViewHandler() {
    }

    default public SmartViewHandler getGenericPopupBackground() {
    }
}

