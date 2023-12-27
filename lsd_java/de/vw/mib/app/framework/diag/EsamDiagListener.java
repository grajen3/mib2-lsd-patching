/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.diag;

import de.vw.mib.app.framework.diag.AppDiag;

public interface EsamDiagListener {
    default public void onEsamVisibilityRelease(AppDiag appDiag, String string, String string2) {
    }

    default public void onEsamVisibilityRequest(AppDiag appDiag, String string, String string2) {
    }

    default public void onEsamVisibilityDenied(AppDiag appDiag, String string, String string2, String string3) {
    }

    default public void onEsamVisibilityDenied(AppDiag appDiag, String string, String string2, String string3, String string4) {
    }

    default public void onEsamVisibilityGranted(AppDiag appDiag, String string, String string2) {
    }

    default public void onEsamVisibilityRevoked(AppDiag appDiag, String string, String string2, String string3, String string4) {
    }

    default public void onRequestHideAllEsamMembers(AppDiag appDiag, String string, String string2) {
    }
}

