/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sse;

import org.dsi.ifc.base.DSIListener;

public interface DSISSEListener
extends DSIListener {
    default public void responseSetMode(int n) {
    }

    default public void updateMode(int n, int n2) {
    }

    default public void updateMicGainLevel(int n, int n2) {
    }

    default public void responseSetMicGainLevel(int n) {
    }

    default public void updateMicMuteState(int n, int n2) {
    }

    default public void responseSetMicMuteState(int n) {
    }
}

