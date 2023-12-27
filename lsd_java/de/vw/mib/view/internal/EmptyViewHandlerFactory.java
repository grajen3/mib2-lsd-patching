/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;

public final class EmptyViewHandlerFactory
implements ViewHandlerFactory {
    private static final String[] EMPTY_NAMES = new String[0];

    @Override
    public ViewHandler createViewHandler(String string) {
        return null;
    }

    @Override
    public PopupViewHandler createPopupViewHandler(String string) {
        return null;
    }

    @Override
    public String[] getFastAccessibleViewHandler() {
        return EMPTY_NAMES;
    }

    @Override
    public String[] getFastAccessiblePopupViewHandler() {
        return EMPTY_NAMES;
    }

    @Override
    public String getDarkFaderIndicatorViewHandler() {
        return null;
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return null;
    }
}

