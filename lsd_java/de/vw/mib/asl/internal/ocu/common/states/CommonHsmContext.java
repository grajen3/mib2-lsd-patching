/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.states;

import de.vw.mib.asl.internal.ocu.common.HsmContext;
import de.vw.mib.genericevents.hsm.HsmState;

public interface CommonHsmContext
extends HsmContext {
    default public HsmState getWaitForLcuStartState() {
    }

    default public HsmState getWaitForMiddlewareState() {
    }

    default public HsmState getVersionCheckState() {
    }

    default public HsmState getWaitForFsgOperationState() {
    }

    default public HsmState getRunningState() {
    }

    default public HsmState getInitializingState() {
    }
}

