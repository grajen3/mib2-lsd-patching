/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.diag;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.ModelApiTracer$1;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.ModelApiUpEvent;

public interface ModelApiTracer {
    public static final ModelApiTracer EMPTY_MODEL_API_TRACER = new ModelApiTracer$1();
    public static final int SCOPE_DISPATCHING;
    public static final int SCOPE_RECEIVE;
    public static final int SCOPE_SEND;

    default public void traceModelApiDownCall(AppDiag appDiag, ModelApiDownEvent modelApiDownEvent, int n) {
    }

    default public void traceModelApiUnboundDownCall(AppDiag appDiag, String string) {
    }

    default public void traceModelApiUnboundUpCall(AppDiag appDiag, String string) {
    }

    default public void traceModelApiUpCall(AppDiag appDiag, ModelApiUpEvent modelApiUpEvent, int n) {
    }
}

