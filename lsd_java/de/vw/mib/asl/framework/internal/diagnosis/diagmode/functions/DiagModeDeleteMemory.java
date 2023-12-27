/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions;

import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeFunction;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public final class DiagModeDeleteMemory
extends DiagModeFunction {
    public DiagModeDeleteMemory(AbstractASLHsmTarget abstractASLHsmTarget) {
        super(abstractASLHsmTarget);
    }

    public void deleteMemory(int n) {
        if (n == 0) {
            this.triggerObserver(-107200256, null);
        }
    }
}

