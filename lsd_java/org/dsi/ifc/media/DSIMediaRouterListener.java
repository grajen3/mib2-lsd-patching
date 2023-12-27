/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouterListener
extends DSIListener {
    default public void responseConfiguration(int n, int n2) {
    }

    default public void responseClientStatus(int n, int n2) {
    }

    default public void updateStreamingStatus(int n, int n2, int n3) {
    }

    default public void updateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
    }
}

