/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sfa;

import org.dsi.ifc.base.DSIListener;

public interface DSISFAListener
extends DSIListener {
    default public void updateAudioRequest(int n, int n2) {
    }

    default public void updateDisplayRequest(int n, int n2) {
    }

    default public void responseKeyTouchEvaluation(int n, int n2) {
    }

    default public void responseDisplayNotVisible(int n) {
    }
}

