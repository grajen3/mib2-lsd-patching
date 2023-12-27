/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;

public interface DSIMediaOnlineListener
extends DSIListener {
    default public void updateBufferState(int n, int n2) {
    }

    default public void updateBufferFillInfo(int n, int n2, int n3) {
    }

    default public void updateAudioSettings(int n, int n2, int n3) {
    }
}

