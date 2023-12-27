/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.diag;

import de.vw.mib.app.framework.diag.AppDiagListener;
import de.vw.mib.app.framework.diag.ModelApiTracer;

public interface AppDiag {
    default public String getAppAdapterClass() {
    }

    default public int getAppInstanceId() {
    }

    default public String getAppInstanceName() {
    }

    default public String getAppName() {
    }

    default public void registerAppDiagListener(AppDiagListener appDiagListener) {
    }

    default public void registerModelApiTracer(ModelApiTracer modelApiTracer) {
    }

    default public void unregisterAppDiagListener(AppDiagListener appDiagListener) {
    }

    default public void unregisterModelApiTracer(ModelApiTracer modelApiTracer) {
    }
}

