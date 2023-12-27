/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager.internal;

import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;

public interface ViewHandlerFactory {
    default public ViewHandler createViewHandler(String string) {
    }

    default public PopupViewHandler createPopupViewHandler(String string) {
    }

    default public String[] getFastAccessibleViewHandler() {
    }

    default public String[] getFastAccessiblePopupViewHandler() {
    }

    default public String getDarkFaderIndicatorViewHandler() {
    }

    default public String getPopupBackgroundViewHandler() {
    }
}

