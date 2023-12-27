/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.framework.diag;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.framework.diag.CioDiagListener$1;
import de.vw.mib.cio.framework.diag.CioIntentDiag;

public interface CioDiagListener {
    public static final CioDiagListener EMPTY_DIAG_LISTENER = new CioDiagListener$1();

    default public void onCioIntentChanged(CioIntentDiag cioIntentDiag) {
    }

    default public void onCioIntentExecute(CioIntentDiag cioIntentDiag, CioActionParameters cioActionParameters) {
    }

    default public void onCioIntentRegistered(CioIntentDiag cioIntentDiag) {
    }

    default public void onCioIntentUnregistered(CioIntentDiag cioIntentDiag) {
    }

    default public void onCioVisualizationChanged(CioIntentDiag cioIntentDiag) {
    }
}

