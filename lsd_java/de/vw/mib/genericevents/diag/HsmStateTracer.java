/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.diag;

import de.vw.mib.genericevents.diag.HsmStateTracer$1;
import de.vw.mib.genericevents.hsm.HsmState;

public interface HsmStateTracer {
    public static final HsmStateTracer EMPTY_TRACER = new HsmStateTracer$1();

    default public void traceGotEvent(String string, HsmState hsmState, int n) {
    }

    default public void traceTrigger(String string, HsmState hsmState, int n) {
    }

    default public void traceTransition(String string, HsmState hsmState, HsmState hsmState2) {
    }
}

