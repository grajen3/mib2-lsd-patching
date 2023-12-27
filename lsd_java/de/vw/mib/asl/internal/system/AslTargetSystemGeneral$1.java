/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;

class AslTargetSystemGeneral$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$1(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadDataFromSystemCommonPersistence();
        this.notifyProfileChanged(true);
    }
}

