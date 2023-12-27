/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.ViewStub;
import de.vw.mib.widgets.models.ScreenModel;

public class ScreenStub
extends ViewStub
implements ScreenModel {
    @Override
    public boolean isDrawBoundingBoxesEnabled() {
        return false;
    }

    @Override
    public void setDrawBoundingBoxesEnabled(boolean bl) {
    }

    @Override
    public boolean isDrawDebugOverlayEnabled() {
        return false;
    }

    @Override
    public void setDrawDebugOverlayEnabled(boolean bl) {
    }
}

