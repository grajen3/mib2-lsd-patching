/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.INavigationPosPosition;

public interface NavigationSplitscreenService {
    default public void freeService() {
    }

    default public INavigationPosPosition getCurrentPosition() {
    }

    default public void setSplitScreenContent(int n) {
    }
}

