/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.diag;

import de.vw.mib.app.framework.diag.AppDiag;

public interface AppDiagListener {
    default public void onEnterView(AppDiag appDiag, String string, String[] stringArray, String string2) {
    }

    default public void onLeaveView(AppDiag appDiag, String string, String[] stringArray, String string2) {
    }

    default public void onLifecycleChanged(AppDiag appDiag, int n) {
    }

    default public void onRequestVisibility(AppDiag appDiag, String string) {
    }

    default public void onRequestVisibilityDenied(AppDiag appDiag, String string) {
    }

    default public void onVisibilityChanged(AppDiag appDiag, String string, String[] stringArray, boolean bl) {
    }
}

