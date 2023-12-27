/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.states;

import de.vw.mib.bap.mqbpq.common.HsmContext;
import de.vw.mib.genericevents.hsm.HsmState;

public interface CommonHsmContext
extends HsmContext {
    default public HsmState getStartState() {
    }

    default public HsmState getTopState() {
    }

    default public HsmState getNotInitializedState() {
    }

    default public HsmState getInitializingState() {
    }

    default public HsmState getRunningState() {
    }
}

