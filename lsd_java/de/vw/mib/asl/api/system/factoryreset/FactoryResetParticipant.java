/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;

public interface FactoryResetParticipant {
    public static final int TRIGGERED_BY_USER;
    public static final int TRIGGERED_BY_DIAGNOSIS_REMOTE_CONTROL;

    default public void reset(FactoryResetCallback factoryResetCallback, int n) {
    }

    default public long getTimeout() {
    }
}

