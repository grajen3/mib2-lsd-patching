/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.internal.persistence.internal.Persistence;
import de.vw.mib.asl.framework.internal.persistence.internal.main.PersistenceMainTarget;
import de.vw.mib.genericevents.GenericEvents;

public final class ApiPersMain {
    private static PersistenceMainTarget mMainTarget = null;

    private ApiPersMain() {
    }

    public static void start(GenericEvents genericEvents, int n, String string, Persistence persistence) {
        mMainTarget = new PersistenceMainTarget(genericEvents, n, string, persistence);
    }

    public static boolean isDiagnosisOn() {
        return ApiPersMain.mMainTarget.mIsDiagnosisOn;
    }

    public static void writeViaDsi() {
        if (mMainTarget != null) {
            mMainTarget.startTimerForWritingRecords();
        }
    }
}

