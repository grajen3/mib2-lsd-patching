/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exlap.api.impl;

import de.vw.mib.asl.api.exlap.ASLExLAPAPI;
import de.vw.mib.asl.api.exlap.ExlapInterface;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;

public class ASLExLAPAPIImpl
implements ASLExLAPAPI {
    private ExlapInterface exlapTarget;

    @Override
    public boolean isChauffeurModeActive() {
        return this.exlapTarget != null && this.exlapTarget.isChauffeurModeActive();
    }

    @Override
    public void setExlapTarget(ExlapInterface exlapInterface) {
        this.exlapTarget = exlapInterface;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, -223143424, 638263360);
        PreRegisteredIds.addServiceOrObserverToArray(2, -223143424, 571154496);
    }
}

