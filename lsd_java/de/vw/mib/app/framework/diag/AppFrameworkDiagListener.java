/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.diag;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.AppDiagListener;

public interface AppFrameworkDiagListener
extends AppDiagListener {
    default public void onAppCreated(AppDiag appDiag) {
    }

    default public void onAppDisposed(AppDiag appDiag) {
    }
}

