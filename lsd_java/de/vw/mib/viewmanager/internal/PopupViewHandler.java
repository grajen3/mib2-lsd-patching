/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.viewmanager.internal;

import de.vw.mib.viewmanager.internal.ViewHandler;

public interface PopupViewHandler
extends ViewHandler {
    default public void suspend() {
    }

    default public void resume() {
    }
}

