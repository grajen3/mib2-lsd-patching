/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.base.DSIListener;

public interface DSIAudioManagementListener
extends DSIListener {
    default public void errorConnection(int n, int n2, int n3) {
    }

    default public void fadedIn(int n, int n2) {
    }

    default public void pauseConnection(int n, int n2) {
    }

    default public void updateActiveConnection(int n, int n2, int n3) {
    }

    default public void updateActiveEntertainmentConnection(int n, int n2, int n3) {
    }

    default public void startConnection(int n, int n2) {
    }

    default public void stopConnection(int n, int n2) {
    }

    default public void updateAMAvailable(int n, int n2, int n3) {
    }

    default public void responseVolumelock(int n, int n2, boolean bl) {
    }
}

