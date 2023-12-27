/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler;

import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import java.util.ArrayList;

public interface SmartViewHandlerProvider {
    default public SmartViewHandler getViewHandler(ViewHandlerProvider viewHandlerProvider, String string, boolean bl) {
    }

    default public SmartViewHandler getPopupViewHandler(String string) {
    }

    default public void reloadViewHandler(SmartViewHandler smartViewHandler) {
    }

    default public SmartViewHandler getDarkFaderIndicatorViewHandler() {
    }

    default public SmartViewHandler getPopupBackgroundViewHandler() {
    }

    default public void free(String string) {
    }

    default public void clear() {
    }

    default public String getGuideName(String string) {
    }

    default public ArrayList addDiagnostics(ArrayList arrayList) {
    }
}

