/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

import org.dsi.ifc.base.DSIListener;

public interface DSIKOMOViewListener
extends DSIListener {
    default public void updateKomoViewEnabled(boolean bl, int n) {
    }

    default public void updateVisibility(boolean bl, int n) {
    }

    default public void komoViewResult(int n) {
    }

    default public void updateCurrentKomoViewType(int n, int n2) {
    }
}

