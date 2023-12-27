/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.genericevents.EventGeneric;

public class DiagModeFunction {
    protected AbstractASLHsmTarget hsmTarget = null;

    public DiagModeFunction(AbstractASLHsmTarget abstractASLHsmTarget) {
        this.hsmTarget = abstractASLHsmTarget;
    }

    protected void send(EventGeneric eventGeneric) {
        if (this.hsmTarget != null) {
            this.hsmTarget.send(eventGeneric);
        }
    }

    protected void triggerObserver(int n, EventGeneric eventGeneric) {
        if (this.hsmTarget != null) {
            this.hsmTarget.triggerObserver(n, eventGeneric);
        }
    }
}

