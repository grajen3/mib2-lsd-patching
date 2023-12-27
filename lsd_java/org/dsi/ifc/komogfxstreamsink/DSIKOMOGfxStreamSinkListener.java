/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komogfxstreamsink;

import org.dsi.ifc.base.DSIListener;

public interface DSIKOMOGfxStreamSinkListener
extends DSIListener {
    default public void updateGfxState(int n, int n2) {
    }

    default public void updateRequestSync(int n, int n2) {
    }

    default public void updateDataRate(int n, int n2) {
    }

    default public void setFGLayerResult(int n) {
    }

    default public void fadeInResult() {
    }

    default public void fadeOutResult() {
    }
}

