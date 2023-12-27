/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;

class AslTargetSystemPowerManagementHandling$2
extends AbstractProfileChangeHandler {
    private final /* synthetic */ AslTargetSystemPowerManagementHandling this$0;

    AslTargetSystemPowerManagementHandling$2(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling) {
        this.this$0 = aslTargetSystemPowerManagementHandling;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistenceData();
        this.this$0.initDataFromPersistence();
        this.notifyProfileChanged(true);
    }
}

