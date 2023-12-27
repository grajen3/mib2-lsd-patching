/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.ViewModel;

public interface ScreenModel
extends ViewModel {
    default public boolean isDrawBoundingBoxesEnabled() {
    }

    default public void setDrawBoundingBoxesEnabled(boolean bl) {
    }

    default public boolean isDrawDebugOverlayEnabled() {
    }

    default public void setDrawDebugOverlayEnabled(boolean bl) {
    }
}

