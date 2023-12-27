/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.internal.impl.system.SystemServicesImpl;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanCallback;
import de.vw.mib.asl.internal.system.persistence.PersistenceDefaults;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;

class SystemServicesImpl$1
implements PersistedBooleanCallback {
    private final /* synthetic */ SystemServicesImpl this$0;

    SystemServicesImpl$1(SystemServicesImpl systemServicesImpl) {
        this.this$0 = systemServicesImpl;
    }

    @Override
    public void set(SystemCommon systemCommon, boolean bl) {
        systemCommon.setShowClock(bl);
    }

    @Override
    public boolean getDefault() {
        return PersistenceDefaults.getDefaultShowClock();
    }

    @Override
    public boolean get(SystemCommon systemCommon) {
        return systemCommon.isShowClock();
    }
}

