/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultViewController;
import de.vw.mib.widgets.event.ViewAdapter;

final class DefaultViewController$ViewChangedHandler
extends ViewAdapter {
    private final DefaultViewController controller;

    public DefaultViewController$ViewChangedHandler(DefaultViewController defaultViewController) {
        this.controller = defaultViewController;
    }

    @Override
    public void viewCovered() {
        this.controller.consumeTouchEvent(DefaultViewController.DEFAULT_CANCEL_EVENT);
    }
}

