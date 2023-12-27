/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions;

import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeFunction;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;

public final class DiagModeDiagnosticValueChanged
extends DiagModeFunction {
    AbstractASLHsmTarget myTarget;

    public DiagModeDiagnosticValueChanged(AbstractASLHsmTarget abstractASLHsmTarget) {
        super(abstractASLHsmTarget);
        this.myTarget = abstractASLHsmTarget;
    }

    public void diagnosticValueChanged(int n, long l) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(2, n);
        eventGeneric.setLong(3, l);
        eventGeneric.setReceiverTargetId(7300);
        eventGeneric.setReceiverEventId(-1551499008);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.myTarget.error(genericEventException);
        }
    }
}

