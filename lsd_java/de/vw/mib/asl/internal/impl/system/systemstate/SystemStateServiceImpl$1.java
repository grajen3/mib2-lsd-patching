/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.systemstate;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.impl.system.systemstate.SystemStateServiceImpl;

class SystemStateServiceImpl$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ SystemStateServiceImpl this$0;

    SystemStateServiceImpl$1(SystemStateServiceImpl systemStateServiceImpl) {
        this.this$0 = systemStateServiceImpl;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistence();
        this.notifyProfileChanged(true);
    }
}

