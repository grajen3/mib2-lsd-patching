/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.esam;

import de.vw.mib.app.esam.EsamChangeListener;
import de.vw.mib.cio.CioIntent;

public interface EsamService {
    default public void clearScreen(String string) {
    }

    default public int getVisibleEsamMemberCount() {
    }

    default public boolean isEsamMemberExclusivelyVisible(String string) {
    }

    default public boolean isEsamMemberVisible(String string) {
    }

    default public void registerEsamChangeListener(EsamChangeListener esamChangeListener) {
    }

    default public void releaseVisibility(String string) {
    }

    default public boolean requestVisibility(String string, CioIntent cioIntent) {
    }

    default public void unregisterEsamChangeListener(EsamChangeListener esamChangeListener) {
    }
}

