/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.waveplayer;

import org.dsi.ifc.base.DSIListener;

public interface DSIWavePlayerListener
extends DSIListener {
    default public void updatePlayTone(int n, int n2) {
    }

    default public void updateAudioRequest(int n, int n2) {
    }

    default public void setPlayTone(int n) {
    }

    default public void audioTriggerResponse(int n) {
    }
}

