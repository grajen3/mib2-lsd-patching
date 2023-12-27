/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.SharedSystemCommonPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.framework.internal.displaymanagement.ASLDisplayManagementTarget;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayBrightness;

class ASLDisplayManagementTarget$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ SharedSystemCommonPersistence val$persistence;
    private final /* synthetic */ ASLSystemAPI val$localSystemApi;
    private final /* synthetic */ DisplayBrightness val$localDisplayBrightness;
    private final /* synthetic */ ASLDisplayManagementTarget this$0;

    ASLDisplayManagementTarget$1(ASLDisplayManagementTarget aSLDisplayManagementTarget, SharedSystemCommonPersistence sharedSystemCommonPersistence, ASLSystemAPI aSLSystemAPI, DisplayBrightness displayBrightness) {
        this.this$0 = aSLDisplayManagementTarget;
        this.val$persistence = sharedSystemCommonPersistence;
        this.val$localSystemApi = aSLSystemAPI;
        this.val$localDisplayBrightness = displayBrightness;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        int n = this.val$persistence.getDisplayBrigtness();
        int n2 = this.val$localSystemApi.mapValue(n, 0, 4, 100, 0);
        this.val$localDisplayBrightness.writeDefaultDisplayBrightnessToDsi(n2);
        this.notifyProfileChanged(true);
    }
}

