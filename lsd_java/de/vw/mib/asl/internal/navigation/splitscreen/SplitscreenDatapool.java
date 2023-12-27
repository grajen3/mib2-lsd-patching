/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;

public class SplitscreenDatapool {
    public int getSplitScreenContentGuidance() {
        return ASLNavigationMapFactory.getNavigationMapApi().getSplitScreenContentGuidance();
    }

    public int getSplitScreenContentNoGuidance() {
        return ASLNavigationMapFactory.getNavigationMapApi().getSplitScreenContentNoGuidance();
    }

    public boolean isSplitScreenGuidance() {
        return ASLNavigationMapFactory.getNavigationMapApi().isSplitScreenGuidance();
    }

    public boolean isSplitScreenNoGuidance() {
        return ASLNavigationMapFactory.getNavigationMapApi().isSplitScreenNoGuidance();
    }

    public void setSplitScreenContentGuidance(int n) {
        if (n != 7) {
            ASLNavigationMapFactory.getNavigationMapApi().setSplitScreenContentGuidance(n);
        }
    }

    public void setSplitScreenContentNoGuidance(int n) {
        ASLNavigationMapFactory.getNavigationMapApi().setSplitScreenContentNoGuidance(n);
    }

    public void setSplitScreenGuidance(boolean bl) {
        ASLNavigationMapFactory.getNavigationMapApi().setSplitScreenGuidance(bl);
    }

    public void setSplitScreenNoGuidance(boolean bl) {
        ASLNavigationMapFactory.getNavigationMapApi().setSplitScreenNoGuidance(bl);
    }
}

