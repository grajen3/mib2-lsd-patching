/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.internal.exboxm.TargetASLExBoxM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public class AbstractExBoxM {
    private TargetASLExBoxM targetASLExBoxM;

    public AbstractExBoxM(TargetASLExBoxM targetASLExBoxM) {
        this.targetASLExBoxM = targetASLExBoxM;
    }

    protected final void sendHMIEvent(int n) {
        this.targetASLExBoxM.sendHMIEvent(n);
    }

    protected final void sendSafe(EventGeneric eventGeneric) {
        this.targetASLExBoxM.sendSafe(eventGeneric);
    }

    protected final int startUniqueTimer(int n, int n2) {
        return this.targetASLExBoxM.startUniqueTimer(n, n2);
    }

    protected final boolean isTraceEnabledEx() {
        return this.targetASLExBoxM.isTraceEnabledEx();
    }

    protected final LogMessage traceEx() {
        return this.targetASLExBoxM.traceEx();
    }

    protected final LogMessage errorEx() {
        return this.targetASLExBoxM.error();
    }

    protected final boolean isExBoxOperationStateNormal() {
        return this.targetASLExBoxM.isExBoxOperationStateNormal();
    }
}

