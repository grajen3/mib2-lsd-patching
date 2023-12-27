/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;

class AslTargetLscTNGBullhorn$7
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$7(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        AslTargetLscTNGBullhorn.access$302(this.this$0, factoryResetCallback);
        this.this$0.processHmiSetterSystemResetSystemSettings();
    }
}

