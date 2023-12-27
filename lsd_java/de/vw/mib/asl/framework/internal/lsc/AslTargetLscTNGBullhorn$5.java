/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;

class AslTargetLscTNGBullhorn$5
extends AbstractProfileChangeHandler {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$5(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.readLanguageDataFromPersistableObject();
        this.this$0.updateLanguageAndSpellerList();
        this.notifyProfileChanged(true);
    }
}

