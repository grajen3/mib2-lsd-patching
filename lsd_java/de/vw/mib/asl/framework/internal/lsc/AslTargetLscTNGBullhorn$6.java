/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;

class AslTargetLscTNGBullhorn$6
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$6(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.resetAndWriteLanguageDataToPersistableObject();
        this.this$0.updateLanguageAndSpellerList();
        factoryResetCallback.notifyResetDone();
    }
}

